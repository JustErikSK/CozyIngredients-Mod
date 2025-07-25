package net.withrage.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.withrage.block.screen.ToasterScreenHandler;
import net.withrage.item.ModItems;
import net.withrage.recipe.ModRecipes;
import net.withrage.recipe.ToasterRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ToasterBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 1;
    private static final int OUTPUT_SLOT = 0;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public ToasterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TOASTER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ToasterBlockEntity.this.progress;
                    case 1 -> ToasterBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ToasterBlockEntity.this.progress = value;
                    case 1 -> ToasterBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Toaster");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("toaster.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("toaster.progress");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ToasterScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) return;

        Optional<ToasterRecipe> recipe = getCurrentRecipe();

        if (isOutputSlotEmptyOrReceivable()) {
            if (recipe.isPresent() && canInsertItemIntoOutputSlot(recipe.get().getOutput(world.getRegistryManager()).getItem())) {
                this.increaseCraftProgress();
                markDirty(world, pos, state);

                if (hasCraftingFinished()) {
                    this.craftItem(recipe.get());
                    this.resetProgress();
                }
            } else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem(ToasterRecipe recipe) {
        this.removeStack(INPUT_SLOT, 1);
        ItemStack result = recipe.getOutput(world.getRegistryManager());

        this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private Optional<ToasterRecipe> getCurrentRecipe() {
        return world.getRecipeManager().getFirstMatch(ModRecipes.TOASTER_TYPE, this, world);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
}
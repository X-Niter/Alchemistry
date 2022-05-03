package com.smashingmods.alchemistry.common.recipe.liquifier;

import com.smashingmods.alchemistry.common.recipe.ProcessingRecipe;
import com.smashingmods.alchemistry.registry.RecipeRegistry;
import com.smashingmods.alchemistry.datagen.recipe.IngredientStack;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;

public class LiquifierRecipe extends ProcessingRecipe {

    public IngredientStack input;
    public FluidStack output;

    public LiquifierRecipe(ResourceLocation id, String group, IngredientStack input, FluidStack output) {
        super(RecipeRegistry.LIQUIFIER_TYPE, id, group, input.ingredient, ItemStack.EMPTY);
        this.input = input;
        this.output = output;
    }

    @Override
    @Nonnull
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.LIQUIFIER_SERIALIZER.get();
    }

    @Override
    @Nonnull
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> temp = NonNullList.create();
        temp.add(input.ingredient);
        return temp;
    }
}
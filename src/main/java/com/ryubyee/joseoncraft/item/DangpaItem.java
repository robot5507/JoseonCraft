package com.ryubyee.joseoncraft.item;

import com.ryubyee.joseoncraft.procedures.DangpaLivingEntityIsHitWithToolProcedure;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class DangpaItem extends SwordItem {
	public DangpaItem() {
		super(new Tier() {
			@Override
			public int getUses() {
				return 250;
			}

			@Override
			public float getSpeed() {
				return 4f;
			}

			@Override
			public float getAttackDamageBonus() {
				return 2f;
			}

			@Override
			public int getLevel() {
				return 2;
			}

			@Override
			public int getEnchantmentValue() {
				return 14;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.IRON_INGOT));
			}
		}, 3, -2.4f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		// 쿨다운 중이면 효과 발동 금지
		if (sourceentity instanceof Player player && player.getCooldowns().isOnCooldown(this)) {
			return false;
		}

		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		DangpaLivingEntityIsHitWithToolProcedure.execute(sourceentity, entity);
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);

		if (player.getCooldowns().isOnCooldown(this)) {
			return InteractionResultHolder.fail(stack);
		}

		return super.use(level, player, hand);
	}
}
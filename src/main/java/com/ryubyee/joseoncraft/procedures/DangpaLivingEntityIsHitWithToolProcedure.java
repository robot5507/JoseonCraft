package com.ryubyee.joseoncraft.procedures;

import com.ryubyee.joseoncraft.item.JoseoncraftItems;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;

public class DangpaLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity sourceentity, Entity entity) {
		if (sourceentity == null || entity == null)
			return;

		// 공격자 당파 쿨다운 200틱
		if (sourceentity instanceof Player attacker) {
			attacker.getCooldowns().addCooldown(JoseoncraftItems.DANGPA.get(), 200);
		}

		// 맞은 대상이 플레이어면 손에 든 무기 드롭
		if (entity instanceof Player targetPlayer) {
			ItemStack mainHand = targetPlayer.getMainHandItem();
			ItemStack offHand = targetPlayer.getOffhandItem();

			if (!mainHand.isEmpty() && isWeapon(mainHand)) {
				ItemStack droppedMain = mainHand.copy();
				targetPlayer.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
				targetPlayer.drop(droppedMain, true, false);
			}

			if (!offHand.isEmpty() && isWeapon(offHand)) {
				ItemStack droppedOff = offHand.copy();
				targetPlayer.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
				targetPlayer.drop(droppedOff, true, false);
			}

			targetPlayer.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1, false, true));
			targetPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0, false, true));
		}

		// 맞은 대상이 몹이면 메인핸드 무기 드롭
		if (entity instanceof Mob mob) {
			ItemStack mobMainHand = mob.getMainHandItem();

			if (!mobMainHand.isEmpty() && isWeapon(mobMainHand)) {
				ItemStack dropped = mobMainHand.copy();
				mob.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
				mob.spawnAtLocation(dropped);

				mob.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1, false, true));
				mob.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0, false, true));
			}
		}
	}

	private static boolean isWeapon(ItemStack stack) 
	{
		if(stack == null || stack.isEmpty())
		{
			return false;
		}
		Item item = stack.getItem();
		return item instanceof Vanishable;
	}
}
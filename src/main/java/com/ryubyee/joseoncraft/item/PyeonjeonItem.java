package com.ryubyee.joseoncraft.item;

import com.ryubyee.joseoncraft.init.ProjectJoseonCraftModItems;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PyeonjeonItem extends ArrowItem {
	public PyeonjeonItem() {
		super(new Item.Properties());
	}

	@Override
	public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter) {
		AbstractArrow arrow = super.createArrow(level, stack, shooter);

		if (shooter instanceof Player player) {
			boolean hasTonga = player.getOffhandItem().is(ProjectJoseonCraftModItems.TONGA.get());

			if (hasTonga) {
				arrow.setBaseDamage(8.0D);
				arrow.setKnockback(1);
			} else {
				arrow.setBaseDamage(5.5D);
			}
		}

		return arrow;
	}
}
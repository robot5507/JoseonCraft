package com.ryubyee.joseoncraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class Jukjangchang2Item extends SwordItem {
	public Jukjangchang2Item() {
		super(new Tier() {
			public int getUses() {
				return 20;
			}

			public float getSpeed() {
				return 0.5f;
			}

			public float getAttackDamageBonus() {
				return 1f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 3, 5f, new Item.Properties());
	}
}
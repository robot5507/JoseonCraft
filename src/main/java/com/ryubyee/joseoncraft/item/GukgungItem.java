package com.ryubyee.joseoncraft.item;

import java.util.function.Predicate;

import com.ryubyee.joseoncraft.init.ProjectJoseonCraftModItems;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class GukgungItem extends BowItem {
	public GukgungItem() {
		super(new Item.Properties().durability(500));
	}

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return stack ->
			stack.is(Items.ARROW)
			|| stack.is(Items.SPECTRAL_ARROW)
			|| stack.is(Items.TIPPED_ARROW)
			|| stack.is(ProjectJoseonCraftModItems.PYEONJEON.get());
	}

	@Override
	public void releaseUsing(ItemStack bowStack, Level level, LivingEntity livingEntity, int timeLeft) {
		if (!(livingEntity instanceof Player player)) {
			return;
		}

		boolean hasTonga = player.getOffhandItem().is(ProjectJoseonCraftModItems.TONGA.get());
		ItemStack ammoStack = getPreferredAmmo(player, hasTonga);

		// 별도 검사
		ItemStack pyeonjeonStack = findAmmo(player, ProjectJoseonCraftModItems.PYEONJEON.get());
		boolean hasPyeonjeon = !pyeonjeonStack.isEmpty();

		if (hasTonga) {
			if (ammoStack.isEmpty()) {
				player.displayClientMessage(
					Component.literal("퉁아를 들고 있으면 편전이 필요합니다!").withStyle(ChatFormatting.GREEN),
					true
				);
				return;
			}

			if (!ammoStack.is(ProjectJoseonCraftModItems.PYEONJEON.get())) {
				player.displayClientMessage(
					Component.literal("퉁아를 들고 있으면 편전만 사용할 수 있습니다!").withStyle(ChatFormatting.GREEN),
					true
				);
				return;
			}
		} else {
			// 퉁아가 없는데 편전만 가지고 있으면 메시지 출력
			if (ammoStack.isEmpty() && hasPyeonjeon) {
				player.displayClientMessage(
					Component.literal("편전은 퉁아가 필요합니다!").withStyle(ChatFormatting.GREEN),
					true
				);
				return;
			}
		}

		boolean infiniteAmmo = player.getAbilities().instabuild
			|| EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, bowStack) > 0;

		if (ammoStack.isEmpty() && !infiniteAmmo) {
			return;
		}

		int useTime = this.getUseDuration(bowStack) - timeLeft;
		float power = BowItem.getPowerForTime(useTime);

		if ((double) power < 0.1D) {
			return;
		}

		if (ammoStack.isEmpty()) {
			ammoStack = new ItemStack(Items.ARROW);
		}

		if (!(ammoStack.getItem() instanceof ArrowItem arrowItem)) {
			return;
		}

		if (!level.isClientSide) {
			AbstractArrow arrow = arrowItem.createArrow(level, ammoStack, player);
			arrow = customArrow(arrow);

			arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, power * 3.0F, 1.0F);

			if (power == 1.0F) {
				arrow.setCritArrow(true);
			}

			int powerEnchant = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);
			if (powerEnchant > 0) {
				arrow.setBaseDamage(arrow.getBaseDamage() + (double) powerEnchant * 0.5D + 0.5D);
			}

			int punchEnchant = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, bowStack);
			if (punchEnchant > 0) {
				arrow.setKnockback(punchEnchant);
			}

			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, bowStack) > 0) {
				arrow.setSecondsOnFire(100);
			}

			if (infiniteAmmo || (player.getAbilities().instabuild
				&& (ammoStack.is(Items.ARROW) || ammoStack.is(Items.SPECTRAL_ARROW) || ammoStack.is(Items.TIPPED_ARROW)))) {
				arrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
			}

			level.addFreshEntity(arrow);
		}

		level.playSound(
			null,
			player.getX(),
			player.getY(),
			player.getZ(),
			SoundEvents.ARROW_SHOOT,
			SoundSource.PLAYERS,
			1.0F,
			1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + power * 0.5F
		);

		if (!infiniteAmmo && !player.getAbilities().instabuild) {
			ammoStack.shrink(1);
			if (ammoStack.isEmpty()) {
				player.getInventory().removeItem(ammoStack);
			}
		}

		bowStack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));
	}

	private ItemStack getPreferredAmmo(Player player, boolean hasTonga) {
		if (hasTonga) {
			ItemStack pyeonjeon = findAmmo(player, ProjectJoseonCraftModItems.PYEONJEON.get());
			if (!pyeonjeon.isEmpty()) {
				return pyeonjeon;
			}
			return ItemStack.EMPTY;
		}

		ItemStack normalArrow = findNormalArrow(player);
		if (!normalArrow.isEmpty()) {
			return normalArrow;
		}

		return ItemStack.EMPTY;
	}

	private ItemStack findAmmo(Player player, Item targetItem) {
		ItemStack offhand = player.getOffhandItem();
		if (offhand.getItem() == targetItem) {
			return offhand;
		}

		ItemStack mainhand = player.getMainHandItem();
		if (mainhand.getItem() == targetItem) {
			return mainhand;
		}

		for (ItemStack stack : player.getInventory().items) {
			if (stack.getItem() == targetItem) {
				return stack;
			}
		}

		return ItemStack.EMPTY;
	}

	private ItemStack findNormalArrow(Player player) {
		ItemStack offhand = player.getOffhandItem();
		if (isVanillaArrow(offhand)) {
			return offhand;
		}

		ItemStack mainhand = player.getMainHandItem();
		if (isVanillaArrow(mainhand)) {
			return mainhand;
		}

		for (ItemStack stack : player.getInventory().items) {
			if (isVanillaArrow(stack)) {
				return stack;
			}
		}

		return ItemStack.EMPTY;
	}

	private boolean isVanillaArrow(ItemStack stack) {
		if (stack.isEmpty()) return false;

		Item item = stack.getItem();
		return item == Items.ARROW
			|| item == Items.SPECTRAL_ARROW
			|| item == Items.TIPPED_ARROW;
	}
}
package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.ConfigManager;
import com.noobanidus.variegated.init.Registrar;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class HorseBreedingHandler {
  @SubscribeEvent
  public static void OnInteract(PlayerInteractEvent.EntityInteract event) {
    if (!ConfigManager.silverAppleBreeding) return;

    PlayerEntity player = event.getPlayer();
    if (player.world.isRemote) return;

    ItemStack item = event.getItemStack();

    if (item.isEmpty() || !(event.getTarget() instanceof AbstractHorseEntity)) return;

    Item type = item.getItem();
    AbstractHorseEntity horse = (AbstractHorseEntity) event.getTarget();

    float f;
    int i;
    int j = 0;

    if (type == Registrar.silveredApple) {
      f = 10.0F;
      i = 240;
      j = 10;
    } else {
      return;
    }

    boolean didStuff = false;

    if (horse.isTame() && horse.getGrowingAge() == 0 && !horse.isInLove()) {
      horse.setInLove(player);
      didStuff = true;
    }

    if (horse.getHealth() < horse.getMaxHealth()) {
      horse.heal(f);
      didStuff = true;
    }

    if (horse.isChild()) {
      //horse.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, horse.posX + (double) (horse.rand.nextFloat() * horse.width * 2.0F) - (double) horse.width, horse.posY + 0.5D + (double) (horse.rand.nextFloat() * horse.height), horse.posZ + (double) (horse.rand.nextFloat() * horse.width * 2.0F) - (double) horse.width, 0.0D, 0.0D, 0.0D);

      horse.addGrowth(i);
      didStuff = true;
    }

    if (didStuff) {
      horse.eatingHorse();

      if (!player.isCreative()) {
        item.shrink(1);
      }

      event.setCanceled(true);
    }
  }
}

package com.xianfengting.minecraft.remote_computer_controller.event

import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.text.TextComponentString
import net.minecraftforge.event.entity.living.LivingFallEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class MainEventHandler private {

  // 初始化块
  {
    // Do something here
  }

  @SubscribeEvent
  def onLivingFall(event: LivingFallEvent) = {
    if (event.getEntityLiving.isServerWorld) {
      event.getEntityLiving match {
        case player : EntityPlayerMP =>
          player.sendMessage(new TextComponentString(s"You fell down. Distance: ${event.getDistance}"))
      }
    }
  }
}

object MainEventHandler {
  var instance: MainEventHandler = _

  def apply: MainEventHandler = {
    if (instance == null) instance = new MainEventHandler
    instance
  }
}

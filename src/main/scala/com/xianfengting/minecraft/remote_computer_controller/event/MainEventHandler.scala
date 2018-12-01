package com.xianfengting.minecraft.remote_computer_controller.event

import net.minecraftforge.common.MinecraftForge

class MainEventHandler private {

  // 初始化块
  {
    // Do something here
  }

}

object MainEventHandler {
  var instance: MainEventHandler = _

  def apply: MainEventHandler = {
    if (instance == null) instance = new MainEventHandler
    instance
  }
}

package com.xianfengting.minecraft.remote_computer_controller.common

import com.xianfengting.minecraft.remote_computer_controller.RemoteComputerControllerMod
import com.xianfengting.minecraft.remote_computer_controller.event.MainEventHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.{FMLConstructionEvent, FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import org.apache.logging.log4j.LogManager

class CommonProxy {
  private var logger = RemoteComputerControllerMod.logger

  def onModConstruction(event: FMLConstructionEvent): Unit = {
    if (logger == null) {
      logger = RemoteComputerControllerMod.logger
      logger.warn(s"${RemoteComputerControllerMod.MOD_NAME}: The logger of the proxy is not set and now it has been set.")
    }
  }

  def onModPreInitialize(event: FMLPreInitializationEvent): Unit = {
    logger.debug(RemoteComputerControllerMod.MOD_NAME + "'s FMLPreInitializationEvent attached!")
  }

  def onModInitialize(event: FMLInitializationEvent): Unit = {
    logger.debug(RemoteComputerControllerMod.MOD_NAME + "'s FMLInitializationEvent attached!")
    MainEventHandler.initializeInstance()
    MinecraftForge.EVENT_BUS.register(MainEventHandler())
  }

  def onModPostInitialize(event: FMLPostInitializationEvent): Unit = {
    logger.debug(RemoteComputerControllerMod.MOD_NAME + "'s FMLPostInitializationEvent attached!")
  }
}

class ClientProxy extends CommonProxy {

}

package com.xianfengting.minecraft.remote_computer_controller.common

import com.xianfengting.minecraft.remote_computer_controller.RemoteComputerControllerMod
import com.xianfengting.minecraft.remote_computer_controller.event.MainEventHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import org.apache.logging.log4j.LogManager

class CommonProxy {
  protected val logger = RemoteComputerControllerMod.logger

  def onModPreInitialize(event: FMLPreInitializationEvent): Unit = {
    logger.debug(RemoteComputerControllerMod.MOD_NAME + "'s FMLPreInitializationEvent attached!")
  }

  def onModInitialize(event: FMLInitializationEvent): Unit = {
    logger.debug(RemoteComputerControllerMod.MOD_NAME + "'s FMLInitializationEvent attached!")
    MinecraftForge.EVENT_BUS.register(MainEventHandler)
  }

  def onModPostInitialize(event: FMLPostInitializationEvent): Unit = {
    logger.debug(RemoteComputerControllerMod.MOD_NAME + "'s FMLPostInitializationEvent attached!")
  }
}

class ClientProxy extends CommonProxy {

}

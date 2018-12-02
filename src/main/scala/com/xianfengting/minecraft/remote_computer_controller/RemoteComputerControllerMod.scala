package com.xianfengting.minecraft.remote_computer_controller

import com.xianfengting.minecraft.remote_computer_controller.common.CommonProxy
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import org.apache.logging.log4j.{LogManager, Logger}

//@Mod(modid = "remote_computer_controller", name = "Remote Computer Controller")
@Mod(
  modid = RemoteComputerControllerMod.MOD_ID,
  name = RemoteComputerControllerMod.MOD_NAME,
  modLanguage = "scala")
object RemoteComputerControllerMod {

  final val MOD_ID = "remote_computer_controller"
  final val MOD_NAME = "Remote Computer Controller"


  protected[remote_computer_controller] var logger: Logger = _
  @SidedProxy(
    clientSide = "com.xianfengting.minecraft.remote_computer_controller.ClientProxy",
    serverSide = "com.xianfengting.minecraft.remote_computer_controller.CommonProxy")
  protected[remote_computer_controller] var proxy: CommonProxy = _


  @Mod.EventHandler
  def onModPreInitialize(event: FMLPreInitializationEvent): Unit = {
    RemoteComputerControllerMod.logger = LogManager.getLogger()
    RemoteComputerControllerMod.proxy.onModPreInitialize(event)
  }

  @Mod.EventHandler
  def onModInitialize(event: FMLInitializationEvent): Unit = {
    RemoteComputerControllerMod.proxy.onModInitialize(event)
  }

  @Mod.EventHandler
  def onModPostInitialize(event: FMLPostInitializationEvent): Unit = {
    RemoteComputerControllerMod.proxy.onModPostInitialize(event)
  }
}

package com.jaquadro.minecraft.storagedrawers.core;

import com.jaquadro.minecraft.storagedrawers.StorageDrawers;
import com.jaquadro.minecraft.storagedrawers.block.*;
import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityController;
import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityDrawersComp;
import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityDrawersStandard;
import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntitySlave;
import com.jaquadro.minecraft.storagedrawers.config.ConfigManager;
import com.jaquadro.minecraft.storagedrawers.item.ItemCompDrawers;
import com.jaquadro.minecraft.storagedrawers.item.ItemController;
import com.jaquadro.minecraft.storagedrawers.item.ItemDrawers;
import com.jaquadro.minecraft.storagedrawers.item.ItemTrim;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks
{
    public static BlockDrawers fullDrawers1;
    public static BlockDrawers fullDrawers2;
    public static BlockDrawers fullDrawers4;
    public static BlockDrawers halfDrawers2;
    public static BlockDrawers halfDrawers4;
    public static BlockCompDrawers compDrawers;
    public static BlockController controller;
    public static BlockTrim trim;
    public static BlockSlave controllerSlave;

    public void init () {
        fullDrawers1 = new BlockDrawers("fullDrawers1", 1, false);
        fullDrawers2 = new BlockDrawers("fullDrawers2", 2, false);
        fullDrawers4 = new BlockDrawers("fullDrawers4", 4, false);
        halfDrawers2 = new BlockDrawers("halfDrawers2", 2, true);
        halfDrawers4 = new BlockDrawers("halfDrawers4", 4, true);
        compDrawers = new BlockCompDrawers("compDrawers");
        controller = new BlockController("drawerController");
        trim = new BlockTrim("trim");
        controllerSlave = new BlockSlave("controllerSlave");

        ConfigManager config = StorageDrawers.config;

        if (config.isBlockEnabled("fulldrawers1")) {
            GameRegistry.registerBlock(fullDrawers1, ItemDrawers.class, "fullDrawers1");
            GameRegistry.registerTileEntity(TileEntityDrawersStandard.class, ModBlocks.getQualifiedName(fullDrawers1));
        }
        if (config.isBlockEnabled("fulldrawers2")) {
            GameRegistry.registerBlock(fullDrawers2, ItemDrawers.class, "fullDrawers2");
            GameRegistry.registerTileEntity(TileEntityDrawersStandard.class, ModBlocks.getQualifiedName(fullDrawers2));
        }
        if (config.isBlockEnabled("fulldrawers4")) {
            GameRegistry.registerBlock(fullDrawers4, ItemDrawers.class, "fullDrawers4");
            GameRegistry.registerTileEntity(TileEntityDrawersStandard.class, ModBlocks.getQualifiedName(fullDrawers4));
        }
        if (config.isBlockEnabled("halfdrawers2")) {
            GameRegistry.registerBlock(halfDrawers2, ItemDrawers.class, "halfDrawers2");
            GameRegistry.registerTileEntity(TileEntityDrawersStandard.class, ModBlocks.getQualifiedName(halfDrawers2));
        }
        if (config.isBlockEnabled("halfdrawers4")) {
            GameRegistry.registerBlock(halfDrawers4, ItemDrawers.class, "halfDrawers4");
            GameRegistry.registerTileEntity(TileEntityDrawersStandard.class, ModBlocks.getQualifiedName(halfDrawers4));
        }
        if (config.isBlockEnabled("compdrawers")) {
            GameRegistry.registerBlock(compDrawers, ItemCompDrawers.class, "compDrawers");
            GameRegistry.registerTileEntity(TileEntityDrawersComp.class, ModBlocks.getQualifiedName(compDrawers));
        }
        if (config.isBlockEnabled("controller")) {
            GameRegistry.registerBlock(controller, ItemController.class, "controller");
            GameRegistry.registerTileEntity(TileEntityController.class, ModBlocks.getQualifiedName(controller));
        }
        if (config.isBlockEnabled("controllerSlave")) {
            GameRegistry.registerBlock(controllerSlave, "controllerSlave");
            GameRegistry.registerTileEntity(TileEntitySlave.class, ModBlocks.getQualifiedName(controllerSlave));
        }
        if (config.isBlockEnabled("trim")) {
            GameRegistry.registerBlock(trim, ItemTrim.class, "trim");
        }
    }

    public static String getQualifiedName (Block block) {
        return GameData.getBlockRegistry().getNameForObject(block);
    }
}

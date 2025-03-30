package me.giveblock.nocturneItems.api;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class ItemHelper {

    public static ItemStack getItem(String matName, int amount) {
        Material mat = Material.valueOf(matName.toUpperCase());
        if (mat != null) {
            return new ItemStack(mat, amount);
        }
        return null;
    }



}

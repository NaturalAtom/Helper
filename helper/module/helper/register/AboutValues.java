package eu.mixeration.helper.module.helper.register;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AboutValues {

    public static void _send(Player player) {
        if(ImportHelperValues._ujp) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aUse Jump Pad"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cUse Jump Pad"));
        }
        if(ImportHelperValues._p) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aStop Proxy"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cStop Proxy"));
        }
        if(ImportHelperValues._enc) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &a2 Enc"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &c2 Enc"));
        }
        if(ImportHelperValues._dc) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aDupe checker"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aDupe checker"));
        }
        if(ImportHelperValues._cDcc) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aClose Dangerous Client Channels"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cClose Dangerous Client Channels"));
        }
        if(ImportHelperValues._aUiids) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aAnti Uuid Spoof"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cAnti Uuid Spoof"));
        }
        if(ImportHelperValues._aUs) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aAnti User Steal"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cAnti User Steal"));
        }
        if(ImportHelperValues._aNt) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aAnti Null Text"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cAnti Null Text"));
        }
        if(ImportHelperValues._aNa) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aAnti Null Address"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cAnti Null Address"));
        }
        if(ImportHelperValues._aFo) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aAnti Force Op"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cAnti Force Op"));
        }
        if(ImportHelperValues._aAdd) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aAnti Address Spoof"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cAnti Address Spoof"));
        }
        if(ImportHelperValues._op) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aOp Password"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cOp Password"));
        }
        if(ImportHelperValues._if) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aItem Fixer"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cItem Fixer"));
        }
        if(ImportHelperValues._ms) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aMention System"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cMention System"));
        }
        if(ImportHelperValues._pjm) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aPlayer Join Motd"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cPlayer Join Motd"));
        }
        if(ImportHelperValues._aUs) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aAnti User Steal"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cAnti User Steal"));
        }
        if(ImportHelperValues._aNN) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &aAnti Null Nick"));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &8&l! &cAnti Null Nick"));
        }
    }

}

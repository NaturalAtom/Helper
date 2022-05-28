package eu.mixeration.bank;

import eu.mixeration.helper.paths.Path_Bank;
import org.bukkit.entity.Player;

import static eu.API_Vault.econ;
import static eu.API_Vault.getEconomy;

public class Bank_Modules {

    @Deprecated
    public static double getMoney(Player player) {
        return econ.getBalance(player);
    }

    @Deprecated
    public static int getPlayerBankBalance(Player player) {
        return Path_Bank.getConfig().getInt("user-data." + player.getUniqueId().toString() + ".bank-balance");
    }

    @Deprecated
    public static void doBoth_removeBalanceFromBank_addBalanceToPlayer(Player player, int amount) {
        addBalanceToBank(player, amount);
        removeBalanceFromBank(player, amount);
    }

    @Deprecated
    public static void doBoth_addBalanceToBank_removeBalanceFromPlayer(Player player, int amount) {
        addBalanceToBank(player, amount);
        removeBalanceFromPlayer(player, amount);
    }

    @Deprecated
    public static void addBalanceToPlayer(Player player, int amount) {
        getEconomy().depositPlayer(player.getName(), amount);
    }

    @Deprecated
    public static void removeBalanceFromPlayer(Player player, int amount) {
        getEconomy().withdrawPlayer(player.getName(), amount);
    }

    @Deprecated
    public static void addBalanceToBank(Player player, int amount) {
        Path_Bank.getConfig().set("user-data." + player.getUniqueId().toString() + ".bank-balance", (Path_Bank.getConfig().getInt("user-data." + player.getUniqueId().toString() + ".bank-balance") + amount));
        Path_Bank.saveConfig();
    }

    @Deprecated
    public static void removeBalanceFromBank(Player player, int amount) {
        Path_Bank.getConfig().set("user-data." + player.getUniqueId().toString() + ".bank-balance", (Path_Bank.getConfig().getInt("user-data." + player.getUniqueId().toString() + ".bank-balance") - amount));
        Path_Bank.saveConfig();
    }

}

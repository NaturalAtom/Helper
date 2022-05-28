package eu.mixeration.helper;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import eu.mixeration.discord.SetupDiscordBot;
import eu.mixeration.essentials.commands.creator.CommandCreatorListener;
import eu.mixeration.essentials.events.CustomJoinMessageEvent;
import eu.mixeration.essentials.events.CustomQuitMessageEvent;
import eu.mixeration.helper.commands.*;
import eu.mixeration.helper.events.MaintenancerEvent;
import eu.mixeration.helper.events.PlayerRegisterBankEvent;
import eu.mixeration.helper.events.proxy.ProxyEvent;
import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.helper.*;
import eu.mixeration.helper.module.helper.register.ImportHelperValues;
import eu.mixeration.helper.module.Lists_And_Maps;
import eu.mixeration.helper.paths.*;
import eu.mixeration.protections.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.PluginMessageListener;

import javax.security.auth.login.LoginException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import static eu.mixeration.essentials.Essentials.essLoad;
import static eu.API_Vault.log;
import static eu.API_Vault.setupEconomy;

public final class Helper extends JavaPlugin implements PluginMessageListener {
    private static Helper instance;
    public static synchronized Helper get() {return instance;}
    public static synchronized void set(Helper mixeration) {instance = mixeration;}
    public PluginManager pluginManager = Bukkit.getPluginManager();
    public ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
    private Path_Helper _help = new Path_Helper(this, "helper.yml");
    private Path_Essentials _ess = new Path_Essentials(this, "essentials.yml");
    private Path_WorldSettings _wrld = new Path_WorldSettings(this, "world-settings.yml");
    private Path_Config _conf = new Path_Config(this, "config.yml");
    private Path_Pluginator _plt = new Path_Pluginator(this, "pluginator.yml");
    private Path_Locale _lang = new Path_Locale(this, "language.yml");
    private Path_ProtectionsLocale _langp = new Path_ProtectionsLocale(this, "protection-language.yml");
    private Path_Optimization _optm = new Path_Optimization(this, "optimization.yml");
    private Path_Discord _dc = new Path_Discord(this, "discord.yml");
    private Path_Maintenancer _mnt = new Path_Maintenancer(this, "maintenancer.yml", "helps");
    private Path_UUID _pathUUID = new Path_UUID(this, "uuid.yml", "storage");
    private Path_Bank _pathBank = new Path_Bank(this, "bank.yml", "storage");
    private Path_Operator _opt = new Path_Operator(this, "operator.yml", "protections");
    private Path_AntiNullNick _ant = new Path_AntiNullNick(this, "anti-null-nick.yml", "protections");
    private Path_AntiBookCrash _abc = new Path_AntiBookCrash(this, "anti-book-crash.yml", "protections");
    private Path_Client _clt = new Path_Client(this, "clients.yml", "protections");
    private NotWorking_Path_AntiFastVersionChange _afvc = new NotWorking_Path_AntiFastVersionChange(this, "anti-fast-version-change.yml", "protections");
    private Path_Proxy _prx = new Path_Proxy(this, "proxy.yml", "protections");

    public void create(){
        _conf.create();
        _lang.create();
        _mnt.create();
        _optm.create();
        _dc.create();
        _pathBank.create();
        _ess.create();
        _help.create();
        _opt.create();
        _ant.create();
        _pathUUID.create();
        _langp.create();
        _prx.create();
        _plt.create();
        _wrld.create();
        /* Maintenance
        _afvc.create();
         */
        _clt.create();
    }
    public void register() {
        pluginManager.registerEvents(new PlayerRegisterBankEvent(this), this);
        pluginManager.registerEvents(new MaintenancerEvent(this), this);
        if(StopProxy.get()) {
            pluginManager.registerEvents(new ProxyEvent(this), this);
        }
        if(AntiMessageSpam.get()) {
            pluginManager.registerEvents(new Protection_AntiMessageSpam(this), this);
        }
        if(AntiUuidSpoof.get()) {
            pluginManager.registerEvents(new Protection_AntiUuidSpoof(this), this);
        }
        /* Maintenance
        pluginManager.registerEvents(new antiFastVersionChange(this), this);
         */
        if(AntiNullNick.get()) {
            pluginManager.registerEvents(new Protection_AntiNullNick(this), this);
        }
        if(AntiForceOp.get()) {
            pluginManager.registerEvents(new Protection_AntiForceOp(this), this);
        }
        if(CommandCreator.creatorEvent()) {
            pluginManager.registerEvents(new CommandCreatorListener(this), this);
        }
        if(CustomJoinMessage.get()) {
            pluginManager.registerEvents(new CustomJoinMessageEvent(this), this);
        }
        if(CustomQuitMessage.get()) {
            pluginManager.registerEvents(new CustomQuitMessageEvent(this), this);
        }
        if(AntiBookCrash.get()) {
            pluginManager.registerEvents(new Protection_AntiBookCrash(this), this);
        }
        getCommand("Helper").setExecutor(new HelperMain(this));
        getCommand("HelperClient").setExecutor(new HelperClient(this));
        getCommand("HelperServer").setExecutor(new HelperServer(this));
        getCommand("HelperEssentials").setExecutor(new HelperEssentials(this));
        getCommand("HelperWorld").setExecutor(new HelperWorld(this));
        Lists_And_Maps.maintenance.put("server", false);
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        essLoad();
    }

    @Override
    public void onEnable() {
        set(this);
        create();
        ImportHelperValues.setupHelper();
        register();
        if(Path_Helper.getConfig().getBoolean("use-helper-on-discord")) {
            try {
                SetupDiscordBot.openDiscordBot(Path_Discord.getConfig().getString("discord.bot-token"));
                Console.message("&b{ &9Helper &3| &fDiscord &b} &7Token : &9" + SetupDiscordBot.jda.getToken().replace("0", " ").replace("W", " ").replace(".", " ").replace("w", " "));
                Console.message(" ");
                Console.message("&b{ &9Helper &3| &fDiscord &b} &7Note : &9The token that appears in the console is not the same as the token in the file. Please do not be afraid.");
                Console.message(" ");
                Console.message("&b{ &9Helper &3| &fDiscord &b} &7Note : &9If your Discord bot is opened, there is no problem. This is done for security purposes.");
            } catch (LoginException e) {
                Console.message("&b{ &9Helper &3| &fDiscord &b} &7Cannot enabled discord bot, something went wrong...");
            }
        } else {
            Console.message("&b{ &9Helper &3| &fDiscord &b} &7Cannot enabled discord bot, &fHelper.yml &7is false or null.");
        }
        if(Path_Helper.getConfig().getBoolean("close-dangerous-client-channels")) {
            Messenger messenger = Bukkit.getMessenger();
            messenger.registerIncomingPluginChannel(this, "minecraft:brand", this);
            Console.message("&b{ &9Helper &3| &fMC|Brand &b} &7Channel &9MC|Brand &7registered.");
        } else{
            Console.message("&b{ &9Helper &3| &fMC|Brand &b} &7Channel &9MC|Brand &7is not registered, &fHelper.yml &7close-dangerous-client-channels is false or null.");
        }
    }

    @Override
    public void onDisable(){
        log.info(String.format("[%s] Disabled Version %s", eu.mixeration.helper.Helper.get().getDescription().getName(), eu.mixeration.helper.Helper.get().getDescription().getVersion()));
    }

    public void onPluginMessageReceived(String channel, Player p, byte[] msg) {
        String brand = (new String(msg, StandardCharsets.UTF_8)).substring(1);
        if (Path_Client.getConfig().getBoolean("helper-client.mc-brand-channels.enable")) {
            Iterator var5;
            String str;
            String kickMsg;
            Iterator var8;
            Player onlineStaff;
            if (Path_Client.getConfig().getString("helper-client.settings.mc-brand.channel-mode", "blacklist").equals("blacklist")) {
                var5 = Path_Client.getConfig().getStringList("helper-client.settings.mc-brand.blacklist.channels").iterator();
                if (var5.hasNext()) {
                    str = (String)var5.next();
                    if (brand.toLowerCase().contains(str.toLowerCase())) {
                        kickMsg = Path_Client.getConfig().getString("helper-client.disallowed-client.kick-suspect").replace("%suspect_client%", brand);
                        p.kickPlayer(ChatColor.translateAlternateColorCodes('&', kickMsg));
                        Bukkit.getLogger().severe(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.console-notifications.severe*3").replace("%suspect%", p.getName().replace("%suspect_address%", p.getAddress().getAddress().getHostAddress()).replace("%suspect_client%", brand))));
                        var8 = Bukkit.getOnlinePlayers().iterator();

                        while(true) {
                            do {
                                if (!var8.hasNext()) {
                                    return;
                                }

                                onlineStaff = (Player)var8.next();
                            } while(!onlineStaff.hasPermission(Path_Client.getConfig().getString("helper-client.notify")) && Lists_And_Maps.notify_client.get(onlineStaff.getUniqueId()) == null);

                            onlineStaff.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.notifications.disallowed-client")).replace("%suspect%", p.getPlayer().getName()).replace("%next_line%", "\n\n").replace("%suspect_address%", p.getAddress().getAddress().getHostAddress()));
                        }
                    }

                    return;
                }
            } else if (Path_Client.getConfig().getString("helper-client.settings.mc-brand.channel-mode", "whitelist").equals("whitelist")) {
                var5 = Path_Client.getConfig().getStringList("helper-client.settings.mc-brand.whitelist.channels").iterator();
                if (var5.hasNext()) {
                    str = (String)var5.next();
                    if (!brand.toLowerCase().contains(str.toLowerCase())) {
                        kickMsg = Path_Client.getConfig().getString("helper-client.disallowed-client.kick-suspect").replace("%suspect_client%", brand);
                        p.kickPlayer(ChatColor.translateAlternateColorCodes('&', kickMsg));
                        Bukkit.getLogger().severe(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.console-notifications.severe*2").replace("%suspect%", p.getName().replace("%suspect_address%", p.getAddress().getAddress().getHostAddress()).replace("%suspect_client%", brand))));
                        var8 = Bukkit.getOnlinePlayers().iterator();

                        while(true) {
                            do {
                                if (!var8.hasNext()) {
                                    return;
                                }

                                onlineStaff = (Player)var8.next();
                            } while(!onlineStaff.hasPermission(Path_Client.getConfig().getString("helper-client.notify")) && Lists_And_Maps.notify_client.get(onlineStaff.getUniqueId()) == null);

                            onlineStaff.sendMessage(ChatColor.translateAlternateColorCodes('&', Path_Client.getConfig().getString("helper-client.notifications.disallowed-client")).replace("%suspect%", p.getPlayer().getName()).replace("%next_line%", "\n\n").replace("%suspect_address%", p.getAddress().getAddress().getHostAddress()));
                        }
                    }

                    return;
                }
            }

        }
    }


}

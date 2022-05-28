package eu.mixeration.helper.module.helper.register;

import eu.mixeration.helper.module.Console;
import eu.mixeration.helper.module.helper.*;
import eu.mixeration.helper.paths.Path_Helper;

public class ImportHelperValues {

    public static boolean _aAdd;
    public static boolean _aFo;
    public static boolean _aNa;
    public static boolean _aNt;
    public static boolean _aUs;
    public static boolean _aNN;
    public static boolean _aUiids;
    public static boolean _cDcc;
    public static boolean _dc;
    public static boolean _enc;
    public static boolean _if;
    public static boolean _ms;
    public static boolean _op;
    public static boolean _p;
    public static boolean _pjm;
    public static boolean _ujp;

    public static void setupHelper(){
        Console.message("&b{ &9Helper &3| &fAnti Exploit &b} &7Getting anti exploit values...");
        if(AntiAddressSpoof.get()) {
            _aAdd = true;
            Console.message("&b{ &9Helper &3| &fAnti Address Spoof &b} &7is &aenabled&7.");
        } else {
            _aAdd = false;
            Console.message("&b{ &9Helper &3| &fAnti Address Spoof &b} &7is &cdisabled&7.");
        }
        if(AntiForceOp.get()) {
            _aFo = true;
            Console.message("&b{ &9Helper &3| &fAnti Force Op &b} &7is &aenabled&7.");
        } else {
            _aFo = false;
            Console.message("&b{ &9Helper &3| &fAnti Force Op &b} &7is &cdisabled&7.");
        }
        if(AntiNullAddress.get()) {
            _aNa = true;
            Console.message("&b{ &9Helper &3| &fAnti Null Address &b} &7is &aenabled&7.");
        } else {
            _aNa = false;
            Console.message("&b{ &9Helper &3| &fAnti Null Address &b} &7is &cdisabled&7.");
        }
        if(AntiNullText.get()) {
            _aNt = true;
            Console.message("&b{ &9Helper &3| &fAnti Null Text &b} &7is &aenabled&7.");
        } else {
            _aNt = false;
            Console.message("&b{ &9Helper &3| &fAnti Null Text &b} &7is &cdisabled&7.");
        }
        if(AntiUserSteal.get()) {
            _aUs = true;
            Console.message("&b{ &9Helper &3| &fAnti User Steal &b} &7is &aenabled&7.");
        } else {
            _aUs = false;
            Console.message("&b{ &9Helper &3| &fAnti User Steal &b} &7is &cdisabled&7.");
        }
        if(AntiUuidSpoof.get()) {
            _aUiids = true;
            Console.message("&b{ &9Helper &3| &fAnti UUID Spoof &b} &7is &aenabled&7.");
        } else {
            _aUiids = false;
            Console.message("&b{ &9Helper &3| &fAnti UUID Spoof &b} &7is &cdisabled&7.");
        }
        if(DangerousClients.get()) {
            _cDcc = true;
            Console.message("&b{ &9Helper &3| &fClosed Dangerous Client Channels &b} &7is &aenabled&7.");
        } else {
            _cDcc = false;
            Console.message("&b{ &9Helper &3| &fClosed Dangerous Client Channels &b} &7is &cdisabled&7.");
        }
        if(DupeChecker.get()) {
            _dc = true;
            Console.message("&b{ &9Helper &3| &fDupe checker &b} &7is &aenabled&7.");
        } else {
            _dc = false;
            Console.message("&b{ &9Helper &3| &fDuper checker&b} &7is &cdisabled&7.");
        }
        if(Encryption.get()) {
            _enc = true;
            Console.message("&b{ &9Helper &3| &f2 Encryption &b} &7is &aenabled&7.");
        } else {
            _enc = false;
            Console.message("&b{ &9Helper &3| &f2 Encryption &b} &7is &cdisabled&7.");
        }
        if(ItemFix.get()) {
            _if = true;
            Console.message("&b{ &9Helper &3| &fItem Fixer &b} &7is &aenabled&7.");
        } else {
            _if = false;
            Console.message("&b{ &9Helper &3| &fItem Fixer &b} &7is &cdisabled&7.");
        }
        if(OpCommandPassword.get()) {
            _op = true;
            Console.message("&b{ &9Helper &3| &fOperator Password &b} &7is &aenabled&7.");
        } else {
            _op = false;
            Console.message("&b{ &9Helper &3| &fOperator Password &b} &7is &cdisabled&7.");
        }
        if(StopProxy.get()) {
            _p = true;
            Console.message("&b{ &9Helper &3| &fStop Proxy &b} &7is &aenabled&7.");
        } else {
            _p = false;
            Console.message("&b{ &9Helper &3| &fStop Proxy &b} &7is &cdisabled&7.");
        }
        if(AntiNullNick.get()) {
            _aNN = true;
            Console.message("&b{ &9Helper &3| &fAnti Null Nick &b} &7is &aenabled&7.");
        } else {
            _aNN = false;
            Console.message("&b{ &9Helper &3| &fAnti Null Nick &b} &7is &cdisabled&7.");
        }
        Console.message("&b{ &9Helper &3| &fServer Simpels &b} &7Getting server simple values...");
        if(PlayerJoinMotd.get()) {
            _pjm = true;
            Console.message("&b{ &9Helper &3| &fPlayer Join Motd &b} &7is &aenabled&7.");
        } else {
            _pjm = false;
            Console.message("&b{ &9Helper &3| &fPlayer Join Motd &b} &7is &cdisabled&7.");
        }
        if(UserJumpPad.get()) {
            _ujp = true;
            Console.message("&b{ &9Helper &3| &fPlayer Jump Pad &b} &7is &aenabled&7.");
        } else {
            _ujp = false;
            Console.message("&b{ &9Helper &3| &fPlayer Jump Pad &b} &7is &cdisabled&7.");
        }
        if(Mention.get()) {
            _ms = true;
            Console.message("&b{ &9Helper &3| &fMention system &b} &7is &aenabled&7.");
        } else {
            _ms = false;
            Console.message("&b{ &9Helper &3| &fMention system &b} &7is &cdisabled&7.");
        }
        if(Path_Helper.getConfig().getString("server-version").equals("empty")) {
            Console.message("&b{ &9Helper &3| &fServer versions &b} &7Here is some supported server versions...");
            Console.message("   &b} > Paper - config text : paper$mxr");
            Console.message("   &b} > Spigot - config text : spigot$mxr");
        }
    }

}

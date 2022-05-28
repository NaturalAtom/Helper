package eu.mixeration.helper.module.helper.helper$modules;

import eu.mixeration.helper.Helper;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Module_Countdown {
    static Map<UUID, Integer> taskID = new HashMap<>();
    public static Map<UUID, Boolean> booleanID = new HashMap<>();
    public static Map<UUID, Integer> timeMap = new HashMap<>();


    static int time;

    public static void startTimer(Player player, int timeAmount){
        timeMap.put(player.getUniqueId(), timeAmount);
        time = timeMap.get(player.getUniqueId());
        int tid = Helper.get().getServer().getScheduler().scheduleSyncRepeatingTask(Helper.get(), new Runnable(){
            int timeRemaining = timeAmount; // Starts with initial value of the countdown
            public void run(){
                if (timeRemaining <= 0) {
                    endTask(player); //Potentially consider using BukkitRunnable and the internal cancel() function, makes it to where you don't have to store the taskID.
                    booleanID.put(player.getUniqueId(), true);
                } else {
                    player.sendMessage("" + timeRemaining);
                    booleanID.put(player.getUniqueId(), false);
                }
                timeMap.put(player.getUniqueId(), timeRemaining--);
            }
        }, 0L, 20L);

        taskID.put(player.getUniqueId(), tid);
    }

    public static void startTimerWithoutRemainingMessage(Player player, int timeAmount){
        timeMap.put(player.getUniqueId(), timeAmount);
        time = timeMap.get(player.getUniqueId());
        int tid = Helper.get().getServer().getScheduler().scheduleSyncRepeatingTask(Helper.get(), new Runnable(){
            int timeRemaining = timeAmount; // Starts with initial value of the countdown
            public void run(){
                if (timeRemaining <= 0) {
                    endTask(player); //Potentially consider using BukkitRunnable and the internal cancel() function, makes it to where you don't have to store the taskID.
                    booleanID.put(player.getUniqueId(), true);
                } else {
                    booleanID.put(player.getUniqueId(), false);
                }
                timeMap.put(player.getUniqueId(), timeRemaining--);
            }
        }, 0L, 20L);

        taskID.put(player.getUniqueId(), tid);
    }

    public static void endTask(Player player){
        if(taskID.containsKey(player.getUniqueId())) {
            int tid = taskID.get(player.getUniqueId());
            Helper.get().getServer().getScheduler().cancelTask(tid);
            taskID.remove(player.getUniqueId());
        }

        if (timeMap.containsKey(player.getUniqueId())) {
            timeMap.remove(player.getUniqueId());
        }

    }

}

package me.agent.BukkitArc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerClass
  implements Listener
{
  public ListenerClass(BukkitArc plugin)
  
  {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }
  
  String bold = ChatColor.BOLD + "";
  String gold = ChatColor.GOLD + "";
  String white = ChatColor.WHITE + "";
  String yellow = ChatColor.YELLOW + "";
  String gray = ChatColor.GRAY + "";
  String red = ChatColor.RED + "";
  String green = ChatColor.GREEN + "";
  String it = ChatColor.ITALIC + "";
  String blue = ChatColor.AQUA + "";
  String purple = ChatColor.LIGHT_PURPLE + "";
  String re = ChatColor.RESET + "";
  String strike = ChatColor.STRIKETHROUGH + "    ";
  String space = "            ";
  String space2 = "  ";
  String un = ChatColor.UNDERLINE + "";
  String m = ChatColor.MAGIC + "";
  String money = gray + green + bold + " $$ ";
  String rad = red +bold + m + " IIIII ";
  
  public static final String HR = ChatColor.STRIKETHROUGH + StringUtils.repeat(" ", 23);

  @EventHandler
  public void onPlayerCraft(PlayerDropItemEvent e) {
	  
	  Player player = e.getPlayer();
	  
	  Item item = e.getItemDrop();
	  
	  Bukkit.broadcast(gray + "Player " + red + 
			  
			  player.getName().toString() 
			  
			  + gray + " dropped a(n) " + red + item + gray + "."
			  
			  , "arcane.notify");
	  
  }
	  
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
	
	Player player = e.getPlayer();
/*	String color = yellow;
	String dg = ChatColor.DARK_GREEN + "";
	String arrow = " " + gold + bold + ">" + yellow + bold + "> ";
	String barrow = " " + gold + bold + "<" + yellow + bold + "< ";
	
	
	plyr.sendMessage("");
	plyr.sendMessage(arrow);
	plyr.sendMessage(space2 + space2 + space2 + gray + "Welcome to" + gold + bold + " Arcane" + gold + bold +  " Survival");
	plyr.sendMessage(arrow + gray + "Welcome to the" + gold + bold + " Arcane Survival" + gray + " server!");
	plyr.sendMessage("");
	plyr.sendMessage(gray + "    You can type " + green + "/help" + gray + " for a list of server commands.");
	plyr.sendMessage(gray + "    Visit " + green + "http://www.arcane-minecraft.com" + gray + " for our website.");
	plyr.sendMessage(gray + "    Today is May 19th. Arcane is now one year old!");
	plyr.sendMessage("");*/


	player.sendMessage(gray + space2 + "");
	player.sendMessage(gray + HR + re + gold + bold + " Arcane Survival " + gray + HR);
    player.sendMessage(gray + space2 + "");
    player.sendMessage(white + "       You can type " + bold + gold + "/help" + re + white + " for a list of commands.");
    player.sendMessage(white + "  Visit our website at " + gold + "http://www.arcane-minecraft.com" + white + "!");
    player.sendMessage(gray + space2 + "");
    player.sendMessage(gray + space2 + "    You can donate for an extra /sethome here:");
    player.sendMessage(gray + space2 + "          http://arcanesurvival.buycraft.net/");
    player.sendMessage(gray + space2 + "");
    player.sendMessage(ChatColor.GRAY + HR + HR + HR + strike);
    player.sendMessage(gray + space2 + "");

/*    plyr.sendMessage(red + "[Notice] " + gray + "You can now donate for an extra /sethome!");
    plyr.sendMessage(red + " [Notice] " + gray + "We've added local chat to Arcane!");
    plyr.sendMessage(red + " [Notice] " + gray + "Type /l <message> to talk locally.");
    plyr.sendMessage("");*/
    
    if (player.hasPermission("new") & !player.isOp()) {
    	  
    	String tag = red + " [Notice] " + gray;
    	
    	  player.sendMessage(tag + ChatColor.DARK_RED +  "You do not have build permissions!");
    	  player.sendMessage("");
    	  player.sendMessage(tag + "You can ask a staff member for approval in the chat.");
    	  player.sendMessage(tag + "Otherwise, you can type " +green+ "/apply " + gray + "to apply via our forum.");
    	  player.sendMessage("");

    }
    
    if (player.hasPermission("arcane.donor")) {
    	
    	 Random randy = new Random();
    	 List<String> donorMessagesList = new ArrayList<String>();

    		donorMessagesList.add("We thank you for supporting Arcane! " + bold + "=)");
    		donorMessagesList.add("You're pretty awesome. Seriously.");
    		donorMessagesList.add("You're pretty awesome. Seriously. 100% awesome.");
    		donorMessagesList.add("By donating, you've helped make Arcane possible. " + bold + "Thanks!");
    		donorMessagesList.add("A really awesome person just joined the server. That's you.");
    		donorMessagesList.add("Welcome back to Arcane.");
    		donorMessagesList.add("Welcome back to Arcane. We've missed you.");
    		donorMessagesList.add("You're way cooler than everybody else.");
    		donorMessagesList.add("Thank you for your support!");
    		donorMessagesList.add("We trust you won't misuse your powerful /slap command.");
    		donorMessagesList.add("Thank you!");
    		donorMessagesList.add("Thank you for supporting Arcane!");
    		donorMessagesList.add("Your awesomeness level has reached 100/100.");
    		donorMessagesList.add("Don't forget, you have access to /slap.");
    		donorMessagesList.add("Don't forget, you have access to /slap. Use it wisely.");
    		donorMessagesList.add("You can hide yourself from the Dynmap via /dynmap hide.");
    		donorMessagesList.add("Did you know there's a donor only section on the forums?");
    		donorMessagesList.add("Welcome back to Arcane Survival! We've missed you.");
    		donorMessagesList.add("We love you.");
    		donorMessagesList.add("We love you. A lot.");
    		donorMessagesList.add("To reappear from the Dynmap if you've hidden yourself, type /dynmap show.");
    		donorMessagesList.add("Thank you.");
    		donorMessagesList.add("If you'd like to hide yourself from our Dynmap, type /dynmap hide.");
    		donorMessagesList.add("Did we tell you you're awesome? You are.");
    		donorMessagesList.add("You're pretty awesome. Not as awesome as _NickV is, though.");
    		donorMessagesList.add("You're pretty awesome. Almost as awesome as _NickV, keep it up.");
    		donorMessagesList.add("One day, you can tell your kids how you helped support Arcane. ");
    		donorMessagesList.add("Thank you. You're awesome.");
    		donorMessagesList.add("Welcome back to Arcane Survival.");
    		donorMessagesList.add("You're pretty awesome. Almost as awesome as Agentred100.");
    		donorMessagesList.add("Rumor has it that you're a pretty cool person.");
    		donorMessagesList.add("What cool stuff can we give to our donors? Let us know on the forums.");
    		donorMessagesList.add("We appreciate your support.");
    		donorMessagesList.add("If you're looking for some building ideas, type /dclem.");
    		donorMessagesList.add("We appreciate your support. :)");
    		
    		String r = donorMessagesList.get(randy.nextInt(donorMessagesList.size()));
   
      player.sendMessage(ChatColor.DARK_AQUA + " You are a donor. " + gray + r);
      player.sendMessage("");
      
    }
      
    }

  }
  
  


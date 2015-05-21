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
	  
	  Player p = e.getPlayer();
	  
	  Item item = e.getItemDrop();
	  
	  Bukkit.broadcast(gray + "Player " + red + 
			  
			  p.getName().toString() 
			  
			  + gray + " dropped a(n) " + red + item + gray + "."
			  
			  , "arcane.notify");
	  
  }
	  
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
	
	Player plyr = e.getPlayer();
	String color = yellow;
	String dg = ChatColor.DARK_GREEN + "";
	String arrow = " " + gold + bold + ">" + yellow + bold + "> ";
	String barrow = " " + gold + bold + "<" + yellow + bold + "< ";
	
	
//	plyr.sendMessage("");
//	//plyr.sendMessage(arrow);
//	//plyr.sendMessage(space2 + space2 + space2 + gray + "Welcome to" + gold + bold + " Arcane" + gold + bold +  " Survival");
//	plyr.sendMessage(arrow + gray + "Welcome to the" + gold + bold + " Arcane Survival" + gray + " server!");
//	plyr.sendMessage("");
//	plyr.sendMessage(gray + "    You can type " + green + "/help" + gray + " for a list of server commands.");
//	plyr.sendMessage(gray + "    Visit " + green + "http://www.arcane-minecraft.com" + gray + " for our website.");
//	plyr.sendMessage(gray + "    Today is May 19th. Arcane is now one year old!");
//	plyr.sendMessage("");


	plyr.sendMessage(gray + space2 + "");
	plyr.sendMessage(gray + HR + re + gold + bold + " Arcane Survival " + gray + HR);
    plyr.sendMessage(gray + space2 + "");
    plyr.sendMessage(white + "       You can type " + bold + gold + "/help" + re + white + " for a list of commands.");
    plyr.sendMessage(white + "  Visit our website at " + gold + "http://www.arcane-minecraft.com" + white + "!");
    plyr.sendMessage(gray + space2 + "");
    plyr.sendMessage(gray + space2 + "    You can donate for an extra /sethome here:");
    plyr.sendMessage(gray + space2 + "          http://arcanesurvival.buycraft.net/");
    plyr.sendMessage(gray + space2 + "");
    plyr.sendMessage(ChatColor.GRAY + HR + HR + HR + strike);
    plyr.sendMessage(gray + space2 + "");

    //plyr.sendMessage(red + "[Notice] " + gray + "You can now donate for an extra /sethome!");
    //plyr.sendMessage(red + " [Notice] " + gray + "We've added local chat to Arcane!");
    //plyr.sendMessage(red + " [Notice] " + gray + "Type /l <message> to talk locally.");
    //plyr.sendMessage("");
    
    if (plyr.hasPermission("new") & !plyr.isOp()) {
    	  
    	String tag = red + " [Notice] " + gray;
    	
    	  plyr.sendMessage(tag + ChatColor.DARK_RED +  "You do not have build permissions!");
    	  plyr.sendMessage("");
    	  plyr.sendMessage(tag + "You can ask a staff member for approval in the chat.");
    	  plyr.sendMessage(tag + "Otherwise, you can type " +green+ "/apply " + gray + "to apply via our forum.");
    	  plyr.sendMessage("");

    }
    
    if (plyr.hasPermission("arcane.donor")) {
    	
    	 Random randy = new Random();
    	 List<String> List = new ArrayList<String>();

    		List.add("We thank you for supporting Arcane! " + bold + "=)");
    		List.add("You're pretty awesome. Seriously.");
    		List.add("You're pretty awesome. Seriously. 100% awesome.");
    		List.add("By donating, you've helped make Arcane possible. " + bold + "Thanks!");
    		List.add("A really awesome person just joined the server. That's you.");
    		List.add("Welcome back to Arcane.");
    		List.add("Welcome back to Arcane. We've missed you.");
    		List.add("You're way cooler than everybody else.");
    		List.add("Thank you for your support!");
    		List.add("We trust you won't misuse your powerful /slap command.");
    		List.add("Thank you!");
    		List.add("Thank you for supporting Arcane!");
    		List.add("Your awesomeness level has reached 100/100.");
    		List.add("Don't forget, you have access to /slap.");
    		List.add("Don't forget, you have access to /slap. Use it wisely.");
    		List.add("You can hide yourself from the Dynmap via /dynmap hide.");
    		List.add("Did you know there's a donor only section on the forums?");
    		List.add("Welcome back to Arcane Survival! We've missed you.");
    		List.add("We love you.");
    		List.add("We love you. A lot.");
    		List.add("To reappear from the Dynmap if you've hidden yourself, type /dynmap show.");
    		List.add("Thank you.");
    		List.add("If you'd like to hide yourself from our Dynmap, type /dynmap hide.");
    		List.add("Did we tell you you're awesome? You are.");
    		List.add("You're pretty awesome. Not as awesome as _NickV is, though.");
    		List.add("You're pretty awesome. Almost as awesome as _NickV, keep it up.");
    		List.add("One day, you can tell your kids how you helped support Arcane. ");
    		List.add("Thank you. You're awesome.");
    		List.add("Welcome back to Arcane Survival.");
    		List.add("You're pretty awesome. Almost as awesome as Agentred100.");
    		List.add("Rumor has it that you're a pretty cool person.");
    		List.add("What cool stuff can we give to our donors? Let us know on the forums.");
    		List.add("We appreciate your support.");
    		List.add("If you're looking for some building ideas, type /dclem.");
    		List.add("We appreciate your support. :)");
    		
    		String r = List.get(randy.nextInt(List.size()));
   
      plyr.sendMessage(ChatColor.DARK_AQUA + " You are a donor. " + gray + r);
      plyr.sendMessage("");
      
    }
      
    }

  }
  
  


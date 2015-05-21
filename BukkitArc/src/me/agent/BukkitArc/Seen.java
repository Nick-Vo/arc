package me.agent.BukkitArc;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Seen extends JavaPlugin

{
	double version = 0.2D;
	Logger log = Logger.getLogger("Minecraft");

	public void onEnable()
	{
		this.log.info("[" + getDescription().getName() + "] " + getDescription().getVersion() + " enabled.");
	}

	public void onDisable()
	{
		this.log.info("[" + getDescription().getName() + "] " + getDescription().getVersion() + " disabled.");
	}

	public static String getCurrentDTG(long l_time)
	{
		Date date = new Date(l_time);
		SimpleDateFormat dtgFormat = new SimpleDateFormat("hh:mm:ss 'on' MMMM dd yyyy");
		return dtgFormat.format(date);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = null;
		if ((sender instanceof Player)) {
			player = (Player)sender;
		}
		if (cmd.getName().equalsIgnoreCase("ss"))
		{
			if (args.length == 0)
			{
				sender.sendMessage(ChatColor.GOLD + " ---- [Arcane Seen] ---- ");
				sender.sendMessage(ChatColor.YELLOW + "/seen <player>" + ChatColor.WHITE + "- Display the date a player was last seen.");
				sender.sendMessage(ChatColor.YELLOW + "/seenf <player>" + ChatColor.WHITE + "- Diplay the date a player joined Arcane.");
				sender.sendMessage(ChatColor.YELLOW + "/fplayer <Part of name> " + ChatColor.GRAY + "- Search for a player");
				sender.sendMessage(ChatColor.GRAY + "Note: These commands are " + ChatColor.RED + "CaseSensitive");
				return true;
			}
			if ((args.length == 1) && (args[0].equalsIgnoreCase("version")))
			{
				sender.sendMessage(ChatColor.GOLD + "[" + getDescription().getName() + "] " + " Version: " + ChatColor.RED + getDescription().getVersion());
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("seen"))
		{
			if (player == null)
			{
				sender.sendMessage("This command can only be run by a player.");
			}
			else if (args.length == 0)
			{
				sender.sendMessage(ChatColor.GOLD + " ---- [Arcane Seen] ---- ");
				sender.sendMessage(ChatColor.YELLOW + "/seen <player>" + ChatColor.WHITE + "- Display the date a player was last seen.");
				sender.sendMessage(ChatColor.YELLOW + "/seenf <player>" + ChatColor.WHITE + "- Diplay the date a player joined Arcane.");
				sender.sendMessage(ChatColor.YELLOW + "/fplayer <Part of name> " + ChatColor.GRAY + "- Search for a player");
				sender.sendMessage(ChatColor.GRAY + "Note: These commands are " + ChatColor.RED + "CaseSensitive");
				return true;
			}
			if (args.length == 1)
			{
				Player targeton = getServer().getPlayer(args[0]);
				if (targeton != null)
				{
					sender.sendMessage(ChatColor.BLUE + targeton.getDisplayName() + ChatColor.GRAY + " is online right now!");
					return true;
				}
				OfflinePlayer target = getServer().getOfflinePlayer(args[0]);
				long lastseen = target.getLastPlayed();
				if (lastseen == 0L)
				{
					sender.sendMessage(ChatColor.BLUE + "'" + args[0] + "'" + ChatColor.GRAY + " has not been seen.");
					sender.sendMessage(ChatColor.GOLD + "(Must use exact username)");
					return true;
				}
				String strDte = getCurrentDTG(lastseen);
				sender.sendMessage(ChatColor.BLUE + target.getName() + ChatColor.GRAY + " was last seen: " + ChatColor.BLUE + strDte);
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("seenf"))
		{
			if (args.length == 0) {
				if (player == null)
				{
					sender.sendMessage("This command can only be run by a player");
				}
				else
				{
					long firstseen = player.getFirstPlayed();
					String strDte = getCurrentDTG(firstseen);
					player.sendMessage(ChatColor.GRAY + "You first logged in: " + ChatColor.BLUE + strDte);
					return true;
				}
			}
			if (args.length == 1)
			{
				Player targeton = getServer().getPlayer(args[0]);
				if (targeton == null)
				{
					OfflinePlayer target = getServer().getOfflinePlayer(args[0]);
					long firstseen = target.getFirstPlayed();
					if (firstseen == 0L)
					{
						sender.sendMessage(ChatColor.BLUE + "'" + args[0] + "'" + ChatColor.GRAY + " has not been seen!");
						sender.sendMessage(ChatColor.GOLD + "(Must use exact username)");
						return true;
					}
					String strDte = getCurrentDTG(firstseen);
					sender.sendMessage(ChatColor.BLUE + target.getName() + ChatColor.GRAY + " first logged in: " + ChatColor.BLUE + strDte);
				}
				else
				{
					long firstseen = targeton.getFirstPlayed();
					String strDte = getCurrentDTG(firstseen);
					sender.sendMessage(ChatColor.BLUE + targeton.getName() + ChatColor.GRAY + " first logged in: " + ChatColor.BLUE + strDte);
				}
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("fplayer")) {
			if (player == null)
			{
				sender.sendMessage("This command can only be run by a player");
			}
			else
			{
				if (args.length == 0)
				{
					sender.sendMessage(ChatColor.GOLD + " ----- Player Search ----- ");
					sender.sendMessage(ChatColor.BLUE + "/fplayer PartofName " + ChatColor.GRAY + "- Search for a player " + ChatColor.RED + "(CaseSensitive)");
					return true;
				}
				sender.sendMessage(ChatColor.GOLD + "Search Results:");

				OfflinePlayer[] Results = Bukkit.getServer().getOfflinePlayers();
				for (int i = 0; i < Results.length; i++) {
					if (Results[i].getName().contains(args[0])) {
						sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.BLUE + Results[i].getName());
					}
				}
				return true;
			}
		}
		return false;
	}
}
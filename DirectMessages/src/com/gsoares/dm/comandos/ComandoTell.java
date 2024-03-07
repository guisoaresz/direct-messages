package com.gsoares.dm.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gsoares.dm.addons.AddonResponder;

public class ComandoTell implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tell")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("tell.use")) {
					if(args.length == 0) {
						p.sendMessage("\n" + ChatColor.DARK_GREEN + "[*] Utilize: /tell (nick) (mensagem).");
					} else if(args.length >= 2) {
						Player p2 = Bukkit.getServer().getPlayer(args[0]);
						if(p2 != null) {
							if(p.getUniqueId() == p2.getUniqueId()) {
								return true;
							}
							int qtdMensagem = args.length - 1;
							String mensagem = "";
							String playerNick = p.getDisplayName();
							String player2Nick = p2.getDisplayName();
							if(qtdMensagem != 0) {
								for(int x = 1; x <= qtdMensagem; x++) {
									mensagem += args[x] + " ";
								}	
							} else {
								p.sendMessage("\n" + ChatColor.DARK_GREEN + "[*] Utilize: /tell (nick) (mensagem).");
							}
							AddonResponder.addLista(p2.getUniqueId(), p.getUniqueId());
							p.sendMessage("\n" + ChatColor.DARK_GREEN + "Mensagem para " + player2Nick
							+ ": " + ChatColor.GREEN + mensagem);
							p2.sendMessage("\n" + ChatColor.DARK_GREEN + "Mensagem de " + playerNick
							+ ": " + ChatColor.GREEN + mensagem);
						} else {
							p.sendMessage("\n" + ChatColor.RED + "[*] Jogador offline ou inexistente.");
						}
					} else {
						p.sendMessage("\n" + ChatColor.DARK_GREEN + "[*] Utilize: /tell (nick) (mensagem).");
					}
				} else {
					p.sendMessage("\n" + ChatColor.RED + "[*] Você não possui permissão.");
				}
			} else {
				sender.sendMessage("\n" + ChatColor.RED + "[*] Comando apenas para jogadores.");
			}
		}
		return false;
	}
	
}

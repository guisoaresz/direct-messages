package com.gsoares.dm.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gsoares.dm.addons.AddonResponder;

public class ComandoResponder implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("responder")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("tell.use")) {
					if(AddonResponder.checkLista(p.getUniqueId()) != null) {
						if(args.length == 0) {
							p.sendMessage("\n" + ChatColor.DARK_GREEN + "[*] Utilize: /responder (mensagem).");
						} else if(args.length >= 1) {
							Player p2 = AddonResponder.checkLista(p.getUniqueId());
							if(p2 != null) {
								int qtdMensagem = args.length;
								String mensagem = "";
								String playerNick = p.getDisplayName();
								String player2Nick = p2.getDisplayName();
								if(qtdMensagem != 0) {
									for(int x = 0; x <= qtdMensagem - 1; x++) {
										mensagem += args[x] + " ";
									}
									AddonResponder.addLista(p2.getUniqueId(), p.getUniqueId());
								} else {
									p.sendMessage("\n" + ChatColor.DARK_GREEN + "[*] Utilize: /responder (mensagem).");
								}
								p.sendMessage("\n" + ChatColor.DARK_GREEN + "Mensagem para " + player2Nick
								+ ": " + ChatColor.GREEN + mensagem);
								p2.sendMessage("\n" + ChatColor.DARK_GREEN + "Mensagem de " + playerNick
								+ ": " + ChatColor.GREEN + mensagem);
							} else {
								p.sendMessage("\n" + ChatColor.RED + "[*] Jogador offline ou inexistente.");
							}
						} else {
							p.sendMessage("\n" + ChatColor.DARK_GREEN + "[*] Utilize: /responder (mensagem).");
						}
					} else {
						p.sendMessage("\n" + ChatColor.RED + "[*] Você não tem ninguém pra responder.");
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

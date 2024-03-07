package com.gsoares.dm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.gsoares.dm.comandos.ComandoResponder;
import com.gsoares.dm.comandos.ComandoTell;

public class Main extends JavaPlugin{
	
	public void onEnable() {
		Comandos();
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[DirectMessages] Plugin foi habilitado com sucesso.");
	}
	
	public void Comandos() {
		Bukkit.getPluginCommand("tell").setExecutor(new ComandoTell());
		Bukkit.getPluginCommand("responder").setExecutor(new ComandoResponder());
	}
}

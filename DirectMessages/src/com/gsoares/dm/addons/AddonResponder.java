package com.gsoares.dm.addons;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AddonResponder {
	
	public static HashMap<UUID, UUID> listaRespostas = new HashMap<UUID, UUID>();
	
	public static void addLista(UUID playerUUID, UUID player2UUID) {
		if(checkLista(playerUUID) != null) {
			removeLista(playerUUID);
		}
		listaRespostas.put(playerUUID, player2UUID);
	}
	public static void removeLista(UUID playerUUID) {
		listaRespostas.remove(playerUUID);
	}
	
	public static Player checkLista(UUID playerUUID) {
		UUID uuid = listaRespostas.get(playerUUID);
		Player p = Bukkit.getServer().getPlayer(uuid);
		return p;
	}
}

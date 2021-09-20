package it.kayes.core.functions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Messages {
	
	// str.str2 -> String[]
	private static HashMap<String, String[]> messages = new HashMap<String, String[]>();
	
	public static HashMap<String, String[]> getMessages() {
		return messages;
	}
	
	public static String[] getMessage(String path) {
		return messages.get(path);
	}
	
	private static String prefix = "";
	
	public static String getPrefix() {
		return prefix;
	}
	
	public static void load() {
		File f = new File("plugins/KayEs-Core" + File.separator + "messages.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		
		if (!f.exists()) {
			try {f.createNewFile();} catch (IOException e) {e.printStackTrace();}
			
			//GENERALI
			cfg.set("general.prefix", new String[] {"&f&lKAY-ES &b&l➤"});
			cfg.set("general.accept", new String[] {"&a&l✔"});
			cfg.set("general.deny", new String[] {"&c&l✘"});
			
			//ERRORI
			cfg.set("error.nopermission", new String[] {"%PREFIX% &fNon possiedi i permessi per eseguire questa azione"});
			cfg.set("error.noargs", new String[] {"%PREFIX% &fArgomenti insufficenti"});
			cfg.set("error.player-notonline", new String[] {"%PREFIX% &fIl giocatore non è online"});
			cfg.set("error.player-notexist", new String[] {"%PREFIX% &fIl giocatore non esiste"});
			cfg.set("error.player-notconsole", new String[] {"%PREFIX% &fSolo un giocatore può eseguire questa azione"});
			
			//TELEPORTS
			cfg.set("teleport.request", new String[] {"","%PREFIX% &b%SENDER% &fvuole teletrasportarsi da te &7[%ACCEPT%&7] &7[%DENY%&7]",""});
			cfg.set("teleport.requesthere", new String[] {"","%PREFIX% &b%SENDER% &fvuole che ti teletrasporti da lui &7[%ACCEPT%&7] &7[%DENY%&7]",""});
			cfg.set("teleport.request-send", new String[] {"","%PREFIX% &fRichiesta inviata",""});
			cfg.set("teleport.requestaccept-you", new String[] {"","%PREFIX% &fRichiesta accettata",""});
			cfg.set("teleport.requestaccept-send", new String[] {"","%PREFIX% &b%VICTIM% &fha accettato la richiesta",""});
			cfg.set("teleport.requestdeny-you", new String[] {"","%PREFIX% &fRichiesta rifiutata",""});
			cfg.set("teleport.requestdeny-send", new String[] {"","%PREFIX% &b%VICTIM% &fha rifiutato la richiesta",""});
			cfg.set("teleport.requestcancel-you", new String[] {"","%PREFIX% &fRichiesta cancellata",""});
			cfg.set("teleport.requestcancel-send", new String[] {"","%PREFIX% &b%SENDER% &fha cancellato la richiesta",""});
			cfg.set("teleport.tp", new String[] {"","%PREFIX% &fTi sei teletrasportato da &b%VICTIM%",""});
			cfg.set("teleport.tphere", new String[] {"","%PREFIX% &fHai teletrasportato &b%VICTIM% &fda te",""});
			cfg.set("teleport.tpall", new String[] {"","%PREFIX% &fHai teletrasportato tutti i giocatori da te",""});
			cfg.set("teleport.notsecure", new String[] {"","%PREFIX% &fTeletrasporto non sicuro",""});
			cfg.set("teleport.notrequest", new String[] {"","%PREFIX% &fNon possiedi nessuna richiesta",""});
			cfg.set("teleport.alredyrequest", new String[] {"","%PREFIX% &fRichiesta già inviata",""});
			cfg.set("teleport.request-self", new String[] {"","%PREFIX% &fNon puoi inviare una richiesta a te stesso",""});
			
			try {cfg.save(f);} catch (IOException e) {e.printStackTrace();}
		}
		
		//GENERALI
		getMessages().put("general.prefix", cfg.getStringList("general.prefix").toArray(new String[cfg.getStringList("general.prefix").size()]));
		getMessages().put("general.accept", (String[]) cfg.getStringList("general.accept").toArray(new String[cfg.getStringList("general.accept").size()]));
		getMessages().put("general.deny", (String[]) cfg.getStringList("general.deny").toArray(new String[cfg.getStringList("general.deny").size()]));
		
		prefix = ((String[]) cfg.getStringList("general.prefix").toArray(new String[cfg.getStringList("general.prefix").size()]))[0];
		
		//ERRORI
		getMessages().put("error.nopermission", (String[]) cfg.getStringList("error.nopermission").toArray(new String[cfg.getStringList("error.nopermission").size()]));
		getMessages().put("error.noargs", (String[]) cfg.getStringList("error.noargs").toArray(new String[cfg.getStringList("error.noargs").size()]));
		getMessages().put("error.player-notonline", (String[]) cfg.getStringList("error.player-notonline").toArray(new String[cfg.getStringList("error.player-notonline").size()]));
		getMessages().put("error.player-notexist", (String[]) cfg.getStringList("error.player-notexist").toArray(new String[cfg.getStringList("error.player-notexist").size()]));
		getMessages().put("error.player-notconsole", (String[]) cfg.getStringList("error.player-notconsole").toArray(new String[cfg.getStringList("error.player-notconsole").size()]));
		
		//TELEPORTS
		getMessages().put("teleport.request", (String[]) cfg.getStringList("teleport.request").toArray(new String[cfg.getStringList("teleport.request").size()]));
		getMessages().put("teleport.requesthere", (String[]) cfg.getStringList("teleport.requesthere").toArray(new String[cfg.getStringList("teleport.requesthere").size()]));
		getMessages().put("teleport.request-send", (String[]) cfg.getStringList("teleport.request-send").toArray(new String[cfg.getStringList("teleport.request-send").size()]));
		getMessages().put("teleport.requestaccept-you", (String[]) cfg.getStringList("teleport.requestaccept-you").toArray(new String[cfg.getStringList("teleport.requestaccept-you").size()]));
		getMessages().put("teleport.requestaccept-send", (String[]) cfg.getStringList("teleport.requestaccept-send").toArray(new String[cfg.getStringList("teleport.requestaccept-send").size()]));
		getMessages().put("teleport.requestdeny-you", (String[]) cfg.getStringList("teleport.requestdeny-you").toArray(new String[cfg.getStringList("teleport.requestdeny-send").size()]));
		getMessages().put("teleport.requestdeny-send", (String[]) cfg.getStringList("teleport.requestdeny-send").toArray(new String[cfg.getStringList("teleport.requestcancel-you").size()]));
		getMessages().put("teleport.requestcancel-you", (String[]) cfg.getStringList("teleport.requestcancel-you").toArray(new String[cfg.getStringList("teleport.requestcancel-send").size()]));
		getMessages().put("teleport.requestcancel-send", (String[]) cfg.getStringList("teleport.requestcancel-send").toArray(new String[cfg.getStringList("teleport.requestcancel-send").size()]));
		getMessages().put("teleport.tp", (String[]) cfg.getStringList("teleport.tp").toArray(new String[cfg.getStringList("teleport.tp").size()]));
		getMessages().put("teleport.tphere", (String[]) cfg.getStringList("teleport.tphere").toArray(new String[cfg.getStringList("teleport.tphere").size()]));
		getMessages().put("teleport.tpall", (String[]) cfg.getStringList("teleport.tpall").toArray(new String[cfg.getStringList("teleport.tpall").size()]));
		getMessages().put("teleport.notsecure", (String[]) cfg.getStringList("teleport.notsecure").toArray(new String[cfg.getStringList("teleport.notsecure").size()]));
		getMessages().put("teleport.notrequest", (String[]) cfg.getStringList("teleport.notrequest").toArray(new String[cfg.getStringList("teleport.notrequest").size()]));
		getMessages().put("teleport.alredyrequest", (String[]) cfg.getStringList("teleport.alredyrequest").toArray(new String[cfg.getStringList("teleport.alredyrequest").size()]));
		getMessages().put("teleport.request-self", (String[]) cfg.getStringList("teleport.request-self").toArray(new String[cfg.getStringList("teleport.request-self").size()]));
	}

}

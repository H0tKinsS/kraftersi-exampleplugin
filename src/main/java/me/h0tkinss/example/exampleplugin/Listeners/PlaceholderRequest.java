package me.h0tkinss.example.exampleplugin.Listeners;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.h0tkinss.example.exampleplugin.ExamplePlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class PlaceholderRequest extends PlaceholderExpansion{
    private ExamplePlugin plugin;
    public PlaceholderRequest(ExamplePlugin plugin) {
        this.plugin = plugin;

    }
    @Override
    public String onPlaceholderRequest(Player p, String identifier) {

        FileConfiguration config = plugin.getConfig();
        if (identifier.equals("ruby")) {
            int money = (int) (plugin.getPpAPI().look(p.getUniqueId()));
            String result = "" + money;
            StringBuilder s = new StringBuilder(result.length());
            CharacterIterator it = new StringCharacterIterator(result);
            for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
                switch (ch) {
                    case '0':
                        s.append(config.getString("char-0"));
                        break;
                    case '1':
                        s.append(config.getString("char-1"));
                        break;
                    case '2':
                        s.append(config.getString("char-2"));
                        break;
                    case '3':
                        s.append(config.getString("char-3"));
                        break;
                    case '4':
                        s.append(config.getString("char-4"));
                        break;
                    case '5':
                        s.append(config.getString("char-5"));
                        break;
                    case '6':
                        s.append(config.getString("char-6"));
                        break;
                    case '7':
                        s.append(config.getString("char-7"));
                        break;
                    case '8':
                        s.append(config.getString("char-8"));
                        break;
                    case '9':
                        s.append(config.getString("char-9"));
                        break;
                    default:
                        s.append(ch);
                        break;
                }
            }

            result = s.toString();

            return result;
        }
        return null;
    }

    @Override
    public String getIdentifier() {
        return "exampleplugin";
    }

    @Override
    public String getAuthor() {
        return "H0tKinsS";
    }

    @Override
    public String getVersion() {
        return null;
    }
}


package Scene;

import java.util.Map;

public abstract class Data {
	public static Map<String,String> HIV = Map.ofEntries(
			Map.entry("Type", "2 Types Of HIV Virus.png"),
			Map.entry("Attack", "attack CD4 celss.png"),
			Map.entry("Infiltrate cells", "Infiltrade cell.png"),
			Map.entry("Cell Activated", "cell activated.png"),
			Map.entry("Replication and target to different cells", "replication and target to different cells.png")
			);
	public static Map<String,String> Covid19 = Map.ofEntries();
	public static Map<String,String> Hepa = Map.ofEntries();
	public static Map<String,String> Japan = Map.ofEntries();
	public static Map<String,String> Flu = Map.ofEntries();
	public static Map<String,String> Iassa = Map.ofEntries();
	public static Map<String,String> Chiku = Map.ofEntries();
	public static Map<String,String> Crim = Map.ofEntries();
	public static Map<String,String> Ebola = Map.ofEntries();
	public static Map<String,String> Nipah = Map.ofEntries();
	public static Map<String,String> Zika = Map.ofEntries();
	public static Map<String,String> Marburg = Map.ofEntries();
}

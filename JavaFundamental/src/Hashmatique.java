import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
	public static void main(String[] args) {
		HashMap<String, String> trackList = new HashMap<String, String>();
		trackList.put("Better Now", "You probably think that you are better now, better now");
		trackList.put("Girls Like You", "Spent 24 hours I need more hours with you");
		trackList.put("Youngblood", "Remember the words you told me, love me 'til the day I die");
		trackList.put("Back To You", "Took you like a shot Thought that I could chase you with a cold evening" );
		trackList.put("God is a Woman", "You, you love it how I move you You love it how I touch you, my one" );
		System.out.println(trackList.get("Better Now"));
		Set<String> keys = trackList.keySet();
		for(String key : keys) {
			System.out.printf("Song title: %s.\nSample Lyrics: %s\n", key, trackList.get(key));
		}
	}
}

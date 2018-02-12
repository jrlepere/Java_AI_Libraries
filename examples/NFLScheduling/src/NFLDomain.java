import java.util.LinkedList;
import java.util.List;

import csp.Domain;

public class NFLDomain implements Domain<List<NFLMatchup>> {

	public NFLDomain(int maxMatchups) {
		this.values = new LinkedList<>();
	}
	
	public List<List<NFLMatchup>> getValues() {
		return values;
	}

	private List<List<NFLMatchup>> values;
	
	public static class AllNFLMatchups {
		public AllNFLMatchups() {
			ALL_MATCHUPS = new LinkedList<>();
			ALL_MATCHUPS.add(new NFLMatchup(NFLTeam.NE, NFLTeam.BUF));
			ALL_MATCHUPS.add(new NFLMatchup(NFLTeam.BUF, NFLTeam.NE));
		}
		static List<NFLMatchup> ALL_MATCHUPS;
	}
	
}

public class NFLMatchup {
	
	public NFLMatchup(NFLTeam home, NFLTeam visitor) {
		this.home = home;
		this.visitor = visitor;
	}
	
	public NFLTeam getHome() {
		return home;
	}
	
	public NFLTeam getVisitor() {
		return visitor;
	}
	
	private NFLTeam home, visitor;
	
}

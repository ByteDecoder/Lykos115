import java.util.Comparator;

class TeamInfo implements Comparator<TeamInfo> {
	
	private String teamName;
	private int teamScore;
	
	TeamInfo(){
		teamName = null;
		teamScore = 0;
	}
	TeamInfo(String teamName, int teamScore){
		this.teamName = teamName;
		this.teamScore = teamScore;
	}
	
	String getName(){
		return teamName;
	}
	
	int getScore(){
		return teamScore;
	}
	void addScore(int teamScore){
		this.teamScore = teamScore;
	}
	public boolean equals(Object temp){
		if (temp instanceof TeamInfo) {
			TeamInfo x = (TeamInfo) temp;
			if (this.teamName.equals(x.teamName)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int compare(TeamInfo teamOne, TeamInfo teamTwo){
		int temp = teamTwo.getScore() - teamOne.getScore();
		if (temp == 0) {
			String one = teamOne.getName().replaceAll(" ", "");
			String two = teamTwo.getName().replaceAll(" ", "");
			if (teamOne.getScore() == teamTwo.getScore()) {
				return one.compareToIgnoreCase(two);
			}
			return 0;
		}
		return temp;
	}
	
}
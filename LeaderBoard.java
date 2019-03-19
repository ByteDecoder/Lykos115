import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

class LeaderBoard {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner inStream = null;
		String path = null;
		ArrayList<TeamInfo> LeaderBoard = new ArrayList<TeamInfo>();
		System.out.print("Read in file: ");
		path = input.next();
		
		try {
			inStream = new Scanner(new FileInputStream(path));
		} catch (Exception e) {
			System.out.println("Error: File not found.");
			System.exit(0);
			
		}

		while (inStream.hasNextLine()) {
			path = inStream.nextLine();
			String hold[] = path.split(", ");
			
			Integer team1 = Integer.parseInt(hold[0].substring(hold[0].length() - 1));
			String teamA = hold[0].substring(0,hold[0].length() - 2);
			
			Integer team2 = Integer.parseInt(hold[1].substring(hold[1].length() - 1));
			String teamB = hold[1].substring(0,hold[1].length() - 2);
			
			TeamInfo teamOne = new TeamInfo(teamA, 0);
			TeamInfo teamTwo = new TeamInfo(teamB, 0);
			
			if (!LeaderBoard.contains(teamOne)) {
				LeaderBoard.add(teamOne);
			}
			if (!LeaderBoard.contains(teamTwo)) {
				LeaderBoard.add(teamTwo);
			}
			
			if (team1 > team2) {
				TeamInfo one = LeaderBoard.get(LeaderBoard.indexOf(teamOne));
				one.addScore(one.getScore() + 3);
			}else if (team1 < team2) {
				TeamInfo two = LeaderBoard.get(LeaderBoard.indexOf(teamTwo));
				two.addScore(two.getScore() + 3);
			}else{
				TeamInfo one = LeaderBoard.get(LeaderBoard.indexOf(teamOne));
				TeamInfo two = LeaderBoard.get(LeaderBoard.indexOf(teamTwo));
				one.addScore(one.getScore() + 1);
				two.addScore(two.getScore() + 1);
			}
			
		}

		Collections.sort(LeaderBoard, new TeamInfo());
		int i = 1;
		for (TeamInfo it:LeaderBoard) {
			System.out.println(i + ". " + it.getName() + ", " + it.getScore() + " pts");
			i++;
		}
	}
}
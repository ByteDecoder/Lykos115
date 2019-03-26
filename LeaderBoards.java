import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

class LeaderBoards {
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
			
			Integer team1 = Integer.parseInt(hold[0].substring(hold[0].lastIndexOf(' ') + 1,hold[0].length()));
			String teamA = hold[0].substring(0,hold[0].lastIndexOf(' '));
			
			Integer team2 = Integer.parseInt(hold[1].substring(hold[1].lastIndexOf(' ') + 1,hold[1].length()));
			String teamB = hold[1].substring(0,hold[1].lastIndexOf(' '));
			
			TeamInfo teamOne = new TeamInfo(teamA, 0);
			TeamInfo teamTwo = new TeamInfo(teamB, 0);
//			System.out.println("team1: " + team1 + " team2: " + team2 + "\n");
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
		int k = 1;
		int temp = 0;
		for (int i = 0; i < LeaderBoard.size() - 1; i++) {
			TeamInfo it = LeaderBoard.get(i);
			TeamInfo next = LeaderBoard.get(i + 1); 
			if (it.getScore() == next.getScore()) {
				System.out.println(k + ". " + it.getName() + ", " + it.getScore() + " pts");
				temp++;
			}else{
				System.out.println(k + ". " + it.getName() + ", " + it.getScore() + " pts");
				k += temp + 1;
				temp = 0;
			}
		}
		TeamInfo it = LeaderBoard.get(LeaderBoard.size() - 1);
		System.out.println(k + ". " + it.getName() + ", " + it.getScore() + " pts");
	}
}

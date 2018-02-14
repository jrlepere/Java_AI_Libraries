import java.util.Scanner;

import games.Decision;
import games.MiniMax;
import games.Problem;

public class Main {
		
	public static void main(String[] args) {
		Problem<Mark, Board> p = new TicTacToe();
		Decision<Mark, Board> d = new MiniMax<>(p);
		//Decision<Mark, Board> d = new AlphaBeta<>(p);
		
		Scanner in = new Scanner(System.in);
		humanFirst(p, d, in);
		//computerFirst(p, d, in);
		in.close();
	}
	
	private static void computerFirst(Problem<Mark, Board> p, Decision<Mark, Board> d, Scanner in) {
		Board s = p.getInitialState();
		System.out.println(s);
		while (!p.isTerminalState(s)) {
			s = d.getOptimalSuccessor(s).execute(s);
			System.out.println("-----\n" + s);
			if (p.isTerminalState(s)) break;
			System.out.print("--> ");
			int m = in.nextInt() - 1;
			Mark mark = new Mark(Symbol.O, m / 3, m % 3);
			s = mark.execute(s);
			System.out.println(s);
		}
	}
	
	private static void humanFirst(Problem<Mark, Board> p, Decision<Mark, Board> d, Scanner in) {
		Board s = p.getInitialState();
		System.out.println(s);
		while (!p.isTerminalState(s)) {
			System.out.print("--> ");
			int m = in.nextInt() - 1;
			Mark mark = new Mark(Symbol.X, m / 3, m % 3);
			s = mark.execute(s);
			System.out.println(s);
			if (p.isTerminalState(s)) break;
			s = d.getOptimalSuccessor(s).execute(s);
			System.out.println("-----\n" + s);
		}
	}
	
}

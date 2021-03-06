import local_search.GeneticAlgorithmSearch.StateBitStreamConversion;
import problem.State;

public class NQueensStateBitStreamConverstion implements StateBitStreamConversion {

	public NQueensStateBitStreamConverstion(int n) {
		this.n = n;
		this.alwaysAcceptableBitStream = ((n & (n-1)) == 0);
	}
	
	public int[] getBitStream(State s) {
		int[] queenLocations = ((NQueensState) s).getQueenLocations();
		int maxBits = Integer.toBinaryString(n-1).length();
		int[] bitStream = new int[maxBits * n];
		for (int i = 0; i < n; i ++) {
			String bString = Integer.toBinaryString(queenLocations[i]);
			for (int e = bString.length(); e < maxBits; e ++) {
				bString = "0" + bString;
			}
			for (int j = 0; j < maxBits; j ++) {
				bitStream[i*maxBits+j] = bString.charAt(j) - 48;
			}
		}
		return bitStream;
	}

	public State convertBitStream(int[] s) {
		int maxBits = Integer.toBinaryString(n-1).length();
		int[] queenLocations = new int[n];
		int numIterations = s.length/maxBits; 
		for (int i = 0; i < numIterations; i ++) {
			int h = i * maxBits;
			queenLocations[i] = bitStreamToInt(s, h, maxBits);
		}
		return new NQueensState(queenLocations);
	}
	
	public boolean isAcceptableBitStream(int[] s) {
		if (alwaysAcceptableBitStream) {
			return true;
		}
		int maxBits = Integer.toBinaryString(n-1).length();
		int numIterations = s.length/maxBits; 
		for (int i = 0; i < numIterations; i ++) {
			int h = i * maxBits;
			if (bitStreamToInt(s, h, maxBits) >= n) return false;
		}
		return true;
	}
	
	private int bitStreamToInt(int[] s, int start, int maxBits) {
		int res = 0;
		for (int i = 0; i < maxBits; i ++) {
			if (s[start+i] == 1) {
				res += Math.pow(2,(maxBits - (i + 1)));
			}
		}
		return res;
	}
	
	private int n;
	private boolean alwaysAcceptableBitStream;

}

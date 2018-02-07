import static org.junit.Assert.*;

import org.junit.Test;

public class NQueensStateBitStreamConverstionTest {
	
	@Test
	public void test1() {
		int[] queenLocations = new int[]{0,1,2,3};
		int[] bitStream = new int[]{0,0,0,1,1,0,1,1};
		NQueensStateBitStreamConverstion c = new NQueensStateBitStreamConverstion(queenLocations.length);
		assertArrayEquals(bitStream,c.getBitStream(new NQueensState(queenLocations)));
		assertArrayEquals(queenLocations,((NQueensState) c.convertBitStream(bitStream)).getQueenLocations());
	}
	
	@Test
	public void test2() {
		int[] queenLocations = new int[]{5,3,7,0,1,4,6,2};
		int[] bitStream = new int[]{1,0,1,0,1,1,1,1,1,0,0,0,0,0,1,1,0,0,1,1,0,0,1,0};
		NQueensStateBitStreamConverstion c = new NQueensStateBitStreamConverstion(queenLocations.length);
		assertArrayEquals(c.getBitStream(new NQueensState(queenLocations)),bitStream);
		assertArrayEquals(((NQueensState) c.convertBitStream(bitStream)).getQueenLocations(),queenLocations);
	}
	
	@Test
	public void test3() {
		int[] queenLocations = new int[]{0,1,2,3,4};
		int[] bitStream = new int[]{0,0,0,0,0,1,0,1,0,0,1,1,1,0,0};
		NQueensStateBitStreamConverstion c = new NQueensStateBitStreamConverstion(queenLocations.length);
		assertArrayEquals(bitStream,c.getBitStream(new NQueensState(queenLocations)));
		assertArrayEquals(queenLocations,((NQueensState) c.convertBitStream(bitStream)).getQueenLocations());
	}
	
	@Test
	public void test4() {
		int[] queenLocations = new int[]{4,3,1,0,2};
		int[] bitStream = new int[]{1,0,0,0,1,1,0,0,1,0,0,0,0,1,0};
		NQueensStateBitStreamConverstion c = new NQueensStateBitStreamConverstion(queenLocations.length);
		assertArrayEquals(bitStream,c.getBitStream(new NQueensState(queenLocations)));
		assertArrayEquals(queenLocations,((NQueensState) c.convertBitStream(bitStream)).getQueenLocations());
	}
	
	@Test
	public void test5() {
		int[] queenLocations = new int[]{5,3,7,0,8,1,4,6,2};
		int[] bitStream = new int[]{0,1,0,1,0,0,1,1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,1,0};
		NQueensStateBitStreamConverstion c = new NQueensStateBitStreamConverstion(queenLocations.length);
		assertArrayEquals(c.getBitStream(new NQueensState(queenLocations)),bitStream);
		assertArrayEquals(((NQueensState) c.convertBitStream(bitStream)).getQueenLocations(),queenLocations);
	}

}

package searchnsort;

import org.junit.Test;

/**
 * @author sabiya
 *
 */
public class JumpSearch {

	
	@Test
	public void testJumpSearch() {
		int input[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
		System.out.print( "Index of : " + jumpSearch(input, 16, 89));
		
	}
	
	public int jumpSearch(int input[], int n , int no){
		int m = (int)  Math.floor(Math.sqrt(n));
		
//		System.out.print(m);
		int step = 0;
		while ((step*m) < n && input[step*m] < no) {
			step++;
		}
			int i = (step -1) * m;
			int j=  step * m;
			while ((i<=Math.min(j,n-1)) && input[i] != no )
				i++;
			if (input[Math.min(i,n-1)] == no)
				return i;
		
		return -1;
	}
}

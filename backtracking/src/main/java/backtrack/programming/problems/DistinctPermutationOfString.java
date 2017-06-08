package backtrack.programming.problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class DistinctPermutationOfString {

	@Test
	public void test() {
		char s[] = {'a','a', 'a'};
		permutation(s, 0, s.length);
		
	}
	
	public void permutation(char []s, int i, int n){
		
		if(i==n-1)
			System.out.print("\n" +new String(s));
		else {
			for(int j=i; j<n; j++) {
				if(s[j] != s[i] || j==i){
					swap(s, j, i);
					permutation(s, i+1, n);
					swap(s, j, i);
				}
				
			}
		}
		
	}

	private void swap(char[] s, int x, int y) {
		// TODO Auto-generated method stub
		char ch = s[x];
		s[x] = s[y];
		s[y] = ch;
		
	}

}

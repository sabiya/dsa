package dynamic.programming.problems;

/**
 * @author sabiya
 *
 */
public class FindLCS {

	public static void main(String [] args){
		
		String s = findLongestSequence("ABCDGH","AEDFHR");
		System.out.println("------- :" +s);
		String seq1 = "AGGTAB", seq2="GXTXAYB";
		
		int s1 = findLCS(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length());
		System.out.println("------- :" +s1);
		
	}
	
	
	public static String findLongestSequence(String s1, String s2){
		String sequence;
		
		int count=0;
		char[] charArray = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		int len = Math.min(charArray.length, charArray2.length);
		char c[] = new char[len];
		int prevIndex =-1;
		int j=0;
		for(int i=0; i<charArray.length; i++){
			j = prevIndex+1;
			while(j<charArray2.length && charArray[i]!= charArray2[j]) {
				j++;
			}
			 if(j<charArray2.length) {
				 prevIndex=j;
				 c[count++] = charArray[i];
			 }
			 
		}
		for(int i=0;i<count;i++){
			System.out.println(c[i]);
		}
		c[count] =0;
		
		sequence = new String(c);
		return sequence;
		
	}
	
	public static int findLCS(char [] x, char y[], int m, int n){
		int ls[][] = new int[m+1][n+1];
		for(int i=0; i<=m;i++){
			for(int j=0; j<=n;j++){
				
				if (i==0 || j==0)
				{
					ls[i][j]=0;
				}else if(x[i-1]==y[j-1])
				{
					ls[i][j] = 1+ ls[i-1][j-1];
				} else{
					ls[i][j] = Math.max(ls[i-1][j], ls[i][j-1]);
				}
			}
			
		}
		
		int i=m, j=n;
		char lcs[] = new char[ls[m][n]];
		
		int count= ls[m][n]-1;
		System.out.println(count);
		while(i>0 && j>0 ){
			if(x[i-1] == y[j-1]) {
					System.out.println(count + " " + i + " "+ j + "c: " + x[i-1]  + " " + y[j-1]);
				lcs[count--] = x[i-1];
				i--;
				j--;
			} else if(ls[i-1][j]> ls[i][j-1])
				i--;
			else{
				j--;
			}
		}
		
		for(i=0;i<ls[m][n];i++){
			System.out.print(lcs[i]);
		}
		return ls[m][n];
		
		
	}
	
}

package greedy;

import org.junit.Test;

/**
 *1) Sort the activities according to their finishing time
  2) Select the first activity from the sorted array and print it.
  3) Do following for remaining activities in the sorted array.
…….  a) If the start time of this activity is greater than or equal to the finish time of previously selected activity then select this activity and print it.
 * @author sabiya
 *
 */
public class ActivitySelectionProblem {

	@Test
	public void testMaxSelectedJobs() {
		
		int start[] = {1, 3, 0, 5, 8, 5};
		int [] finish = {2, 4, 6, 7, 9, 9};
		printMaxSelectedJobs(start,finish, start.length);
		
	}
	public void printMaxSelectedJobs(int [] startTime, int [] finishTime, int n){
		
		// consider finishTime is sorted
		int activity = 0;
		int prevEndTime = finishTime[0];
		System.out.print(activity);
		for(int i=1;i<n; i++) {
			if(startTime[i]>= prevEndTime){
				System.out.print("\n" + i);
				prevEndTime = finishTime[i];
			}

		}
	}
}

package logical;

import java.util.Arrays;

/**
 * Given a list of people with their birth and death years. Implements a method to compute the year with the 
 * most number of people alive. You can assume that all years are between 1900 and 2000.
 * @author suni
 *
 */
public class LivingPeople {
	
	
	/**
	 * Sort the birth and death arrays.  Take each value from both array in the order of min and see if
	 * birth is min then someone born increase alive count. If death is picked then reduce count.
	 *
	 */
	 public int maxAliveYear(int[] birth, int[] death){
	
		 Arrays.sort(birth);
		 Arrays.sort(death);
		 
		 int birthIndex =0;
		 int deathIndex =0;
		 int maxAliveCount = 0;
		 int maxAliveYear = 1990;
		 int countAlive =0;
		 
		 while(birthIndex < birth.length){
			 
			 if(birth[birthIndex] <= death[deathIndex]){ 
				 
				  countAlive++;
				  if(maxAliveCount < countAlive){ // Record max
					  maxAliveCount = countAlive;
					  maxAliveYear = birth[birthIndex];
				  }
				 birthIndex++;
			 }else{
				 countAlive --;
				 
				 deathIndex++;
			 }
			 
			 
		 }
		 
		 return maxAliveYear;
		 
	 }
	 
	 public static void main(String[] arg){
		 
		 int[] b = {1865, 1978, 1985};
		 int[] d = {1986, 1990, 2000};
		 System.out.println((new LivingPeople()).maxAliveYear(b,  d));
	 }

}

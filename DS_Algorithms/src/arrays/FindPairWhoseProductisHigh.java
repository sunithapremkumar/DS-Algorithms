package arrays;

/**
 * Find the pair that sums up to the given number whose product is highest
 * 
 * Algorithm
 * 
 * Start with 1 end at (number -1). Slide both sides dependending on whether the sum is higher or lower than the given num.
 * @author prasunit
 *
 */
public class FindPairWhoseProductisHigh {

	
	
	public static void findHighProductPairThatSumsTo(int num){
	   
	     if(num ==0)
	      return;
	     
	     int start =1, end = (num-1);
	     String pair="";
	     long highProd = 0;
	     while(start < end){
	      
	        int pairSum = start + end;
	        
	        if(pairSum == num){
	             long pairProd = start* end;
	             if(pairProd > highProd){
	                highProd = pairProd;     // Store highest product    
	                pair = start +" " + end; // Store that corresponding pair to print
	             }
	             start++;
	             end--;
	        }else if(pairSum < num){ // increment lower end if the sum is low
	
	          start++;	        
	
	        }else if(pairSum > num){ // Decrement higher end if the sum is > num        
	
	           end--;
	        }
	        
	     
	     }
	     
	     System.out.println("Highest product pair that sums to " + num + "is "+ pair);
	}
	
	
	public static void main(String... arg){
	  
	    findHighProductPairThatSumsTo(75);
	
	}


	
	
}

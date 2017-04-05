package binarysearchtree;
/**
 * Find minimum in sorted rotated array. No duplicates there.
 * @author suni
 *
 */
public class FindMinInRotatedArray {
	    public int findMin(int[] nums) {
	        
	        int min= search(nums, 0, nums.length-1);
	        if(min == -1)
	           return nums[0];
	        else
	           return min;
	        
	    }
	    
	    //ALGO - check mid to see if it is pivot by checking it's previous value greater than its value
	    // else search on unsorted side.. 
	    // if both sides are sorted, then search both side.
	    public int search(int[] nums, int start, int end){
	        if(start > end)
	          return -1;
	        
	         int mid = (start +end)/2;
	         
	         if((mid>0) && (nums[mid-1] > nums[mid]))
	            return nums[mid];
	        else if(nums[start] > nums[mid]){ //left side unsorted so search the unsorted side first
	            return search(nums, start, mid-1);	     
	        }else if(nums[mid] > nums[end]) {//right side unsorted
	        	return search(nums, mid+1, end);
	    	}else{
	    		int min = search(nums, start, mid-1);
	            if(min == -1)
	               min = search(nums, mid+1, end);
	            return min;
	    	}
	         
	    }
	    
	    public static void main(String arg[]){
	    	FindMinInRotatedArray obj = new FindMinInRotatedArray();
	    	int[] nums = {4,5,6,7,1,2,3};
	    	
	    	int min = obj.findMin(nums);
	    	System.out.println(min);
	    }
}



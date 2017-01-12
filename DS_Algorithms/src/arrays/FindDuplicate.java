package arrays;

/**
 Find a duplicate int in an array of integers from 1 to n and the array size is n+1.
*/
public class FindDuplicate {


/**
  if there is only 1 duplicate in an array. O(n) time.
*/
public static int findDuplicate(int[] arr){

 if(arr == null)
 	return -1;
  int n = arr.length-1;
  int sum = (n * (n+1))/2; // Formula for sum of n numbers
  int tot = 0;  
  for(int i : arr){
      tot = tot + i;  
  }
  
  int duplicate = tot - sum;
  
  return duplicate;
}

/**
  if there are multiple duplicates in an array. O(n)
*/
public static void findMultipleDupes(int[] arr){

   for(int i : arr){
      
        if(arr[Math.abs(i)] > 0){
           arr[Math.abs(i)] = -arr[Math.abs(i)];
        }else
          System.out.println(Math.abs(i));
   }

}

public static void main(String arg[]){
  int[] arr = {1,2,4,5,3,2};
  System.out.println(findDuplicate(arr));
  
  int[] arr1 = {1,2,4,3,1,5,2};
  findMultipleDupes(arr1);
}

  

}

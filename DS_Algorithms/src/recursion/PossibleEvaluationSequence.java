package recursion;

import java.util.*;

/**
 * // Q. You are given a list of integers.    
// Find out what possible sequence of operations can be used to make the last number an evaluation of the numbers before it?  

// Example  
// input 3 2 5 8 17  
// possible sequence 3 + 2 * 5 - 8 = 17  
  
// Example  
// input 5 1 6 11  
// possible sequence 5 / 1 + 6 = 11     5+1-6
  
// Some simplifications we can make -   
//* Assume - the numbers on the left (before the = ) are all just single digits 0-9  
//* Assume - don't worry about order of operations.  - apply left to right regardless of type of operation
//* Assume - the operations are simply + - / *  

 * @author suni
 *
 */
public class PossibleEvaluationSequence {
	char[] op = {'+', '-', '/', '*'};

	public List<String>  findSeq(int[] arr){
	    if(arr  == null)
	       return null;
	       
	    int lastindex = arr.length-1;
	    List<String> seqList = new ArrayList<>();
	    List<String> seq = new ArrayList<>();
	    seq.add(arr[0]+"");
	    calculate(arr[0], 1, arr, arr[lastindex], seqList, seq);   
	    
	    return seqList;
	}

    // Time complex - (4^(n-1). 4 operations are performed for (n-2) elements. The possible combinations  -  (4^(n-1)
	public void calculate(int first, int index, int[] arr,  int expectedResult, List<String> seqList, List<String> runningSeq ){    
	    
	    if(index >= arr.length-1)
	        {
	            if(first == expectedResult)
	                 seqList.add(convertToString(runningSeq));
	            return;
	        }
	    int second = arr[index]; 
	    for(int i=0; i< op.length; i++){
	     int result = evaluate(first, second, op[i]);   
	     runningSeq.add(op[i]+"");
	     runningSeq.add(second+"");   
	     calculate(result,  index+1, arr, expectedResult, seqList, runningSeq);
	     // updating running sequence 
	     runningSeq.remove(runningSeq.size()-1);
	     runningSeq.remove(runningSeq.size()-1);
	    }
	    
	} 
	
	private String convertToString(List<String> list){
		
		String result = "";
		for(int i=0;i <list.size();i ++){
			result += " " + list.get(i);
		}
		return result;
	}
	
	private int evaluate(int first, int second, char op){
		
		if(op == '+')
			return (first + second);
		else if(op == '-')
			return (first - second);
		else if (op == '*')
			return (first * second);
		else
			return (first/second);
	}
	
	public static void main(String arg[]){
		PossibleEvaluationSequence seq = new PossibleEvaluationSequence();
		int[] arr = {3,2,5,8,17}; // {5,1,6,11}
		
		List<String> list = seq.findSeq(arr);
		for(String s : list)
		System.out.println(s);
		
	}

}

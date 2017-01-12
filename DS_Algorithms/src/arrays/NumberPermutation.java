package arrays;


	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;
/**
 * Given an -digit positive integer, count and print the number of multiples of 8 that can be formed by concatenating subsequences of the given number's digits, modulo 10pow9 +7.
 * @author prasunit
 *
 */
	public class NumberPermutation {

	     ArrayList<Integer> resultList = new ArrayList<>();
	   
	     public void findPermutation(int num, int div){
	        int digit;
	        if(div !=0)
	            digit = (num/div);
	        else
	            digit = num;
	        
	        appendToList(digit);
	        
	        if( div == 1 )
	            return;
	        findPermutation(num%div, div/10);
	    }
	    
	    private void appendToList(int num){
	        ArrayList<Integer> tempList = new ArrayList<>();
	        for(int i : resultList){
	            tempList.add(Integer.parseInt(i+""+num));
	        }
	        tempList.add(num);
	        resultList.addAll(tempList);
	    }
	    
	    public long findModulo(){
	        ArrayList<Integer> finalList = new ArrayList<>();
	        for(int i: resultList){
	            if((i%8) ==0)
	               finalList.add(i);
	        }
	    
	        int count = finalList.size();
	        double d = (Math.pow(10,9) + 7);
	        long l = new Double(d).longValue();
	        long result = count % l;
	        return result;
	    }
	    
	    public static void main(String[] args) {
	       // Scanner in = new Scanner(System.in);
	        int n = 3;
	        String number = "986";

	        NumberPermutation obj = new NumberPermutation();
	         if(n==1){
	             obj.resultList.add(Integer.parseInt(number));           
	         }
	        else{
	            double d = Math.pow(10,(n-1));
	            int div = new Double(d).intValue();
	            //int div = Math.round(d);      
	            obj.findPermutation(Integer.parseInt(number), div);
	        }
	        System.out.println(obj.findModulo());
	    }
	}



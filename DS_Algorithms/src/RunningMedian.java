
import java.util.PriorityQueue;
import java.util.*;

public class RunningMedian {

	private class MyComparator implements Comparator<Integer>{
		 public int compare(Integer a, Integer b){
	            return (b-a);
	        }
	}
	 static PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
	        public int compare(Integer a, Integer b){
	            return (b-a);
	        }
	    });
	   static PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
	    
	    public static void addToList(int n){
	        if(lowers.size() ==0 || n < lowers.peek())
	            lowers.add(n);
	        else
	            highers.add(n);
	    }
	    
	    public static void rebalance(){
	        PriorityQueue<Integer> bigger = (lowers.size() > highers.size())?lowers:highers;
	        PriorityQueue<Integer> smaller = (lowers.size() > highers.size())?highers:lowers;
	        if((bigger.size() - smaller.size()) >=2){
	            smaller.add(bigger.poll());
	        }
	    }
	    
	    public static double findMedian(){      
	    	 PriorityQueue<Integer> bigger = (lowers.size() > highers.size())?lowers:highers;
		     PriorityQueue<Integer> smaller = (lowers.size() > highers.size())?highers:lowers;
	        if(bigger.size() == smaller.size()){
	            return ((double)(bigger.peek() + smaller.peek()))/2;
	        }
	        else
	            return (double)bigger.peek();
	    }
	   
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int a[] = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	            addToList(a[a_i]);
	            rebalance();
	            double median = findMedian();
	            System.out.println(median);
	        }
	    }
	}


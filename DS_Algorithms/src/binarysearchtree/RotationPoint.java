package binarysearchtree;

public class RotationPoint {
	
	
	public static int findRotationPoint(String[] arr, int start, int end){
		
		if(end < start)
			return -1;
		int mid = (start+end)/2;
		if((mid !=  0 && (arr[mid -1].compareTo(arr[mid]) > 0 ))|| (mid == 0))
			return mid;
		
		if(arr[start].compareTo(arr[mid]) >0 ) {// left side unsorted
			return findRotationPoint(arr, start, mid-1);
		}else if(arr[mid].compareTo(arr[end]) >0 ) {// right side unsorted
			return findRotationPoint(arr, mid+1, end);
		}else { //both sides sorted, so search both sides
			int val = findRotationPoint(arr, start, mid+1);
			if(val == -1)
				val =  findRotationPoint(arr, mid+1, end);
			return val;
		}
				
	}

	public static void main(String arg[]){
		String[] arr = { "ptolemaic",
			    "retrograde",
			    "supplant",
			    "undulate",
			    "xenoepist",
			    "asymptote", // <-- rotates here!
			    "babka",
			    "banoffee",
			    "engender",
			    "karpatka",
			    "othellolagkage"};
		System.out.println(RotationPoint.findRotationPoint(arr, 0, arr.length));
	}
}

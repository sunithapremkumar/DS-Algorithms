package binarysearchtree;

/**
 * Given a sorted array of strings that has empty strings, write a method to f][p0ind the index of a given string
 * @author suni
 *
 */
public class SparseSearch {

	
private int binarySearch(String[] arr, int start, int end, String x){
		
		if(start>end)
			return -1;
		int mid = (start+end)/2;
		
		if(arr[mid].equals("")){
			int left = mid-1;
			int right= mid+1;
			while(true){
				if(left < start && right >end)
					return -1;
				if(left >= start && !arr[left].equals("")){
					mid = left;
					break;
				}
				else if(right <= end && !arr[right].equals("")){
					mid = right;
					break;
				}
				left--;
				right++;
					
			}
		}
		
		if(arr[mid].equals(x))
			return mid;
		else if(x.compareTo(arr[mid]) < 0)
			return binarySearch(arr, start, mid-1, x);
		else
			return binarySearch(arr, mid+1, end, x);
	}

	public int search(String[] arr, String x){
		if(arr == null || x == null || x.equals(""))
			return -1;
		return binarySearch(arr, 0, arr.length-1, x);
	}

  public static void main(String arg[]){
	  
	  SparseSearch obj = new SparseSearch();
	  
	  String[] arr={"ar", "", "", "", "ball", "", "" , "car", "", "", "dad"};
	  
	  System.out.println(obj.search(arr, "car"));
	   
  }

}


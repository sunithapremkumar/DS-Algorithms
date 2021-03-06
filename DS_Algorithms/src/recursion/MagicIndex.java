package recursion;
/**
 * Given a array of sorted distinct integers, find a magic index. MAgic index is the index where a[i] = i
 * 
 *  Add on - What if the array elements are not distinct
 *  
 *  CTCI problem
 * @author suni
 *
 */
public class MagicIndex {

	public int magicIndex(int[] arr, int start, int end){
		if(start > end)
			return -1;
		
		int mid = (start+end)/2;
		if(arr[mid] == mid)
			return mid;
		else if(arr[mid] > mid) // if the arr[mid] > mid, then the magic number can only be in left side
			return magicIndex(arr, start, mid-1);
		else // (arr[mid] < mid) //else it can be only in right side
			return magicIndex(arr, mid+1, end);
	}
	// in case of repeated numbers, magic number can be either on left side or right side of mid.
	// So first search left, if not there then search right.. 
	public int magicIndexWithRepeatedElements(int[] arr, int start, int end) {
		if (start > end)
			return -1;

		int mid = (start + end) / 2;
		if (arr[mid] == mid)
			return mid;

		int left = Math.min(mid - 1, arr[mid]);
		int magicLeft = magicIndexWithRepeatedElements(arr, start, left);
		if (magicLeft >= 0)
			return magicLeft;
		int right = Math.max(mid + 1, arr[mid]);
		return magicIndexWithRepeatedElements(arr, right, end);
	}
	
	public static void main(String arg[])
	{
		MagicIndex obj = new MagicIndex();
		int[] arr= {-1,0,2,4,5,8};
		System.out.println(obj.magicIndex(arr, 0, arr.length));
	}
}
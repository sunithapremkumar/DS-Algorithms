package ds;

public class PriorityQueue {
	
	int[] arr = null;
	int size = 0;
	
	public PriorityQueue(int capacity){
		arr = new int[capacity];
	}
	
	public boolean insert(int val){
		if(size == arr.length)
			return false;
		arr[size] = val; //add to end of array
		trickleUp(size);
		size++;
		return true;
	}

	
	 private void trickleUp(int index){
		 
		 int parent = (index-1)/2;
		 int bottom = arr[index];
		 
		 while(index > 0 && bottom > arr[parent]){ // check if the current node > parent, if so swap. go until root 
			 arr[index] = arr[parent];
			 index = parent;
			 parent = (index-1)/2;
		 }
		 arr[index] = bottom;
	 }
	 
	 public int remove(){
		 int temp = arr[0]; //always remove the root node
		 arr[0] = arr[--size]; //assign the last node to root
		 trickleDown(0);
		 return temp;
	 }
	 
	 private void trickleDown(int index){
		 int top = arr[index];
		 
		 while(index/2 > 0 ){ // do until the node has atleast 1 child
			 int leftindex = (2*index)+1;
			 int rightindex = (2*index)+2;
			 
			 int leftVal = (leftindex >0)? arr[leftindex] : Integer.MIN_VALUE;
			 int rightVal = (rightindex >0)? arr[rightindex] : Integer.MIN_VALUE;
			 
			 int largestindex = (leftVal > rightVal)? leftindex: rightindex;
			 if(top > arr[largestindex]) // if current node is bigger then break else swap with largest node
				 break;
			 
			 arr[index] = arr[largestindex];
			 index = largestindex;
			 
		 }
		 arr[index] = top;
		 
	 }
	 
}

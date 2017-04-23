package stack;
/**
 * Use single array to implement 3 stacks
 * @author suni
 *
 */
public class ThreeInOne {

	 int numOfStacks = 3;
	 int[]  array;
	 int stackCapacity;
	 int[] stackSizes = new int[numOfStacks];
	 
	 public ThreeInOne(int size){
		 stackCapacity = size;
		 array = new int[stackCapacity * numOfStacks];
	 }
	 
	 public void push(int val, int stackNum){
		 stackSizes[stackNum]++;
		 int index = topIndex(stackNum);
		 array[index] = val;
	 }
	 
	 public int pop(int stackNum) throws Exception{ 
		 
		 if(isEmpty(stackNum))
			 throw new Exception();
		 int index = topIndex(stackNum);
		 int tmp = array[index];
		 array[index] = 0;
		 stackSizes[stackNum]--;
		 return  tmp;
	 }
	 
	 public int peek(int stackNum) throws Exception{
		 if(isEmpty(stackNum))
			 throw new Exception();
	
		 return array[topIndex(stackNum)];
	 }
	 
	 public boolean isEmpty(int stackNum){
		 return (stackSizes[stackNum] == 0);
	 }
	 
	 public int topIndex(int stackNum){
		 int offset = stackNum * stackCapacity;
		 int  index = offset + stackSizes[stackNum] -1;
		 return index;
	 
}
}
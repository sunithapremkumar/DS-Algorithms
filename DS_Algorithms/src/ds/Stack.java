package ds;

public class Stack {

	 int arr[] = null;
	 int top = -1;
	 
	 public Stack(){
		 arr = new int[100];
	 }
	 
	 public void push(int val){
		 arr[++top] = val;
	 }
	 
	 public int pop(){
		 if(top <0)
			 return -1;
		 int tmp = arr[top];
		 top--;
		 return tmp;                                                                                                                       
	 }
	 
}

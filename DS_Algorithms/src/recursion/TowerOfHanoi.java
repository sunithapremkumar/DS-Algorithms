package recursion;

import java.util.Stack;

public class TowerOfHanoi {

	
	public void move(int n, char from, char to, char inter){
		  if(n == 0 ) return;
		   move((n-1), from, inter, to);
		   
		   System.out.println("Moving disc" + n + "from " + from + "to " + to);
		   
		   move((n-1), inter, to, from);
		   
	}
	
	public static void main(String arg[]){
		TowerOfHanoi hanoi = new TowerOfHanoi();
		//hanoi.move(3, 'A', 'C', 'B');
		
		Tower[] towers = new Tower[3];
		for(int i=0;i<3;i++)
			towers[i] = hanoi.new Tower(i);
		
		for(int n=2; n >=0; n--){
			towers[0].add(n);
		}
		towers[0].moveDisks(3, towers[2], towers[1]);
		
		//printing destination tower
		while(!towers[2].stack.isEmpty())
			System.out.println(towers[2].stack.pop());
			
 	}
	
	//Using stacks
	
	public class Tower{ //This is a wrapper class to stack to control the bigger disk on top of smaller.
		public Stack<Integer> stack = new Stack<>();
		int towerIndex;
		
		public Tower(int index)
		{
			towerIndex = index;
		}
		
		public void add(int data){
			if(!stack.isEmpty() && stack.peek() < data)
				System.out.println("Cannot add bigger disk on smaller");
			else
				stack.push(data);
			
		}
		
		public void moveTop(Tower t){
			if(!stack.isEmpty()){
				t.add(stack.pop());
			}
		}
	
		
		public void moveDisks(int n, Tower destination, Tower buffer){
			if(n ==0)
				return;
			moveDisks(n-1, buffer, destination);
			moveTop(destination);
			buffer.moveDisks(n-1,  destination, this);
		}
		
	}
}

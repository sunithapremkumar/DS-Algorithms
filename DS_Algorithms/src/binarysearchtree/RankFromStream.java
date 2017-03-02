package binarysearchtree;
/**
 * Imagine we are given stream of integers.. Implement a Data structure and algorithm that supports these operations.
 * Implement track method which is called when each number is generated and method getRank(x) which returns the number of
 * values less than or equal to x (not including x)
 * 
 * Example - 5,1,4,4,5,9,7,13,3
 * getRank(1) = 0
 * gerRank(3) = 1
 * gerrank(4) = 3
 *
 */
public class RankFromStream {
	RankNode root = null;
	
	public void track(int x){
		if(root == null)
			root = new RankNode(x);
		else
			root.insert(x);
	}
	
	public int getRank(int x){
		return root.getRank(x);
	}
	
	
	public class RankNode{
		RankNode left, right;
		int leftSize = 0;
		int data;
		
		public RankNode(int dat){
			data = dat;
		}
		
		/**
		 * While inserting the node, take count of how of how many left nodes are inserted.. which gives the number of
		 * nodes less than the given node.
		 * @param x
		 */
		public void insert(int x){
			if(x <= data){
				if(left == null)
					left = new RankNode(x);
				else
					left.insert(x);
				leftSize++;
			}else{
				if(right == null)
					right = new RankNode(x);
				else
					right.insert(x);
			}
			
		}
		/**
		 * If the node == curNode, return leftSize;
		 * if the node lies on left side of curNode, then return the getRank(node.left) of that node.
		 * If the node lies on right side of curNode, then side would be the leftSize + 1 + getRank(node.right)
		 * @param x
		 * @return
		 */
		public int getRank(int x){
			if(data == x)
				return leftSize;
			else if(x < data)
				return (left== null)? -1: left.getRank(x);
			else{
				int rightS = (right == null)?-1:right.getRank(x);
				if(rightS == -1) return -1;
				return leftSize + 1 + rightS;
			}
		}
		
	}
	
	public static void main(String arg[]){
		RankFromStream obj = new RankFromStream();
		obj.track(5);
		obj.track(1);
		obj.track(4);
		obj.track(4);
		obj.track(5);
		obj.track(9);
		obj.track(7);
		obj.track(13);
		obj.track(3);
		
		System.out.println(obj.getRank(1));
		System.out.println(obj.getRank(3));
		System.out.println(obj.getRank(4));
		
		
	}

}

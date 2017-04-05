package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SerialiseDeserializeBinaryTree {
	
	// Do in order traversal and append the nodes to string.
	public String serialize(TreeNode root) {
		   int height = getHeight(root);
		   
		   System.out.println(height);
	        ArrayList<Integer> list = new ArrayList<>();
	         serial(root, list, 1, height);
	         
	         StringBuffer buf = new StringBuffer();
	         for(int i=0; i< list.size(); i++)
	         {
	        	 if(i==0)
	        		 buf.append(list.get(i));
	        	 else
	        		 buf.append(","+list.get(i));
	         }
	         System.out.println(buf.toString());
	        return buf.toString();
	    }
  private int getHeight(TreeNode r){
	  if(r == null)
		   return 0;
	  
	  int l = getHeight(r.left);
	  int right = getHeight(r.right);
	  
	  int height = Math.max(l, right) + 1;
	  
	  return height;
  }
    
	   private void serial(TreeNode node, List<Integer> list, int curDepth, int maxDepth){
	       
	       if(node == null){
	    	   if(curDepth <= maxDepth){	       
	    		   list.add(null);
	    	   }
	         return;
	       }
	       serial(node.left, list, curDepth+1, maxDepth);
	       list.add(node.data);
	       serial(node.right, list, curDepth+1, maxDepth);
	       
	   }
	   
	   // Createa  tree from the array...
	   public TreeNode deserialize(String data) {
		   String arr[] = data.split(",");
		   
		   TreeNode root = convertToTree(arr, 0, arr.length-1);
		   
		   return root;
	   }
	   
	   private TreeNode convertToTree(String[] arr, int start, int end){
		   if(start >end)
			   return null;
		   int mid = (start+end)/2;
		   if(arr[mid].equals("null"))
			   return null;
		   TreeNode n = new TreeNode(Integer.parseInt(arr[mid]));
		   
		   n.left = convertToTree(arr, start, mid-1);
		   n.right = convertToTree(arr, mid+1, end);
		   
		   return n;
		   
	   }
	   
	   public void printTree(TreeNode n){
		   if(n == null)
			   return;
		   printTree(n.left);
		   System.out.println(n.data);
		   
		   printTree(n.right);
	   }
	   public static void main(String atg[]){
		   SerialiseDeserializeBinaryTree obj = new SerialiseDeserializeBinaryTree();
		   
		   
		   TreeNode root = new TreeNode(1);
			root.left = new TreeNode(2);
			root.right = new TreeNode(3);
			root.right.left = new TreeNode(4);
			root.right.right = new TreeNode(5);
		   
			String data = obj.serialize(root);
			
			TreeNode n = obj.deserialize(data);
			
			obj.printTree(n);
	   }
}

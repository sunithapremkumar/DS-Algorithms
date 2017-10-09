package recursion;

import java.util.ArrayList;
/**
 * 
 * @author suni
 *
 */
public class PrintXPaths {

public void findPaths(Node node, String tag, int level, ArrayList<String> result){
	result.add(node.tag());
	
	if(node.tag().equals(tag)){
		printResult(result);
		return;
	}
	
	for(int i=0; i< node.childcount();i ++){
		findPaths(node.child(i), tag, i, result)
		result.remove(result.size()-1);
	}
	
}


	public interface Node{
	  Node child(int i);
	  int childcount();
	  String tag();
	}

}


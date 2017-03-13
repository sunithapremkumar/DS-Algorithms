package stack;

import java.util.Stack;

/**
 * CTCI page 185
 * 
 * Given an arithmetic expression consisting of +,-,*,/ ( no paranthesis), compute the result
 * 
 * I/p - 2*3+5/6*3+15
 * o/p - 23.5 = (2*3) + (5/6)*3+15
 * @author suni
 *
 */
public class ExpressionEvaluationWithoutParanthesis {
	
	private static Stack<String> ops = new Stack<>();
	private static Stack<Double> val = new Stack<>();
	
	/**
	 *  ALGO:  push each element to stack until we see * or / at which point we have to evaluate and push the result
	 *  Finally evaluate the + and - going through all the remaining items in stack.
	 * @param s
	 * @return
	 */
	public double evaluateExpression(String s){
		if(s == null)
			return -1;
		
		String[] arr = s.split(" ");
		
		int i=0;
		while(i < arr.length){
			
			 String cur = arr[i];
			 switch(cur){
			 	case "+":
			    case "-":
			    	ops.push(cur);
			    	break;
			    case "*":
			    	if((i+1) < arr.length && !val.isEmpty()){
			    		double res = val.pop() * Double.valueOf(arr[i+1] +"");
			    		val.push(res);
			    		i++;			    		
			    	}
			    	break;
			    case "/":
			    	if((i+1) < arr.length && !val.isEmpty()){
			    		double res = val.pop() / Double.valueOf(arr[i+1] +"");
			    		val.push(res);
			    		i++;			    		
			    	}
			    	break;
			    default:
			    	val.push(Double.valueOf(cur));
			 }
			
			 i++;
		}
		
		//Evaluating the remaining items in stack (+ and -)
		while( !ops.isEmpty()){
			
			if(val.isEmpty())
				break;
			double seconditem = val.pop();
			if(val.isEmpty())
				break;
			double firstitem = val.pop();
			
			String op = ops.pop();
			
			switch(op){
		 		case "+":
		 			double res = firstitem + seconditem;
		 			val.push(res);
		 			break;
		 		case "-":
		 			double res1 = firstitem - seconditem;
		 			val.push(res1);
		 			break;
		 		default:
			}
		}
		
		if(!val.isEmpty())
			return val.pop();
		
		return -1;
	}
	
	public static void main(String arg[]){
		
		ExpressionEvaluationWithoutParanthesis obj = new ExpressionEvaluationWithoutParanthesis();
		String exp = "2 * 3 + 5 / 6 * 3 + 15";
		
		double result  = obj.evaluateExpression(exp);
		System.out.println(result);
	}
}

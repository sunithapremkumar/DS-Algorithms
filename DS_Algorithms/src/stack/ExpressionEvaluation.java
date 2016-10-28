package stack;

import java.util.Stack;

/**
 *  Using Dijikstra's 2 stack algorithm
 *  
 *  If you see a digit push to val stack, if you see operand push to ops stack. If you see open braces ignore. If you seeclose braces evaluate by poping the last 
 *  operand fromops stack and last 2 values from val stack and push the result to val stack Repeat this for all chars in incoming string.
 * @author prasunit
 *
 */
public class ExpressionEvaluation {

	private static Stack<String> ops = new Stack<String>();
	private static Stack<Double> val = new Stack<Double>();
	
  public static double evaluateExpression(String inputStr) throws Exception{
	  
	  if(inputStr == null)
		  return 0;
	  
	  String strArr[] = inputStr.split("");
	  
	  for(String s: strArr){
		  
		  switch(s){
		    case "+":
		    case "-":
		    case "*":
		    case "/":
		    	ops.push(s);
		    	break;
		    case "(":
		    	break;
		    case ")":
		    	evaluate();
		        break;
		    default:
		    	val.push(Double.valueOf(s));
		  }
	  }
	  //Cover the case where the entire expression is not enclosed within parenthesis
	  while (!ops.isEmpty()){
		  evaluate();
  
	  }
	  return val.pop();
  }
  
  private static void evaluate(){
	  
	  String op = ops.pop();
	  double result = 0;
	  double secondVal = val.pop();
	  double firstVal = val.pop();
	  switch(op){
	  case "+":	
		  result = firstVal + secondVal;
		  break;
	  case "-":	
		  result = firstVal - secondVal;
		  break;
	  case "*":	
		  result = firstVal * secondVal;
		  break;
	  case "/":	
		  result = firstVal / secondVal;
		  break;
	  }
	  val.push(result);
  }
  
  public static void main(String...strings){
	  
	  String s = "(2+4)*(6/3)";
	  try{
	   System.out.println(evaluateExpression(s));
	  }catch(Exception e) {e.printStackTrace();}
  }



}

package string;

/**
 * CTCI page 91
 * @author suni
 *
 */
public class StringCompression {

	
	public String compress(String str){
		
		if(str == null)
			return null;
		
		int cnt = 1;
		char prev = '0';
		
		StringBuffer buf = new StringBuffer();
		for(int i=0; i <str.length(); i++){
			char c = str.charAt(i);
			   if(prev == c){
				   cnt++;
			   }else{
				  if(i != 0)
					  buf.append(cnt);
				   cnt = 1;
				   buf.append(c);
			   }
			   prev = c;
		}
		buf.append(cnt);
		if(buf.toString().length() == str.length())
			return str;
		return buf.toString();
	}
	
	public static void main(String arg[]){
		
		StringCompression obj = new StringCompression();
		String str = "aabccccaaa";
		System.out.println(obj.compress(str));
	}
}

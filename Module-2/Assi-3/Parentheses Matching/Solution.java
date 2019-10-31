class Solution{
	public static String isMatching(String str){
		// fill you code Here
		String[] braces = new String[str.length()];

		braces = str.split("");

		String[] stack = new String[str.length()];
		int size = 0;
		//for each loop 
		for(String eachBrace : braces) {
			if(eachBrace.equals("[") ||  eachBrace.equals("(") ||  eachBrace.equals("{")){
				stack[size++] = eachBrace;   //inserting each brace into stack named array
			}else if(size > 0){
				String recentBrace = stack[size -1];   //new array named recentBrace
				
				//checking recentBrace is closed of eachBrace 
				if(recentBrace.equals("[") && eachBrace.equals("]")){
					size--;     //poping up the top element by reducing size
				}
				else if(recentBrace.equals("(") && eachBrace.equals(")")){
					size--;
				}
				else if(recentBrace.equals("{") && eachBrace.equals("}")){
					size--;
				}
			}		
		}

		if(size == 0){
			return "YES";
		}else{
			return "NO";
		}
	}
}
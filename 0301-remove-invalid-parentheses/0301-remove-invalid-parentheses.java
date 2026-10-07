class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c =='('){
                stack.push(')');
            }else if(c ==')'){
                if(stack.isEmpty() || stack.peek() != ')'){
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public void backtrack(String s, int invalid,StringBuilder sb, int index, int curInvalid, List<String> result){
        if(curInvalid == invalid || index == s.length()){

            int added = s.length() - index;

            for(int i = index;i < s.length();i++){
                sb.append(s.charAt(i));
            }

            if(isValid(sb.toString())){
                if(!result.contains(sb.toString())){
                    result.add(sb.toString());
                }
            }

            while(added-- > 0){
                sb.deleteCharAt(sb.length()-1);
            }

            return;
        }

        sb.append(s.charAt(index));
        

        backtrack(s, invalid, sb, index+1, curInvalid, result);

        sb.deleteCharAt(sb.length()-1);
        

        if(s.charAt(index) == '(' || s.charAt(index) == ')'){
            backtrack(s, invalid, sb, index+1, curInvalid+1, result);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        int invalid = 0;

        int open = 0,close = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                open++;
            }else if(c == ')'){
                if(open > 0){
                    open--;
                }else{
                    close++;
                }
            }
        }

        invalid = open + close;

        List<String> result = new ArrayList<>();

        backtrack(s, invalid,new StringBuilder(), 0, 0, result);

        return result;
    }
}
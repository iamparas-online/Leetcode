class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> mp = new HashMap<>();

        for(int i = 0; i < knowledge.size(); i++){
            mp.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        StringBuilder SB = new StringBuilder();

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '('){

                int start = i + 1;

                while(s.charAt(i) != ')'){
                    i++;
                }

                String key = s.substring(start, i);

                if(mp.containsKey(key)){
                    SB.append(mp.get(key));
                }
                else{
                    SB.append("?");
                }

            }
            else{
                SB.append(s.charAt(i));
            }
        }

        return SB.toString();
    }
}
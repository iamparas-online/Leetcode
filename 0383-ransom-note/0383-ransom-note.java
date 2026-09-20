class Solution {
    public boolean canConstruct(String r, String m) {
        int [] count = new int [26];

        for(int i=0;i<m.length();i++){
            char c = m.charAt(i);
            count[c - 'a']++;
        }

        for(int i=0;i<r.length();i++){
            int c = r.charAt(i);
            if(count[c - 'a'] == 0){
                return false;
            }
            count[c - 'a']--;  
        }
        return true ;
    }
}
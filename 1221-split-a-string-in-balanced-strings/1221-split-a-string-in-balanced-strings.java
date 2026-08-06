class Solution {
    public int balancedStringSplit(String s) {
        int l=0;
        int r=0;
        int ans=0;
        char c;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);

            if(c=='L'){
                l++;
            }
            else{
                r++;
            }

         if(l==r){
            ans++;
            r=0;
            l=0;
        }
        
        }
        return ans;
        
    }
}
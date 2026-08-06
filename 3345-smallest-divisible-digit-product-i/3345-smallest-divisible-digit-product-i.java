class Solution {
    public int smallestNumber(int n, int t) {
        if(n<t){
            return t;
        }
        
        int prod=1;
        for(int i=0;i<10;i++){
            int a=n;
            prod=1;
        while(a!=0){
            int b=a%10;
            prod=prod*b;
            a=a/10;}
            
        
        if(prod%t==0){
            return n;
        }
        n=n+1;
        }
        return -1;
    }
}
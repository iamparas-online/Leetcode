class Solution {
    public boolean checkDivisibility(int n) {
        
        int temp=n;
        int sum=0;
        int mul=1;

        while(temp>0){

        int d=temp%10;

        sum = sum+d;
        mul = mul*d;

        temp = temp/10;
        
        }    
        return n%(sum+mul)==0;
    }
}
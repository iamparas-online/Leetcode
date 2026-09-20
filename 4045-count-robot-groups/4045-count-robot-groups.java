class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;
        int group = 1;
        int group_speed = speed[n-1]; //last robot speed 

        for(int i=n-2;i>=0;i--){

            if(position[i+1] - position[i] <= distance){
                continue;
            }
            else if(speed[i] <= group_speed){
                group++;
                group_speed=speed[i];
            }
        }
        return group;
    }
}
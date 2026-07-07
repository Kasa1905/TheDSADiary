class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n ==0) return true ;
        if(flowerbed.length == 1&& n == 1){
            return flowerbed[0] ==0;
        }
        int prev = -2;
        for(int i = 0; i<flowerbed.length;i++){
            if(flowerbed[i] == 1) prev =i;
            else if(prev<i-1){
                if(i+1 >=flowerbed.length || flowerbed[i+1] == 0){
                    n--;
                    if(n==0) return true;
                    prev = i; 
                }
            }
        }
        return false;
    }
}
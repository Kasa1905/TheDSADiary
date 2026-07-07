class Solution {
    public String shortestCompletingWord(String lp, String[] words) {
       int[] lipc=new int[26];
       for(char c:lp.toCharArray()){
            if(Character.isAlphabetic(c)){
                char ch=Character.toLowerCase(c);
                lipc[ch-'a']++;
            }
       }
       String ans=null;
       for(String s:words){
            int[] stringCounts=new int[26];
            for(Character c :s.toCharArray()){
                stringCounts[Character.toLowerCase(c)-'a']++;
            }
            boolean exist=true;
            for(int i=0;i<26;i++){
                if(stringCounts[i]<lipc[i]){
                    exist=false;
                    break;
                }
            }
            if(exist){
                ans=(ans==null||s.length()<ans.length()?s:ans);
            }
       } 
       return ans;
    }
}
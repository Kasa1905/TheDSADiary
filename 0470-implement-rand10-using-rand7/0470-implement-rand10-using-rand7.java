/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    static int curr=0;
    public int rand10(){
        curr=(curr+rand7())%10;
        return (curr==0)?10:curr;
    }
}
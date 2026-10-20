class Solution {
    
    public int strongPasswordChecker(String password) {
        char[] c = password.toCharArray();
        int n = c.length;
        int addreq = 0; 
        int delreq = 0; 
        int fillme = 0; 
        int nut = 0; 
        if (n < 6) addreq = 6 - n;
        if (n > 20) delreq = n - 20;

        char temp = '@';
        boolean digitp = false;
        boolean upperp = false;
        boolean lowerp = false;

        int np = 0; 
        int repchel = 0; 
        Queue<Integer> delqueue = new PriorityQueue<>((a, b) -> a % 3 - b % 3);

        for (char ch : c) {
            if (ch == temp) {
                np++;
            } else {
                if (np >= 3) {
                    delqueue.offer(np);
                }
                np = 1;
                temp = ch;
            }

            if (!digitp && Character.isDigit(ch)) digitp = true;
            if (!upperp && Character.isUpperCase(ch)) upperp = true;
            if (!lowerp && Character.isLowerCase(ch)) lowerp = true;
        }

        if (np >= 3) {
            delqueue.offer(np);
        }
        
        if (!digitp) fillme++;
        if (!upperp) fillme++;
        if (!lowerp) fillme++;
        while (delreq > 0 && !delqueue.isEmpty()) {
            int l = delqueue.peek();
            int tobedeleted = l % 3 + 1;
            if (tobedeleted > delreq) break;
            else {
                delreq -= tobedeleted;
                l -= tobedeleted;
                delqueue.poll();
                nut += tobedeleted;
                if (l >= 3) delqueue.offer(l);
            }
        }
        int repreq = 0;
        while (!delqueue.isEmpty()) {
            repreq += delqueue.poll() / 3;
        }
        return nut + delreq + Math.max(fillme, Math.max(addreq, repreq));
    }
}
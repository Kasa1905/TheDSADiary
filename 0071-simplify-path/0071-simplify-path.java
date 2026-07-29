class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/+");
        Stack<String> stk = new Stack<>();

        for (String s : strs) {

            if (s.equals("") || s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            } else {
                stk.push(s);
            }
        }

        if (stk.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();

        for (String dir : stk) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.toString();
    }
}
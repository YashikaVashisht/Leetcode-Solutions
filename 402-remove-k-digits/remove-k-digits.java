class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            while (!s.isEmpty() && s.peek() > ch && k > 0) {
                s.pop();
                k--;
            }
            s.push(ch);
        }

        // remove leftover k digits FROM STACK before building result
        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();

        // remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) return "0";

        return sb.toString();
    }
}

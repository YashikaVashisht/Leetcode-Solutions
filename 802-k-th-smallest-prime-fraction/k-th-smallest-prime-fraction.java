class Solution {
    class Pair{
        int num;
        int den;
        double val;
        Pair(int num, int den){
            this.num = num;
            this.den = den;
            this.val = (double) num / den;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<Pair> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                list.add(new Pair(arr[i], arr[j]));
            }
        }

        Collections.sort(list, (a, b) -> Double.compare(a.val, b.val));

        Pair ans = list.get(k - 1);

        return new int[]{ans.num, ans.den};
    }
}
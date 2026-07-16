class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> finalList = new ArrayList<>();

        // Create rows filled with 1's
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                row.add(1);
            }

            finalList.add(row);
        }

        // Fill the middle elements
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                finalList.get(i).set(
                    j,
                    finalList.get(i - 1).get(j - 1) + finalList.get(i - 1).get(j)
                );
            }
        }

        return finalList.get(rowIndex);
    }
}
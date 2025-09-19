class Spreadsheet {
    HashMap<String, Integer> hm;

    
    public Spreadsheet(int rows) {
        hm = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        hm.put(cell, value);
    }
    
    public void resetCell(String cell) {
        hm.put(cell,0);
    }
    
    public int getValue(String formula) {
        // If formula starts with '=' → it's an expression
        if (formula.startsWith("=")) {
            formula = formula.substring(1); // remove '='
        }

        // Split on '+'
        int plusIndex = formula.indexOf('+');
        if (plusIndex == -1) {
            // single token
            return getTokenValue(formula);
        }

        String left = formula.substring(0, plusIndex).trim();
        String right = formula.substring(plusIndex + 1).trim();

        int val1 = getTokenValue(left);
        int val2 = getTokenValue(right);

        return val1 + val2;
    }

    private int getTokenValue(String token) {
    // Case 1: It's another cell reference
        if (hm.containsKey(token)) {
            return hm.get(token);
        }

        // Case 2: Try parsing as integer
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            // If it's neither in map nor a number, treat as 0 (empty cell)
            return 0;
        }
    }
      
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
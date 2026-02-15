import java.math.BigInteger;
class Solution {

    public String addBinary(String a, String b) {
        BigInteger num1=new BigInteger(a,2);
        BigInteger num2=new BigInteger(b,2);
        BigInteger zero =new BigInteger("0",2);
        while(!num2.equals(zero)){
            BigInteger carry=num1.and(num2).shiftLeft(1);
            num1=num1.xor(num2);
            num2=carry;
        }
        return num1.toString(2);
        
        
    }
}
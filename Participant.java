import java.math.BigInteger;

public class Participant {

    private BigInteger num, blindNum, signature, r;

    public void chooseNumber() {
        num = new BigInteger(512, new java.util.Random());
    }

    public void blindNumber(BigInteger e, BigInteger n) {
        blindNum = num.modPow(e, n);
    }

    public void unblindNumber(BigInteger d, BigInteger n) {
        r = blindNum.modPow(d, n);
    }

    public boolean verifySignature(BigInteger e, BigInteger n) {
        signature = r.modPow(e, n);
        return signature.equals(num);
    }
    
}

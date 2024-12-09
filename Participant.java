import java.math.BigInteger;

public class Participant {

    private BigInteger num, blindNum, signature, r;

    // Getter
    public BigInteger getR() {
        return r;
    }

    // Choose a number
    public void chooseNumber() {
        num = new BigInteger(512, new java.util.Random());
    }

    // Blind the number
    public void blindNumber(BigInteger e, BigInteger n) {
        blindNum = num.modPow(e, n);
    }

    // Unblind the number
    public void unblindNumber(BigInteger d, BigInteger n) {
        r = blindNum.modPow(d, n);
    }

    // Verify the signature
    public boolean verifySignature(BigInteger e, BigInteger n) {
        signature = r.modPow(e, n);
        return signature.equals(num);
    }
    
}

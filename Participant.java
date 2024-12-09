import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Participant {
    private BigInteger num, blindNum, blindingFactor;

    // Getter
    public BigInteger getBlindNum() {
        return blindNum;
    }

    // Choose a number
    public void chooseNumber() {
        num = new BigInteger(512, new java.util.Random());
    }

    // Blind the number
    public void blindNumber(BigInteger e, BigInteger n) {
        blindingFactor = new BigInteger(n.bitLength(), new java.util.Random()).mod(n);
        blindNum = num.multiply(blindingFactor.modPow(e, n)).mod(n);
    }

    // Unblind the signature
    public BigInteger unblindSignature(BigInteger signature, BigInteger n) {
        return signature.multiply(blindingFactor.modInverse(n)).mod(n);
    }

    // Verify the signature
    public boolean verifySignature(BigInteger unblindedSignature, BigInteger e, BigInteger n) {
        return unblindedSignature.modPow(e, n).equals(num);
    }

    // Hash a string
    public static BigInteger hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes());
        return new BigInteger(1, hash);
    }
}

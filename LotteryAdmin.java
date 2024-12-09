import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class LotteryAdmin {
    // Big Integers needed
    private BigInteger p, q, n, phi, e, d;

    // Key size
    private final int KEY_SIZE = 512;

    // Constructor
    public LotteryAdmin() {
        generateKeys();
    }

    // Getters
    public BigInteger getE() {
        return e;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getD() {
        return d;
    }

    void generateKeys() {
        // Generate p and q
        p = new BigInteger(KEY_SIZE, 100, new java.util.Random());
        q = new BigInteger(KEY_SIZE, 100, new java.util.Random());

        // Calculate n
        n = p.multiply(q);

        // Calculate phi
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Generate e
        e = new BigInteger(KEY_SIZE, 100, new java.util.Random());
        while (phi.gcd(e).intValue() > 1) {
            e = new BigInteger(KEY_SIZE, 100, new java.util.Random());
        }

        // Generate d
        d = e.modInverse(phi);
    }

    // Sign the blind number
    public BigInteger sign(BigInteger blindNum) {
        return blindNum.modPow(d, n);
    }

    // Verify the signature
    public boolean verify(BigInteger signature, BigInteger num) {
        return signature.modPow(e, n).equals(num);
    }

    // // Hash a string
    // public static BigInteger hashString(String input) {
    //     return new BigInteger(input.getBytes());
    // }

    public static BigInteger hashString(String input) throws NoSuchAlgorithmException {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(input.getBytes());
        return new BigInteger(1, messageDigest);
    }
}
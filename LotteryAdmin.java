import java.math.BigInteger;

public class LotteryAdmin {
    // Big Integers needed
    private BigInteger p, q, n, phi, e, d;

    // Key size
    private final int KEY_SIZE = 512;

    // Constructor
    public LotteryAdmin() {
        generateKeys();
    }

    private void generateKeys() {
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
}
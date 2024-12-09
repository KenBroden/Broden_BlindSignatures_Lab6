import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        LotteryAdmin admin = new LotteryAdmin();
        Participant participant = new Participant();
        
        // Admin generates keys
        admin.generateKeys();
        
        // Participant chooses a number
        participant.chooseNumber();
        
        // Participant blinds the number
        participant.blindNumber(admin.getE(), admin.getN());
        
        // Admin signs the blinded number
        BigInteger signature = admin.sign(participant.getBlindNum());

        // Participant unblinds the signature
        BigInteger unblindedSignature = participant.unblindSignature(signature, admin.getN());
        
        // Participant verifies the signature
        boolean verified = participant.verifySignature(unblindedSignature, admin.getE(), admin.getN());
        
        System.out.println("Number signature verified: " + verified);

        // Hash and sign participant's name
        try {
            BigInteger hashedName = Participant.hashString("Ken");
            BigInteger signedName = admin.sign(hashedName);
            System.out.println("Signed name: " + signedName);
        } catch (Exception e) {
            System.out.println("Error while signing name: " + e);
        }

        // Verify the signature
        try {
            BigInteger hashedName = Participant.hashString("Ken");
            BigInteger signedName = admin.sign(hashedName);
            boolean verifiedName = admin.verify(signedName, hashedName);
            System.out.println("Name signature verified: " + verifiedName);
        } catch (Exception e) {
            System.out.println("Error while verifying name signature: " + e);
        }
    }
}

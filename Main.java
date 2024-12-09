import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        LotteryAdmin admin = new LotteryAdmin();
        Participant participant = new Participant();
        
        // Admin generates keys
        admin.generateKeys();
        
        // Participant chooses a number
        participant.chooseNumber();
        
        // Admin blinds the number
        participant.blindNumber(admin.getE(), admin.getN());
        
        // Participant unblinds the number
        participant.unblindNumber(admin.getD(), admin.getN());
        
        // Admin signs the number
        BigInteger signature = admin.sign(participant.getR());
        
        // Participant verifies the signature
        boolean verified = participant.verifySignature(admin.getE(), admin.getN());
        
        System.out.println("Signature verified: " + verified);
    }
}

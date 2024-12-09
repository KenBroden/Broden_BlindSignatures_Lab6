# Broden_BlindSignatures_Lab6

*Lab completed by Ken Broden*

## Lab Tasks

Your task is to implement an online lottery with the following requirements:

1. **Lottery Administration**:
   - Sells tickets.
   - Conducts the lottery by randomly choosing a winning number.
   - Awards the winning money to a person who chose the winning number (if any).

2. **Privacy Requirements**:
   - Lottery organizers must not know the numbers chosen by participants or their identities.
   - Transactions occur via a public channel, ensuring no one can see anyone's names.

3. **Blind Signatures**:
   - Participants obscure their chosen numbers with a "blinding factor" and send them to the lottery admin for a blind signature.
   - Participants also send the hash of their name for a blind signature to verify their identity.

4. **Winning Process**:
   - Once the winning number is announced, anyone who can send a correct signed number and name to the lottery administration gets the money.

## Explanation of `Main` Class

The `Main` class demonstrates the process of conducting an online lottery using blind signatures. Here are the steps involved:

1. **Initialize LotteryAdmin and Participant**:
   - An instance of `LotteryAdmin` and `Participant` is created.

2. **Generate RSA Keys**:
   - The `LotteryAdmin` generates a public/private RSA key pair.

3. **Participant Chooses a Number**:
   - The `Participant` chooses a random 10-digit decimal number.

4. **Blind the Number**:
   - The `Participant` blinds the chosen number using a blinding factor and the public key components (`e` and `n`) from the `LotteryAdmin`.

5. **Sign the Blinded Number**:
   - The `LotteryAdmin` signs the blinded number using its private key (`d`).

6. **Unblind the Signature**:
   - The `Participant` unblinds the signature received from the `LotteryAdmin`.

7. **Verify the Signature**:
   - The `Participant` verifies the unblinded signature using the public key components (`e` and `n`) from the `LotteryAdmin`.

8. **Hash and Sign Participant's Name**:
   - The `Participant` hashes their name using SHA-256 and sends it to the `LotteryAdmin` for signing.
   - The `LotteryAdmin` signs the hashed name.

9. **Verify the Name Signature**:
   - The `Participant` verifies the signature of the hashed name using the public key components (`e` and `n`) from the `LotteryAdmin`.

## Example Output

The output of the program indicates the success of the signature verification process for both the number and the name:

```plaintext
Number signature verified: true
Signed name: 54773856922899680361680667565460287730303226917868966623471270833067492078996875490727669605466858910175992500558284977575466559055247726478912443838437447993812511181429262989701459484140113189530610196138883263858514602797007779221459045814710108177394540694569149651904080327953371621360150766001001058767
Name signature verified: true
```

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

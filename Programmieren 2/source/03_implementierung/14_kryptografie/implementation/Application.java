import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;

@Slf4j
public class Application {
    public static void main(String... args) {
        SecretKey key = EncryptionUtility.generateKey();

        String pin = "1234";

        BankingCard card = BankingCard.builder().cardHolderName("John Doe").cardNumber("1234 5678 9876 5432").expirationDate(
                "12/25").build();

        card.encryptAndStorePin(pin, key);
        String decryptedPin = card.decryptPin(key);

        log.info("encrypted PIN stored on magnetic stripe : {}", card.getEncryptedPin());
        log.info("decrypted PIN (from reader)             : {}", decryptedPin);
        log.info("card holder                             : {}", card.getCardHolderName());
        log.info("card number                             : {}", card.getCardNumber());
        log.info("expiration date                         : {}", card.getExpirationDate());
    }
}
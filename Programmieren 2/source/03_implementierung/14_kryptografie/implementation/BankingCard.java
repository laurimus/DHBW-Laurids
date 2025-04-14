import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.crypto.SecretKey;

@Builder
@Getter
@Setter
public class BankingCard {
    private String cardHolderName, cardNumber, expirationDate, encryptedPin;

    @SneakyThrows
    public void encryptAndStorePin(String pin, SecretKey key) {
        encryptedPin = EncryptionUtility.encrypt(pin, key);
    }

    @SneakyThrows
    public String decryptPin(SecretKey key) {
        return EncryptionUtility.decrypt(encryptedPin, key);
    }
}
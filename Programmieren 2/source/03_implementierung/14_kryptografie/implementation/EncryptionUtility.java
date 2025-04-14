import lombok.SneakyThrows;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class EncryptionUtility {
    private static final String ALGORITHM = "AES";

    @SneakyThrows
    public static SecretKey generateKey() {
        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
        kg.init(128);
        return kg.generateKey();
    }

    @SneakyThrows
    public static String encrypt(String data, SecretKey key) {
        return Base64.getEncoder().encodeToString(process(Cipher.ENCRYPT_MODE, data.getBytes(), key));
    }

    @SneakyThrows
    public static String decrypt(String encryptedData, SecretKey key) {
        return new String(process(Cipher.DECRYPT_MODE, Base64.getDecoder().decode(encryptedData), key));
    }

    @SneakyThrows
    private static byte[] process(int mode, byte[] data, SecretKey key) {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(mode, key);
        return cipher.doFinal(data);
    }
}
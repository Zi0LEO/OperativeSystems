package Esercitazione03.Seminario;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicBoolean;

public class BruteForceDecrypter implements Runnable {
    final Integer startingAt, endingAt;
    private static AtomicBoolean solutionFound;
    static byte[] inputBytes = new byte[0];
    static byte[] solution;
    static byte[] rightKey;
    static final String stringToFind = "SISOP-corsoA";

    public BruteForceDecrypter(Integer startingAt, Integer endingAt){
        this.startingAt = startingAt;
        this.endingAt = endingAt;
        solutionFound = new AtomicBoolean(false);
    }

    @Override
    public void run() {
            searchKey();
        }

    private void searchKey() {
        String possibleSolution;
        for (Integer i = startingAt; i < endingAt; i++) {
            if (solutionFound.get())
                break;
            byte[] possibleKey = createString(i).getBytes();

            try {
                possibleSolution = new String(decrypt(possibleKey));
                if (possibleSolution.contains(stringToFind)) {
                    solution = possibleSolution.getBytes();
                    solutionFound.set(true);
                    rightKey = possibleKey;
                }
            } catch (Exception ignored) {}
        } //for
    }

    private byte[] decrypt(byte[] possibleKey)
            throws IllegalBlockSizeException, BadPaddingException,
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = createAndInitializeCipher(possibleKey);
        return cipher.doFinal(inputBytes);
    }

    private static Cipher createAndInitializeCipher(byte[] possibleKey)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES");
        Key secretKey = new SecretKeySpec(possibleKey, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher;
    }

    private String createString(Integer number){
        String partialKey = number.toString();
        StringBuilder sb = new StringBuilder();

        int zeroesToAppend = 16 - partialKey.length();
        sb.append("0".repeat(zeroesToAppend));
        sb.append(partialKey);

        return sb.toString();
    }
}

package lab8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * You are given a binary file which contains a sequence of characters representing a private Bitcoin key (256 characters).
 * From the keyboard read a sequence of characters which represents the public key for a Bitcoin. Generate the
 * transaction id for this information by using the XOR bitwise operator applied upon the private and public keys. Write the
 * result in another binary file.
 */
public class Lab8Prb4 {
    private static final int KEY_LENGTH = 256;

    public static void main(String[] args) {
        String privateKeyFile = "C:\\Users\\razvan.cacu\\Desktop\\se labs\\src\\lab8\\private_key.bin";
        String outputFile = "transaction_id.bin";

        try {
            byte[] privateKey = readBinaryFile(privateKeyFile);
            checkKeyLength(privateKey);
            byte[] publicKey = readPublicKey();
            checkKeyLength(publicKey);
            byte[] transactionId = xorKeys(privateKey, publicKey);
            writeBinaryFile(outputFile, transactionId);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static byte[] readBinaryFile(String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] content = new byte[fis.available()];
            fis.read(content);
            return content;
        }
    }

    private static byte[] readPublicKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the public key:");
        String publicKey = scanner.nextLine();

        return publicKey.getBytes();
    }

    private static byte[] xorKeys(byte[] privateKey, byte[] publicKey) {
        byte[] result = new byte[KEY_LENGTH];
        for (int i = 0; i < KEY_LENGTH; i++) {
            result[i] = (byte) (privateKey[i] ^ publicKey[i]);
        }

        return result;
    }

    private static void checkKeyLength(byte[] key) throws IOException {
        if (key.length != KEY_LENGTH)
            throw new IOException("Invalid key length!");
    }

    private static void writeBinaryFile(String fileName, byte[] content) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(content);
        }
    }
}

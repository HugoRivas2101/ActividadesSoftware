package org.example;

public class EncryptionExample {
    public static void main(String[] args) {

        try {
            EncryptionManager encryptionManager = new EncryptionManager();
            String originalData = "Soy un string ultra seguro";

            // Encriptar los datos
            String encryptedData = encryptionManager.encrypt(originalData);
            System.out.println("Encrypted Data: " + encryptedData);

            // Desencriptar los datos
            String decryptedData = encryptionManager.decrypt(encryptedData);
            System.out.println("Decrypted Data: " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
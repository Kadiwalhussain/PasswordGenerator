
import java.security.SecureRandom;
import java.util.Random;
public class pass {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOL = "!@#$%^&*()|;:{}[]/.,?<>";

    private static final String ALL_CHARACTERS = LOWERCASE + UPPERCASE +DIGITS + SYMBOL;

    public static void main(String[] args) {
        int passwordLength = 12;
        String generatedPassword = generatePassword(passwordLength);
        System.out.println("Generated Password: " + generatedPassword);

    }

    public static String generatePassword(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("Password length must be at least 4.");
        }

        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SYMBOL.charAt(random.nextInt(SYMBOL.length())));

        String availableCharacters = ALL_CHARACTERS;
        availableCharacters = availableCharacters.replace(password.charAt(0), ' ');
        availableCharacters = availableCharacters.replace(password.charAt(1), ' ');
        availableCharacters = availableCharacters.replace(password.charAt(2), ' ');
        availableCharacters = availableCharacters.replace(password.charAt(3), ' ');

        for (int i = 4; i< length; i++) {
            password.append(availableCharacters.charAt(random.nextInt(availableCharacters.length())));

        }
        return shuffleString(password.toString());

    }


    public static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i< characters.length; i++) {
            int randomIndex = (int) (Math.random() * characters.length);
            char temp = characters[i];
            characters [randomIndex] = temp;
        }
        return new String(characters);

    }



}

import java.util.Scanner;


public class Cipher {
	
	public static void main(String[] args) {
		Scanner inputText = new Scanner(System.in);
		System.out.println("Enter the phrase to encrypt: ");
		String plaintext = inputText.nextLine();
		
		Scanner offsetInput = new Scanner(System.in);
		System.out.println("Enter the offset value: ");
		int offset = offsetInput.nextInt();
		
		
		String text = Cipher.encrypt(plaintext, offset);
		System.out.println("Encrypted: " + text);
		System.out.println("Decrypted: " + Cipher.decrypt(text, offset));
		
		inputText.close();
		offsetInput.close();	
	}
	
	public static String decrypt(String text, int offset) {
		//reverse the proccess of the encryption by using the neg
		return encrypt(text, -offset);
	}

	public static String encrypt(String plaintext, int offset) {
		// Create StringBuilder obj because that are mutable.
		// allowing the use of append, instead of rebuilding the string each
		// time
		StringBuilder ciphertext = new StringBuilder();

		// Used to keep the offset shift at a range of 26-51
		offset = offset % 26 + 26;

		// We convert the string to a char array to allow us to iterate through
		// each individual element
		char current[] = plaintext.toCharArray();
		for (char i : current) { 
			// Verify the unicode value of i is in the
			// alphabet range.
			if ((i >= 'a') && (i <= 'z')) {
				// Subtract the unicode value of i from a and add the offset.
				// that value is then mod to 26 and set to j, the new position
				// from 'a'
				int j = (i - 'a' + offset) % 26;
				// the value of j is added to the unicode value of 'a' which is
				// the offset position of the new character
				// It is casted to a char so the interpreter accepts it into the
				// StringBuilder as a character.
				ciphertext.append((char) (j + 'a'));
			} else if ((i >= 'A') && (i <= 'Z')) {
				// Subtract the unicode value of i from a and add the offset.
				// that value is then mod to 26 and set to j, the new position
				// from 'A'
				int j = (i - 'A' + offset) % 26;
				// the value of j is added to the unicode value of 'A' which is
				// the offset position of the new character
				// It is casted to a char so the interpreter accepts it into the
				// StringBuilder as a character.
				ciphertext.append((char) (j + 'A'));
				}
			else {
				// if the value of i is not within the a-z unicode alphabet we
				// do nothing but add it to the string
				ciphertext.append(i);
			}
		}

		return ciphertext.toString();
	}
}

public class Rotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "hello world!";
		String alpha = "abcdefghijklmnopqrstuvwxyz1234567890 .,!";
		int num = 13;

		System.out.println(rotatationCipherEncrypt(text, num, alpha));

		System.out.println(rotationCipherDecrypt(rotatationCipherEncrypt(text, num, alpha), num, alpha));

	}

	public static boolean isValidPermutation(int[] permutation) {
		for (int i = 0; i < permutation.length; i++) {
			for (int j = i + 1; j < permutation.length; j++) {
				if (permutation[i] == permutation[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public String substitutionCipher(String plainText, int[] permutation, String alphabet) {

		String output = "";

		for (int i = 0; i < plainText.length(); i++) {

			int index = alphabet.indexOf(plainText.substring(i, i + 1));

			output += alphabet.substring(permutation[index], permutation[index] + 1);

		}
		return output;
	}

	public static String rotationCipherDecrypt(String cipherText, int shiftNumber, String alphabet) {
		return rotatationCipherEncrypt(cipherText, -shiftNumber, alphabet);
	}

	public static String rotatationCipherEncrypt(String plainText, int shiftNumber, String alphabet) {

		String output = "";

		for (int i = 0; i < plainText.length(); i++) {

			int index = alphabet.indexOf(plainText.substring(i, i + 1));

			for (int j = 0; j < Math.abs(shiftNumber); j++) {
				if (index == alphabet.length() - 1 && (shiftNumber / Math.abs(shiftNumber)) == 1) {
					index = 0;
				} else if (index == 0 && (shiftNumber / Math.abs(shiftNumber)) == -1) {
					index = alphabet.length() - 1;
				} else {
					index += (shiftNumber / Math.abs(shiftNumber));
				}
			}

			output += alphabet.substring(index, index + 1);

		}
		return output;
	}

}

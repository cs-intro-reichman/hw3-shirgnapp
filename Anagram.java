//import javax.imageio.spi.ImageWriterSpi;

//import com.apple.laf.resources.aqua;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2); 
		boolean Isequal = false;
		for (int i=0; i<str1.length(); i++) { 
			for(int j=0; j<str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					Isequal = true;
				}
			}
			if (Isequal == false) {
				return Isequal;
			}
			Isequal = false;
		}
		return true;
	}  
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		if (str.isEmpty()) {
			return str;
		}
		int length = str.length();
		String OnlyLetters = "";
		char letter;
		for(int i=0; i< length; i++)
		{
			letter = str.charAt(i);
			if (Character.isLetter(letter) == true) {
				OnlyLetters += letter;
			}
			if (letter == ' ') {
				OnlyLetters += letter;
			}
		}
		OnlyLetters = OnlyLetters.toLowerCase();
		return OnlyLetters;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		if (str.isEmpty()) 
			return str;
		int length = str.length();
		if (length == 1 || length ==0) {
			return str;
		}
		str= preProcess(str);
		if (str.isEmpty()) {
			return str;
		}
		String Newstring = "";
		double i = Math.random() * length;
		int random = (int)i;
		for(int j=0; j < length; j++) {
			if (j == random) {
				char letter= str.charAt(j);
				char[] charArray = str.toCharArray();
				if(j > 0){
				charArray[j] = str.charAt(j-1);
				charArray[j-1] = letter;
				Newstring = new String(charArray);
				break;
				}
				if (j == 0 && length !=1 || (j + 1) > length) {
				charArray[j] = str.charAt(j+1);
				charArray[j+1] = letter;
				Newstring = new String(charArray);
				break;
				}
			}
		} 
		return Newstring;
	}
	}

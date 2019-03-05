
public class AlphabetSoup {

	public static void main(String[] args) {

		// M is the dimension of the message and S is the dimension of the bowl of letters
		// the complexity in term of computational time is O(MxS), this because I have put two 'cicle for' that 
		// run through the two input string and each of this 'for' has a complexity proportional to the input dimension (M or S)
		//String a = "   of David is";
		//String a = "egassem";
		String a = "Hi,   message of David is"; 
		//String bowl = "EgaSsEmoff"; /*false result*/
		String bowl = "message,abcdefghjFHiGTUOIKJofisDavidHFGREJvdser"; /*true result*/

		System.out.println("Checking if I can write your message with the letters found in your bowl of soup,"
				+ " result = "+checkBowl(a,bowl)+"\n");
	}

	static boolean checkBowl(String message, String bowlOfAlphabetSoup) {

		boolean result = false;
		message = message.replaceAll("\\s+","");
		bowlOfAlphabetSoup = bowlOfAlphabetSoup.replaceAll("\\s+","");

		if (message.length() > bowlOfAlphabetSoup.length())
			return result; // there are not enough letters into the bowl to compose the message
		int i = 0;

		for (int j = 0, s = bowlOfAlphabetSoup.length(); j < s && i < message.length(); j++) {

			char checkChar = message.charAt(i);
			if (String.valueOf(checkChar).equalsIgnoreCase(String.valueOf(bowlOfAlphabetSoup.charAt(j)))){
				String found = String.valueOf(bowlOfAlphabetSoup.charAt(j));  
				result = true;
				bowlOfAlphabetSoup = bowlOfAlphabetSoup.replaceFirst(found, "");
				j=-1;
				i++;
			}
			else{
				if (j == s-1) {
					result = false;
					return result;
				}
			}
		}
		return result;
	}
}

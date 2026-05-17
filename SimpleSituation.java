
public class SimpleSituation {
	//The following method checks whether a string is a numeric string:
		public static boolean isNumeric(String token) {
		try {
		    Double.parseDouble(token);
		return true;
		  }
		catch (java.lang.NumberFormatException ex) {
		return false;
		  }
		}
		//Is it correct? Rewrite it without using exceptions.
		//It is correct,but there is a more convenient and less memory-intensive method.

		
		public static boolean isNumeric1(String token) {
		    // STEP 1: Edge case check (Null or empty strings cannot be numeric)
		    if (token == null || token.isEmpty()) {
		        return false;
		    }

		    int length = token.length();
		    int startIndex = 0;
		    boolean hasDot = false;
		    int digitCount = 0;

		    // STEP 2: Sign validation
		    // If the first character is a sign (+ or -), we start the loop from index 1
		    if (token.charAt(0) == '-' || token.charAt(0) == '+') {
		        startIndex = 1; 
		    }

		    // STEP 3: Character-by-character analysis using a single loop
		    for (int i = startIndex; i < length; i++) {
		        char ch = token.charAt(i);

		        // Decimal point check
		        if (ch == '.') {
		            // If we have already seen a dot, this is the second one; hence invalid.
		            if (hasDot) {
		                return false; 
		            }
		            hasDot = true; // Record that we encountered the first dot
		        } 
		        // Standard numeric range check in Java
		        else if (ch >= '0' && ch <= '9') {
		            digitCount++; // Valid digit found, increment the counter
		        } 
		        // Any other character (letters, spaces, special chars) invalidates the number
		        else {
		            return false; 
		        }
		    }

		    // STEP 4: Final confirmation
		    // The string must contain at least one valid digit after the loop finishes.
		    // (e.g., if the token is just "." or "-", digitCount remains 0 and returns false)
		    return digitCount > 0;
		}
}

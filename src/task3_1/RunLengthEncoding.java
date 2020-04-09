package task3_1;

import java.util.regex.Pattern;

public class RunLengthEncoding {
    public String encode(String inputString) {
        String encodedString = "";
        if (inputString == null || inputString.isEmpty()) {
            return encodedString;
        }

        if (inputString.length() == 1) {
            encodedString = "1" + inputString;
        } else {
            int occur = 1;
            StringBuilder encodedBString = new StringBuilder();
            for (int i = 0; i < inputString.length(); i++) {
                if (i + 1 < inputString.length() && inputString.charAt(i) == inputString.charAt(i + 1)) {
                    occur++;
                    continue;
                }

                if (Pattern.matches("[\\d]+", String.valueOf(inputString.charAt(i))) ||
                        String.valueOf(inputString.charAt(i)).contains("\\")
                ) {
                    encodedBString.append("\\");
                } else {
                    encodedBString.append(occur);
                }

                encodedBString.append(inputString.charAt(i));
                occur = 1;
            }
            encodedString = encodedBString.toString();
        }

        return encodedString;
    }
}

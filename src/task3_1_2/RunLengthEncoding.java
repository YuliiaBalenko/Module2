package task3_1_2;

import java.util.regex.Pattern;

public class RunLengthEncoding {
    public String encode(String inputString) {

        if (inputString == null || inputString.isEmpty())
            return "";

        int occur = 0;
        StringBuilder encodedBString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char symbol = inputString.charAt(i);
            if (symbol == '\\' || Pattern.matches("[\\d]+", String.valueOf(symbol))) {
                encodedBString.append('\\');
                encodedBString.append(symbol);
            } else {
                occur++;

                if (i == inputString.length() - 1 || inputString.charAt(i + 1) != symbol) {
                    encodedBString.append(occur);
                    encodedBString.append(symbol);
                    occur = 0;
                }
            }
        }

        return encodedBString.toString();
    }

    public String decode(String inputString) throws RuntimeException {

        if (inputString == null || inputString.isEmpty())
            return "";

        Boolean isSlash = false;
        StringBuilder decodedBString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char symbol = inputString.charAt(i);
            if (isSlash) {
                if (symbol == '\\' || Pattern.matches("[\\d]+", String.valueOf(symbol))) {
                    decodedBString.append(symbol);
                    isSlash = false;
                    continue;
                }
            }

            if (symbol == '\\') {
                isSlash = true;
                continue;
            }

            if (Pattern.matches("[\\d]+", String.valueOf(symbol))) {
                if (i + 1 < inputString.length() && Pattern.matches("[\\w]", String.valueOf(inputString.charAt(i + 1)))) {
                    int num = Integer.parseInt(String.valueOf(symbol));
                    while (num-- != 0) {
                        decodedBString.append(inputString.charAt(i + 1));
                    }
                    i++;
                } else {
                    throw new RuntimeException("ERROR: next symbol must be a-z || A-Z");
                }
            } else {
                throw new RuntimeException("ERROR: invalid data");
            }
        }

        return decodedBString.toString();
    }
}

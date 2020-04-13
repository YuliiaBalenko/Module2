package task3_1_2;

public class Test {
    public static void main(String[] args) {
        RunLengthEncoding rle = new RunLengthEncoding();

        String source = "\\0yyytYYYYYuuuu87\\IIIIIIppp";
        String encode= rle.encode(source);
        String decode= rle.decode(encode);

        System.out.println("Source: " + source);
        System.out.println("Encode: " + encode);
        System.out.println("Decode: " + decode);
    }
}

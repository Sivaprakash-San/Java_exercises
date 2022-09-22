import java.util.Scanner;

public class VigenereCipher{

    static String encode(String text, String key){

        String res = "";
        
        for (int i = 0, j = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') {

                continue;
            }
            res += (char) ((c + key.charAt(j) ) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Keyword : ");
        String key = scn.next();
        key = key.toUpperCase();
        System.out.print("Enter messaage to encrypt : ");
        String msg = scn.next();
        msg = msg.toUpperCase();
        msg = msg.replaceAll("\\s", "");
        String enc = encode(msg, key);
        System.out.println("Encrypted Message : " + enc);

        scn.close();
    }
}
import java.util.*;
public class HillCipher {

    public static int[][] keymat = new int[][] { { 1, 2, 1 }, { 2, 3, 1 }, { 2, 1, 2 } };

    public static String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(char a, char b, char c) {

        String ret = "";
        int x, y, z;
        int posa = (int) a - 65;
        int posb = (int) b - 65;
        int posc = (int) c - 65;
        x = posa * keymat[0][0] + posb * keymat[0][1] + posc * keymat[0][2];
        y = posa * keymat[1][0] + posb * keymat[1][1] + posc * keymat[1][2];
        z = posa * keymat[2][0] + posb * keymat[2][1] + posc * keymat[2][2];
        a = key.charAt(x % 26);
        b = key.charAt(y % 26);
        c = key.charAt(z % 26);
        ret = "" + a + b + c;
        return ret;
    }
    public static void main(String[] args){
        
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Plain Text : " );
        String msg = scn.next();
        String enc = "";
        int n;
        msg = msg.toUpperCase();
        msg = msg.replaceAll("\\s", "");
        n = msg.length() % 3;

        if (n != 0) {

            for (int i = 0; i < (3 - n); i++) {
                msg += 'X';
            }
        }
        
        char[] ptchrs = msg.toCharArray();
        
        for (int i = 0; i < msg.length(); i += 3){
    
            enc += encrypt(ptchrs[i], ptchrs[i + 1], ptchrs[i + 2]);
        }
        
        System.out.println("Encrypted Message : " + enc);
    }
}
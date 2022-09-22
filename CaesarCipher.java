import java.util.Scanner;
public class CaesarCipher
{ 
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter text to Encrypt : ");
        String text = scn.nextLine();   
        int s = 3;

        StringBuffer result= new StringBuffer();
  
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
                result.append(ch);
            }
            else if (Character.isLowerCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
                result.append(ch);
            }
            else{
                char ch = text.charAt(i);
                result.append(ch);
            }
        }

        System.out.println("After Encryption: " + result);
        scn.close();
    }
}
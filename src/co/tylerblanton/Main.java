/* Main.java
 *
 * This is the main file for java version of pa1md5 for Spring 2016 Advanced Programming at UC Denver
 *
 * Author: Tyler Blanton
 * Date Started: January 26, 2016
 * Date Due: February 9, 2016
 * repository url:
 */
//package co.tylerblanton;      //must comment this out to run program on the command line
import static java.lang.System.out;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            Scanner s = new Scanner(System.in);
            out.print("Enter the string you would like to encrypt: ");
            String md5 = s.nextLine();
            try
            {
                MessageDigest md = java.security.MessageDigest.getInstance("MD5");
                byte[] arr = md.digest(md5.getBytes());
                StringBuffer buffer = new StringBuffer();
                for(int i=0; i < arr.length; i++)
                {
                    //got help here from Stack Overflow: http://stackoverflow.com/questions/2817752/java-code-to-convert-byte-to-hexadecimal
                    buffer.append(Character.forDigit((arr[i] >> 4) & 0xF, 16));
                    buffer.append(Character.forDigit((arr[i] & 0xF), 16));
                }
                out.println(md5 + "\t" + buffer);
            }catch(NoSuchAlgorithmException e)
            {
                out.println("Algorithm does not exist. Program terminated.");
                return;
            }
        }
        else
        {
            int N = Integer.valueOf(args[0]);
            for(int i = 0; i < N; ++i)
            {
                String md5 = "Test<" + (i+1) + ">";
                try
                {
                    MessageDigest md = java.security.MessageDigest.getInstance("MD5");
                    byte[] arr = md.digest(md5.getBytes());
                    StringBuffer buffer = new StringBuffer();
                    for (int j = 0; j < arr.length; j++)
                    {
                        //got help from StackOverflow: http://stackoverflow.com/questions/2817752/java-code-to-convert-byte-to-hexadecimal
                        buffer.append(Character.forDigit((arr[j] >> 4) & 0xF, 16));
                        buffer.append(Character.forDigit((arr[j] & 0xF), 16));
                    }
                    if(i == 0 || i == N-1)
                    {
                        out.format("%-20s%s\n", md5, buffer);
                    }
                }catch (NoSuchAlgorithmException e)
                {
                    out.println("No algorithm exists");
                    return;
                }
            }
        }
    }
}

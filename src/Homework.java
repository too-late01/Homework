import java.util.Base64;
import java.util.Scanner;
public class Homework {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        System.out.println ("Please enter your full name");
        String name = sc.nextLine ();
        String encodedFullName = Base64.getEncoder().encodeToString(name.getBytes());
        System.out.println("Program result: " + encodedFullName);
    }
}

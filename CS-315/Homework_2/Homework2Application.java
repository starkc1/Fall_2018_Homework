import java.util.Scanner;

/**
 *
 * @author PUT YOUR NAME HERE
 */
public class Homework2Application {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        OurLinkedStack<Character> charStack = new OurLinkedStack<Character>();
        getCharactersFromUser(sc, charStack);
        if(charStack.size() > 0)
        {
            displayStack(charStack); 
            int n = getNumberFromUser(sc, "n");
            int k = getNumberFromUser(sc, "k");
            roll(charStack, n, k);
            System.out.println("\nThe rolled stack: ");
            displayStack(charStack); 
        }
        else
        {
            System.out.println("You did not enter anything.");
        }
        
        sc.close();
    }//end main
    
    public static void getCharactersFromUser(Scanner sc, 
                                    OurLinkedStack<Character> charStack)
    {
        System.out.println("Please enter any string");
        String str = sc.nextLine();
        //Insert code to get each character from the string and push it 
        //onto the charStack.
    }
    
    public static void displayStack(OurLinkedStack<Character> charStack)
    {
        //Insert code to display the contents of the charStack on the screen
        //in such a way that, when the method exits, the stack is back to
        //its original state.
        //Hint: Use a temporary stack.
    }

    public static int getNumberFromUser(Scanner sc, String which)
    {
        //This method gets either the n or the k needed for the roll method
        int value;
        System.out.print("Enter a non-negative value for " + which + " ");
        String ans = sc.nextLine();
        if (ans.length() == 0)
            return 0;
        value = Integer.parseInt(ans);
        return value;
    }
    
    public static void roll(OurLinkedStack<Character> stack, 
            int n, int k) throws Exception
    {
        //Insert code to implement roll as described in the text.
        //You may need a temporary stack and a queue.
    }
}//end class

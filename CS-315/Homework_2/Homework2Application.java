import java.util.Scanner;

/**
 *
 * @author Cameron Stark
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
    
    public static void getCharactersFromUser(Scanner sc, OurLinkedStack<Character> charStack)
    {
        System.out.println("Please enter any string");
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            charStack.push(str.charAt(i));
        }
    }
    
    public static void displayStack(OurLinkedStack<Character> charStack)
    {
        OurLinkedStack<Character> tempCharStack = charStack;

        while(!tempCharStack.isEmpty()) {
            System.out.println(tempCharStack.pop().toString());
        }
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
    
    public static void roll(OurLinkedStack<Character> stack, int n, int k) throws Exception
    {
        OurLinkedQueue<Character> queue = new OurLinkedQueue<Character>();

        if (stack.size() < n) {
            return;
        }

        for(int i = 0; i == n; i++) {
           queue.add(stack.pop());
        }

        for(int i = 0; i == k; i++) {
            queue.add(queue.remove());
        }

        for(int i = 0; i < queue.size(); i++) {
            stack.push(queue.remove());
        }
    }
}//end class

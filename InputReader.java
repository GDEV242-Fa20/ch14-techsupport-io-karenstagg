import java.util.HashSet;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * InputReader reads a text file as input. 
 * The text is then chopped into words, and a set of words 
 * is provided.
 * 
 * @author Karen Stagg
 * @version November 30, 2020
 */
public class InputReader
{
    private Scanner reader;
    //The name of the file containing the input
    private static final String INPUT_TEXT_FILE = "input.txt";

    /**
     * Create a new InputReader that reads text from a text file.
     * A blank line marks the end of a text entry.  
     * A text entry can have multiple lines.
     * The string "bye" ends the input.
     */

    public InputReader() 
    {
        try
        {
            reader = new Scanner(Paths.get(INPUT_TEXT_FILE)); 
        }
        catch(IOException e)
        {
            System.err.println("Cannot find file: " + INPUT_TEXT_FILE);
        }
    }

    /**
     * Read a line of text from text file input
     * and return it as a set of words.   
     *
     * @return  A set of Strings, where each String is one of the 
     *          words contained in the text file.  
     */
    public HashSet<String> getInput() 
    {
        String input;
        String entireInput = "";
        //Read the input text file and append multiple lines of entry
        if (reader.hasNext())
        {
            do
            {
                input = reader.nextLine();
                if (entireInput.length() > 0)
                {
                    entireInput = entireInput + " " + input;
                }
                else
                {
                    entireInput = input;
                } 
            }
            //while there are more lines and input is not blank 
            //or is first line read
            while (reader.hasNext() && (input.length()  != 0 || entireInput.length() == 0));
        }
        //to handle end of file reached without a bye
        else
        {
            entireInput = "bye";
        }  
        
        //Display the line(s) of text read
        System.out.println("\n" + entireInput + "\n");
                
        //split entry into separate words and create HashSet to place words into   
        String[] wordArray = entireInput.split(" ");
        HashSet<String> words = new HashSet<String>();
        for (String word : wordArray)
        {
            words.add(word);
        } 
        return words;
    }
}


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Kendra Driver 
 */
public class AssignmentFive {


    double found = 0;
    double notFound = 0;
    long compCountF =0;
    long compCountNF=0;
    
    
   /**
     * @param args the command line arguments
     * @requires - a dictionary test file and a text file of the words
     *              to be checked
     * @ensures - the number of words not/found and the total number of 
     *              words checked.
     * 
     */
    
    public void assignmentFive() {
        
        BinarySearchTree[] dictionaryList = new BinarySearchTree[26];

        try {
            FileInputStream inf = new FileInputStream(new File("random_dictionary.txt"));
            char let;
            String word = ""; //word to be processed
            int n = 0;
            while ((n = inf.read()) != -1) {
                let = (char) n;
                if (Character.isLetter(let)) {
                    word += Character.toLowerCase(let);
                }//if
                if ((Character.isWhitespace(let) || let == '-') && !word.isEmpty()) {
                    if (dictionaryList[word.charAt(0) - 97] == null) {
                        dictionaryList[word.charAt(0) - 97] = new BinarySearchTree();
                        dictionaryList[word.charAt(0) - 97].insert(word);
                    } else {
                        dictionaryList[word.charAt(0) - 97].insert(word);
                    }//else null pointer exception catch
                    word = "";
                }//If
            }//While 

            inf.close();

            FileInputStream olive = new FileInputStream(new File("oliver.txt"));
            while ((n = olive.read()) != -1) {
                let = (char) n;
                if (Character.isLetter(let)) {
                    word += Character.toLowerCase(let);
                }//if character 

                if ((Character.isWhitespace(let) || let == '-') && !word.isEmpty()) {
                   
                    if (dictionaryList[word.charAt(0) - 97].search(word)) {
                        compCountF= compCountF + dictionaryList[word.charAt(0) - 97].getSize()+1;
                        found++;
                    } else {
                       compCountNF= compCountNF + dictionaryList[word.charAt(0) - 97].size;
                        notFound++;
                    }//else
                    word = "";
                }//If
                
            }//While 
            olive.close();
        }//Try             
        catch (IOException e) {
            e.printStackTrace();
        }//Catch

    }//bringInDictionary

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("~~Binary Search Tree~~");
        
        AssignmentFive run = new AssignmentFive();
        
        long startTime = System.nanoTime(); //start clock
        
        run.assignmentFive();

        System.out.println("Found = " + run.found);
        System.out.println("Not Found = " + run.notFound);
        
        System.out.println("compCountF = " + run.compCountF);
        System.out.println("compCountNF = " + run.compCountNF);

       
        double total = run.found + run.notFound;
        System.out.println("Total = " + total);

        System.out.println("Average comparisons for words found = " 
                + run.compCountF / run.found);
        System.out.println("Average comparisons for words not found = "
                + run.compCountNF / run.notFound);
        
       
        long elapsedTime = System.nanoTime() - startTime; //stop clock - start clock gives elapsed time
        System.out.println("");
        System.out.printf("Time elapsed: = %f", ((double) elapsedTime) / Math.pow(10, 9));
        System.out.println(""); 
        
        
//*/         

    }//Main

}//Class


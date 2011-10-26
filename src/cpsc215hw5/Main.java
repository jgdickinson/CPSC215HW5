/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpsc215hw5;

/**
 *
 * @author jgdicki
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        try {
            Fraction start = new Fraction(1,4);
            start.printFraction();

            Fraction end = new Fraction(3,4);
            
            Fraction test = new Fraction(4,5);
            
            System.out.println(test.fallsBetween(start, end));


        } catch (IllegalArgumentException iae) {
            System.err.println("Cannot divide by 0.");
        } catch (NullPointerException npe) {
            System.out.println("Falls Between Failed");
        }
    }
}

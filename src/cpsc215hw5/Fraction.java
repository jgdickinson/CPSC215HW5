package cpsc215hw5;
/**
 * <p>A <code>Fraction</code> represents an immutable,
 * fully reduced fraction with an integer numerator and denominator.</p>
 */
public class Fraction {

    private int myNumerator;
    private int myDenominator;

    /**
     * <p>Creates a new <code>Fraction</code> based on
     * the given numerator and denominator.  The created fraction will represent
     * a fully reduced version of the given numerator and denominator.  If the
     * numerator is 0, the fraction will be reduced to 0 over 1.  If the
     * fraction is negative, the created fraction will be represented with a
     * negative numerator and a positive denominator--the created fraction's
     * denominator will never be negative.</p>
     *
     * @param numerator The numerator of the fraction.
     * @param denominator The non-zero denominator of the fraction.
     *
     * @throws IllegalArgumentException If <code>denominator = 0</code>.
     */
    public Fraction(int numerator, int denominator) {

        if (denominator == 0){
            throw new IllegalArgumentException("The denom cannot be 0, bitch.");
        }
        else if (numerator == 0){
            myNumerator = 0;
            myDenominator = 1;
        }
        else if(denominator < 0 && numerator > 0){
            myNumerator = numerator * -1;
            myDenominator = denominator * -1;
        }
        else if (denominator < 0 && numerator < 0){
            myNumerator = numerator * -1;
            myDenominator = denominator * -1;
        }
        else {
        myNumerator = numerator;
        myDenominator = denominator;
        }
    }
    /**
     * <p>Returns the numerator of the fraction.</p>
     *
     * @return The numerator.
     */
    public int getNumerator() {
         return myNumerator;
    }

    /**
     * <p>Returns the denominator of the fraction.</p>
     *
     * @return The denominator.
     */
    public int getDenominator() {
        return myDenominator;
    }

    /**
     * <p>Multiplies this fraction with another.</p>
     *
     * @param other The other fraction.
     *
     * @return The result of multiplying this fraction with the other.
     */
    public Fraction times(Fraction other) {
        Fraction result = new Fraction(0,1);

        result.myDenominator = this.myDenominator * other.myDenominator;
        result.myNumerator = this.myNumerator * other.myNumerator;

        return result;

    }

    /**
     * <p>Returns the result of performing double division on the numerator
     * and denominator of this fraction.</p>
     *
     * @return The double approximation.
     */
    public double approximate() {
        return ((double)this.myNumerator) / ((double)this.myDenominator);
     }

    /**
     * <p>Returns <code>true</code> if and only if this fraction is equal to
     * or bigger than <code>start</code> and equal to or less than
     * <code>end</code>.</p>
     *
     * @param start The lower bound of the window (inclusive.)
     * @param end The upper bound of the window (inclusive.)
     * @return True <strong>iff</strong> this fraction falls between
     *      <code>start</code> and <code>end</code>.
     *
     * @throws NullPointerException If <code>start</code> or <code>end</code> is
     *                              <code>null</code>.
     */
    public boolean fallsBetween(Fraction start, Fraction end) {

        double doubleStart = 0;
        double doubleEnd   = 0;
        double doubleThis = 0;

        if(start == null || end == null){
            throw new NullPointerException();
        }

        doubleStart = start.approximate();
        doubleEnd   = end.approximate();
        doubleThis  = this.approximate();


        return (doubleStart <= doubleThis && doubleEnd >= doubleThis);
    }

    public void printFraction(){
        System.out.println(this.myNumerator + " / " + this.myDenominator);
    }

    /**
     * <p>Returns true if and only if the given object is a
     * <code>Fraction</code> that equals this one.</p>
     */
    @Override
    public boolean equals(Object o) {
        boolean retval;

        if (o instanceof Fraction) {
            Fraction oAsFraction = (Fraction) o;
            retval = (oAsFraction.getNumerator() == myNumerator) &&
                (oAsFraction.getDenominator() == myDenominator);
        }
        else {
            retval = false;
        }

        return retval;
    }
}

/**
 * @author Noah Stephen Haskell
 *
 *<br>
 * This is a class of immutable complex numbers capable of all 
 * features of complex arithmetic.
 *
 *
 */

public class Complex
{
    private static final double TINY = 1e-6;
    private double a;
    private double b;

    public static Complex ONE = new Complex(1);
    public static Complex ZERO = new Complex();
    public static Complex I = new Complex(0,1);

    /**
    *   Constructs a complex in the format a+bi, where a is the real term and i is the imaginary term
     */
    public Complex(double _real, double _imaginary)
    {
        //a + bi, where real is a and imaginary is b
        this.a = _real;
        this.b = _imaginary;
    }
    
    /**
     * Constructs a complex with no imaginary term.
     */
    public Complex(double _real)
    {
        this.a = _real;
        this.b = 0;
    }
    /** Constructs a complex with no imaginary or real term.
     */
    public Complex()
    {
        this.a = 0;
        this.b = 0;
    }
    /** Prints the construct in the form a+bi, replacing + with - if b is negative
     */
    @Override
    public String toString(){
        String printme;
        if(this.b < 0){
            printme = this.a + "-" + (0-this.b) + "i";
        }else{
            printme = this.a + "+" + this.b + "i";
        }
        return printme;
    }
    //use this in test code to check if complex numbers
    //are "close enough" since == and .equals and floating
    //point numbers don't always play nicely.
    private static boolean closeEnough(Complex z, Complex w)
    {
        return z.subtract(w).magnitude() < TINY;
    }
    /** Checks to see if object o is a complex, and if it is, then checks to see if a == a and b == b
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Complex){
            Complex cmplx = (Complex) o;
            System.out.println(cmplx + " " + this);
            if ((cmplx.a == this.a) && (cmplx.b == this.b)){
                return true;
            }
        }
        return false;
        
    }
    /** Adds two complex by combining like terms
      */
    public Complex add(Complex that) {
        return new Complex((this.a + that.a), (this.b + that.b));
    }
    /** Subtracts two complex numbers by combining like terms
      */
    public Complex subtract(Complex that) {
        return new Complex((this.a - that.a), (this.b - that.b));
    }
    /** Multiplies two Complexes (a+bi)(c+di)=(a*c)-(b-d)+i*(a*d)+(b*c)
      */
    public Complex multiply(Complex that) {
        return new Complex(((this.a*that.a)-(this.b*that.b)),((this.a*that.b)+(this.b*that.a)));
    }
    /** Divides two complexes by dividing the product of two complexes (a+bi)(c+di) by c squared plus d squared
     */
    public Complex divide(Complex that) {
        Complex numerator = this.multiply(that.conjugate());
        Double denominator = (that.magnitude()*that.magnitude());
        return new Complex(numerator.a/denominator, numerator.b/denominator);
    }
    /** returns the congugate of the complex
      */
    public Complex conjugate() {
        return new Complex(this.a, 0 - this.b);
    }
    /** return the absolute value of the complex
      */
    public double magnitude() {
        return Math.sqrt((this.a*this.a)+(this.b*this.b));
    }
    /** return the complex to the n. n is an integer
      */
    public Complex pow(int n) {
        Complex total = ONE;
        int count = 1;
        if(n < 0 ){
          n = 0-n;
            do{
                total = total.divide(this);
                count ++;
            } while (count != n+1);
        }
        else {
            do {
                total = total.multiply(this);
                count ++;
            } while (count != n+1);
        }
        return total;
    }
    /** return the real term of the complex
      */
    public double re() {
        return this.a;
    }
    /** return the imaginary term of the complex
      */
    public double im() {
        return this.b;
    }
    /** return the argument of the complex
      */
    public double arg() {
        return Math.asin(this.b/this.magnitude());
    }
    /** This is test code
      */
    public static void main(String[] args)
    {
        Complex test1 = new Complex(3, 5);
        Complex test2 = new Complex(2, 3);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println("add testing:");
        System.out.println(closeEnough(test1.add(test2), new Complex(5,8)));
        System.out.println("subtract testing");
        System.out.println(closeEnough(test1.subtract(test2), new Complex(1, 2)));
        System.out.println("Multiply testing:");
        System.out.println(closeEnough(test1.multiply(test2), new Complex(-9, 19)));
        System.out.println("Division testing:");
        System.out.println(closeEnough(new Complex(-9, 19).divide(test1), test2));
        System.out.println("toString testing:");
        System.out.println(test1 + " " + test2 + " " + new Complex(9,-19));
        System.out.println("equals testing:");
        System.out.println(test1.equals(test1));
        System.out.println("Congutate testing:");
        System.out.println(closeEnough(test1.conjugate(), new Complex(3, -5)));
        System.out.println(closeEnough(test1.conjugate().conjugate(), test1));
        System.out.println("Magnitude testing:");
        System.out.println(test2.magnitude() == Math.sqrt(13));
        System.out.println("Power testing");
        System.out.println(closeEnough(new Complex(3,2).pow(2), new Complex(5, 12)));
        System.out.println(closeEnough(new Complex(2).pow(-1), new Complex(.5)));
        System.out.println("Re testing:");
        System.out.println(test1.a == test1.re());
        System.out.println("im testing:");
        System.out.println(test1.b == test1.im());
        System.out.println("arg testing:");
        System.out.println("This should be about .79 radians (45 degrees)");
        System.out.println(new Complex(1,1).arg());





    }
}


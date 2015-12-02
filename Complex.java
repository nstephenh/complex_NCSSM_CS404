/**
 * This is a class of immutable complex numbers capable of all 
 * features of complex arithmetic.  
 */
public class Complex
{
    private static final double TINY = 1e-6;
    public Complex(double _real, double _imaginary)
    {
        //code
    }
    
    public Complex(double _real)
    {
        //code
    }
    public Complex()
    {
        //code
    }
    public String toString()
    {
        return null;
    }
    //use this in test code to check if complex numbers
    //are "close enough" since == and .equals and floating 
    //point numbers don't always play nicely.
    private static boolean closeEnough(Complex z, Complex w)
    {
        return z.subtract(w).magnitude() < TINY;
    }
    public boolean equals(Object o)
    {
        return false;
    }
    public Complex add(Complex that)
    {
        return null;
    }
    public Complex subtract(Complex that)
    {
        return null;
    }
    public Complex multiply(Complex that)
    {
        return null;
    }
    public Complex divide(Complex that)
    {
        return null;
    }
    public Complex conjugate()
    {
        return null;
    }
    public double magnitude()
    {
        return 0;
    }
    public Complex pow(int n)
    {
        return null;
    }
    public double re()
    {
        return 0;
    }
    public double im()
    {
        return 0;
    }
    public double arg()
    {
        return 0;
    }
    public static void main(String[] args)
    {
        //PUT TEST CODE HERE!!!!
    }
}


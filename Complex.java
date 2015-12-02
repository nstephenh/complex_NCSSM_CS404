/**
 * This is a class of immutable complex numbers capable of all 
 * features of complex arithmetic.  
 */
public class Complex
{
    private static final double TINY = 1e-6;
    private double a;
    private double b;

    public Complex ONE = new Complex(1);
    public Complex ZERO = new Complex();
    public Complex I = new Complex(0,1);


    public Complex(double _real, double _imaginary)
    {
        //a + bi, where real is a and imaginary is b
        this.a = _real;
        this.b = _imaginary;
    }
    
    public Complex(double _real)
    {
        this.a = _real;
        this.b = 0;
    }
    public Complex()
    {
        this.a = 0;
        this.b = 0;
    }
    public String toString(){
        String printme;
        if(this.b < 0){
            printme = this.a + "-" + (0-this.b);
        }else{
            printme = this.a + "+" + this.b;
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
    public boolean equals(Object o) {
        if (o.getClass().equals(ZERO)){
            Complex cmplx = (Complex)o;
            if ((cmplx.a == this.a) && (cmplx.b == this.b)){
                return true;
            }
        }
        return false;
    }
    public Complex add(Complex that) {
        return new Complex((this.a + that.a), (this.b + that.a));
    }
    public Complex subtract(Complex that) {
        return new Complex((this.a - that.a), (this.b - that.b));
    }
    public Complex multiply(Complex that) {
        return new Complex(((this.a*that.a)-(this.b*that.b)),((this.a*that.b)+(this.b*that.a)));
    }
    public Complex divide(Complex that) {
        Complex numerator = this.multiply(that);
        Double denominator = (that.magnitude()*that.magnitude());
        return new Complex(numerator.a/denominator, numerator.b/denominator);
    }
    public Complex conjugate() {
        return new Complex(this.a, 0 - this.b);
    }
    public double magnitude() {
        return Math.sqrt((this.a*this.a)+(this.b*this.b));
    }
    public Complex pow(int n) {
        return null;
    }
    public double re()
    {
        return this.a;
    }
    public double im()
    {
        return this.b;
    }
    public double arg()
    {
        return Math.atan2(this.a, this.b); //leared about this on wikipedia, not sure if right
    }
    public static void main(String[] args)
    {
        //PUT TEST CODE HERE!!!!
    }
}


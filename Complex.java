/**
 * @author Noah Stephen Haskell
 *
 *
 * This is a class of immutable complex numbers capable of all 
 * features of complex arithmetic.
 *
 *It features the following constants:
 * <ul>
 *<li><code>Complex.ONE</code>  This is 1 + 0i.</li>
*<li><code>Complex.ZERO</code>  This is 0 + 0i.</li>
*<li><code>Complex.I</code>  This is  0 +  i.</li>
*</ul>
 * And the following methods/operations
*<ul>
*<li><code>Complex(double _real, double _imaginary)</code>  This
*constructor creates <code>_real + i*_imaginary</code></li>
*<li><code>Complex(double _real)</code>  This
*constructor creates <code>_real + i*0</code></li>
*<li><code>Complex()</code>  This
*constructor creates <code>0 + i*0</code></li>
*<li><code>String toString()</code> returns a string representation that
*looks like <code>a + ib</code> or <code>a - ib</code>.</li>
*<li><code>boolean equals(Object o)</code> returns <code>true</code>
*if <code>o</code> is a <code>Complex</code> and if its real and imaginary
*parts agree with those of this complex number.</li>
*looks like <code>a + ib</code> or <code>a - ib</code>.</li>
*<li><code>Complex add(Complex that)</code> Returns <code>this + that</code></li>
*<li><code>Complex subtract(Complex that)</code>returns <code>this - that</code></li>
*<li><code>Complex multiply(Complex that)</code>returns <code>this * that</code></li>
*<li><code>Complex divide(Complex that)</code>returns <code>this / that</code></li>
*<li><code>Complex conjugate()</code> returns the conjugate of <code>this </code></li>
*<li><code>Complex magnitude()</code> returns <code>|this|</code>. In mathematical parlance, we use \(|z|\) for the
magnitude of a complex number. Notice how this is an
extension of the definition of absolute value for a real
number. </li>
*<li><code>Complex pow(int n)</code> returns <code>this<sup>n</sup></code></li>
*<li><code>double re()</code> returns the real part of <code>this</code></li>
*<li><code>double im()</code> returns the imaginary part of <code>this</code></li>
*<li><code>double arg()</code> returns the argument of <code>this</code>. For a complex number \(z = a + ib\), its <em>argument</em>
is defined as \(\arcsin(b/|z|)\). This it the angle it makes,
as a vector, with the positive real (\(x\)-axis) in the complex
plane.</li>
*</ul>
 */
public class Complex
{
    private static final double TINY = 1e-6;
    private double a;
    private double b;

    public static Complex ONE = new Complex(1);
    public static Complex ZERO = new Complex();
    public static Complex I = new Complex(0,1);


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
        Complex total = ONE;
        int count = 1;
        if(n < 0 ){
            do{
                total = total.divide(this);
            } while (count != n);
        }
        else {
            do {
                total = total.multiply(this);
            } while (count != n);
        }
        return total;
    }
    public double re() {
        return this.a;
    }
    public double im() {
        return this.b;
    }
    public double arg() {
        return Math.atan(this.b/this.magnitude()); //leared about this on wikipedia, not sure if right
    }
    public static void main(String[] args)
    {
        //PUT TEST CODE HERE!!!!
    }
}


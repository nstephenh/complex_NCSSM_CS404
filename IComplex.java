/**
 * This is the design contract.  DO NOT CHANGE ANYTHING IN IT.
 * I will be running this design contract alongside of your code
 * to ensure you have not changed method names.  It completely
 * specifies the public portion of your Complex class.
 */
public interface IComplex
{
    public Complex add(Complex that);
    public Complex subtract(Complex that);
    public Complex multiply(Complex that);
    public Complex divide(Complex that);
    public Complex conjugate();
    public double magnitude();
    public Complex pow(int n);
    public double re();
    public double im();
    public double arg();
}

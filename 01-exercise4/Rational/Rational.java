package Rational;//1
import java.lang.Math;

public class Rational {//1
    private int numerator;
    private int denominator;
    int t_den;
    int t_num;

    public Rational() {//2
      this.numerator = 0;
      this.denominator = 1;
    }
    public Rational(int num, int den) { //7
      this.numerator = num;
      this.denominator = den;
      t_den = den;
      t_num = num;
    }

    public void printRational() {//3
      System.out.printf("numerator: %d\ndenominator: %d\n", this.numerator, this.denominator);
    }
    public String toString() {//6
      return Integer.toString(this.numerator)+"/"+Integer.toString(this.denominator);
    }
    public void negate() {
      if(this.numerator < 0) {
        this.numerator = Math.abs(this.numerator);
      } else if(this.numerator > 0) {
        this.numerator *= -1;
      }

      if(this.denominator < 0) {
        this.denominator = Math.abs(this.denominator);
      } else if(this.denominator > 0) {
        this.denominator *= -1;
      }
    }
    public void inverse() {
      int temp = this.numerator;
      if(this.numerator != this.denominator) {
        this.numerator = this.denominator;
        this.denominator = temp;
      }
    }

    public double toDouble() {
      return ((double)this.numerator /(double)this.denominator);
    }

    public int GCD(int a, int b) {
      if(a == 0) {
        return b;
      } 
      return GCD(b % a, a);
    }

    public void add(Rational rationale) {
      int nd = GCD(this.denominator, rationale.t_den);
      nd = (this.denominator * rationale.t_den) / nd;
      int nn = (this.numerator)*(nd/this.denominator) + (rationale.t_num)*(nd/rationale.t_den);

      // System.out.println(nn+"/"+nd);
      int cf = GCD(nn, nd);
      nd = nd/cf;
      nn = nn/cf;
      System.out.println(nn+"/"+nd);
    }
}

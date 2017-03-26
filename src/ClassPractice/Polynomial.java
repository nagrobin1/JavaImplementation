package ClassPractice;

/**
 * Created by test on 3/15/17.
 */
public class Polynomial {

    double [] coefficents;
    int len;

    // variable number of arguments,
    // the incoming parameter is treated as an array
    // c[0] is the c0 in "cnx^n+cn-1x^(n-1)+...+c1x+c0".
    public Polynomial(double... c){
        coefficents = c;
        len = c.length;
    }

    private int getDegree(){
        return this.len - 1;
    }

    @Override
    public String toString(){

        String res = "" + coefficents[0];
        for(int i = 1; i < this.len; i++ ){
            if(coefficents[i] == 0){
                continue;
            }
            res = res + "+" + coefficents[i] + "X^" + i;
        }
        return res;
    }

    // evaluate the polynomial for the given x, by substituting the given x into the polynomial expression.
    public double evaluate(double x){
        double result = 0;

        for(int i = 0; i < this.len; i++){
            result = result + (this.coefficents[i] * Math.pow(x, i));
        }

        return result;
    }

}
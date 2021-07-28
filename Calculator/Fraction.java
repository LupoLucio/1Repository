
public class Fraction {

    private int num;
    private int den;

    public Fraction(int num, int den) {

        this.num = num;
        this.den = den;
        riduciFraz();
    }

    public Fraction(Fraction fr) {

        this.num = fr.num;
        this.den = fr.den;
        riduciFraz();
    }

    public void riduciFraz() {

        int MaxDiv = MCD(den, num);

        num = num / MaxDiv;
        den = den / MaxDiv;

    }

    public Fraction somma(Fraction fr) {

        int risNum = this.num * fr.den + fr.num * this.den;
        int risDen = this.den * fr.den;

        Fraction result = new Fraction(risNum, risDen);

        return result;
    }

    public Fraction differenza(Fraction fr) {

        int risNum = this.num * fr.den - fr.num * this.den;
        int risDen = this.den * fr.den;

        Fraction result = new Fraction(risNum, risDen);

        return result;
    }

    public Fraction prodotto(Fraction fr) {

        int risNum = this.num * fr.num;
        int risDen = this.den * fr.den;

        Fraction result = new Fraction(risNum, risDen);

        return result;

    }

    public Fraction quoziente(Fraction fr) {

        int risNum = this.num * fr.den;
        int risDen = this.den * fr.num;

        Fraction result = new Fraction(risNum, risDen);

        return result;

    }

    public boolean isZero() {

        return num == 0;
    }

    public String toString() {

        return "(" + this.num + "/" + this.den + ")";
    }

    public static int MCD(int a, int b) {

        if (a == 0 || b == 0) {
            return 1;
        }

        int r = a % b;
        if (r == 0) {
            return b;
        }
        return MCD(b, r);
    }

}
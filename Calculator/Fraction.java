public class Fraction{

    public int num;
    public int den;

    public Fraction(int num,int den){

        this.num = num;
        this.den = den;
    }

    public Fraction(Fraction fr){

        this.num = fr.num;
        this.den = fr.den;
    }

    public void riduciFraz(){

        int min = Math.min(num,den);

        for(int i=1;i <= min;i++){

            if(num%i == 0 && den%i == 0){
                num = num / i;
                den = den / i;
                i = 1;
            }

        }



    }

    public Fraction somma(Fraction fr){

        int risNum = this.num * fr.den+ fr.num * this.den;
        int risDen = this.den * fr.den;

        Fraction result = new Fraction(risNum,risDen);
        result.riduciFraz();

        return result;
    }

    public Fraction differenza(Fraction fr){

        int risNum = this.num * fr.den - fr.num * this.den;
        int risDen = this.den * fr.den;

        Fraction result = new Fraction(risNum,risDen);
        result.riduciFraz();

        return result;
    }

    public Fraction prodotto(Fraction fr){

        int risNum = this.num * fr.num;
        int risDen = this.den * fr.den;

        Fraction result = new Fraction(risNum,risDen);
        result.riduciFraz();

        return result;        


    }

    public Fraction quoziente(Fraction fr){

        int risNum = this.num * fr.den;
        int risDen = this.den * fr.num;

        Fraction result = new Fraction(risNum,risDen);
        result.riduciFraz();

        return result;        


    }

    public boolean checkZero(){
        if(num == 0) return true;

        return false;
    }



    public String toString(){

        return "("+this.num+","+this.den+")";
    }

    








}
import java.awt.Frame;

public class Tester {
    public static void main(String[] args){
    
    /*    Fraction fr1 = new Fraction(16,1);
    Fraction fr2 = new Fraction(18,9);

    Fraction fr3 = new Fraction(fr2.somma(fr1));
    String s = fr3.toString();
    System.out.println(s);
    */

    int[][] num = {
     {1,2,3} , {2,4,7} , {1,9,5}   };

    Matrice mat = new Matrice(num);

   
    Matrice mat2 = new Matrice(num);

    System.out.println(mat.prodotto(mat2));
    System.out.println(mat.laplace());
    Matrice mat3 = new Matrice(mat.Scala());
    System.out.println(mat3);
    System.out.println(mat3.rango());
  

    }
}

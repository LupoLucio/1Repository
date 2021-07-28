
public class Tester {
    public static void main(String[] args) {

        int[][] num = { { 1, 2, 3 }, { 2, 5, 5 }, { 6, 1, 4 } };

        Matrice mat = new Matrice(num);
        Matrice inv = mat.matInv();

        System.out.println("det = " + mat.laplace());
        System.out.println(inv.toString());

    }
}

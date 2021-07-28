import javax.swing.*;
import java.awt.*;
import java.applet.Applet;

public class Tester {
  public static void main(String[] args) {
    /*
     * int[][] num = { {1,2,3},{2,5,5},{6,1,4} };
     * 
     * Matrice mat = new Matrice(num); Matrice inv = mat.matInv();
     * 
     * System.out.println("det = "+mat.laplace());
     * System.out.println(inv.toString());
     */

    JFrame frame = new JFrame();
    JPanel showMatPanel = new JPanel();
    GridLayout gl = new GridLayout(5, 5, 10, 10);
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        JButton showMatButton = new JButton();
        System.out.println("e");
        showMatButton.setFocusable(true);
        showMatButton.setVisible(true);
        showMatPanel.add(showMatButton);
      }
    }

  }
}

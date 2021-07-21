import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Matrix extends Calculator {
    
  public JFrame inFrame;
  public JTextField textfield3;
  public JButton confirm2;
  public JLabel indicazioni;
  public JButton back2;

  public JFrame tempFrame;
  public JTextField textfieldRig;
  public JTextField textfieldCol;
  public JButton backTemp;
  public JButton confirm;
  public JLabel scrittaRig;
  public JLabel scrittaCol;

  public JFrame frame2;
	public JButton back,add;
	public JPanel panel2;

  public int index = 0;

  Matrice[] memory = new Matrice[3];
  Pair[] memoryPair = new Pair[3];

    Matrix(){
     // Calculator calc = new Calculator();

    frame2 = new JFrame("Matrix");

    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame2.setSize(420, 600);
    frame2.setLayout(null);

    back = new JButton("back");
    back.addActionListener(this);
    //back.setFont(myFont);;
    back.setFocusable(false);
    back.setBounds(0,0,100,100);
    /*panel2 = new JPanel();
    panel2.add(back);*/

    add = new JButton("add");
    add.addActionListener(this);
    add.setFocusable(true);
    add.setBounds(125, 0,100, 100);

    frame2.add(back);
    frame2.add(add);
    frame2.setVisible(false);



    textfieldRig = new JTextField();
    textfieldRig.setVisible(false);
    textfieldRig.setBounds(25, 100, 300, 50);
    textfieldRig.setFont(myFont);
    textfieldCol = new JTextField();
    textfieldCol.setVisible(false);
    textfieldCol.setBounds(25, 250, 300, 50);
    textfieldCol.setFont(myFont);
    String rig = "inserisci numero di righe";
    String col = "inserisci numero di colonne";
    scrittaRig = new JLabel(rig);
    scrittaRig.setBounds(25, 25, 300, 50);
    scrittaCol = new JLabel(col);
    scrittaCol.setBounds(25, 175, 300, 50);
    confirm = new JButton("vai");
    confirm.addActionListener(this);
    confirm.setFocusable(true);
    confirm.setBounds(50, 500, 100, 50);
    backTemp = new JButton("back");
    backTemp.addActionListener(this);
    backTemp.setFocusable(false);
    backTemp.setBounds(300,500,100,50);
    tempFrame = new JFrame("temp");
    tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tempFrame.setSize(420, 600);
		tempFrame.setLayout(null);
    tempFrame.setVisible(false);
    tempFrame.add(textfieldRig);
    tempFrame.add(textfieldCol);
    tempFrame.add(confirm);
    tempFrame.add(scrittaRig);
    tempFrame.add(scrittaCol);
    tempFrame.add(backTemp);


    back2 = new JButton("back");
    back2.addActionListener(this);
    back2.setFocusable(false);
    back2.setBounds(300,500,100,50);
    textfield3 = new JTextField();
    textfield3.setVisible(false);
    textfield3.setBounds(25, 100, 300, 50);
    textfield3.setFont(myFont);
    String s2 = "INDICAZIONI";
    indicazioni = new JLabel(s2);
    indicazioni.setBounds(25, 25, 300, 50);
    confirm2 = new JButton("GO");
    confirm2.addActionListener(this);
    confirm2.setFocusable(true);
    confirm2.setBounds(50, 500, 100, 50);
    inFrame = new JFrame("input");
    inFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inFrame.setSize(420, 600);
		inFrame.setLayout(null);
    inFrame.setVisible(false);
    inFrame.add(textfield3);
    inFrame.add(confirm2);
    inFrame.add(indicazioni);
    inFrame.add(back2);

 
    }

    public void actionPerformed(ActionEvent e){
 
      // eredito il metodo actionPerformed dalla super classe Calculator
        super.actionPerformed(e);
		
      if(e.getSource() == matButton){

        frame.setVisible(false);
        frame2.setVisible(true);
        
      }

		if(e.getSource() == back){
		//	System.out.println("ee");
			frame2.setVisible(false);
			frame.setVisible(true);
		}
    
    if(e.getSource() == add){
      
      //Matrice mat = new Matrice();
      tempFrame.setVisible(true);
      frame2.setVisible(false);
      textfieldRig.setVisible(true);
      textfieldCol.setVisible(true);
     
    }if(e.getSource() == backTemp){

      tempFrame.setVisible(false);
      frame2.setVisible(true);
    }


    if(e.getSource() == confirm){

      

      int righe = Integer.parseInt(textfieldRig.getText());
      int colonne = Integer.parseInt(textfieldCol.getText());

      memoryPair[index] = new Pair(righe,colonne);

     


      System.out.println(memoryPair[index].getRiga()+" "+memoryPair[index].getColonna());
      tempFrame.setVisible(false);
      inFrame.setVisible(true);
      textfield3.setVisible(true);
      
    }
    if(e.getSource() == back2){
      inFrame.setVisible(false);
      tempFrame.setVisible(true);

    }
    if(e.getSource() == confirm2){

      String numeri = textfield3.getText();

      inFrame.setVisible(false);
      tempFrame.setVisible(true);
      // memotrizzaee nella metrice il contenuto della
      // stringa del textfield3
      inizializzaMat(memory, numeri, memoryPair[index].getRiga(), memoryPair[index].getColonna(),index);
      System.out.println(memory[index].toString());

      index++;
      System.out.println("indice : "+index);
    }



    }
    public static void main(String[] args){

      
      Matrix mat = new Matrix();
    }

    private class Pair{

      int riga;
      int colonna;

      Pair(int riga,int colonna){
        this.riga = riga;
        this.colonna = colonna;
      }
      public int getRiga() {
        return riga;
      }
      public int getColonna(){
        return colonna;
      }
      public void setRiga(int riga){
        this.riga = riga;
      }
      public void setColonna(int colonna){
        this.colonna = colonna;
      }
    }
    private void inizializzaMat(Matrice[] mat,String s,int rig,int col,int index){

      int[][] num = new int[rig][col];

      int a = 0;
      int b = 0;

      while(s.length()>0){

      int i = s.indexOf(",");
      int number = 0;
      if(i == -1){
        number = Integer.parseInt(s);
        s = "";
      }else{
        number = Integer.parseInt(s.substring(0, i));
        s = s.substring(i+1);
      }
      
       
      if(b<col ){

        
        num[a][b] = number;
        b++;
        
      }else {
        b = 0;
        a++;
        num[a][b] = number;
        b++;
      }
      System.out.println(a+" "+b);
      
      System.out.println(s);
      }

      mat[index] = new Matrice(num);


    }


}


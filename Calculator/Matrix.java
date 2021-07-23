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

  public boolean isMat1On,isMat2On,isResOn;
  public JFrame frame2;
	public JButton back,add;
  public JButton mat1,mat2,matRes;
  public JButton rango,det;
  public JButton somma,diff,molt;
	public JTextField showRes;

  public JPanel showMatPanel;
  public JButton showMat;
  

  public int index = 0;

  Matrice[] memory = new Matrice[3];
  Pair[] memoryPair = new Pair[3];

    Matrix(){
     // Calculator calc = new Calculator();

    frame2 = new JFrame("Matrix");

    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame2.setSize(440, 620);
    frame2.setLayout(null);
    back = new JButton("back");
    back.addActionListener(this);
    back.setFont(new Font("Arial",Font.PLAIN,20));;
    back.setFocusable(false);
    back.setBounds(50,100,100,100);
    showMat = new JButton("show");
    showMat.addActionListener(this);
    showMat.setFont(new Font("Arial",Font.PLAIN,20));;
    showMat.setFocusable(false);
    showMat.setBounds(300,350,100,100);
    mat1 = new JButton("mat1");
    mat1.addActionListener(this);
    mat1.setFont(new Font("Arial",Font.PLAIN,20));
    mat1.setFocusable(false);
    mat1.setBounds(50, 225, 100, 100);
    mat2 = new JButton("mat2");
    mat2.addActionListener(this);
    mat2.setFont(new Font("Arial",Font.PLAIN,20));
    mat2.setFocusable(false);
    mat2.setBounds(175, 225, 100, 100);
    matRes = new JButton("Res");
    matRes.addActionListener(this);
    matRes.setFont(new Font("Arial",Font.PLAIN,20));
    matRes.setFocusable(false);
    matRes.setBounds(300, 225, 100, 100);
    rango = new JButton("rango");
    rango.addActionListener(this);
    rango.setFont(new Font("Arial",Font.PLAIN,20));
    rango.setFocusable(false);
    rango.setBounds(50, 350, 100, 100);
    det = new JButton("det");
    det.addActionListener(this);
    det.setFont(new Font("Arial",Font.PLAIN,20));
    det.setFocusable(false);
    det.setBounds(175, 350, 100, 100);
    add = new JButton("edit");   
    add.addActionListener(this);
    add.setFont(new Font("Arial",Font.PLAIN,20));
    add.setFocusable(true);
    add.setBounds(175, 100,100, 100);
    somma = new JButton("+");
    somma.addActionListener(this);
    somma.setFont(new Font("Arial",Font.PLAIN,20));
    somma.setFocusable(false);
    somma.setBounds(50, 475, 100, 100);
    diff = new JButton("-");
    diff.addActionListener(this);
    diff.setFont(new Font("Arial",Font.PLAIN,20));
    diff.setFocusable(false);
    diff.setBounds(175, 475, 100, 100);
    molt = new JButton("*");
    molt.addActionListener(this);
    molt.setFont(new Font("Arial",Font.PLAIN,20));
    molt.setFocusable(false);
    molt.setBounds(300, 475, 100, 100);

    showRes = new JTextField();
		showRes.setBounds(50,25,300,50);
		showRes.setFont(myFont);
		showRes.setEditable(false);
    frame2.add(showRes);
    frame2.add(back);
    frame2.add(add);
    frame2.setVisible(false);
    frame2.add(mat1);
    frame2.add(mat2);
    frame2.add(rango);
    frame2.add(det);
    frame2.add(showMat);
    frame2.add(matRes);
    frame2.add(somma);
    frame2.add(diff);
    frame2.add(molt);
    isMat1On = false;
    isMat2On = false;
    isResOn = false;



    textfieldRig = new JTextField();
    textfieldRig.setVisible(false);
    textfieldRig.setBounds(25, 100, 300, 50);
    textfieldRig.setFont(new Font("Arial",Font.PLAIN,20));
    textfieldCol = new JTextField();
    textfieldCol.setVisible(false);
    textfieldCol.setBounds(25, 250, 300, 50);
    textfieldCol.setFont(new Font("Arial",Font.PLAIN,20));
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
    textfield3.setFont(new Font("Arial",Font.PLAIN,20));
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
    
    if(e.getSource() == add && (isMat1On || isMat2On)){
      
      //Matrice mat = new Matrice();
      tempFrame.setVisible(true);
      frame2.setVisible(false);
      textfieldRig.setVisible(true);
      textfieldCol.setVisible(true);
     
    }
    if(e.getSource() == mat1){

      if(isMat1On) {
        isMat1On = false;
        mat1.setBackground(det.getBackground());;
      }else{
        isMat1On = true;
        isMat2On = false;
        isResOn = false;
        mat1.setBackground(Color.BLACK);
        mat2.setBackground(det.getBackground());
        matRes.setBackground(det.getBackground());
      }

    }

    if(e.getSource() == mat2){

      if(isMat2On) {
        isMat2On = false;
        mat2.setBackground(det.getBackground());
      }else{
        isMat2On = true;
        isMat1On = false;
        isResOn = false;
        mat2.setBackground(Color.BLACK);
        mat1.setBackground(det.getBackground());;
        matRes.setBackground(det.getBackground());
        
      }

    }

    if(e.getSource() == matRes){

      if(isResOn){
        isResOn = false;
        matRes.setBackground(det.getBackground());
      }else{
        isResOn = true;
        isMat1On = false;
        isMat2On = false;

        matRes.setBackground(Color.BLACK);
        mat1.setBackground(det.getBackground());
        mat2.setBackground(det.getBackground());

      }


    }

    if(e.getSource() == det && isMat1On){

      String result = memory[0].laplace()+"";
      showRes.setText(result);

    }

   if(e.getSource() == rango && isMat1On ){

      String result = memory[0].rango()+"";
      showRes.setText(result);

    }


    if(e.getSource() == det && isMat2On ){

      String result = memory[1].laplace()+"";
      showRes.setText(result);

    }

   if(e.getSource() == rango && isMat2On){

      String result = memory[1].rango()+"";
      showRes.setText(result);

    }
    if(e.getSource() == showMat && isMat1On ){

      JFrame showMatFrame = new JFrame();
     
      showMatFrame.setSize(400,400);
      showMatPanel = new JPanel(new GridLayout(memoryPair[0].getRiga(),memoryPair[0].getColonna(),10,10));

      for(int i=0;i<memoryPair[0].riga;i++){
        for(int j=0;j<memoryPair[0].colonna;j++){
          JButton showMatButton = new JButton(memory[0].getFraction(i, j)+"");
          showMatPanel.add(showMatButton);
        }
      }
     showMatFrame.add(showMatPanel);
     showMatFrame.setVisible(true);

    }

    if(e.getSource() == showMat && isMat2On ){

      JFrame showMatFrame = new JFrame();
     
      showMatFrame.setSize(400,400);
      showMatPanel = new JPanel(new GridLayout(memoryPair[1].getRiga(),memoryPair[1].getColonna(),10,10));

      for(int i=0;i<memoryPair[1].riga;i++){
        for(int j=0;j<memoryPair[1].colonna;j++){
          JButton showMatButton = new JButton(memory[1].getFraction(i, j)+"");
          showMatPanel.add(showMatButton);
        }
      }
     showMatFrame.add(showMatPanel);
     showMatFrame.setVisible(true);

    }

    if(e.getSource() == showMat && isResOn ){

      JFrame showMatFrame = new JFrame();
     
      showMatFrame.setSize(400,400);
      showMatPanel = new JPanel(new GridLayout(memoryPair[2].getRiga(),memoryPair[2].getColonna(),10,10));

      for(int i=0;i<memoryPair[2].riga;i++){
        for(int j=0;j<memoryPair[2].colonna;j++){
          JButton showMatButton = new JButton(memory[2].getFraction(i, j)+"");
          showMatPanel.add(showMatButton);
        }
      }
     showMatFrame.add(showMatPanel);
     showMatFrame.setVisible(true);

    }



    if(e.getSource() == somma){
      try{
      memory[2] = memory[0].somma(memory[1]);
      memoryPair[2] = new Pair(memory[2].getRows(),memory[2].getCols());
      }catch(IllegalArgumentException exc){
        showRes.setText("eccezzione");
      }
    }

    if(e.getSource() == diff){
      try{
      memory[2] = memory[0].differenza(memory[1]);
      memoryPair[2] = new Pair(memory[2].getRows(),memory[2].getCols());
      }catch(IllegalArgumentException exc){
        showRes.setText("eccezzione");
      }
    }

    if(e.getSource() == molt){
      try{
      memory[2] = memory[0].prodotto(memory[1]);
      memoryPair[2] = new Pair(memory[2].getRows(),memory[2].getCols());
      }catch(IllegalArgumentException exc){
        showRes.setText("eccezzione");
      }
    }

    
    if(e.getSource() == backTemp){

      tempFrame.setVisible(false);
      frame2.setVisible(true);
    }


    if(e.getSource() == confirm){

      

      int righe = Integer.parseInt(textfieldRig.getText());
      int colonne = Integer.parseInt(textfieldCol.getText());

      if(isMat1On){
      memoryPair[0] = new Pair(righe,colonne);
      }else if(isMat2On){
        memoryPair[1] = new Pair(righe,colonne);
      }
     


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
      if(isMat1On){
      inizializzaMat(memory, numeri, memoryPair[0].getRiga(), memoryPair[0].getColonna(),0);
      }else if(isMat2On){
        inizializzaMat(memory, numeri, memoryPair[1].getRiga(), memoryPair[1].getColonna(),1);
      }


      
   
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


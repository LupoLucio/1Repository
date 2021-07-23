public class Matrice {
    
    private int cols,rows;
    private Fraction[][] mat;

    public Matrice(int cols,int rows){

        if(cols < 1 || rows < 1) throw new IllegalArgumentException();

        this.cols = cols;
        this.rows = rows;
        
        mat = new Fraction[cols][rows];
        this.setTo0();

    }
    public Matrice(Fraction[][] matrice){

        this.cols = matrice.length;
        this.rows = matrice[0].length;
        
        mat = matrice;
       

    }
    public Matrice(int[][] matrice){

        this.cols = matrice.length;
        this.rows = matrice[0].length;
        
        Fraction[][] matFr = new Fraction[this.cols][this.rows];

        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                Fraction fr = new Fraction(matrice[i][j],1);
                matFr[i][j] = fr;
            }
        }
        this.mat = matFr;
    }
    public void setTo0(){
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                mat[i][j] = new Fraction(0,1);
            }
        }
    }
    public void setFraction(Fraction fr,int i,int j){

        this.mat[i][j] = new Fraction(fr);

    }
    public Fraction getFraction(int i,int j){
        return this.mat[i][j];
    }
    public Matrice somma(Matrice matrice) {

       /* if(matrice.cols != this.cols || matrice.rows!= this.rows){
            throw new IllegalAccessException("matrici con dimensioni diverse");
        }*/

        Matrice result = new Matrice(this.cols,this.rows);
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                sommaFraz(matrice, result, i, j);
            }
        }

        return result;

    }

    public Matrice differenza(Matrice matrice) throws IllegalArgumentException{


        /*if(matrice.cols != this.cols || matrice.rows!= this.rows){
            throw new IllegalAccessException("matrici con dimensioni diverse");
        }*/

        Matrice result = new Matrice(this.cols,this.rows);
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                sottraiFraz(matrice, result, i, j);
            }
        }

        return result;
    }

    private void sommaFraz(Matrice matrice, Matrice result, int i, int j) {
        result.setFraction(matrice.getFraction(i, j).somma(this.getFraction(i, j)),i,j);
    }
    private void sottraiFraz(Matrice matrice, Matrice result, int i, int j) {
        result.setFraction(matrice.getFraction(i, j).differenza(this.getFraction(i, j)),i,j);
    }


    public Matrice prodotto(Matrice matrice){

        if(this.rows != matrice.getCols()){
            throw new IllegalArgumentException();
        }
        Matrice result = new Matrice(this.cols,matrice.getRows());
        
        Fraction sum = new Fraction(0,1);
        for(int i = 0; i < cols; i++){
            for(int j = 0;j < cols; j++){
                for(int k = 0;k < rows;k++){
                    Fraction fr = this.getFraction(i, k).prodotto(matrice.getFraction(k, j));
                    sum = sum.somma(fr);
                   
                }
               result.setFraction(sum, i, j);
               sum = new Fraction(0,1);
            }
        }

        return result;
    }


    public Fraction laplace(){

        if(rows != cols){
            throw new IllegalArgumentException("matrice non quadrata");
        }

        if(rows == 1){
            return mat[0][0];
        }

        Fraction sum = new Fraction(0,1);
        for(int i=0;i<rows;i++){

            Fraction f = new Fraction((int) Math.pow(-1,i),1).prodotto(mat[0][i])
            .prodotto(rimozionePrimaRigaColonnaLaplace(i).laplace());

            sum = sum.somma(f);
            System.out.println(sum);
        }
        
        return sum;
    }

    private Matrice rimozionePrimaRigaColonnaLaplace(int index){

        Fraction[][] temp = new Fraction[cols-1][rows-1];
        for(int i=1;i<rows;i++){
            int c = 0;
            for(int j=0;j<rows;j++){
                if(j == index) continue;
                temp[i-1][c] = mat[i][j];
                c++;
            }
        }
        Matrice out = new Matrice(temp);
        return out;
    }

    public void swapRighe(int pos1,int pos2,Fraction[][] mat){

        Fraction[] vett = new Fraction[rows];

        for(int i=0;i<rows;i++){
            vett[i] = mat[pos2][i];
        }
        for(int i=0;i<rows;i++){
            mat[pos2][i] = mat[pos1][i];
            mat[pos1][i] = vett[i];
        }
 
    }
    public void swapColonne(int pos1,int pos2){

        Fraction[] vett = new Fraction[rows];

        for(int i=0;i<rows;i++){
            vett[i] = mat[i][pos2];
        }
        for(int i=0;i<rows;i++){
            mat[i][pos2] = mat[i][pos1];
            mat[i][pos1] = vett[i];
        }
 
    }
    public Fraction[][] Scala(){

        Fraction[][] out = new Fraction[cols][rows];
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                out[i][j] = mat[i][j];
            }
        }

        boolean done = false;

        for(int i = 0; i < rows - 1; i++){
            for(int k = i;k < cols -1; k++){
                if(out[i][i].isZero()){

                    for(int l = i + 1; l < cols;l++){

                        if(!out[l][i].isZero()){
                            swapRighe(l,i,out);
                            System.out.println("swap");
                            done = true;
                            break;
                        }

                    }
                    /*if(!done){
                        i++;
                    }*/
                }
                   
                if(!done){
                    sottrazRighe(k+1,i,i,out);
                    }

                /*if(!done && i >= 1){
                    sottrazRighe(k+1,i-1,i,out);
                    }*/

                    for(int l = 0;l < out.length; l++){
                        for(int o = 0; o<out.length; o++){
                            System.out.print(out[l][o].toString()+" ");
                        }
                        System.out.println(" ");
                    }


            }
        }

        return out;
    }
    private void sottrazRighe(int rig1,int rig2,int index,Fraction[][] matf){

        Fraction a1 = matf[rig1][index];
        Fraction a2 = matf[rig2][index];

        for(int i = index;i < mat[0].length;i++){

            Fraction coeff = a1.quoziente(a2);
            Fraction sott = matf[rig2][i].prodotto(coeff);
            matf[rig1][i] = matf[rig1][i].differenza(sott);

        }

    }
    public int rango(){

        int nul = 0;
        boolean nullità = true;
        Fraction[][] matrix = this.Scala();

  

        for(int i=0;i<matrix.length;i++){
            nullità = true;
            for(int j=0;j<matrix[0].length;j++){
                if(!matrix[i][j].isZero()){
                    nullità = false;
                }

            }
            if(nullità == true){
                nul++;
            }
        }

        return matrix.length-nul;
    }

    public int getRows(){
        return rows;
    }
    public int getCols(){
        return cols;
    }

    public String toString(){

        String s = "";

        for(int i = 0; i < cols; i++){
            for(int j = 0;j < rows;j++){
                s += mat[i][j].toString()+" ";
            }
            s += "\n";
        }

        return s;
    }




}

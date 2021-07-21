public class Matrice {
    
    public int height,width;
    public Fraction[][] mat;

    public Matrice(int height,int width){

        this.height = height;
        this.width = width;
        
        mat = new Fraction[height][width];

    }
    public Matrice(Fraction[][] matrice){
        this.height = matrice.length;
        this.width = matrice[0].length;
        
        mat = matrice;

    }
    public Matrice(int[][] matrice){
        this.height = matrice.length;
        this.width = matrice[0].length;
        
        Fraction[][] matFr = new Fraction[this.height][this.width];

        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                Fraction fr = new Fraction(matrice[i][j],1);
                matFr[i][j] = fr;
            }
        }
        this.mat = matFr;
    }
    public void setTo0(){
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                mat[i][j] = new Fraction(0,1);
            }
        }
    }
    public void setFraction(Fraction fr,int i,int j){

        this.mat[i][j] = new Fraction(fr);

    }
    public Fraction outFraction(int i,int j){
        return this.mat[i][j];
    }
    public Matrice somma(Matrice matrice) {

       /* if(matrice.height != this.height || matrice.width!= this.width){
            throw new IllegalAccessException("matrici con dimensioni diverse");
        }*/

        Matrice result = new Matrice(this.height,this.width);
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                sommaFraz(matrice, result, i, j);
            }
        }

        return result;

    }

    public Matrice differenza(Matrice matrice) throws IllegalAccessException{


        /*if(matrice.height != this.height || matrice.width!= this.width){
            throw new IllegalAccessException("matrici con dimensioni diverse");
        }*/

        Matrice result = new Matrice(this.height,this.width);
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                sottraiFraz(matrice, result, i, j);
            }
        }

        return result;
    }

    private void sommaFraz(Matrice matrice, Matrice result, int i, int j) {
        result.setFraction(matrice.outFraction(i, j).somma(this.outFraction(i, j)),i,j);
    }
    private void sottraiFraz(Matrice matrice, Matrice result, int i, int j) {
        result.setFraction(matrice.outFraction(i, j).differenza(this.outFraction(i, j)),i,j);
    }


    public Matrice prodotto(Matrice matrice){

        Matrice result = new Matrice(this.height,this.width);
        
        Fraction sum = new Fraction(0,1);
        for(int i = 0; i < height; i++){
            for(int j = 0;j < height; j++){
                for(int k = 0;k < width;k++){
                    Fraction fr = this.outFraction(i, k).prodotto(matrice.outFraction(k, j));
                    sum = sum.somma(fr);
                   
                }
               result.setFraction(sum, i, j);
               sum = new Fraction(0,1);
            }
        }

        return result;
    }


    public Fraction laplace(){

        if(width != height){
            throw new IllegalArgumentException("matrice non quadrata");
        }

        if(width == 1){
            return mat[0][0];
        }

        Fraction sum = new Fraction(0,1);
        for(int i=0;i<width;i++){

            Fraction f = new Fraction((int) Math.pow(-1,i),1).prodotto(mat[0][i])
            .prodotto(rimozionePrimaRigaColonnaLaplace(i).laplace());

            sum = sum.somma(f);
        }
        return sum;
    }

    private Matrice rimozionePrimaRigaColonnaLaplace(int index){

        Fraction[][] temp = new Fraction[height-1][width-1];
        for(int i=1;i<width;i++){
            int c = 0;
            for(int j=0;j<width;j++){
                if(j == index) continue;
                temp[i-1][c] = mat[i][j];
                c++;
            }
        }
        Matrice out = new Matrice(temp);
        return out;
    }

    public void swapRighe(int pos1,int pos2){

        Fraction[] vett = new Fraction[width];

        for(int i=0;i<width;i++){
            vett[i] = mat[pos2][i];
        }
        for(int i=0;i<width;i++){
            mat[pos2][i] = mat[pos1][i];
            mat[pos1][i] = vett[i];
        }
 
    }
    public void swapColonne(int pos1,int pos2){

        Fraction[] vett = new Fraction[width];

        for(int i=0;i<width;i++){
            vett[i] = mat[i][pos2];
        }
        for(int i=0;i<width;i++){
            mat[i][pos2] = mat[i][pos1];
            mat[i][pos1] = vett[i];
        }
 
    }
    public Fraction[][] Scala(){

        Fraction[][] out = new Fraction[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                out[i][j] = mat[i][j];
            }
        }

        boolean done = false;

        for(int i = 0; i < width - 1; i++){
            for(int k = i;k < height -1; k++){
                if(out[i][i].checkZero()){

                    for(int l = i + 1; l< height;l++){

                        if(!out[l][i].checkZero()){
                            swapRighe(l,k);
                            done = true;
                            break;
                        }

                    }
                    if(!done){
                        i++;
                    }
                }
                   
                if((k+1) != i){
                    sottrazRighe(k+1,i,i,out);
                    }

                if(!done && i >= 1){
                    sottrazRighe(k+1,i-1,i,out);
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
        boolean bol = true;
        Fraction[][] matrix = this.Scala();

        for(int i=0;i<matrix.length;i++){
            bol = true;
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j].checkZero()){
                    bol = false;
                }

            }
            if(bol == true){
                nul++;
            }
        }

        return matrix.length-nul;
    }

    public String toString(){

        String s = "";

        for(int i = 0; i < height; i++){
            for(int j = 0;j < width;j++){
                s += mat[i][j].toString()+" ";
            }
            s += "\n";
        }

        return s;
    }




}

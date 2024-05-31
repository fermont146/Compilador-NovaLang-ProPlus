 
package ASintactico;

 
public class Gramatica {
    char OPERADORES[]={'+','-','*','/'};
    int  LIMIT=0;
    int  LIMS=100;
    char CADA[]={'b','f','h','j','k','0','1','2','3','4','5','6','7','8','9'};
    String ASIG=":=";
    String OPERADOR[]={">=","<=",">","<","=","<>","{","}","[","]","(",")",",",";",".."};
    String PR[]={"if","else","for","print","int","bj","jk","jb"};

    public char[] getOPERADORES() {
        return OPERADORES;
    }

    public void setOPERADORES(char[] OPERADORES) {
        this.OPERADORES = OPERADORES;
    }

    public int getLIMI() {
        return LIMIT;
    }

    public void setLIMIT(int LIMIT) {
        this.LIMIT = LIMIT;
    }

    public int getLIMS() {
        return LIMS;
    }

    public void setLIMS(int LIMS) {
        this.LIMS = LIMS;
    }

    public char[] getCADA() {
        return CADA;
    }

    public void setCADA(char[] CADA) {
        this.CADA = CADA;
    }

    public String getASIG() {
        return ASIG;
    }

    public void setASIG(String ASIG) {
        this.ASIG = ASIG;
    }

    public String[] getOPERADOR() {
        return OPERADOR;
    }

    public void setOPERADOR(String[] OPERADOR) {
        this.OPERADOR = OPERADOR;
    }

    public String[] getPR() {
        return PR;
    }

    public void setPR(String[] PR) {
        this.PR = PR;
    }
}

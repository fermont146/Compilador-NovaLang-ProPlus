
package ALexico.Tablas;

 
public class Tablasimbolos {
    int id;
  String nombre;
  String tokens;

   public Tablasimbolos(int id, String nombre, String tokens) {
        this.id = id;
        this.nombre = nombre;
        this.tokens = tokens;
    } 

    Tablasimbolos(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTokens() {
        return tokens;
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
    }
      
    
        public static class ElementoTs  // elemento de la tabla de simbolos,
    {
        String lexema;               //aqui debemos poner todos los atributos que queremos usar en el compilador
        int longitudBytes;
        public ElementoTs(String l) // constructor que recibe lexema
        {
            this.lexema=l;
        }
        public void setLexema(String l)   // a partir de aqui ponemos todos los "getters" y los "setters"
        {
            this.lexema=l;
        }
        public String getLexema()
        {
            return this.lexema;
        }
 
    }
 
    public static final int p=23;  // el tamaño del arreglo de hash (un número primo)
 
    public static int h(String x)  // la funcion de hash
    {   int suma=0;
        for (int i=0; i<x.length(); i++)
            suma+=x.charAt(i);
        return suma%p;
    }
 
 
}

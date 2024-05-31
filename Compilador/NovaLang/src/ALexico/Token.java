 
package ALexico;

 
public class Token {
       public static String yytname[]=
    {
        "$end", 
        "error", 
        "$undefined", 
        "VOID - PALABRA RESERVADA",
        "MAIN - PALABRA RESERVADA", 
        "VARIABLE", 
        "ENTERO - PALABRA RESERVADA",
        "DECIMAL - PALABRA RESERVADA",
        "BOLEANO - PALABRA RESERVADA",
        "CADENA - PALABRA RESERVADA",
        "ENTERO - PALABRA RESERVADA", 
        "DECIMAL - PALABRA RESERVADA", 
        "BOLEANO - PALABRA RESERVADA",
        "CADENA - PALABRA RESERVADA", 
        "SUMA - OPERADOR", "RESTA - OPERADOR",
        "MULTIPLICACION - OPERADOR", 
        "DIVISION - OPERADOR", 
        "AUMENTAR - OPERADOR",
        "DISMINUIR - OPERADOR",
        "ASIGNADOR - OPERADOR", 
        "MAYOR - OPERADOR", 
        "MENOR - OPERADOR", 
        "IGUAL - OPERADOR",
        "PUNTO - OPERADOR",
        "MAYORIGUAL - OPERADOR",
        "MENORIGUAL - OPERADOR",
        "NOIGUAL - OPERADOR", 
        "SI - PALABRA RESERVADA", 
        "NO - PALABRA RESERVADA", 
        "SINO - PALABRA RESERVADA", 
        "PARA- PALABRA RESERVADA", 
        "MIENTRAS - PALABRA RESERVADA", 
        "PRINT - PALABRA RESERVADA",
        "SYSTEM - PALABRA RESERVADA",
        "OUT - PALABRA RESERVADA",
         
        "'(' - OPERADOR",
        "')' - OPERADOR", 
        "'{' - OPERADOR", 
        "'}' - OPERADOR", 
        "';' - PUNTUACION", 
        "',' - PUNTUACION", 
        "'['  - OPERADOR", 
        "']'  - OPERADOR"
    };
    
    
    public static int yytoknum[]=
    {
        0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
        265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
        275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
        285,   286,    40,    41,   123,   125,    59,    44,    91,    93
    };
}

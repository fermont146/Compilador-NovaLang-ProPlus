package ALexico;
import ALexico.Visuales.*;
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import JFlex.sym;
import javax.swing.DefaultListModel;

%%

%class lexico
%unicode
%cup
%line
%char
%column
%cupsym Symbol
%public
%full

%{
    
    StringBuffer string = new StringBuffer();
    
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

TerminacionLinea = \r|\n|\r\n
caracter = [^\r\n]
espacio = {TerminacionLinea}|[\t\f]

Bloque = "/*" [^*] ~"*/" | "/*" "*"+ "/"
ComentarioLinea  = "//" {caracter}*{TerminacionLinea}

Identificador = [:jletter:]|[:jletter:][:jletterdigit:]*
Entero = 0|[1-9][0-9]*
Decimal = Entero"."Entero
Cadenas = "\"" [^\"]* "\""

%%

<YYINITIAL> {espacio}          {/*no hace nada, aumenta una columna*/yychar++; }
<YYINITIAL> {TerminacionLinea} {yychar=0; yyline++;}

// Palabras clave de PL/SQL
<YYINITIAL>"BEGIN"             { return symbol(Simbolo.BEGIN, new String(yytext())); }
<YYINITIAL>"END"               { return symbol(Simbolo.END, new String(yytext())); }
<YYINITIAL>"DECLARE"           { return symbol(Simbolo.DECLARE, new String(yytext())); }
<YYINITIAL>"EXCEPTION"         { return symbol(Simbolo.EXCEPTION, new String(yytext())); }
<YYINITIAL>"IF"                { return symbol(Simbolo.IF, new String(yytext())); }
<YYINITIAL>"ELSE"              { return symbol(Simbolo.ELSE, new String(yytext())); }
<YYINITIAL>"ELSIF"             { return symbol(Simbolo.ELSIF, new String(yytext())); }
<YYINITIAL>"LOOP"              { return symbol(Simbolo.LOOP, new String(yytext())); }
<YYINITIAL>"WHILE"             { return symbol(Simbolo.WHILE, new String(yytext())); }
<YYINITIAL>"FOR"               { return symbol(Simbolo.FOR, new String(yytext())); }
<YYINITIAL>"INSERT"            { return symbol(Simbolo.INSERT, new String(yytext())); }
<YYINITIAL>"UPDATE"            { return symbol(Simbolo.UPDATE, new String(yytext())); }
<YYINITIAL>"DELETE"            { return symbol(Simbolo.DELETE, new String(yytext())); }
<YYINITIAL>"SELECT"            { return symbol(Simbolo.SELECT, new String(yytext())); }
<YYINITIAL>"FROM"              { return symbol(Simbolo.FROM, new String(yytext())); }
<YYINITIAL>"WHERE"             { return symbol(Simbolo.WHERE, new String(yytext())); }
<YYINITIAL>"INTO"              { return symbol(Simbolo.INTO, new String(yytext())); }
<YYINITIAL>"VALUES"            { return symbol(Simbolo.VALUES, new String(yytext())); }

// Palabras clave de T-SQL
<YYINITIAL>"SELECT"            { return symbol(Simbolo.TSQL_SELECT, new String(yytext())); }
<YYINITIAL>"FROM"              { return symbol(Simbolo.TSQL_FROM, new String(yytext())); }
<YYINITIAL>"WHERE"             { return symbol(Simbolo.TSQL_WHERE, new String(yytext())); }
<YYINITIAL>"INSERT"            { return symbol(Simbolo.TSQL_INSERT, new String(yytext())); }
<YYINITIAL>"UPDATE"            { return symbol(Simbolo.TSQL_UPDATE, new String(yytext())); }
<YYINITIAL>"DELETE"            { return symbol(Simbolo.TSQL_DELETE, new String(yytext())); }
<YYINITIAL>"CREATE"            { return symbol(Simbolo.TSQL_CREATE, new String(yytext())); }
<YYINITIAL>"DROP"              { return symbol(Simbolo.TSQL_DROP, new String(yytext())); }
<YYINITIAL>"ALTER"             { return symbol(Simbolo.TSQL_ALTER, new String(yytext())); }
<YYINITIAL>"JOIN"              { return symbol(Simbolo.TSQL_JOIN, new String(yytext())); }

// Palabras clave de Pascal
<YYINITIAL>"begin"             { return symbol(Simbolo.PASCAL_BEGIN, new String(yytext())); }
<YYINITIAL>"end"               { return symbol(Simbolo.PASCAL_END, new String(yytext())); }
<YYINITIAL>"var"               { return symbol(Simbolo.PASCAL_VAR, new String(yytext())); }
<YYINITIAL>"program"           { return symbol(Simbolo.PASCAL_PROGRAM, new String(yytext())); }
<YYINITIAL>"const"             { return symbol(Simbolo.PASCAL_CONST, new String(yytext())); }
<YYINITIAL>"if"                { return symbol(Simbolo.PASCAL_IF, new String(yytext())); }
<YYINITIAL>"else"              { return symbol(Simbolo.PASCAL_ELSE, new String(yytext())); }
<YYINITIAL>"for"               { return symbol(Simbolo.PASCAL_FOR, new String(yytext())); }
<YYINITIAL>"while"             { return symbol(Simbolo.PASCAL_WHILE, new String(yytext())); }
<YYINITIAL>"do"                { return symbol(Simbolo.PASCAL_DO, new String(yytext())); }
<YYINITIAL>"repeat"            { return symbol(Simbolo.PASCAL_REPEAT, new String(yytext())); }
<YYINITIAL>"until"             { return symbol(Simbolo.PASCAL_UNTIL, new String(yytext())); }

// Palabras clave de JavaScript
<YYINITIAL>"var"               { return symbol(Simbolo.JS_VAR, new String(yytext())); }
<YYINITIAL>"let"               { return symbol(Simbolo.JS_LET, new String(yytext())); }
<YYINITIAL>"const"             { return symbol(Simbolo.JS_CONST, new String(yytext())); }
<YYINITIAL>"function"          { return symbol(Simbolo.JS_FUNCTION, new String(yytext())); }
<YYINITIAL>"if"                { return symbol(Simbolo.JS_IF, new String(yytext())); }
<YYINITIAL>"else"              { return symbol(Simbolo.JS_ELSE, new String(yytext())); }
<YYINITIAL>"for"               { return symbol(Simbolo.JS_FOR, new String(yytext())); }
<YYINITIAL>"while"             { return symbol(Simbolo.JS_WHILE, new String(yytext())); }
<YYINITIAL>"do"                { return symbol(Simbolo.JS_DO, new String(yytext())); }
<YYINITIAL>"switch"            { return symbol(Simbolo.JS_SWITCH, new String(yytext())); }
<YYINITIAL>"case"              { return symbol(Simbolo.JS_CASE, new String(yytext())); }
<YYINITIAL>"default"           { return symbol(Simbolo.JS_DEFAULT, new String(yytext())); }
<YYINITIAL>"break"             { return symbol(Simbolo.JS_BREAK, new String(yytext())); }
<YYINITIAL>"continue"          { return symbol(Simbolo.JS_CONTINUE, new String(yytext())); }
<YYINITIAL>"return"            { return symbol(Simbolo.JS_RETURN, new String(yytext())); }
<YYINITIAL>"class"             { return symbol(Simbolo.JS_CLASS, new String(yytext())); }
<YYINITIAL>"extends"           { return symbol(Simbolo.JS_EXTENDS, new String(yytext())); }
<YYINITIAL>"import"            { return symbol(Simbolo.JS_IMPORT, new String(yytext())); }
<YYINITIAL>"export"            { return symbol(Simbolo.JS_EXPORT, new String(yytext())); }

// Palabras clave de HTML
<YYINITIAL>"<html>"            { return symbol(Simbolo.HTML_HTML_OPEN, new String(yytext())); }
<YYINITIAL>"</html>"           { return symbol(Simbolo.HTML_HTML_CLOSE, new String(yytext())); }
<YYINITIAL>"<head>"            { return symbol(Simbolo.HTML_HEAD_OPEN, new String(yytext())); }
<YYINITIAL>"</head>"           { return symbol(Simbolo.HTML_HEAD_CLOSE, new String(yytext())); }
<YYINITIAL>"<body>"            { return symbol(Simbolo.HTML_BODY_OPEN, new String(yytext())); }
<YYINITIAL>"</body>"           { return symbol(Simbolo.HTML_BODY_CLOSE, new String(yytext())); }
<YYINITIAL>"<title>"           { return symbol(Simbolo.HTML_TITLE_OPEN, new String(yytext())); }
<YYINITIAL>"</title>"          { return symbol(Simbolo.HTML_TITLE_CLOSE, new String(yytext())); }
<YYINITIAL>"<div>"             { return symbol(Simbolo.HTML_DIV_OPEN, new String(yytext())); }
<YYINITIAL>"</div>"            { return symbol(Simbolo.HTML_DIV_CLOSE, new String(yytext())); }
<YYINITIAL>"<p>"               { return symbol(Simbolo.HTML_P_OPEN, new String(yytext())); }
<YYINITIAL>"</p>"              { return symbol(Simbolo.HTML_P_CLOSE, new String(yytext())); }

// Palabras clave de Python
<YYINITIAL>"def"               { return symbol(Simbolo.PYTHON_DEF, new String(yytext())); }
<YYINITIAL>"class"             { return symbol(Simbolo.PYTHON_CLASS, new String(yytext())); }
<YYINITIAL>"if"                { return symbol(Simbolo.PYTHON_IF, new String(yytext())); }
<YYINITIAL>"else"              { return symbol(Simbolo.PYTHON_ELSE, new String(yytext())); }
<YYINITIAL>"elif"              { return symbol(Simbolo.PYTHON_ELIF, new String(yytext())); }
<YYINITIAL>"for"               { return symbol(Simbolo.PYTHON_FOR, new String(yytext())); }
<YYINITIAL>"while"             { return symbol(Simbolo.PYTHON_WHILE, new String(yytext())); }
<YYINITIAL>"import"            { return symbol(Simbolo.PYTHON_IMPORT, new String(yytext())); }
<YYINITIAL>"from"              { return symbol(Simbolo.PYTHON_FROM, new String(yytext())); }
<YYINITIAL>"return"            { return symbol(Simbolo.PYTHON_RETURN, new String(yytext())); }
<YYINITIAL>"break"             { return symbol(Simbolo.PYTHON_BREAK, new String(yytext())); }
<YYINITIAL>"continue"          { return symbol(Simbolo.PYTHON_CONTINUE, new String(yytext())); }
<YYINITIAL>"pass"              { return symbol(Simbolo.PYTHON_PASS, new String(yytext())); }

// Palabras clave de C++
<YYINITIAL>"#include"          { return symbol(Simbolo.CPP_INCLUDE, new String(yytext())); }
<YYINITIAL>"int"               { return symbol(Simbolo.CPP_INT, new String(yytext())); }
<YYINITIAL>"main"              { return symbol(Simbolo.CPP_MAIN, new String(yytext())); }
<YYINITIAL>"std::cout"         { return symbol(Simbolo.CPP_STD_COUT, new String(yytext())); }
<YYINITIAL>"std::endl"         { return symbol(Simbolo.CPP_STD_ENDL, new String(yytext())); }
<YYINITIAL>"using namespace std" { return symbol(Simbolo.CPP_USING_NAMESPACE_STD, new String(yytext())); }

// Operadores y símbolos comunes
<YYINITIAL>"+"                 { return symbol(Simbolo.MAS, new String(yytext())); }
<YYINITIAL>"-"                 { return symbol(Simbolo.MENOS, new String(yytext())); }
<YYINITIAL>"*"                 { return symbol(Simbolo.POR, new String(yytext())); }
<YYINITIAL>"/"                 { return symbol(Simbolo.DIAGONAL, new String(yytext())); }
<YYINITIAL>"%"                 { return symbol(Simbolo.MODULO, new String(yytext())); }

<YYINITIAL>"=="                { return symbol(Simbolo.IGUALACION, new String(yytext())); }
<YYINITIAL>"!="                { return symbol(Simbolo.DIFERENTE, new String(yytext())); }
<YYINITIAL>"<"                 { return symbol(Simbolo.MENORQ, new String(yytext())); }
<YYINITIAL>"<="                { return symbol(Simbolo.MENORIQ, new String(yytext())); }
<YYINITIAL>">"                 { return symbol(Simbolo.MAYORQ, new String(yytext())); }
<YYINITIAL>">="                { return symbol(Simbolo.MAYORIQ, new String(yytext())); }

<YYINITIAL>"&&"                { return symbol(Simbolo.AND, new String(yytext())); }
<YYINITIAL>"||"                { return symbol(Simbolo.OR, new String(yytext())); }
<YYINITIAL>"!"                 { return symbol(Simbolo.NOT, new String(yytext())); }
<YYINITIAL>"="                 { return symbol(Simbolo.IGUAL, new String(yytext())); }
<YYINITIAL>"{"                 { return symbol(Simbolo.LLAVEA, new String(yytext())); }
<YYINITIAL>"}"                 { return symbol(Simbolo.LLAVEC, new String(yytext())); }
<YYINITIAL>"("                 { return symbol(Simbolo.PARA, new String(yytext())); }
<YYINITIAL>")"                 { return symbol(Simbolo.PARC, new String(yytext())); }
<YYINITIAL>"["                 { return symbol(Simbolo.CORA, new String(yytext())); }
<YYINITIAL>"]"                 { return symbol(Simbolo.CORC, new String(yytext())); }
<YYINITIAL>";"                 { return symbol(Simbolo.PCOMA, new String(yytext())); }
<YYINITIAL>","                 { return symbol(Simbolo.COMA, new String(yytext())); }
<YYINITIAL>"."                 { return symbol(Simbolo.PUNTO, new String(yytext())); }

<YYINITIAL>{ComentarioLinea}   { return symbol(Simbolo.COMENTARIOL, new String(yytext())); }
<YYINITIAL>{Bloque}            { return symbol(Simbolo.COMENTARIOB, new String(yytext())); }
<YYINITIAL>{Identificador}     { return symbol(Simbolo.IDENTIFICADOR, new String(yytext())); }
<YYINITIAL>{Entero}            { return symbol(Simbolo.ENTERO, new String(yytext())); }
<YYINITIAL>{Decimal}           { return symbol(Simbolo.DECIMAL, new String(yytext())); }
<YYINITIAL>{Cadenas}           { return symbol(Simbolo.CADENAS, new String(yytext())); }

. { 
    System.out.println("error lexico en la fila "+yyline +" y en la columna " + yychar);
    DefaultListModel filas = new DefaultListModel();
    DefaultListModel columnas = new DefaultListModel();
    DefaultListModel carac = new DefaultListModel();
    filas.addElement(yyline);
    ErrorLinea.jList2.setModel(filas);
    columnas.addElement(yychar);
    ErrorLinea.jList3.setModel(columnas);
    carac.addElement(yytext());
    ErrorLinea.jList1.setModel(carac);
}

[\r] { return symbol(Simbolo.ESPACIO, new String(yytext())); }
[\n] { return symbol(Simbolo.LINEA, new String(yytext())); }
[ \t\r\f\n]+ { /* Son ignorados */ }

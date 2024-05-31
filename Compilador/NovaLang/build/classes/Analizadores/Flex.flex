package Analizadores;
import java.io.*;
import static Analizadores.tok.*;
%%
%class lexer
%type tok
%line
%column
D=[0-0]
L=[a-zA-z_]
CA="\""[^*]-"" | "" + "\""
WHITE=[ \t\r\n]
%{
public String lexeme;
Codigo c = new Codigo();
%}
%%
{WHITE} {/*Ignore*/}
<YYINITIAL> "+"  {c.linea=yyline; lexeme=yytext(); return MAS;}
<YYINITIAL> "==" {c.linea=yyline; lexeme=yytext(); return IGUAL;}
<YYINITIAL> "-"  {c.linea=yyline; lexeme=yytext(); return MENOS;}
<YYINITIAL> "!=" {c.linea=yyline; lexeme=yytext(); return DISTINTO;}
<YYINITIAL> "||" {c.linea=yyline; lexeme=yytext(); return OR;}
<YYINITIAL> "&&" {c.linea=yyline; lexeme=yytext(); return AND;}
<YYINITIAL> "{"  {c.linea=yyline; lexeme=yytext(); return DELIMITADOR;}
<YYINITIAL> "}"  {c.linea=yyline; lexeme=yytext(); return DELIMITADOR;}
<YYINITIAL> "("  {c.linea=yyline; lexeme=yytext(); return DELIMITADOR;}
<YYINITIAL> ")"  {c.linea=yyline; lexeme=yytext(); return DELIMITADOR;}
<YYINITIAL> "["  {c.linea=yyline; lexeme=yytext(); return DELIMITADOR;}
<YYINITIAL> "]"  {c.linea=yyline; lexeme=yytext(); return DELIMITADOR;}
<YYINITIAL> "="  {c.linea=yyline; lexeme=yytext(); return ASIGNACION;}
<YYINITIAL> "/"  {c.linea=yyline; lexeme=yytext(); return ENTRE;}
<YYINITIAL> "%"  {c.linea=yyline; lexeme=yytext(); return MODULO;}
<YYINITIAL> "<"  {c.linea=yyline; lexeme=yytext(); return MENOR;}
<YYINITIAL> ">"  {c.linea=yyline; lexeme=yytext(); return MAYOR;}
<YYINITIAL> ";"  {c.linea=yyline; lexeme=yytext(); return PUNTOYCOMA;}
<YYINITIAL> "Main"  {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "if"    {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "while" {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "else"  {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "put"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "int"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "break"  {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "puts"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "Console"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "Writeline"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "Readline"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "Readkey"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "println"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "system"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "out"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "Class"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "Main"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "Public"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "double"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "String"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "switch"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "do while"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}
<YYINITIAL> "repeat"   {c.linea=yyline; lexeme=yytext(); return RESERVADA;}



<YYINITIAL> {D}+     {c.linea=yyline; lexeme=yytext(); return CANTIDAD;}
<YYINITIAL> {L}({L}|{D})* {c.linea=yyline; lexeme=yytext(); return ID;}
<YYINITIAL> {CA}          {c.linea=yyline; lexeme=yytext(); return CADENA;}
<YYINITIAL> "*"           {c.linea=yyline; lexeme=yytext(); return POR;}
. {c.linea=yyline;lexeme=yytext(); return ERROR;}














 
package ASintactico;

import java.util.ArrayList;

 
public class Analisis { 
        Gramatica gra=new Gramatica();
        String resul="";
        String error="";
        int cont=0;
      public String verificacion(ArrayList<String> TK){
         cont=0;
      
        while(cont<TK.size()){
                 
                try{
                    int cons =Integer.parseInt(TK.get(cont));
                    if(cons>=gra.LIMIT&&cons<=gra.LIMS){
                          resul+="\n"+(cont+1)+" CONSTANTE NUMERICA "+TK.get(cont);  
                    }else{
                        error+="\n"+(cont+1)+" ERROR EN CONSTANTE "+TK.get(cont)+" VALOR EXCEDE LOS LIMITES";    
                    }
                } catch(NumberFormatException n){
                         if(VerOPERADORES(TK.get(cont).charAt(0))){
           resul+="\n"+(cont+1)+" OPERADOR ARITMETICO "+TK.get(cont);    
            }else  if(gra.getASIG().equals(TK.get(cont))){
                resul+="\n"+(cont+1)+" OPERADOR DE ASIGNACION "+TK.get(cont);   
            }else if(VerOPERADOR(TK.get(cont))){
                resul+="\n"+(cont+1)+" OPERADOR RELACIONAL "+TK.get(cont); 
            }
            else if(VerPR(TK.get(cont))){
                 resul+="\n"+(cont+1)+" PALABRA RESERVADA "+TK.get(cont); 
            }else if(VerCADA(TK.get(cont))){
               resul+="\n"+(cont+1)+" IDENTIFICADOR "+TK.get(cont);
           }   
                }
            cont++;
            }
          return resul;          
        }
      
      public void verificarSintaxis(ArrayList<String> TK){
          
      }
        
      
      public boolean VerCADA(String Iden){
          if(Iden.length()<=15){
               if(!opcionesCaracID(Iden.charAt(0),1)){
          error+="\n"+(cont+1)+" ERROR EN EL IDENTIFICADOR "+Iden+" SOLO PUEDE INICIAR EN bfjhk";
                    }
                  for(int j=1;j<Iden.length();j++){
          if(!opcionesCaracID(Iden.charAt(j),2)){
               error+="\n"+(cont+1)+" ERROR EN EL IDENTIFICADOR "+Iden+" CONTIENE CARACTERES NO ACEPTADOS";
                  return false;
          }
          } 
                  return true;
          
          }
         error+="\n"+(cont+1)+" ERROR EN EL IDENTIFICADOR "+Iden+" EXCEDIO EL LIMITE DE CARACTERES PERMITIDOS ";
          return false;
      }
      
      public boolean VerPR(String var){
           String rsv[]=gra.getPR();
          if(rsv[0].equals(var)||rsv[1].equals(var)||rsv[2].equals(var)||rsv[3].equals(var)||
                  rsv[4].equals(var)||rsv[5].equals(var)||rsv[6].equals(var)||rsv[7].equals(var)){
             return  true; 
          }
          return false;
      }
      
      public boolean opcionesCaracID(char l,int init){
          char caracteresID[]=gra.getCADA();
          if(init==1){
             if(caracteresID[0]==l||caracteresID[1]==l||caracteresID[2]==l||
                  caracteresID[3]==l||caracteresID[4]==l){
              return true;
          }  
          }else
          
          if(caracteresID[0]==l||caracteresID[1]==l||caracteresID[2]==l||
                  caracteresID[3]==l||caracteresID[6]==l||caracteresID[7]==l||
                  caracteresID[4]==l||caracteresID[5]==l||caracteresID[8]==l||
                  caracteresID[9]==l||caracteresID[10]==l||caracteresID[11]==l||
                  caracteresID[12]==l||caracteresID[13]==l||caracteresID[14]==l){
              return true;
          }
          
         return false;
      }
      
  
      public boolean VerOPERADORES(char var){
          char opa[]=gra.getOPERADORES();
          if(opa[0]==var||opa[1]==var||opa[2]==var||opa[3]==var){
             return  true; 
          }
          return false;
      }
      
        
      public boolean VerOPERADOR(String var){
          String opr[]=gra.getOPERADOR();
          if(opr[0].equals(var)||opr[1].equals(var)||opr[2].equals(var)||opr[3].equals(var)||
                  opr[4].equals(var)||opr[5].equals(var)||opr[6].equals(var)||opr[7].equals(var)||
                  opr[8].equals(var)||opr[9].equals(var)||opr[10].equals(var)||opr[11].equals(var)||
                  opr[12].equals(var)||opr[13].equals(var)||opr[14].equals(var)){
             return  true; 
          }
          return false;
      }
}

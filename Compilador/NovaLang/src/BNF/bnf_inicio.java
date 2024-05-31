 
package BNF;

import java.util.ArrayList;

 
public class bnf_inicio { 
    String ES = "";
    int contaLin=1;
    
    public boolean varasign(String lineaCodigo){
        
     boolean valor= false;
          ArrayList <String> lis= new ArrayList<>();
        for(int i=0; i<lineaCodigo.length();i++){
            if(lineaCodigo.charAt(i)!=' '){
                String aux="";
                aux+= lineaCodigo.charAt(i);
                   i++;
                   
                while((i+1)<lineaCodigo.length()&&lineaCodigo.charAt(i)!=' '){
                    
                   aux+= lineaCodigo.charAt(i);
                   i++;
                     if(i+1==lineaCodigo.length()){
                    aux+=lineaCodigo.charAt(i);
                }
                }
                lis.add(aux);
          
            }
        } 
        if(lis.size()==3){
            if(lis.get(1).charAt(0)=='j'||lis.get(1).charAt(0)=='d'||lis.get(1).charAt(0)=='d'||lis.get(1).charAt(0)=='s'||lis.get(1).charAt(0)=='s'){
           if(lis.get(0).equals("int")&&!lis.get(1).equals("")&&lis.get(2).equals(";")){
           valor= true;
           }
        }  else{
            valor = false ;
        }
        }else if(lis.size()==5){
            if(lis.get(0).equals("int")&&lis.get(2).equals(":=")&&lis.get(4).equals(";")){
           valor= true ;
        }
        }else{
            valor= false ;
        }
        return valor ; 
    } 
    
    public boolean asign(String lineaCodigo){
         
        boolean valor= false;
          ArrayList <String> lis= new ArrayList<>();
        for(int i=0; i<lineaCodigo.length();i++){
            if(lineaCodigo.charAt(i)!=' '){
                String aux="";
                aux+= lineaCodigo.charAt(i);
                   i++;
                   
                while((i+1)<lineaCodigo.length()&&lineaCodigo.charAt(i)!=' '){
                    
                   aux+= lineaCodigo.charAt(i);
                   i++;
                     if(i+1==lineaCodigo.length()){
                    aux+=lineaCodigo.charAt(i);
                }
                }
                lis.add(aux);
          
            }
        }
      
        
        if(lis.size()==4){
            if(lis.get(0).charAt(0)=='j'||lis.get(0).charAt(0)=='d'||lis.get(0).charAt(0)=='d'||lis.get(0).charAt(0)=='s'||lis.get(0).charAt(0)=='s'){
           if(lis.get(1).equals(":=")&&!lis.get(2).equals("")&&lis.get(3).equals(";")){ 
           valor = true;
           }
        }  else{ 
            valor=false;
        }
        }else{
            valor=false;
        }
            
        return valor;
    }
    
    
    
    
    public void verificador(String lineas[]){
        int cont = 0; 
       
        do{
             
         if(varasign(lineas[cont])){
             
         }  
         else if( asign(lineas[cont])){
             
             
         }else{
             ES+="Linea "+contaLin+" incorrecta\n";  
         }
          cont++;
           contaLin++;
           }while(lineas.length>cont); 
    } 
}

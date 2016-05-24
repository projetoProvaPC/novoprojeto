/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ads;

/**
 *
 * @author Thais
 */
public class Thais {
    public void chegarFesta(){
        
    }
    public void tomarDrink(){
        
    }
    public void chamarAtencao(){
        
    }
   
    int notaDoBoy =0;

    public boolean visualizarBoy(){
        if(notaDoBoy==10){
            return true;
        }else{
            return false;
        }
    }
    public void agir(){
        if(visualizarBoy()){
            chamarAtencao();
        }else{
            tomarDrink();
        }
        
    }
    

public class Boy{
    public void prestarAtencao(){
        
    }
    public void dancarMuito(){
        
    }
    public void jogarPapo(){
        
    }
    int aceitou=1;
    public boolean chamarPraDancar(){
        if(aceitou==1){
            return true;
      }else{
            return false;
    }
    }
    public void atitude(){
        if(chamarPraDancar()){
            dancarMuito();
        }else{
            jogarPapo();
        }
    }
    public void darUnsPega(){
        
    }

}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Thais thais = new Thais();
        thais.chegarFesta();
        thais.visualizarBoy();
        thais.notaDoBoy=10;
        thais.agir();
        
        Boy boy = new Boy();
    }
    
}

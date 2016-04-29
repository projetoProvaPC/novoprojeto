/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Thais
 */
public class Main {
    public static void main(String[] args) {
 
    Prova p = new Prova();
    RepositorioProva rep= new RepositorioProva();
    Prova p2 = new Prova();
    
    rep.adicionar(p);
    rep.adicionar(p2);
    
    
}
}

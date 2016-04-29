/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioProva {
    
    public void adicionar(Prova p){
        DaoManagerHiber.getInstance().persist(p);
    }
    public void remover(Prova p){
        DaoManagerHiber.getInstance().delete(p);
    }
    public void alterar(Prova p){
        DaoManagerHiber.getInstance().update(p);
    }
    public Prova recuperar(int id){
        return (Prova) DaoManagerHiber.getInstance().recover("from Prova where id=" +id).get(0);
    }
    public List recuperarTodos(){
        return DaoManagerHiber.getInstance().recover("from Prova");
    }
}

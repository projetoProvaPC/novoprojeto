/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.interfaces;

import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 * @param <Tipo>
 */
public class RepositorioIT<Tipo extends Persistivel> {
    
    public Repositorio<Tipo> repositorio;
    public Tipo t1 = null;
    
    /**
     * Exige uma nova prova.
     */
    public void testAAdicionar() {
        repositorio.adicionar(t1);
    }
    
    /**
     * Recuperar Todos depois de Adicionar
     */
    public void testBPosAdicionarRecuperarTodos() {
        assertNotNull(t1);
        List<Tipo> recuperar = repositorio.recuperar();
        for(Tipo t2 : recuperar){
            if(t1.equals(t2)){
                assertEquals(t2, t1);
                t1 = t2;  // será usado no próximo método
                return;
            }
        }
        fail("Not found");
    }
    
    /**
     * Verifica se existe pelo id recuperado no testBPosAdicionarRecuperarTodos
     */
    public void testCPosAdicionarExisteId() {
        assertNotNull(t1);
        long id = t1.getId();
        assertTrue(repositorio.existe(id));
    }
    
    /**
     * Verifica se existe o objeto recuperado no testBPosAdicionarRecuperarTodos
     */
    public void testDPosAdicionarExisteObject() {
        assertNotNull(t1);
        assertTrue(repositorio.existe(t1));
    }
    
    /**
     * Tenta recuperar por id o objeto adicionado
     */
    public void testEPosAdicionarRecuperarId() {
        assertNotNull(t1);
        long id = t1.getId();
        Tipo t2 = repositorio.recuperar(id);
        assertNotNull(t2);
        assertEquals(t2, t1);
        assertEquals(t2.getId(), t1.getId());
    }
    
    /**
     * Exige alteração
     */
    public void testFAlterar() {
        repositorio.alterar(t1);
    }
    
    /**
     * Tenta recuperar o que foi alterado pelo id
     */
    public void testGPosAlterarRecuperarId() {
        assertNotNull(t1);
        long id = t1.getId();
        Tipo t2 = repositorio.recuperar(id);
        assertNotNull(t2);
        assertEquals(t2, t1);
        assertEquals(t2.getId(), t1.getId());
    }
    
    /**
     * Agora remove
     */
    public void testHRemoverId() {
        assertNotNull(t1);
        long id = t1.getId();
        repositorio.remover(id);
    }
    
    /**
     * Não pode encontrar por id
     */
    public void testIPosRemoverIdExisteId() {
        assertNotNull(t1);
        long id = t1.getId();
        assertNull(repositorio.recuperar(id));
    }
    
    /**
     * Adiciono outro
     * Exige outra prova
     */
    public void testJAdicionar2() {
        repositorio.adicionar(t1);
    }
    
    /**
     * Recuperar Todos depois de Adicionar de novo
     */
    public void testKPosAdicionar2RecuperarTodos() {
        assertNotNull(t1);
        List<Tipo> recuperar = repositorio.recuperar();
        for(Tipo t2 : recuperar){
            if(t2.equals(t1)){
                assertEquals(t2, t1);
                t1 = t2;  // será usado no próximo método
                return;
            }
        }
        t1=null;
        fail("Not found");
    }
    
    public void testLRemoverObject() {
        assertNotNull(t1);
        repositorio.remover(t1);
    }
    
    public void testMPosRemoverExisteObject() {
        assertNotNull(t1);
        assertFalse(repositorio.existe(t1));
    }
    
}

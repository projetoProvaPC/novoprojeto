/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class RepositorioProvaBDITest {
    
    private RepositorioProvaBD repositorio = new RepositorioProvaBD();
    private Prova p1 = new Prova("Primeira prova");
    private Prova p2 = null;
    private Prova p3 = null;
    private Prova p4 = new Prova("Segunda prova");
    private Prova p5 = null;
    
    @Test
    public void testAAdicionar() {
        repositorio.adicionar(p1);
    }
    
    /**
     * Fails if the object add at testA is not found at the result.
     */
    @Test
    public void testBPosAdicionarRecuperarTodos() {
        List<Prova> recuperar = repositorio.recuperar();
        boolean found = false;
        for(Prova p : recuperar){
            if(p.getTitulo().equals(p1.getTitulo())){
                found = true;
                assertEquals(p.getTitulo(), p1.getTitulo());
                p1 = p;  // será usado no próximo método
            }
        }
        if(!found) {
            fail("Not found");
        }
    }
    
    @Test
    public void testCPosAdicionarExisteId() {
        long id = p1.getId();
        assertTrue(repositorio.existe(id));
    }
    
    @Test
    public void testCPosAdicionarExisteObject() {
        assertTrue(repositorio.existe(p1));
    }
    
    @Test
    public void testCPosAdicionarRecuperarId() {
        long id = p1.getId();
        p2 = repositorio.recuperar(id);
        assertNotNull(p2);
        assertEquals(p2.getTitulo(), p1.getTitulo());
    }
    
    @Test
    public void testDAlterar() {
        p2.setTitulo("Primeira Prova Atualizado");
        repositorio.alterar(p2);
    }
    
    @Test
    public void testEPosAlterarRecuperarTodos() {
        List<Prova> recuperar = repositorio.recuperar();
        boolean found = false;
        for(Prova p : recuperar){
            if(p.getTitulo().equals(p2.getTitulo())){
                found = true;
                assertEquals(p.getTitulo(), p2.getTitulo());
                assertEquals(p.getId(), p2.getId());
                p3 = p;  // será usado no próximo método
            }
        }
        if(!found) {
            fail("Not found");
        }
    }
    
    @Test
    public void testFPosAlterarRecuperarId() {
        long id = p2.getId();
        p3 = repositorio.recuperar(id);
        assertNotNull(p3);
        assertEquals(p3.getTitulo(), p2.getTitulo());
    }
    
    @Test
    public void testGRemoverId() {
        long id = p3.getId();
        repositorio.remover(id);
    }
    
    @Test
    public void testHPosRemoverIdRecuperarTodos() {
        List<Prova> recuperar = repositorio.recuperar();
        boolean found = false;
        for(Prova p : recuperar){
            if(!p.getTitulo().equals(p3.getTitulo())){
                found = true;
                p5 = p;
                break;
            }
        }
        assertNull(p5);
    }
    
    @Test
    public void testIPosRemoverIdExisteId() {
        long id = p5.getId();
        assertNull(repositorio.recuperar(id));
    }
    
    @Test
    public void testJAdicionar2() {
        repositorio.adicionar(p1);
    }
    
    @Test
    public void testLRemoverObject() {
        repositorio.remover(p1);
    }
    
    @Test
    public void testNPosRemoverExisteObject() {
        assertTrue(repositorio.existe(p1));
    }
    
}

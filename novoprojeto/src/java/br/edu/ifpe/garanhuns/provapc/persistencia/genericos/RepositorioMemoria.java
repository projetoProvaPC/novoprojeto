/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.provapc.persistencia.genericos;


import br.edu.ifpe.garanhuns.provapc.persistencia.fabricas.FabricaRepositorio;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Persistivel;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Repositorio;
import java.beans.IntrospectionException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;
import net.sf.ehcache.util.PropertyUtil;

/**
 *
 * @author lucas
 * @param <Tipo>
 */
public abstract class RepositorioMemoria<Tipo extends Persistivel> implements Repositorio<Tipo> {

    public RepositorioMemoria() {
        // analise um a um
        for(Field f : c.getDeclaredFields()){
            // analise cada anotação
            for(Annotation a : f.getDeclaredAnnotations()){
                // Você deve tratar todos os fields com essas anotações
                if(a.annotationType().equals(javax.persistence.OneToMany.class)){
                    fields.put(f,javax.persistence.OneToMany.class);
                } else if (a.annotationType().equals(javax.persistence.OneToOne.class)){
                    fields.put(f, javax.persistence.OneToOne.class);
                } else if (a.annotationType().equals(javax.persistence.ManyToMany.class)){
                    fields.put(f, javax.persistence.ManyToMany.class);
                } else if (a.annotationType().equals(javax.persistence.ManyToOne.class)) {
                    fields.put(f, javax.persistence.ManyToOne.class);
                }
            }
        }
    }
    
    // Encontre a classe da qual o repositório vai se ocupar
    private final Class c =  (Class<Tipo>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    private final Map<Field,Class> fields = new HashMap<>();
    private final Map<Long,Tipo> elementos = new HashMap<>();
    private static long maxid = 1;
    
    @Override
    public void adicionar(Tipo t){
        t.setId(maxid++);
        elementos.put(t.getId(), t);
        this.atualizarObjetosDependentes(t,"adicionar");
    }

    @Override
    public void remover(long id) {
        elementos.remove(id);
    }

    @Override
    public void alterar(Tipo t) {
        try {
            elementos.get(t.getId()).alterar(t);
            this.atualizarObjetosDependentes(t,"alterar");
        } catch(NullPointerException e) {
            return;
        }
    }

    @Override
    public List<Tipo> recuperar() {
        ArrayList<Tipo> al = new ArrayList<>();
        for (Map.Entry<Long, Tipo> e : elementos.entrySet()) {
            al.add(e.getValue());
        }
        return al;
    }

    @Override
    public Tipo recuperar(long id) {
        return elementos.get(id);
    }
    
    private void atualizarObjetosDependentes(Tipo t, String todoName) {
        try {
            Method todo = Repositorio.class.getMethod(todoName, Persistivel.class);
            for(Field f : fields.keySet()){
            // One to many = tem uma Collection que eu preciso adicionar
            if(fields.get(f).equals(javax.persistence.OneToMany.class)) {
                // O tipo do field
                Class<?> fieldTipo = (Class<?>) f.getType();
                    if(Collection.class.isAssignableFrom(fieldTipo)) {
                        // é uma coleção
                        Class<?> fieldListTipo = (Class<?>) ((ParameterizedType) f.getGenericType()).getActualTypeArguments()[0];
                        // Pegue o respositório
                        Repositorio rep = FabricaRepositorio.getFabrica().getRepositorio(fieldListTipo);
                        // O parametro de tipo da Collection
                        Collection<Persistivel> ps = (Collection<Persistivel>) new java.beans.PropertyDescriptor(f.getName(),c).getReadMethod().invoke(t);
                        for(Persistivel p : ps) {
                            todo.invoke(rep, p);
                        }
                    } else {
                        // é só um objeto!
                        Persistivel p = (Persistivel) new java.beans.PropertyDescriptor(f.getName(),c).getReadMethod().invoke(t);
                        Repositorio rep = FabricaRepositorio.getFabrica().getRepositorio(fieldTipo);
                        todo.invoke(rep, p);
                    }
            }
        }
        } catch (NoSuchMethodException | SecurityException | IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(RepositorioMemoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.model.dao;

/**
 *
 * @author Thais
 */
public class FabricaRepositorios {

    public static final int questao = 1;
    public static final int alternativa = 2;
    public static final int prova = 3;
    public static final int professor = 4;
    public static final int aluno = 5;
    public static final int usuario = 6;
    public static final int respostaProva = 7;


    public static final int BD = 1;

    public static RepositorioGenerico fabricarRepositorio(int tipoNegocio, int tipoPersistivel){
        if(tipoPersistivel==BD){
            if(tipoNegocio==questao){
                return new RepositorioQuestao();
            }else if(tipoNegocio==alternativa){
                return new RepositorioAlternativa();
            }else if(tipoNegocio==prova){
                return new RepositorioProva();
            }else if(tipoNegocio==professor){
                return new RepositorioProfessor();
            }else if(tipoNegocio==aluno){
                return new RepositorioAluno();
            }else if(tipoNegocio==usuario){
                return new RepositorioUsuario();
            }else if(tipoNegocio==respostaProva){
                return new RepositorioRespostaProva();
            }
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import util.ConexaoMySQL;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Guilherme
 */
@ManagedBean
@RequestScoped
public class CadastroDisciplinaBean {

    private String disciplina;
    private int semestre;
    private String prerequisito;

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setPrerequisito(String prerequisito) {
        this.prerequisito = prerequisito;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getPrerequisito() {
        return prerequisito;
    }

    public void cadastroDisciplina(){
        ConexaoMySQL conecta = new ConexaoMySQL();
    }
    public CadastroDisciplinaBean() {
    }

}

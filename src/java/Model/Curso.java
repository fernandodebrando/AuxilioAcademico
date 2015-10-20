/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author fernando
 */
@ApplicationScoped
public class Curso {

    private Integer id;
    private String nome;
    private String nomeDisciplina;
    private String horas;
    private String semestre;
    private String ead;
    private String preRequisito;
    private String caracterizacao;
    private String competenciaEssencial;
    private String nivelDificuldade;
    private String sala;
    private String diaSemana;
    private String turno;
    private String nomeProfessor;
    private String curriculo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getEad() {
        return ead;
    }

    public void setEad(String ead) {
        this.ead = ead;
    }

    public String getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(String preRequisito) {
        this.preRequisito = preRequisito;
    }

    public String getCaracterizacao() {
        return caracterizacao;
    }

    public void setCaracterizacao(String caracterizacao) {
        this.caracterizacao = caracterizacao;
    }

    public String getCompetenciaEssencial() {
        return competenciaEssencial;
    }

    public void setCompetenciaEssencial(String competenciaEssencial) {
        this.competenciaEssencial = competenciaEssencial;
    }

    public String getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(String nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public List<Curso> list() {

        try {

            List<Curso> arrayList = new ArrayList();
            ExecuteSQL exec = new ExecuteSQL();
            String sql = "select * "
                    + "from curso as c \n";

            ResultSet rs = exec.executeQuery(sql);

            while (rs.next()) {
                Curso c = new Curso();
                c.setId(Integer.parseInt(rs.getString("id")));
                c.setNome(rs.getString("nome"));
                arrayList.add(c);
            }

            return arrayList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public Boolean salvar(Integer idCurso, String nomeCurso) {

        try {

            String sql = "";
            ExecuteSQL exec = new ExecuteSQL();
            if (idCurso != null) {
                sql = "update curso set nome = '" + nomeCurso + "' where id = " + idCurso;
            } else {
                sql = "insert into curso (nome) values('" + nomeCurso+ "')";
            }

            return exec.insert(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    public Boolean excluir(Integer idCurso) {

        try {

            ExecuteSQL exec = new ExecuteSQL();
            String sql = "delete from curso where id = " + idCurso;

            ResultSet rs = exec.executeQuery(sql);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

}

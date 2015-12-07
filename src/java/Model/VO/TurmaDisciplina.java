/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.VO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "turma_disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurmaDisciplina.findAll", query = "SELECT t FROM TurmaDisciplina t"),
    @NamedQuery(name = "TurmaDisciplina.findById", query = "SELECT t FROM TurmaDisciplina t WHERE t.id = :id"),
    @NamedQuery(name = "TurmaDisciplina.findBySala", query = "SELECT t FROM TurmaDisciplina t WHERE t.sala = :sala"),
    @NamedQuery(name = "TurmaDisciplina.findByDiaSemana", query = "SELECT t FROM TurmaDisciplina t WHERE t.diaSemana = :diaSemana"),
    @NamedQuery(name = "TurmaDisciplina.findByAtivo", query = "SELECT t FROM TurmaDisciplina t WHERE t.ativo = :ativo")})
public class TurmaDisciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "sala")
    private String sala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia_semana")
    private int diaSemana;
    @Size(max = 45)
    @Column(name = "ativo")
    private String ativo;
    @JoinColumn(name = "id_turma", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Turma idTurma;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Disciplina idDisciplina;
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Professor idProfessor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurmaDisciplina")
    private Collection<AlunoTurmaDisciplina> alunoTurmaDisciplinaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurmaDisciplina")
    private Collection<DisciplinaHashtag> disciplinaHashtagCollection;

    public TurmaDisciplina() {
    }

    public TurmaDisciplina(Integer id) {
        this.id = id;
    }

    public TurmaDisciplina(Integer id, int diaSemana) {
        this.id = id;
        this.diaSemana = diaSemana;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public Turma getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Turma idTurma) {
        this.idTurma = idTurma;
    }

    public Disciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Disciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Professor getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Professor idProfessor) {
        this.idProfessor = idProfessor;
    }

    @XmlTransient
    public Collection<AlunoTurmaDisciplina> getAlunoTurmaDisciplinaCollection() {
        return alunoTurmaDisciplinaCollection;
    }

    public void setAlunoTurmaDisciplinaCollection(Collection<AlunoTurmaDisciplina> alunoTurmaDisciplinaCollection) {
        this.alunoTurmaDisciplinaCollection = alunoTurmaDisciplinaCollection;
    }

    @XmlTransient
    public Collection<DisciplinaHashtag> getDisciplinaHashtagCollection() {
        return disciplinaHashtagCollection;
    }

    public void setDisciplinaHashtagCollection(Collection<DisciplinaHashtag> disciplinaHashtagCollection) {
        this.disciplinaHashtagCollection = disciplinaHashtagCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurmaDisciplina)) {
            return false;
        }
        TurmaDisciplina other = (TurmaDisciplina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VO.TurmaDisciplina[ id=" + id + " ]";
    }
    
}

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
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findById", query = "SELECT d FROM Disciplina d WHERE d.id = :id"),
    @NamedQuery(name = "Disciplina.findByNomeDisciplina", query = "SELECT d FROM Disciplina d WHERE d.nomeDisciplina = :nomeDisciplina"),
    @NamedQuery(name = "Disciplina.findByHoras", query = "SELECT d FROM Disciplina d WHERE d.horas = :horas"),
    @NamedQuery(name = "Disciplina.findBySemestre", query = "SELECT d FROM Disciplina d WHERE d.semestre = :semestre"),
    @NamedQuery(name = "Disciplina.findByEad", query = "SELECT d FROM Disciplina d WHERE d.ead = :ead"),
    @NamedQuery(name = "Disciplina.findByPreRequisito", query = "SELECT d FROM Disciplina d WHERE d.preRequisito = :preRequisito"),
    @NamedQuery(name = "Disciplina.findByCaracterizacao", query = "SELECT d FROM Disciplina d WHERE d.caracterizacao = :caracterizacao"),
    @NamedQuery(name = "Disciplina.findByCompetenciaEssencial", query = "SELECT d FROM Disciplina d WHERE d.competenciaEssencial = :competenciaEssencial"),
    @NamedQuery(name = "Disciplina.findByNivelDificuldade", query = "SELECT d FROM Disciplina d WHERE d.nivelDificuldade = :nivelDificuldade")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome_disciplina")
    private String nomeDisciplina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "horas")
    private String horas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private int semestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ead")
    private boolean ead;
    @Size(max = 500)
    @Column(name = "pre_requisito")
    private String preRequisito;
    @Size(max = 1000)
    @Column(name = "caracterizacao")
    private String caracterizacao;
    @Size(max = 1000)
    @Column(name = "competencia_essencial")
    private String competenciaEssencial;
    @Column(name = "nivel_dificuldade")
    private Character nivelDificuldade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisciplina")
    private Collection<TurmaDisciplina> turmaDisciplinaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisciplina")
    private Collection<CursoDisciplina> cursoDisciplinaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisciplina")
    private Collection<DisciplinaHashtag> disciplinaHashtagCollection;
   
    public Disciplina() {
    }

    public Disciplina(Integer id) {
        this.id = id;
    }

    public Disciplina(Integer id, String nomeDisciplina, String horas, int semestre, boolean ead) {
        this.id = id;
        this.nomeDisciplina = nomeDisciplina;
        this.horas = horas;
        this.semestre = semestre;
        this.ead = ead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public boolean getEad() {
        return ead;
    }

    public void setEad(boolean ead) {
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

    public Character getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(Character nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    @XmlTransient
    public Collection<TurmaDisciplina> getTurmaDisciplinaCollection() {
        return turmaDisciplinaCollection;
    }

    public void setTurmaDisciplinaCollection(Collection<TurmaDisciplina> turmaDisciplinaCollection) {
        this.turmaDisciplinaCollection = turmaDisciplinaCollection;
    }

    @XmlTransient
    public Collection<CursoDisciplina> getCursoDisciplinaCollection() {
        return cursoDisciplinaCollection;
    }

    public void setCursoDisciplinaCollection(Collection<CursoDisciplina> cursoDisciplinaCollection) {
        this.cursoDisciplinaCollection = cursoDisciplinaCollection;
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
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VO.Disciplina[ id=" + id + " ]";
    }
    
}

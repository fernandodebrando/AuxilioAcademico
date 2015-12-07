/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.VO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "disciplina_hashtag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisciplinaHashtag.findAll", query = "SELECT d FROM DisciplinaHashtag d"),
    @NamedQuery(name = "DisciplinaHashtag.findById", query = "SELECT d FROM DisciplinaHashtag d WHERE d.id = :id")})
public class DisciplinaHashtag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_turma_disciplina", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TurmaDisciplina idTurmaDisciplina;
    @JoinColumn(name = "id_hashtag", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hashtag idHashtag;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Disciplina idDisciplina;
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aluno idAluno;

    public DisciplinaHashtag() {
    }

    public DisciplinaHashtag(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TurmaDisciplina getIdTurmaDisciplina() {
        return idTurmaDisciplina;
    }

    public void setIdTurmaDisciplina(TurmaDisciplina idTurmaDisciplina) {
        this.idTurmaDisciplina = idTurmaDisciplina;
    }

    public Hashtag getIdHashtag() {
        return idHashtag;
    }

    public void setIdHashtag(Hashtag idHashtag) {
        this.idHashtag = idHashtag;
    }

    public Disciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Disciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
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
        if (!(object instanceof DisciplinaHashtag)) {
            return false;
        }
        DisciplinaHashtag other = (DisciplinaHashtag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VO.DisciplinaHashtag[ id=" + id + " ]";
    }
    
}

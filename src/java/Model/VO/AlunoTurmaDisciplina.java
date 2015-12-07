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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "aluno_turma_disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoTurmaDisciplina.findAll", query = "SELECT a FROM AlunoTurmaDisciplina a"),
    @NamedQuery(name = "AlunoTurmaDisciplina.findById", query = "SELECT a FROM AlunoTurmaDisciplina a WHERE a.id = :id"),
    @NamedQuery(name = "AlunoTurmaDisciplina.findBySituacao", query = "SELECT a FROM AlunoTurmaDisciplina a WHERE a.situacao = :situacao")})
public class AlunoTurmaDisciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "id_turma_disciplina", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TurmaDisciplina idTurmaDisciplina;
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aluno idAluno;

    public AlunoTurmaDisciplina() {
    }

    public AlunoTurmaDisciplina(Integer id) {
        this.id = id;
    }

    public AlunoTurmaDisciplina(Integer id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public TurmaDisciplina getIdTurmaDisciplina() {
        return idTurmaDisciplina;
    }

    public void setIdTurmaDisciplina(TurmaDisciplina idTurmaDisciplina) {
        this.idTurmaDisciplina = idTurmaDisciplina;
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
        if (!(object instanceof AlunoTurmaDisciplina)) {
            return false;
        }
        AlunoTurmaDisciplina other = (AlunoTurmaDisciplina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VO.AlunoTurmaDisciplina[ id=" + id + " ]";
    }
    
}

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
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findById", query = "SELECT a FROM Aluno a WHERE a.id = :id"),
    @NamedQuery(name = "Aluno.findByMatricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula"),
    @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome")})
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "matricula")
    private String matricula;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<AlunoCurso> alunoCursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<AlunoTurmaDisciplina> alunoTurmaDisciplinaCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<DisciplinaHashtag> disciplinaHashtagCollection;

    public Aluno() {
    }

    public Aluno(Integer id) {
        this.id = id;
    }

    public Aluno(Integer id, String matricula) {
        this.id = id;
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<AlunoCurso> getAlunoCursoCollection() {
        return alunoCursoCollection;
    }

    public void setAlunoCursoCollection(Collection<AlunoCurso> alunoCursoCollection) {
        this.alunoCursoCollection = alunoCursoCollection;
    }

    @XmlTransient
    public Collection<AlunoTurmaDisciplina> getAlunoTurmaDisciplinaCollection() {
        return alunoTurmaDisciplinaCollection;
    }

    public void setAlunoTurmaDisciplinaCollection(Collection<AlunoTurmaDisciplina> alunoTurmaDisciplinaCollection) {
        this.alunoTurmaDisciplinaCollection = alunoTurmaDisciplinaCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VO.Aluno[ id=" + id + " ]";
    }
    
}

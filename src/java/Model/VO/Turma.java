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
@Table(name = "turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t"),
    @NamedQuery(name = "Turma.findById", query = "SELECT t FROM Turma t WHERE t.id = :id"),
    @NamedQuery(name = "Turma.findBySemestreTurma", query = "SELECT t FROM Turma t WHERE t.semestreTurma = :semestreTurma"),
    @NamedQuery(name = "Turma.findByTurno", query = "SELECT t FROM Turma t WHERE t.turno = :turno"),
    @NamedQuery(name = "Turma.findByAtivo", query = "SELECT t FROM Turma t WHERE t.ativo = :ativo")})
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre_turma")
    private int semestreTurma;
    @Size(max = 45)
    @Column(name = "turno")
    private String turno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ativo")
    private boolean ativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurma")
    private Collection<TurmaDisciplina> turmaDisciplinaCollection;
    @JoinColumn(name = "id_cad_turma", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CadTurma idCadTurma;

    public Turma() {
    }

    public Turma(Integer id) {
        this.id = id;
    }

    public Turma(Integer id, int semestreTurma, boolean ativo) {
        this.id = id;
        this.semestreTurma = semestreTurma;
        this.ativo = ativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSemestreTurma() {
        return semestreTurma;
    }

    public void setSemestreTurma(int semestreTurma) {
        this.semestreTurma = semestreTurma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public Collection<TurmaDisciplina> getTurmaDisciplinaCollection() {
        return turmaDisciplinaCollection;
    }

    public void setTurmaDisciplinaCollection(Collection<TurmaDisciplina> turmaDisciplinaCollection) {
        this.turmaDisciplinaCollection = turmaDisciplinaCollection;
    }

    public CadTurma getIdCadTurma() {
        return idCadTurma;
    }

    public void setIdCadTurma(CadTurma idCadTurma) {
        this.idCadTurma = idCadTurma;
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
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VO.Turma[ id=" + id + " ]";
    }
    
}

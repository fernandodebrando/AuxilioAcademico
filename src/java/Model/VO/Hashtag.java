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
@Table(name = "hashtag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hashtag.findAll", query = "SELECT h FROM Hashtag h"),
    @NamedQuery(name = "Hashtag.findById", query = "SELECT h FROM Hashtag h WHERE h.id = :id"),
    @NamedQuery(name = "Hashtag.findByNome", query = "SELECT h FROM Hashtag h WHERE h.nome = :nome"),
    @NamedQuery(name = "Hashtag.findByDescricao", query = "SELECT h FROM Hashtag h WHERE h.descricao = :descricao"),
    @NamedQuery(name = "Hashtag.findByPesoHashtag", query = "SELECT h FROM Hashtag h WHERE h.pesoHashtag = :pesoHashtag"),
    @NamedQuery(name = "Hashtag.findByTema", query = "SELECT h FROM Hashtag h WHERE h.tema = :tema")})
public class Hashtag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_hashtag")
    private double pesoHashtag;
    @Size(max = 50)
    @Column(name = "tema")
    private String tema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHashtag")
    private Collection<DisciplinaHashtag> disciplinaHashtagCollection;

    public Hashtag() {
    }

    public Hashtag(Integer id) {
        this.id = id;
    }

    public Hashtag(Integer id, String nome, double pesoHashtag) {
        this.id = id;
        this.nome = nome;
        this.pesoHashtag = pesoHashtag;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPesoHashtag() {
        return pesoHashtag;
    }

    public void setPesoHashtag(double pesoHashtag) {
        this.pesoHashtag = pesoHashtag;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
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
        if (!(object instanceof Hashtag)) {
            return false;
        }
        Hashtag other = (Hashtag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VO.Hashtag[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danielPC
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByCodPersona", query = "SELECT p FROM Persona p WHERE p.codPersona = :codPersona"),
    @NamedQuery(name = "Persona.findByIdentificacion", query = "SELECT p FROM Persona p WHERE p.identificacion = :identificacion"),
    @NamedQuery(name = "Persona.findByPrimerNombre", query = "SELECT p FROM Persona p WHERE p.primerNombre = :primerNombre"),
    @NamedQuery(name = "Persona.findBySegundoNombre", query = "SELECT p FROM Persona p WHERE p.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Persona.findByPrimerApellido", query = "SELECT p FROM Persona p WHERE p.primerApellido = :primerApellido"),
    @NamedQuery(name = "Persona.findBySegundoApellido", query = "SELECT p FROM Persona p WHERE p.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Persona.findByEdad", query = "SELECT p FROM Persona p WHERE p.edad = :edad"),
    @NamedQuery(name = "Persona.findBySexo", query = "SELECT p FROM Persona p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Persona.findByDomicilio", query = "SELECT p FROM Persona p WHERE p.domicilio = :domicilio"),
    @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email"),
    @NamedQuery(name = "Persona.findByFechaNac", query = "SELECT p FROM Persona p WHERE p.fechaNac = :fechaNac"),
    @NamedQuery(name = "Persona.findByProfesion", query = "SELECT p FROM Persona p WHERE p.profesion = :profesion"),
    @NamedQuery(name = "Persona.findByOcupacion", query = "SELECT p FROM Persona p WHERE p.ocupacion = :ocupacion"),
    @NamedQuery(name = "Persona.findByEstcivil", query = "SELECT p FROM Persona p WHERE p.estcivil = :estcivil")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_persona")
    private String codPersona;
    @Size(max = 15)
    @Column(name = "identificacion")
    private String identificacion;
    @Size(max = 50)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Size(max = 50)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Size(max = 2)
    @Column(name = "edad")
    private String edad;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 100)
    @Column(name = "domicilio")
    private String domicilio;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 80)
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Size(max = 100)
    @Column(name = "profesion")
    private String profesion;
    @Size(max = 100)
    @Column(name = "ocupacion")
    private String ocupacion;
    @Size(max = 1)
    @Column(name = "estcivil")
    private String estcivil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.EAGER)
    private List<MateriaParalelo> materiaParaleloList;
    @OneToMany(mappedBy = "codPersona", fetch = FetchType.EAGER)
    private List<Estudiante> estudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.EAGER)
    private List<RegActas> regActasList;
    @OneToMany(mappedBy = "codTutor", fetch = FetchType.EAGER)
    private List<Paralelo> paraleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.EAGER)
    private List<RepresentanteEstudianteEmpresa> representanteEstudianteEmpresaList;
    @JoinColumn(name = "tipo_persona", referencedColumnName = "codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoPersona tipoPersona;
    @JoinColumn(name = "tipo_idenficacion", referencedColumnName = "codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoIdentificacion tipoIdenficacion;
    @JoinColumn(name = "ciudad_nac", referencedColumnName = "codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Ciudad ciudadNac;

    public Persona() {
    }

    public Persona(String codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(String codPersona) {
        this.codPersona = codPersona;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEstcivil() {
        return estcivil;
    }

    public void setEstcivil(String estcivil) {
        this.estcivil = estcivil;
    }

    @XmlTransient
    public List<MateriaParalelo> getMateriaParaleloList() {
        return materiaParaleloList;
    }

    public void setMateriaParaleloList(List<MateriaParalelo> materiaParaleloList) {
        this.materiaParaleloList = materiaParaleloList;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @XmlTransient
    public List<RegActas> getRegActasList() {
        return regActasList;
    }

    public void setRegActasList(List<RegActas> regActasList) {
        this.regActasList = regActasList;
    }

    @XmlTransient
    public List<Paralelo> getParaleloList() {
        return paraleloList;
    }

    public void setParaleloList(List<Paralelo> paraleloList) {
        this.paraleloList = paraleloList;
    }

    @XmlTransient
    public List<RepresentanteEstudianteEmpresa> getRepresentanteEstudianteEmpresaList() {
        return representanteEstudianteEmpresaList;
    }

    public void setRepresentanteEstudianteEmpresaList(List<RepresentanteEstudianteEmpresa> representanteEstudianteEmpresaList) {
        this.representanteEstudianteEmpresaList = representanteEstudianteEmpresaList;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public TipoIdentificacion getTipoIdenficacion() {
        return tipoIdenficacion;
    }

    public void setTipoIdenficacion(TipoIdentificacion tipoIdenficacion) {
        this.tipoIdenficacion = tipoIdenficacion;
    }

    public Ciudad getCiudadNac() {
        return ciudadNac;
    }

    public void setCiudadNac(Ciudad ciudadNac) {
        this.ciudadNac = ciudadNac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Persona[ codPersona=" + codPersona + " ]";
    }
    
}

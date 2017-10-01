package ec.edu.utpl.svied.model;
// Generated 01/09/2017 12:34:01 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TdiModalidad generated by hbm2java
 */
@Entity
@Table(name="TDI_MODALIDAD"
    ,schema="ESQ_SIEC"
)
public class TdiModalidad  implements java.io.Serializable {


     private BigDecimal moId;
     private String moNombre;
     private BigDecimal moEquIdNsga;
     private String moEquNombreNsga;
     private BigDecimal moEquIdSga;
     private String moEquNombreSga;
     private BigDecimal moEquIdEva;
     private String moEquNombreEva;
     private Date moFechaCreacion;
     private Date moFechaActualizacion;
     private String moVigencia;
     private BigDecimal moEquiIdExalumnos;
     private String moEquiNombreExalumnos;
     private Set<TdiPeriodoDetalle> tdiPeriodoDetalles = new HashSet<TdiPeriodoDetalle>(0);
     private Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs = new HashSet<TheActividadesDocEvaCab>(0);
     private Set<TheActividadesDocEvaDet> theActividadesDocEvaDets = new HashSet<TheActividadesDocEvaDet>(0);
     private Set<TheActividadesEvaAvance> theActividadesEvaAvances = new HashSet<TheActividadesEvaAvance>(0);

    public TdiModalidad() {
    }

	
    public TdiModalidad(BigDecimal moId, String moNombre, Date moFechaCreacion, String moVigencia) {
        this.moId = moId;
        this.moNombre = moNombre;
        this.moFechaCreacion = moFechaCreacion;
        this.moVigencia = moVigencia;
    }
    public TdiModalidad(BigDecimal moId, String moNombre, BigDecimal moEquIdNsga, String moEquNombreNsga, BigDecimal moEquIdSga, String moEquNombreSga, BigDecimal moEquIdEva, String moEquNombreEva, Date moFechaCreacion, Date moFechaActualizacion, String moVigencia, BigDecimal moEquiIdExalumnos, String moEquiNombreExalumnos, Set<TdiPeriodoDetalle> tdiPeriodoDetalles, Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs, Set<TheActividadesDocEvaDet> theActividadesDocEvaDets, Set<TheActividadesEvaAvance> theActividadesEvaAvances) {
       this.moId = moId;
       this.moNombre = moNombre;
       this.moEquIdNsga = moEquIdNsga;
       this.moEquNombreNsga = moEquNombreNsga;
       this.moEquIdSga = moEquIdSga;
       this.moEquNombreSga = moEquNombreSga;
       this.moEquIdEva = moEquIdEva;
       this.moEquNombreEva = moEquNombreEva;
       this.moFechaCreacion = moFechaCreacion;
       this.moFechaActualizacion = moFechaActualizacion;
       this.moVigencia = moVigencia;
       this.moEquiIdExalumnos = moEquiIdExalumnos;
       this.moEquiNombreExalumnos = moEquiNombreExalumnos;
       this.tdiPeriodoDetalles = tdiPeriodoDetalles;
       this.theActividadesDocEvaCabs = theActividadesDocEvaCabs;
       this.theActividadesDocEvaDets = theActividadesDocEvaDets;
       this.theActividadesEvaAvances = theActividadesEvaAvances;
    }
   
     @Id 

    
    @Column(name="MO_ID", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getMoId() {
        return this.moId;
    }
    
    public void setMoId(BigDecimal moId) {
        this.moId = moId;
    }

    
    @Column(name="MO_NOMBRE", nullable=false, length=100)
    public String getMoNombre() {
        return this.moNombre;
    }
    
    public void setMoNombre(String moNombre) {
        this.moNombre = moNombre;
    }

    
    @Column(name="MO_EQU_ID_NSGA", precision=22, scale=0)
    public BigDecimal getMoEquIdNsga() {
        return this.moEquIdNsga;
    }
    
    public void setMoEquIdNsga(BigDecimal moEquIdNsga) {
        this.moEquIdNsga = moEquIdNsga;
    }

    
    @Column(name="MO_EQU_NOMBRE_NSGA", length=100)
    public String getMoEquNombreNsga() {
        return this.moEquNombreNsga;
    }
    
    public void setMoEquNombreNsga(String moEquNombreNsga) {
        this.moEquNombreNsga = moEquNombreNsga;
    }

    
    @Column(name="MO_EQU_ID_SGA", precision=22, scale=0)
    public BigDecimal getMoEquIdSga() {
        return this.moEquIdSga;
    }
    
    public void setMoEquIdSga(BigDecimal moEquIdSga) {
        this.moEquIdSga = moEquIdSga;
    }

    
    @Column(name="MO_EQU_NOMBRE_SGA", length=100)
    public String getMoEquNombreSga() {
        return this.moEquNombreSga;
    }
    
    public void setMoEquNombreSga(String moEquNombreSga) {
        this.moEquNombreSga = moEquNombreSga;
    }

    
    @Column(name="MO_EQU_ID_EVA", precision=22, scale=0)
    public BigDecimal getMoEquIdEva() {
        return this.moEquIdEva;
    }
    
    public void setMoEquIdEva(BigDecimal moEquIdEva) {
        this.moEquIdEva = moEquIdEva;
    }

    
    @Column(name="MO_EQU_NOMBRE_EVA", length=100)
    public String getMoEquNombreEva() {
        return this.moEquNombreEva;
    }
    
    public void setMoEquNombreEva(String moEquNombreEva) {
        this.moEquNombreEva = moEquNombreEva;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="MO_FECHA_CREACION", nullable=false, length=7)
    public Date getMoFechaCreacion() {
        return this.moFechaCreacion;
    }
    
    public void setMoFechaCreacion(Date moFechaCreacion) {
        this.moFechaCreacion = moFechaCreacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="MO_FECHA_ACTUALIZACION", length=7)
    public Date getMoFechaActualizacion() {
        return this.moFechaActualizacion;
    }
    
    public void setMoFechaActualizacion(Date moFechaActualizacion) {
        this.moFechaActualizacion = moFechaActualizacion;
    }

    
    @Column(name="MO_VIGENCIA", nullable=false, length=1)
    public String getMoVigencia() {
        return this.moVigencia;
    }
    
    public void setMoVigencia(String moVigencia) {
        this.moVigencia = moVigencia;
    }

    
    @Column(name="MO_EQUI_ID_EXALUMNOS", precision=22, scale=0)
    public BigDecimal getMoEquiIdExalumnos() {
        return this.moEquiIdExalumnos;
    }
    
    public void setMoEquiIdExalumnos(BigDecimal moEquiIdExalumnos) {
        this.moEquiIdExalumnos = moEquiIdExalumnos;
    }

    
    @Column(name="MO_EQUI_NOMBRE_EXALUMNOS", length=50)
    public String getMoEquiNombreExalumnos() {
        return this.moEquiNombreExalumnos;
    }
    
    public void setMoEquiNombreExalumnos(String moEquiNombreExalumnos) {
        this.moEquiNombreExalumnos = moEquiNombreExalumnos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiModalidad")
    public Set<TdiPeriodoDetalle> getTdiPeriodoDetalles() {
        return this.tdiPeriodoDetalles;
    }
    
    public void setTdiPeriodoDetalles(Set<TdiPeriodoDetalle> tdiPeriodoDetalles) {
        this.tdiPeriodoDetalles = tdiPeriodoDetalles;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiModalidad")
    public Set<TheActividadesDocEvaCab> getTheActividadesDocEvaCabs() {
        return this.theActividadesDocEvaCabs;
    }
    
    public void setTheActividadesDocEvaCabs(Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs) {
        this.theActividadesDocEvaCabs = theActividadesDocEvaCabs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiModalidad")
    public Set<TheActividadesDocEvaDet> getTheActividadesDocEvaDets() {
        return this.theActividadesDocEvaDets;
    }
    
    public void setTheActividadesDocEvaDets(Set<TheActividadesDocEvaDet> theActividadesDocEvaDets) {
        this.theActividadesDocEvaDets = theActividadesDocEvaDets;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiModalidad")
    public Set<TheActividadesEvaAvance> getTheActividadesEvaAvances() {
        return this.theActividadesEvaAvances;
    }
    
    public void setTheActividadesEvaAvances(Set<TheActividadesEvaAvance> theActividadesEvaAvances) {
        this.theActividadesEvaAvances = theActividadesEvaAvances;
    }




}



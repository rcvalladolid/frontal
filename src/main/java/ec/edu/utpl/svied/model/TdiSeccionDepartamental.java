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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TdiSeccionDepartamental generated by hbm2java
 */
@Entity
@Table(name="TDI_SECCION_DEPARTAMENTAL"
    ,schema="ESQ_SIEC"
)
public class TdiSeccionDepartamental  implements java.io.Serializable {


     private BigDecimal seId;
     private TdiDepartamento tdiDepartamento;
     private String seNombre;
     private Date seFechaInicioVigencia;
     private Date seFechaFinVigencia;
     private String seVigente;
     private BigDecimal secIdNsga;
     private Set<TheActividadesDocEvaDet> theActividadesDocEvaDets = new HashSet<TheActividadesDocEvaDet>(0);
     private Set<TdiComponenteEducativo> tdiComponenteEducativos = new HashSet<TdiComponenteEducativo>(0);
     private Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs = new HashSet<TheActividadesDocEvaCab>(0);
     private Set<TheActividadesEvaAvance> theActividadesEvaAvances = new HashSet<TheActividadesEvaAvance>(0);

    public TdiSeccionDepartamental() {
    }

	
    public TdiSeccionDepartamental(BigDecimal seId, TdiDepartamento tdiDepartamento, String seNombre, Date seFechaInicioVigencia, String seVigente) {
        this.seId = seId;
        this.tdiDepartamento = tdiDepartamento;
        this.seNombre = seNombre;
        this.seFechaInicioVigencia = seFechaInicioVigencia;
        this.seVigente = seVigente;
    }
    public TdiSeccionDepartamental(BigDecimal seId, TdiDepartamento tdiDepartamento, String seNombre, Date seFechaInicioVigencia, Date seFechaFinVigencia, String seVigente, BigDecimal secIdNsga, Set<TheActividadesDocEvaDet> theActividadesDocEvaDets, Set<TdiComponenteEducativo> tdiComponenteEducativos, Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs, Set<TheActividadesEvaAvance> theActividadesEvaAvances) {
       this.seId = seId;
       this.tdiDepartamento = tdiDepartamento;
       this.seNombre = seNombre;
       this.seFechaInicioVigencia = seFechaInicioVigencia;
       this.seFechaFinVigencia = seFechaFinVigencia;
       this.seVigente = seVigente;
       this.secIdNsga = secIdNsga;
       this.theActividadesDocEvaDets = theActividadesDocEvaDets;
       this.tdiComponenteEducativos = tdiComponenteEducativos;
       this.theActividadesDocEvaCabs = theActividadesDocEvaCabs;
       this.theActividadesEvaAvances = theActividadesEvaAvances;
    }
   
     @Id 

    
    @Column(name="SE_ID", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getSeId() {
        return this.seId;
    }
    
    public void setSeId(BigDecimal seId) {
        this.seId = seId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DE_ID", nullable=false)
    public TdiDepartamento getTdiDepartamento() {
        return this.tdiDepartamento;
    }
    
    public void setTdiDepartamento(TdiDepartamento tdiDepartamento) {
        this.tdiDepartamento = tdiDepartamento;
    }

    
    @Column(name="SE_NOMBRE", nullable=false, length=300)
    public String getSeNombre() {
        return this.seNombre;
    }
    
    public void setSeNombre(String seNombre) {
        this.seNombre = seNombre;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="SE_FECHA_INICIO_VIGENCIA", nullable=false, length=7)
    public Date getSeFechaInicioVigencia() {
        return this.seFechaInicioVigencia;
    }
    
    public void setSeFechaInicioVigencia(Date seFechaInicioVigencia) {
        this.seFechaInicioVigencia = seFechaInicioVigencia;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="SE_FECHA_FIN_VIGENCIA", length=7)
    public Date getSeFechaFinVigencia() {
        return this.seFechaFinVigencia;
    }
    
    public void setSeFechaFinVigencia(Date seFechaFinVigencia) {
        this.seFechaFinVigencia = seFechaFinVigencia;
    }

    
    @Column(name="SE_VIGENTE", nullable=false, length=1)
    public String getSeVigente() {
        return this.seVigente;
    }
    
    public void setSeVigente(String seVigente) {
        this.seVigente = seVigente;
    }

    
    @Column(name="SEC_ID_NSGA", precision=22, scale=0)
    public BigDecimal getSecIdNsga() {
        return this.secIdNsga;
    }
    
    public void setSecIdNsga(BigDecimal secIdNsga) {
        this.secIdNsga = secIdNsga;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiSeccionDepartamental")
    public Set<TheActividadesDocEvaDet> getTheActividadesDocEvaDets() {
        return this.theActividadesDocEvaDets;
    }
    
    public void setTheActividadesDocEvaDets(Set<TheActividadesDocEvaDet> theActividadesDocEvaDets) {
        this.theActividadesDocEvaDets = theActividadesDocEvaDets;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiSeccionDepartamental")
    public Set<TdiComponenteEducativo> getTdiComponenteEducativos() {
        return this.tdiComponenteEducativos;
    }
    
    public void setTdiComponenteEducativos(Set<TdiComponenteEducativo> tdiComponenteEducativos) {
        this.tdiComponenteEducativos = tdiComponenteEducativos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiSeccionDepartamental")
    public Set<TheActividadesDocEvaCab> getTheActividadesDocEvaCabs() {
        return this.theActividadesDocEvaCabs;
    }
    
    public void setTheActividadesDocEvaCabs(Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs) {
        this.theActividadesDocEvaCabs = theActividadesDocEvaCabs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiSeccionDepartamental")
    public Set<TheActividadesEvaAvance> getTheActividadesEvaAvances() {
        return this.theActividadesEvaAvances;
    }
    
    public void setTheActividadesEvaAvances(Set<TheActividadesEvaAvance> theActividadesEvaAvances) {
        this.theActividadesEvaAvances = theActividadesEvaAvances;
    }




}



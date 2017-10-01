package ec.edu.utpl.svied.model;
// Generated 01/09/2017 12:34:01 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * TdsRolUsuario generated by hbm2java
 */
@Entity
@Table(name="TDS_ROL_USUARIO"
    ,schema="ESQ_SIEC"
    , uniqueConstraints = @UniqueConstraint(columnNames={"RO_ID", "US_ID"}) 
)
public class TdsRolUsuario  implements java.io.Serializable {


     private BigDecimal ruId;
     private TdsRol tdsRol;
     private TdsUsuario tdsUsuario;
     private Date ruFechaInicioVig;
     private Date ruFechaFinVig;
     private String ruVigente;
     private Date ruFechaCreacion;
     private Date ruFechaUtlAct;
     private String usuarioApexCrea;
     private String usuarioApexUltAct;

    public TdsRolUsuario() {
    }

	
    public TdsRolUsuario(BigDecimal ruId, TdsRol tdsRol, TdsUsuario tdsUsuario, Date ruFechaInicioVig, String ruVigente) {
        this.ruId = ruId;
        this.tdsRol = tdsRol;
        this.tdsUsuario = tdsUsuario;
        this.ruFechaInicioVig = ruFechaInicioVig;
        this.ruVigente = ruVigente;
    }
    public TdsRolUsuario(BigDecimal ruId, TdsRol tdsRol, TdsUsuario tdsUsuario, Date ruFechaInicioVig, Date ruFechaFinVig, String ruVigente, Date ruFechaCreacion, Date ruFechaUtlAct, String usuarioApexCrea, String usuarioApexUltAct) {
       this.ruId = ruId;
       this.tdsRol = tdsRol;
       this.tdsUsuario = tdsUsuario;
       this.ruFechaInicioVig = ruFechaInicioVig;
       this.ruFechaFinVig = ruFechaFinVig;
       this.ruVigente = ruVigente;
       this.ruFechaCreacion = ruFechaCreacion;
       this.ruFechaUtlAct = ruFechaUtlAct;
       this.usuarioApexCrea = usuarioApexCrea;
       this.usuarioApexUltAct = usuarioApexUltAct;
    }
   
     @Id 

    
    @Column(name="RU_ID", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getRuId() {
        return this.ruId;
    }
    
    public void setRuId(BigDecimal ruId) {
        this.ruId = ruId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="RO_ID", nullable=false)
    public TdsRol getTdsRol() {
        return this.tdsRol;
    }
    
    public void setTdsRol(TdsRol tdsRol) {
        this.tdsRol = tdsRol;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="US_ID", nullable=false)
    public TdsUsuario getTdsUsuario() {
        return this.tdsUsuario;
    }
    
    public void setTdsUsuario(TdsUsuario tdsUsuario) {
        this.tdsUsuario = tdsUsuario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RU_FECHA_INICIO_VIG", nullable=false, length=7)
    public Date getRuFechaInicioVig() {
        return this.ruFechaInicioVig;
    }
    
    public void setRuFechaInicioVig(Date ruFechaInicioVig) {
        this.ruFechaInicioVig = ruFechaInicioVig;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RU_FECHA_FIN_VIG", length=7)
    public Date getRuFechaFinVig() {
        return this.ruFechaFinVig;
    }
    
    public void setRuFechaFinVig(Date ruFechaFinVig) {
        this.ruFechaFinVig = ruFechaFinVig;
    }

    
    @Column(name="RU_VIGENTE", nullable=false, length=1)
    public String getRuVigente() {
        return this.ruVigente;
    }
    
    public void setRuVigente(String ruVigente) {
        this.ruVigente = ruVigente;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RU_FECHA_CREACION", length=7)
    public Date getRuFechaCreacion() {
        return this.ruFechaCreacion;
    }
    
    public void setRuFechaCreacion(Date ruFechaCreacion) {
        this.ruFechaCreacion = ruFechaCreacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RU_FECHA_UTL_ACT", length=7)
    public Date getRuFechaUtlAct() {
        return this.ruFechaUtlAct;
    }
    
    public void setRuFechaUtlAct(Date ruFechaUtlAct) {
        this.ruFechaUtlAct = ruFechaUtlAct;
    }

    
    @Column(name="USUARIO_APEX_CREA", length=50)
    public String getUsuarioApexCrea() {
        return this.usuarioApexCrea;
    }
    
    public void setUsuarioApexCrea(String usuarioApexCrea) {
        this.usuarioApexCrea = usuarioApexCrea;
    }

    
    @Column(name="USUARIO_APEX_ULT_ACT", length=50)
    public String getUsuarioApexUltAct() {
        return this.usuarioApexUltAct;
    }
    
    public void setUsuarioApexUltAct(String usuarioApexUltAct) {
        this.usuarioApexUltAct = usuarioApexUltAct;
    }




}


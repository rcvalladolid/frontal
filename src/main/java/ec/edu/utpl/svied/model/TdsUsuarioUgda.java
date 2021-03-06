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
 * TdsUsuarioUgda generated by hbm2java
 */
@Entity
@Table(name="TDS_USUARIO_UGDA"
    ,schema="ESQ_SIEC"
)
public class TdsUsuarioUgda  implements java.io.Serializable {


     private BigDecimal usuId;
     private String usuIdentificacion;
     private String usuNombres;
     private Date usuFechaInicioVig;
     private Date usuFechaFinVig;
     private String usuActivo;
     private String usuUsername;
     private String usuPassword;
     private BigDecimal usuCod;
     private BigDecimal usuEnvioMail;
     private String usuUltFechaEnvioMail;
     private Set<TdsRolUsuarioUgda> tdsRolUsuarioUgdas = new HashSet<TdsRolUsuarioUgda>(0);

    public TdsUsuarioUgda() {
    }

	
    public TdsUsuarioUgda(BigDecimal usuId, String usuIdentificacion, String usuNombres, Date usuFechaInicioVig, String usuActivo) {
        this.usuId = usuId;
        this.usuIdentificacion = usuIdentificacion;
        this.usuNombres = usuNombres;
        this.usuFechaInicioVig = usuFechaInicioVig;
        this.usuActivo = usuActivo;
    }
    public TdsUsuarioUgda(BigDecimal usuId, String usuIdentificacion, String usuNombres, Date usuFechaInicioVig, Date usuFechaFinVig, String usuActivo, String usuUsername, String usuPassword, BigDecimal usuCod, BigDecimal usuEnvioMail, String usuUltFechaEnvioMail, Set<TdsRolUsuarioUgda> tdsRolUsuarioUgdas) {
       this.usuId = usuId;
       this.usuIdentificacion = usuIdentificacion;
       this.usuNombres = usuNombres;
       this.usuFechaInicioVig = usuFechaInicioVig;
       this.usuFechaFinVig = usuFechaFinVig;
       this.usuActivo = usuActivo;
       this.usuUsername = usuUsername;
       this.usuPassword = usuPassword;
       this.usuCod = usuCod;
       this.usuEnvioMail = usuEnvioMail;
       this.usuUltFechaEnvioMail = usuUltFechaEnvioMail;
       this.tdsRolUsuarioUgdas = tdsRolUsuarioUgdas;
    }
   
     @Id 

    
    @Column(name="USU_ID", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getUsuId() {
        return this.usuId;
    }
    
    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }

    
    @Column(name="USU_IDENTIFICACION", nullable=false, length=80)
    public String getUsuIdentificacion() {
        return this.usuIdentificacion;
    }
    
    public void setUsuIdentificacion(String usuIdentificacion) {
        this.usuIdentificacion = usuIdentificacion;
    }

    
    @Column(name="USU_NOMBRES", nullable=false, length=250)
    public String getUsuNombres() {
        return this.usuNombres;
    }
    
    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="USU_FECHA_INICIO_VIG", nullable=false, length=7)
    public Date getUsuFechaInicioVig() {
        return this.usuFechaInicioVig;
    }
    
    public void setUsuFechaInicioVig(Date usuFechaInicioVig) {
        this.usuFechaInicioVig = usuFechaInicioVig;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="USU_FECHA_FIN_VIG", length=7)
    public Date getUsuFechaFinVig() {
        return this.usuFechaFinVig;
    }
    
    public void setUsuFechaFinVig(Date usuFechaFinVig) {
        this.usuFechaFinVig = usuFechaFinVig;
    }

    
    @Column(name="USU_ACTIVO", nullable=false, length=1)
    public String getUsuActivo() {
        return this.usuActivo;
    }
    
    public void setUsuActivo(String usuActivo) {
        this.usuActivo = usuActivo;
    }

    
    @Column(name="USU_USERNAME", length=80)
    public String getUsuUsername() {
        return this.usuUsername;
    }
    
    public void setUsuUsername(String usuUsername) {
        this.usuUsername = usuUsername;
    }

    
    @Column(name="USU_PASSWORD", length=80)
    public String getUsuPassword() {
        return this.usuPassword;
    }
    
    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    
    @Column(name="USU_COD", precision=22, scale=0)
    public BigDecimal getUsuCod() {
        return this.usuCod;
    }
    
    public void setUsuCod(BigDecimal usuCod) {
        this.usuCod = usuCod;
    }

    
    @Column(name="USU_ENVIO_MAIL", precision=22, scale=0)
    public BigDecimal getUsuEnvioMail() {
        return this.usuEnvioMail;
    }
    
    public void setUsuEnvioMail(BigDecimal usuEnvioMail) {
        this.usuEnvioMail = usuEnvioMail;
    }

    
    @Column(name="USU_ULT_FECHA_ENVIO_MAIL", length=50)
    public String getUsuUltFechaEnvioMail() {
        return this.usuUltFechaEnvioMail;
    }
    
    public void setUsuUltFechaEnvioMail(String usuUltFechaEnvioMail) {
        this.usuUltFechaEnvioMail = usuUltFechaEnvioMail;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdsUsuarioUgda")
    public Set<TdsRolUsuarioUgda> getTdsRolUsuarioUgdas() {
        return this.tdsRolUsuarioUgdas;
    }
    
    public void setTdsRolUsuarioUgdas(Set<TdsRolUsuarioUgda> tdsRolUsuarioUgdas) {
        this.tdsRolUsuarioUgdas = tdsRolUsuarioUgdas;
    }




}



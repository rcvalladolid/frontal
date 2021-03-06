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
import javax.persistence.UniqueConstraint;

/**
 * TdiGlosario generated by hbm2java
 */
@Entity
@Table(name="TDI_GLOSARIO"
    ,schema="ESQ_SIEC"
    , uniqueConstraints = {@UniqueConstraint(columnNames={"DIC_CODIGO_GRUPO", "DIC_CODIGO"}), @UniqueConstraint(columnNames="DIC_CODIGO")} 
)
public class TdiGlosario  implements java.io.Serializable {


     private BigDecimal dicId;
     private TdiGlosario tdiGlosario;
     private String dicCodigo;
     private String dicCodigoGrupo;
     private String dicNombre;
     private char dicEstado;
     private BigDecimal dicEquiNsga;
     private String dicDescripcion;
     private BigDecimal faId;
     private String dicTablaNsga;
     private BigDecimal dicEquiSga;
     private String dicTablaSga;
     private String dicCodigoSniese;
     private BigDecimal dicPeso;
     private BigDecimal dicEquiIdSiac;
     private String dicTablaSiac;
     private Date dicFechaCreacionSiec;
     private Set<TdiCentroUniversitario> tdiCentroUniversitariosForCuIdProvincia = new HashSet<TdiCentroUniversitario>(0);
     private Set<TheActividadesDocEvaDet> theActividadesDocEvaDets = new HashSet<TheActividadesDocEvaDet>(0);
     private Set<TdiOfertaNsga> tdiOfertaNsgasForOnsEtiquetaOferta = new HashSet<TdiOfertaNsga>(0);
     private Set<TheActividadesEvaAvance> theActividadesEvaAvances = new HashSet<TheActividadesEvaAvance>(0);
     private Set<TdiCentroUniversitario> tdiCentroUniversitariosForCuTipoSede = new HashSet<TdiCentroUniversitario>(0);
     private Set<TdiCriteriosEvaluacion> tdiCriteriosEvaluacions = new HashSet<TdiCriteriosEvaluacion>(0);
     private Set<TevaMicrovideos> tevaMicrovideoses = new HashSet<TevaMicrovideos>(0);
     private Set<TdiOfertaNsga> tdiOfertaNsgasForOnsParalelo = new HashSet<TdiOfertaNsga>(0);
     private Set<TdiDocente> tdiDocentesForDoTipoIdentificacion = new HashSet<TdiDocente>(0);
     private Set<TdiGlosario> tdiGlosarios = new HashSet<TdiGlosario>(0);
     private Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs = new HashSet<TheActividadesDocEvaCab>(0);
     private Set<TdiDocente> tdiDocentesForDoNacionalidad = new HashSet<TdiDocente>(0);
     private Set<TdiCentroUniversitario> tdiCentroUniversitariosForCuTipoCentro = new HashSet<TdiCentroUniversitario>(0);

    public TdiGlosario() {
    }

	
    public TdiGlosario(BigDecimal dicId, String dicCodigo, String dicCodigoGrupo, String dicNombre, char dicEstado) {
        this.dicId = dicId;
        this.dicCodigo = dicCodigo;
        this.dicCodigoGrupo = dicCodigoGrupo;
        this.dicNombre = dicNombre;
        this.dicEstado = dicEstado;
    }
    public TdiGlosario(BigDecimal dicId, TdiGlosario tdiGlosario, String dicCodigo, String dicCodigoGrupo, String dicNombre, char dicEstado, BigDecimal dicEquiNsga, String dicDescripcion, BigDecimal faId, String dicTablaNsga, BigDecimal dicEquiSga, String dicTablaSga, String dicCodigoSniese, BigDecimal dicPeso, BigDecimal dicEquiIdSiac, String dicTablaSiac, Date dicFechaCreacionSiec, Set<TdiCentroUniversitario> tdiCentroUniversitariosForCuIdProvincia, Set<TheActividadesDocEvaDet> theActividadesDocEvaDets, Set<TdiOfertaNsga> tdiOfertaNsgasForOnsEtiquetaOferta, Set<TheActividadesEvaAvance> theActividadesEvaAvances, Set<TdiCentroUniversitario> tdiCentroUniversitariosForCuTipoSede, Set<TdiCriteriosEvaluacion> tdiCriteriosEvaluacions, Set<TevaMicrovideos> tevaMicrovideoses, Set<TdiOfertaNsga> tdiOfertaNsgasForOnsParalelo, Set<TdiDocente> tdiDocentesForDoTipoIdentificacion, Set<TdiGlosario> tdiGlosarios, Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs, Set<TdiDocente> tdiDocentesForDoNacionalidad, Set<TdiCentroUniversitario> tdiCentroUniversitariosForCuTipoCentro) {
       this.dicId = dicId;
       this.tdiGlosario = tdiGlosario;
       this.dicCodigo = dicCodigo;
       this.dicCodigoGrupo = dicCodigoGrupo;
       this.dicNombre = dicNombre;
       this.dicEstado = dicEstado;
       this.dicEquiNsga = dicEquiNsga;
       this.dicDescripcion = dicDescripcion;
       this.faId = faId;
       this.dicTablaNsga = dicTablaNsga;
       this.dicEquiSga = dicEquiSga;
       this.dicTablaSga = dicTablaSga;
       this.dicCodigoSniese = dicCodigoSniese;
       this.dicPeso = dicPeso;
       this.dicEquiIdSiac = dicEquiIdSiac;
       this.dicTablaSiac = dicTablaSiac;
       this.dicFechaCreacionSiec = dicFechaCreacionSiec;
       this.tdiCentroUniversitariosForCuIdProvincia = tdiCentroUniversitariosForCuIdProvincia;
       this.theActividadesDocEvaDets = theActividadesDocEvaDets;
       this.tdiOfertaNsgasForOnsEtiquetaOferta = tdiOfertaNsgasForOnsEtiquetaOferta;
       this.theActividadesEvaAvances = theActividadesEvaAvances;
       this.tdiCentroUniversitariosForCuTipoSede = tdiCentroUniversitariosForCuTipoSede;
       this.tdiCriteriosEvaluacions = tdiCriteriosEvaluacions;
       this.tevaMicrovideoses = tevaMicrovideoses;
       this.tdiOfertaNsgasForOnsParalelo = tdiOfertaNsgasForOnsParalelo;
       this.tdiDocentesForDoTipoIdentificacion = tdiDocentesForDoTipoIdentificacion;
       this.tdiGlosarios = tdiGlosarios;
       this.theActividadesDocEvaCabs = theActividadesDocEvaCabs;
       this.tdiDocentesForDoNacionalidad = tdiDocentesForDoNacionalidad;
       this.tdiCentroUniversitariosForCuTipoCentro = tdiCentroUniversitariosForCuTipoCentro;
    }
   
     @Id 

    
    @Column(name="DIC_ID", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getDicId() {
        return this.dicId;
    }
    
    public void setDicId(BigDecimal dicId) {
        this.dicId = dicId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DIC_PADRE")
    public TdiGlosario getTdiGlosario() {
        return this.tdiGlosario;
    }
    
    public void setTdiGlosario(TdiGlosario tdiGlosario) {
        this.tdiGlosario = tdiGlosario;
    }

    
    @Column(name="DIC_CODIGO", unique=true, nullable=false, length=30)
    public String getDicCodigo() {
        return this.dicCodigo;
    }
    
    public void setDicCodigo(String dicCodigo) {
        this.dicCodigo = dicCodigo;
    }

    
    @Column(name="DIC_CODIGO_GRUPO", nullable=false, length=30)
    public String getDicCodigoGrupo() {
        return this.dicCodigoGrupo;
    }
    
    public void setDicCodigoGrupo(String dicCodigoGrupo) {
        this.dicCodigoGrupo = dicCodigoGrupo;
    }

    
    @Column(name="DIC_NOMBRE", nullable=false, length=500)
    public String getDicNombre() {
        return this.dicNombre;
    }
    
    public void setDicNombre(String dicNombre) {
        this.dicNombre = dicNombre;
    }

    
    @Column(name="DIC_ESTADO", nullable=false, length=1)
    public char getDicEstado() {
        return this.dicEstado;
    }
    
    public void setDicEstado(char dicEstado) {
        this.dicEstado = dicEstado;
    }

    
    @Column(name="DIC_EQUI_NSGA", precision=22, scale=0)
    public BigDecimal getDicEquiNsga() {
        return this.dicEquiNsga;
    }
    
    public void setDicEquiNsga(BigDecimal dicEquiNsga) {
        this.dicEquiNsga = dicEquiNsga;
    }

    
    @Column(name="DIC_DESCRIPCION", length=1000)
    public String getDicDescripcion() {
        return this.dicDescripcion;
    }
    
    public void setDicDescripcion(String dicDescripcion) {
        this.dicDescripcion = dicDescripcion;
    }

    
    @Column(name="FA_ID", precision=22, scale=0)
    public BigDecimal getFaId() {
        return this.faId;
    }
    
    public void setFaId(BigDecimal faId) {
        this.faId = faId;
    }

    
    @Column(name="DIC_TABLA_NSGA", length=40)
    public String getDicTablaNsga() {
        return this.dicTablaNsga;
    }
    
    public void setDicTablaNsga(String dicTablaNsga) {
        this.dicTablaNsga = dicTablaNsga;
    }

    
    @Column(name="DIC_EQUI_SGA", precision=22, scale=0)
    public BigDecimal getDicEquiSga() {
        return this.dicEquiSga;
    }
    
    public void setDicEquiSga(BigDecimal dicEquiSga) {
        this.dicEquiSga = dicEquiSga;
    }

    
    @Column(name="DIC_TABLA_SGA", length=40)
    public String getDicTablaSga() {
        return this.dicTablaSga;
    }
    
    public void setDicTablaSga(String dicTablaSga) {
        this.dicTablaSga = dicTablaSga;
    }

    
    @Column(name="DIC_CODIGO_SNIESE", length=10)
    public String getDicCodigoSniese() {
        return this.dicCodigoSniese;
    }
    
    public void setDicCodigoSniese(String dicCodigoSniese) {
        this.dicCodigoSniese = dicCodigoSniese;
    }

    
    @Column(name="DIC_PESO", precision=22, scale=0)
    public BigDecimal getDicPeso() {
        return this.dicPeso;
    }
    
    public void setDicPeso(BigDecimal dicPeso) {
        this.dicPeso = dicPeso;
    }

    
    @Column(name="DIC_EQUI_ID_SIAC", precision=22, scale=0)
    public BigDecimal getDicEquiIdSiac() {
        return this.dicEquiIdSiac;
    }
    
    public void setDicEquiIdSiac(BigDecimal dicEquiIdSiac) {
        this.dicEquiIdSiac = dicEquiIdSiac;
    }

    
    @Column(name="DIC_TABLA_SIAC", length=100)
    public String getDicTablaSiac() {
        return this.dicTablaSiac;
    }
    
    public void setDicTablaSiac(String dicTablaSiac) {
        this.dicTablaSiac = dicTablaSiac;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DIC_FECHA_CREACION_SIEC", length=7)
    public Date getDicFechaCreacionSiec() {
        return this.dicFechaCreacionSiec;
    }
    
    public void setDicFechaCreacionSiec(Date dicFechaCreacionSiec) {
        this.dicFechaCreacionSiec = dicFechaCreacionSiec;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosarioByCuIdProvincia")
    public Set<TdiCentroUniversitario> getTdiCentroUniversitariosForCuIdProvincia() {
        return this.tdiCentroUniversitariosForCuIdProvincia;
    }
    
    public void setTdiCentroUniversitariosForCuIdProvincia(Set<TdiCentroUniversitario> tdiCentroUniversitariosForCuIdProvincia) {
        this.tdiCentroUniversitariosForCuIdProvincia = tdiCentroUniversitariosForCuIdProvincia;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosario")
    public Set<TheActividadesDocEvaDet> getTheActividadesDocEvaDets() {
        return this.theActividadesDocEvaDets;
    }
    
    public void setTheActividadesDocEvaDets(Set<TheActividadesDocEvaDet> theActividadesDocEvaDets) {
        this.theActividadesDocEvaDets = theActividadesDocEvaDets;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosarioByOnsEtiquetaOferta")
    public Set<TdiOfertaNsga> getTdiOfertaNsgasForOnsEtiquetaOferta() {
        return this.tdiOfertaNsgasForOnsEtiquetaOferta;
    }
    
    public void setTdiOfertaNsgasForOnsEtiquetaOferta(Set<TdiOfertaNsga> tdiOfertaNsgasForOnsEtiquetaOferta) {
        this.tdiOfertaNsgasForOnsEtiquetaOferta = tdiOfertaNsgasForOnsEtiquetaOferta;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosario")
    public Set<TheActividadesEvaAvance> getTheActividadesEvaAvances() {
        return this.theActividadesEvaAvances;
    }
    
    public void setTheActividadesEvaAvances(Set<TheActividadesEvaAvance> theActividadesEvaAvances) {
        this.theActividadesEvaAvances = theActividadesEvaAvances;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosarioByCuTipoSede")
    public Set<TdiCentroUniversitario> getTdiCentroUniversitariosForCuTipoSede() {
        return this.tdiCentroUniversitariosForCuTipoSede;
    }
    
    public void setTdiCentroUniversitariosForCuTipoSede(Set<TdiCentroUniversitario> tdiCentroUniversitariosForCuTipoSede) {
        this.tdiCentroUniversitariosForCuTipoSede = tdiCentroUniversitariosForCuTipoSede;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosario")
    public Set<TdiCriteriosEvaluacion> getTdiCriteriosEvaluacions() {
        return this.tdiCriteriosEvaluacions;
    }
    
    public void setTdiCriteriosEvaluacions(Set<TdiCriteriosEvaluacion> tdiCriteriosEvaluacions) {
        this.tdiCriteriosEvaluacions = tdiCriteriosEvaluacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosario")
    public Set<TevaMicrovideos> getTevaMicrovideoses() {
        return this.tevaMicrovideoses;
    }
    
    public void setTevaMicrovideoses(Set<TevaMicrovideos> tevaMicrovideoses) {
        this.tevaMicrovideoses = tevaMicrovideoses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosarioByOnsParalelo")
    public Set<TdiOfertaNsga> getTdiOfertaNsgasForOnsParalelo() {
        return this.tdiOfertaNsgasForOnsParalelo;
    }
    
    public void setTdiOfertaNsgasForOnsParalelo(Set<TdiOfertaNsga> tdiOfertaNsgasForOnsParalelo) {
        this.tdiOfertaNsgasForOnsParalelo = tdiOfertaNsgasForOnsParalelo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosarioByDoTipoIdentificacion")
    public Set<TdiDocente> getTdiDocentesForDoTipoIdentificacion() {
        return this.tdiDocentesForDoTipoIdentificacion;
    }
    
    public void setTdiDocentesForDoTipoIdentificacion(Set<TdiDocente> tdiDocentesForDoTipoIdentificacion) {
        this.tdiDocentesForDoTipoIdentificacion = tdiDocentesForDoTipoIdentificacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosario")
    public Set<TdiGlosario> getTdiGlosarios() {
        return this.tdiGlosarios;
    }
    
    public void setTdiGlosarios(Set<TdiGlosario> tdiGlosarios) {
        this.tdiGlosarios = tdiGlosarios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosario")
    public Set<TheActividadesDocEvaCab> getTheActividadesDocEvaCabs() {
        return this.theActividadesDocEvaCabs;
    }
    
    public void setTheActividadesDocEvaCabs(Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs) {
        this.theActividadesDocEvaCabs = theActividadesDocEvaCabs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosarioByDoNacionalidad")
    public Set<TdiDocente> getTdiDocentesForDoNacionalidad() {
        return this.tdiDocentesForDoNacionalidad;
    }
    
    public void setTdiDocentesForDoNacionalidad(Set<TdiDocente> tdiDocentesForDoNacionalidad) {
        this.tdiDocentesForDoNacionalidad = tdiDocentesForDoNacionalidad;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiGlosarioByCuTipoCentro")
    public Set<TdiCentroUniversitario> getTdiCentroUniversitariosForCuTipoCentro() {
        return this.tdiCentroUniversitariosForCuTipoCentro;
    }
    
    public void setTdiCentroUniversitariosForCuTipoCentro(Set<TdiCentroUniversitario> tdiCentroUniversitariosForCuTipoCentro) {
        this.tdiCentroUniversitariosForCuTipoCentro = tdiCentroUniversitariosForCuTipoCentro;
    }




}



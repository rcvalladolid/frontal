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
 * TdiPeriodo generated by hbm2java
 */
@Entity
@Table(name="TDI_PERIODO"
    ,schema="ESQ_SIEC"
)
public class TdiPeriodo  implements java.io.Serializable {


     private BigDecimal peId;
     private TdiPeriodo tdiPeriodo;
     private TdsUsuario tdsUsuario;
     private String peNombre;
     private BigDecimal peEquIdNsga;
     private String peEquNombreNsga;
     private BigDecimal peEquIdSga;
     private String peEquNombreSga;
     private BigDecimal peEquIdPdo;
     private String peEquNombrePdo;
     private BigDecimal peEquIdSica;
     private String peEquNombreSica;
     private BigDecimal peEquIdEva;
     private String peEquNombreEva;
     private String peVigente;
     private Date peFechaInicioVig;
     private Date peFechaFinVig;
     private BigDecimal peAnio;
     private Date peFechaIniVigSiec;
     private Date peFechaFinVigSiec;
     private String peCodigoSiec;
     private String peValidado;
     private BigDecimal peEquIdSgaOtro;
     private String peMad;
     private String peActivoSiec;
     private BigDecimal peRetencionInicial;
     private String peGuidNsga;
     private BigDecimal peOrdenPreg;
     private BigDecimal peOrdenPosgrado;
     private BigDecimal peOrdenPeriodo;
     private BigDecimal pePerteneceAPeriodoPos;
     private String peEjecutaBatch;
     private BigDecimal peIdOficial;
     private String pePeriodosContiene;
     private String peEsPeriodoExtraordinario;
     private String peActivoCargaExcel;
     private String peSoloProcesosInternos;
     private String peEsPeriodoOficial;
     private String peEficienciaTerminal;
     private String peActivoAdmDisSiec;
     private BigDecimal peValidacionDistributivo;
     private String peNombrePeriodoOficial;
     private String pePeriodoOrdinario;
     private Set<TdiRangosSemaforo> tdiRangosSemaforos = new HashSet<TdiRangosSemaforo>(0);
     private Set<TheActividadesDocEvaDet> theActividadesDocEvaDets = new HashSet<TheActividadesDocEvaDet>(0);
     private Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs = new HashSet<TheActividadesDocEvaCab>(0);
     private Set<TdiPeriodoDetalle> tdiPeriodoDetalles = new HashSet<TdiPeriodoDetalle>(0);
     private Set<TevaMicrovideos> tevaMicrovideoses = new HashSet<TevaMicrovideos>(0);
     private Set<TheActividadesEvaAvance> theActividadesEvaAvances = new HashSet<TheActividadesEvaAvance>(0);
     private Set<TdiOfertaNsga> tdiOfertaNsgas = new HashSet<TdiOfertaNsga>(0);
     private Set<TdiPeriodo> tdiPeriodos = new HashSet<TdiPeriodo>(0);

    public TdiPeriodo() {
    }

	
    public TdiPeriodo(BigDecimal peId, String peNombre, String peVigente, Date peFechaInicioVig, BigDecimal peAnio, Date peFechaIniVigSiec, Date peFechaFinVigSiec, String peCodigoSiec, String peSoloProcesosInternos) {
        this.peId = peId;
        this.peNombre = peNombre;
        this.peVigente = peVigente;
        this.peFechaInicioVig = peFechaInicioVig;
        this.peAnio = peAnio;
        this.peFechaIniVigSiec = peFechaIniVigSiec;
        this.peFechaFinVigSiec = peFechaFinVigSiec;
        this.peCodigoSiec = peCodigoSiec;
        this.peSoloProcesosInternos = peSoloProcesosInternos;
    }
    public TdiPeriodo(BigDecimal peId, TdiPeriodo tdiPeriodo, TdsUsuario tdsUsuario, String peNombre, BigDecimal peEquIdNsga, String peEquNombreNsga, BigDecimal peEquIdSga, String peEquNombreSga, BigDecimal peEquIdPdo, String peEquNombrePdo, BigDecimal peEquIdSica, String peEquNombreSica, BigDecimal peEquIdEva, String peEquNombreEva, String peVigente, Date peFechaInicioVig, Date peFechaFinVig, BigDecimal peAnio, Date peFechaIniVigSiec, Date peFechaFinVigSiec, String peCodigoSiec, String peValidado, BigDecimal peEquIdSgaOtro, String peMad, String peActivoSiec, BigDecimal peRetencionInicial, String peGuidNsga, BigDecimal peOrdenPreg, BigDecimal peOrdenPosgrado, BigDecimal peOrdenPeriodo, BigDecimal pePerteneceAPeriodoPos, String peEjecutaBatch, BigDecimal peIdOficial, String pePeriodosContiene, String peEsPeriodoExtraordinario, String peActivoCargaExcel, String peSoloProcesosInternos, String peEsPeriodoOficial, String peEficienciaTerminal, String peActivoAdmDisSiec, BigDecimal peValidacionDistributivo, String peNombrePeriodoOficial, String pePeriodoOrdinario, Set<TdiRangosSemaforo> tdiRangosSemaforos, Set<TheActividadesDocEvaDet> theActividadesDocEvaDets, Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs, Set<TdiPeriodoDetalle> tdiPeriodoDetalles, Set<TevaMicrovideos> tevaMicrovideoses, Set<TheActividadesEvaAvance> theActividadesEvaAvances, Set<TdiOfertaNsga> tdiOfertaNsgas, Set<TdiPeriodo> tdiPeriodos) {
       this.peId = peId;
       this.tdiPeriodo = tdiPeriodo;
       this.tdsUsuario = tdsUsuario;
       this.peNombre = peNombre;
       this.peEquIdNsga = peEquIdNsga;
       this.peEquNombreNsga = peEquNombreNsga;
       this.peEquIdSga = peEquIdSga;
       this.peEquNombreSga = peEquNombreSga;
       this.peEquIdPdo = peEquIdPdo;
       this.peEquNombrePdo = peEquNombrePdo;
       this.peEquIdSica = peEquIdSica;
       this.peEquNombreSica = peEquNombreSica;
       this.peEquIdEva = peEquIdEva;
       this.peEquNombreEva = peEquNombreEva;
       this.peVigente = peVigente;
       this.peFechaInicioVig = peFechaInicioVig;
       this.peFechaFinVig = peFechaFinVig;
       this.peAnio = peAnio;
       this.peFechaIniVigSiec = peFechaIniVigSiec;
       this.peFechaFinVigSiec = peFechaFinVigSiec;
       this.peCodigoSiec = peCodigoSiec;
       this.peValidado = peValidado;
       this.peEquIdSgaOtro = peEquIdSgaOtro;
       this.peMad = peMad;
       this.peActivoSiec = peActivoSiec;
       this.peRetencionInicial = peRetencionInicial;
       this.peGuidNsga = peGuidNsga;
       this.peOrdenPreg = peOrdenPreg;
       this.peOrdenPosgrado = peOrdenPosgrado;
       this.peOrdenPeriodo = peOrdenPeriodo;
       this.pePerteneceAPeriodoPos = pePerteneceAPeriodoPos;
       this.peEjecutaBatch = peEjecutaBatch;
       this.peIdOficial = peIdOficial;
       this.pePeriodosContiene = pePeriodosContiene;
       this.peEsPeriodoExtraordinario = peEsPeriodoExtraordinario;
       this.peActivoCargaExcel = peActivoCargaExcel;
       this.peSoloProcesosInternos = peSoloProcesosInternos;
       this.peEsPeriodoOficial = peEsPeriodoOficial;
       this.peEficienciaTerminal = peEficienciaTerminal;
       this.peActivoAdmDisSiec = peActivoAdmDisSiec;
       this.peValidacionDistributivo = peValidacionDistributivo;
       this.peNombrePeriodoOficial = peNombrePeriodoOficial;
       this.pePeriodoOrdinario = pePeriodoOrdinario;
       this.tdiRangosSemaforos = tdiRangosSemaforos;
       this.theActividadesDocEvaDets = theActividadesDocEvaDets;
       this.theActividadesDocEvaCabs = theActividadesDocEvaCabs;
       this.tdiPeriodoDetalles = tdiPeriodoDetalles;
       this.tevaMicrovideoses = tevaMicrovideoses;
       this.theActividadesEvaAvances = theActividadesEvaAvances;
       this.tdiOfertaNsgas = tdiOfertaNsgas;
       this.tdiPeriodos = tdiPeriodos;
    }
   
     @Id 

    
    @Column(name="PE_ID", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPeId() {
        return this.peId;
    }
    
    public void setPeId(BigDecimal peId) {
        this.peId = peId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PE_PERTENECE_A_PERIODO_PRE")
    public TdiPeriodo getTdiPeriodo() {
        return this.tdiPeriodo;
    }
    
    public void setTdiPeriodo(TdiPeriodo tdiPeriodo) {
        this.tdiPeriodo = tdiPeriodo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="US_ID")
    public TdsUsuario getTdsUsuario() {
        return this.tdsUsuario;
    }
    
    public void setTdsUsuario(TdsUsuario tdsUsuario) {
        this.tdsUsuario = tdsUsuario;
    }

    
    @Column(name="PE_NOMBRE", nullable=false, length=50)
    public String getPeNombre() {
        return this.peNombre;
    }
    
    public void setPeNombre(String peNombre) {
        this.peNombre = peNombre;
    }

    
    @Column(name="PE_EQU_ID_NSGA", precision=22, scale=0)
    public BigDecimal getPeEquIdNsga() {
        return this.peEquIdNsga;
    }
    
    public void setPeEquIdNsga(BigDecimal peEquIdNsga) {
        this.peEquIdNsga = peEquIdNsga;
    }

    
    @Column(name="PE_EQU_NOMBRE_NSGA", length=100)
    public String getPeEquNombreNsga() {
        return this.peEquNombreNsga;
    }
    
    public void setPeEquNombreNsga(String peEquNombreNsga) {
        this.peEquNombreNsga = peEquNombreNsga;
    }

    
    @Column(name="PE_EQU_ID_SGA", precision=22, scale=0)
    public BigDecimal getPeEquIdSga() {
        return this.peEquIdSga;
    }
    
    public void setPeEquIdSga(BigDecimal peEquIdSga) {
        this.peEquIdSga = peEquIdSga;
    }

    
    @Column(name="PE_EQU_NOMBRE_SGA", length=100)
    public String getPeEquNombreSga() {
        return this.peEquNombreSga;
    }
    
    public void setPeEquNombreSga(String peEquNombreSga) {
        this.peEquNombreSga = peEquNombreSga;
    }

    
    @Column(name="PE_EQU_ID_PDO", precision=22, scale=0)
    public BigDecimal getPeEquIdPdo() {
        return this.peEquIdPdo;
    }
    
    public void setPeEquIdPdo(BigDecimal peEquIdPdo) {
        this.peEquIdPdo = peEquIdPdo;
    }

    
    @Column(name="PE_EQU_NOMBRE_PDO", length=100)
    public String getPeEquNombrePdo() {
        return this.peEquNombrePdo;
    }
    
    public void setPeEquNombrePdo(String peEquNombrePdo) {
        this.peEquNombrePdo = peEquNombrePdo;
    }

    
    @Column(name="PE_EQU_ID_SICA", precision=22, scale=0)
    public BigDecimal getPeEquIdSica() {
        return this.peEquIdSica;
    }
    
    public void setPeEquIdSica(BigDecimal peEquIdSica) {
        this.peEquIdSica = peEquIdSica;
    }

    
    @Column(name="PE_EQU_NOMBRE_SICA", length=100)
    public String getPeEquNombreSica() {
        return this.peEquNombreSica;
    }
    
    public void setPeEquNombreSica(String peEquNombreSica) {
        this.peEquNombreSica = peEquNombreSica;
    }

    
    @Column(name="PE_EQU_ID_EVA", precision=22, scale=0)
    public BigDecimal getPeEquIdEva() {
        return this.peEquIdEva;
    }
    
    public void setPeEquIdEva(BigDecimal peEquIdEva) {
        this.peEquIdEva = peEquIdEva;
    }

    
    @Column(name="PE_EQU_NOMBRE_EVA", length=100)
    public String getPeEquNombreEva() {
        return this.peEquNombreEva;
    }
    
    public void setPeEquNombreEva(String peEquNombreEva) {
        this.peEquNombreEva = peEquNombreEva;
    }

    
    @Column(name="PE_VIGENTE", nullable=false, length=2)
    public String getPeVigente() {
        return this.peVigente;
    }
    
    public void setPeVigente(String peVigente) {
        this.peVigente = peVigente;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PE_FECHA_INICIO_VIG", nullable=false, length=7)
    public Date getPeFechaInicioVig() {
        return this.peFechaInicioVig;
    }
    
    public void setPeFechaInicioVig(Date peFechaInicioVig) {
        this.peFechaInicioVig = peFechaInicioVig;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PE_FECHA_FIN_VIG", length=7)
    public Date getPeFechaFinVig() {
        return this.peFechaFinVig;
    }
    
    public void setPeFechaFinVig(Date peFechaFinVig) {
        this.peFechaFinVig = peFechaFinVig;
    }

    
    @Column(name="PE_ANIO", nullable=false, precision=22, scale=0)
    public BigDecimal getPeAnio() {
        return this.peAnio;
    }
    
    public void setPeAnio(BigDecimal peAnio) {
        this.peAnio = peAnio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PE_FECHA_INI_VIG_SIEC", nullable=false, length=7)
    public Date getPeFechaIniVigSiec() {
        return this.peFechaIniVigSiec;
    }
    
    public void setPeFechaIniVigSiec(Date peFechaIniVigSiec) {
        this.peFechaIniVigSiec = peFechaIniVigSiec;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PE_FECHA_FIN_VIG_SIEC", nullable=false, length=7)
    public Date getPeFechaFinVigSiec() {
        return this.peFechaFinVigSiec;
    }
    
    public void setPeFechaFinVigSiec(Date peFechaFinVigSiec) {
        this.peFechaFinVigSiec = peFechaFinVigSiec;
    }

    
    @Column(name="PE_CODIGO_SIEC", nullable=false, length=30)
    public String getPeCodigoSiec() {
        return this.peCodigoSiec;
    }
    
    public void setPeCodigoSiec(String peCodigoSiec) {
        this.peCodigoSiec = peCodigoSiec;
    }

    
    @Column(name="PE_VALIDADO", length=1)
    public String getPeValidado() {
        return this.peValidado;
    }
    
    public void setPeValidado(String peValidado) {
        this.peValidado = peValidado;
    }

    
    @Column(name="PE_EQU_ID_SGA_OTRO", precision=22, scale=0)
    public BigDecimal getPeEquIdSgaOtro() {
        return this.peEquIdSgaOtro;
    }
    
    public void setPeEquIdSgaOtro(BigDecimal peEquIdSgaOtro) {
        this.peEquIdSgaOtro = peEquIdSgaOtro;
    }

    
    @Column(name="PE_MAD", length=8)
    public String getPeMad() {
        return this.peMad;
    }
    
    public void setPeMad(String peMad) {
        this.peMad = peMad;
    }

    
    @Column(name="PE_ACTIVO_SIEC", length=1)
    public String getPeActivoSiec() {
        return this.peActivoSiec;
    }
    
    public void setPeActivoSiec(String peActivoSiec) {
        this.peActivoSiec = peActivoSiec;
    }

    
    @Column(name="PE_RETENCION_INICIAL", precision=22, scale=0)
    public BigDecimal getPeRetencionInicial() {
        return this.peRetencionInicial;
    }
    
    public void setPeRetencionInicial(BigDecimal peRetencionInicial) {
        this.peRetencionInicial = peRetencionInicial;
    }

    
    @Column(name="PE_GUID_NSGA", length=100)
    public String getPeGuidNsga() {
        return this.peGuidNsga;
    }
    
    public void setPeGuidNsga(String peGuidNsga) {
        this.peGuidNsga = peGuidNsga;
    }

    
    @Column(name="PE_ORDEN_PREG", precision=22, scale=0)
    public BigDecimal getPeOrdenPreg() {
        return this.peOrdenPreg;
    }
    
    public void setPeOrdenPreg(BigDecimal peOrdenPreg) {
        this.peOrdenPreg = peOrdenPreg;
    }

    
    @Column(name="PE_ORDEN_POSGRADO", precision=22, scale=0)
    public BigDecimal getPeOrdenPosgrado() {
        return this.peOrdenPosgrado;
    }
    
    public void setPeOrdenPosgrado(BigDecimal peOrdenPosgrado) {
        this.peOrdenPosgrado = peOrdenPosgrado;
    }

    
    @Column(name="PE_ORDEN_PERIODO", precision=22, scale=0)
    public BigDecimal getPeOrdenPeriodo() {
        return this.peOrdenPeriodo;
    }
    
    public void setPeOrdenPeriodo(BigDecimal peOrdenPeriodo) {
        this.peOrdenPeriodo = peOrdenPeriodo;
    }

    
    @Column(name="PE_PERTENECE_A_PERIODO_POS", precision=22, scale=0)
    public BigDecimal getPePerteneceAPeriodoPos() {
        return this.pePerteneceAPeriodoPos;
    }
    
    public void setPePerteneceAPeriodoPos(BigDecimal pePerteneceAPeriodoPos) {
        this.pePerteneceAPeriodoPos = pePerteneceAPeriodoPos;
    }

    
    @Column(name="PE_EJECUTA_BATCH", length=1)
    public String getPeEjecutaBatch() {
        return this.peEjecutaBatch;
    }
    
    public void setPeEjecutaBatch(String peEjecutaBatch) {
        this.peEjecutaBatch = peEjecutaBatch;
    }

    
    @Column(name="PE_ID_OFICIAL", precision=22, scale=0)
    public BigDecimal getPeIdOficial() {
        return this.peIdOficial;
    }
    
    public void setPeIdOficial(BigDecimal peIdOficial) {
        this.peIdOficial = peIdOficial;
    }

    
    @Column(name="PE_PERIODOS_CONTIENE", length=25)
    public String getPePeriodosContiene() {
        return this.pePeriodosContiene;
    }
    
    public void setPePeriodosContiene(String pePeriodosContiene) {
        this.pePeriodosContiene = pePeriodosContiene;
    }

    
    @Column(name="PE_ES_PERIODO_EXTRAORDINARIO", length=1)
    public String getPeEsPeriodoExtraordinario() {
        return this.peEsPeriodoExtraordinario;
    }
    
    public void setPeEsPeriodoExtraordinario(String peEsPeriodoExtraordinario) {
        this.peEsPeriodoExtraordinario = peEsPeriodoExtraordinario;
    }

    
    @Column(name="PE_ACTIVO_CARGA_EXCEL", length=1)
    public String getPeActivoCargaExcel() {
        return this.peActivoCargaExcel;
    }
    
    public void setPeActivoCargaExcel(String peActivoCargaExcel) {
        this.peActivoCargaExcel = peActivoCargaExcel;
    }

    
    @Column(name="PE_SOLO_PROCESOS_INTERNOS", nullable=false, length=1)
    public String getPeSoloProcesosInternos() {
        return this.peSoloProcesosInternos;
    }
    
    public void setPeSoloProcesosInternos(String peSoloProcesosInternos) {
        this.peSoloProcesosInternos = peSoloProcesosInternos;
    }

    
    @Column(name="PE_ES_PERIODO_OFICIAL", length=1)
    public String getPeEsPeriodoOficial() {
        return this.peEsPeriodoOficial;
    }
    
    public void setPeEsPeriodoOficial(String peEsPeriodoOficial) {
        this.peEsPeriodoOficial = peEsPeriodoOficial;
    }

    
    @Column(name="PE_EFICIENCIA_TERMINAL", length=1)
    public String getPeEficienciaTerminal() {
        return this.peEficienciaTerminal;
    }
    
    public void setPeEficienciaTerminal(String peEficienciaTerminal) {
        this.peEficienciaTerminal = peEficienciaTerminal;
    }

    
    @Column(name="PE_ACTIVO_ADM_DIS_SIEC", length=1)
    public String getPeActivoAdmDisSiec() {
        return this.peActivoAdmDisSiec;
    }
    
    public void setPeActivoAdmDisSiec(String peActivoAdmDisSiec) {
        this.peActivoAdmDisSiec = peActivoAdmDisSiec;
    }

    
    @Column(name="PE_VALIDACION_DISTRIBUTIVO", precision=22, scale=0)
    public BigDecimal getPeValidacionDistributivo() {
        return this.peValidacionDistributivo;
    }
    
    public void setPeValidacionDistributivo(BigDecimal peValidacionDistributivo) {
        this.peValidacionDistributivo = peValidacionDistributivo;
    }

    
    @Column(name="PE_NOMBRE_PERIODO_OFICIAL", length=120)
    public String getPeNombrePeriodoOficial() {
        return this.peNombrePeriodoOficial;
    }
    
    public void setPeNombrePeriodoOficial(String peNombrePeriodoOficial) {
        this.peNombrePeriodoOficial = peNombrePeriodoOficial;
    }

    
    @Column(name="PE_PERIODO_ORDINARIO", length=1)
    public String getPePeriodoOrdinario() {
        return this.pePeriodoOrdinario;
    }
    
    public void setPePeriodoOrdinario(String pePeriodoOrdinario) {
        this.pePeriodoOrdinario = pePeriodoOrdinario;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiPeriodo")
    public Set<TdiRangosSemaforo> getTdiRangosSemaforos() {
        return this.tdiRangosSemaforos;
    }
    
    public void setTdiRangosSemaforos(Set<TdiRangosSemaforo> tdiRangosSemaforos) {
        this.tdiRangosSemaforos = tdiRangosSemaforos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiPeriodo")
    public Set<TheActividadesDocEvaDet> getTheActividadesDocEvaDets() {
        return this.theActividadesDocEvaDets;
    }
    
    public void setTheActividadesDocEvaDets(Set<TheActividadesDocEvaDet> theActividadesDocEvaDets) {
        this.theActividadesDocEvaDets = theActividadesDocEvaDets;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiPeriodo")
    public Set<TheActividadesDocEvaCab> getTheActividadesDocEvaCabs() {
        return this.theActividadesDocEvaCabs;
    }
    
    public void setTheActividadesDocEvaCabs(Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs) {
        this.theActividadesDocEvaCabs = theActividadesDocEvaCabs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiPeriodo")
    public Set<TdiPeriodoDetalle> getTdiPeriodoDetalles() {
        return this.tdiPeriodoDetalles;
    }
    
    public void setTdiPeriodoDetalles(Set<TdiPeriodoDetalle> tdiPeriodoDetalles) {
        this.tdiPeriodoDetalles = tdiPeriodoDetalles;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiPeriodo")
    public Set<TevaMicrovideos> getTevaMicrovideoses() {
        return this.tevaMicrovideoses;
    }
    
    public void setTevaMicrovideoses(Set<TevaMicrovideos> tevaMicrovideoses) {
        this.tevaMicrovideoses = tevaMicrovideoses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiPeriodo")
    public Set<TheActividadesEvaAvance> getTheActividadesEvaAvances() {
        return this.theActividadesEvaAvances;
    }
    
    public void setTheActividadesEvaAvances(Set<TheActividadesEvaAvance> theActividadesEvaAvances) {
        this.theActividadesEvaAvances = theActividadesEvaAvances;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiPeriodo")
    public Set<TdiOfertaNsga> getTdiOfertaNsgas() {
        return this.tdiOfertaNsgas;
    }
    
    public void setTdiOfertaNsgas(Set<TdiOfertaNsga> tdiOfertaNsgas) {
        this.tdiOfertaNsgas = tdiOfertaNsgas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiPeriodo")
    public Set<TdiPeriodo> getTdiPeriodos() {
        return this.tdiPeriodos;
    }
    
    public void setTdiPeriodos(Set<TdiPeriodo> tdiPeriodos) {
        this.tdiPeriodos = tdiPeriodos;
    }




}



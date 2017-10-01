package ec.edu.utpl.svied.model;
// Generated 01/09/2017 12:34:01 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;

/**
 * TdiOfertaNsga generated by hbm2java
 */
@Entity
@Table(name="TDI_OFERTA_NSGA"
    ,schema="ESQ_SIEC"
    , uniqueConstraints = @UniqueConstraint(columnNames="OFD_ID_NSGA") 
)
public class TdiOfertaNsga  implements java.io.Serializable {


     private BigDecimal onsId;
     private TdiComponenteEducativo tdiComponenteEducativo;
     private TdiPeriodo tdiPeriodo;
     private TdiGlosario tdiGlosarioByOnsEtiquetaOferta;
     private TdiGlosario tdiGlosarioByOnsParalelo;
     private BigDecimal onsCupos;
     private BigDecimal onsOfertadoPor;
     private BigDecimal onsOfertanteId;
     private BigDecimal ofeIdNsga;
     private BigDecimal ofdIdNsga;
     private BigDecimal seIdCe;
     private BigDecimal moId;
     private String guidOfdIdNsga;
     private Set<TdiOfertaDocentesNsga> tdiOfertaDocentesNsgas = new HashSet<TdiOfertaDocentesNsga>(0);
     private Set<TheActividadesEvaAvance> theActividadesEvaAvances = new HashSet<TheActividadesEvaAvance>(0);
     private Set<TevaMicrovideos> tevaMicrovideoses = new HashSet<TevaMicrovideos>(0);
     private Set<TheActividadesDocEvaDet> theActividadesDocEvaDets = new HashSet<TheActividadesDocEvaDet>(0);
     private Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs = new HashSet<TheActividadesDocEvaCab>(0);

    public TdiOfertaNsga() {
    }

	
    public TdiOfertaNsga(BigDecimal onsId, TdiComponenteEducativo tdiComponenteEducativo, TdiPeriodo tdiPeriodo, TdiGlosario tdiGlosarioByOnsEtiquetaOferta, TdiGlosario tdiGlosarioByOnsParalelo, BigDecimal onsCupos, BigDecimal onsOfertadoPor, BigDecimal onsOfertanteId, BigDecimal ofeIdNsga, BigDecimal ofdIdNsga) {
        this.onsId = onsId;
        this.tdiComponenteEducativo = tdiComponenteEducativo;
        this.tdiPeriodo = tdiPeriodo;
        this.tdiGlosarioByOnsEtiquetaOferta = tdiGlosarioByOnsEtiquetaOferta;
        this.tdiGlosarioByOnsParalelo = tdiGlosarioByOnsParalelo;
        this.onsCupos = onsCupos;
        this.onsOfertadoPor = onsOfertadoPor;
        this.onsOfertanteId = onsOfertanteId;
        this.ofeIdNsga = ofeIdNsga;
        this.ofdIdNsga = ofdIdNsga;
    }
    public TdiOfertaNsga(BigDecimal onsId, TdiComponenteEducativo tdiComponenteEducativo, TdiPeriodo tdiPeriodo, TdiGlosario tdiGlosarioByOnsEtiquetaOferta, TdiGlosario tdiGlosarioByOnsParalelo, BigDecimal onsCupos, BigDecimal onsOfertadoPor, BigDecimal onsOfertanteId, BigDecimal ofeIdNsga, BigDecimal ofdIdNsga, BigDecimal seIdCe, BigDecimal moId, String guidOfdIdNsga, Set<TdiOfertaDocentesNsga> tdiOfertaDocentesNsgas, Set<TheActividadesEvaAvance> theActividadesEvaAvances, Set<TevaMicrovideos> tevaMicrovideoses, Set<TheActividadesDocEvaDet> theActividadesDocEvaDets, Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs) {
       this.onsId = onsId;
       this.tdiComponenteEducativo = tdiComponenteEducativo;
       this.tdiPeriodo = tdiPeriodo;
       this.tdiGlosarioByOnsEtiquetaOferta = tdiGlosarioByOnsEtiquetaOferta;
       this.tdiGlosarioByOnsParalelo = tdiGlosarioByOnsParalelo;
       this.onsCupos = onsCupos;
       this.onsOfertadoPor = onsOfertadoPor;
       this.onsOfertanteId = onsOfertanteId;
       this.ofeIdNsga = ofeIdNsga;
       this.ofdIdNsga = ofdIdNsga;
       this.seIdCe = seIdCe;
       this.moId = moId;
       this.guidOfdIdNsga = guidOfdIdNsga;
       this.tdiOfertaDocentesNsgas = tdiOfertaDocentesNsgas;
       this.theActividadesEvaAvances = theActividadesEvaAvances;
       this.tevaMicrovideoses = tevaMicrovideoses;
       this.theActividadesDocEvaDets = theActividadesDocEvaDets;
       this.theActividadesDocEvaCabs = theActividadesDocEvaCabs;
    }
   
     @Id 

    
    @Column(name="ONS_ID", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getOnsId() {
        return this.onsId;
    }
    
    public void setOnsId(BigDecimal onsId) {
        this.onsId = onsId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CE_ID", nullable=false)
    public TdiComponenteEducativo getTdiComponenteEducativo() {
        return this.tdiComponenteEducativo;
    }
    
    public void setTdiComponenteEducativo(TdiComponenteEducativo tdiComponenteEducativo) {
        this.tdiComponenteEducativo = tdiComponenteEducativo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PE_ID", nullable=false)
    public TdiPeriodo getTdiPeriodo() {
        return this.tdiPeriodo;
    }
    
    public void setTdiPeriodo(TdiPeriodo tdiPeriodo) {
        this.tdiPeriodo = tdiPeriodo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ONS_ETIQUETA_OFERTA", nullable=false)
    public TdiGlosario getTdiGlosarioByOnsEtiquetaOferta() {
        return this.tdiGlosarioByOnsEtiquetaOferta;
    }
    
    public void setTdiGlosarioByOnsEtiquetaOferta(TdiGlosario tdiGlosarioByOnsEtiquetaOferta) {
        this.tdiGlosarioByOnsEtiquetaOferta = tdiGlosarioByOnsEtiquetaOferta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ONS_PARALELO", nullable=false)
    public TdiGlosario getTdiGlosarioByOnsParalelo() {
        return this.tdiGlosarioByOnsParalelo;
    }
    
    public void setTdiGlosarioByOnsParalelo(TdiGlosario tdiGlosarioByOnsParalelo) {
        this.tdiGlosarioByOnsParalelo = tdiGlosarioByOnsParalelo;
    }

    
    @Column(name="ONS_CUPOS", nullable=false, precision=22, scale=0)
    public BigDecimal getOnsCupos() {
        return this.onsCupos;
    }
    
    public void setOnsCupos(BigDecimal onsCupos) {
        this.onsCupos = onsCupos;
    }

    
    @Column(name="ONS_OFERTADO_POR", nullable=false, precision=22, scale=0)
    public BigDecimal getOnsOfertadoPor() {
        return this.onsOfertadoPor;
    }
    
    public void setOnsOfertadoPor(BigDecimal onsOfertadoPor) {
        this.onsOfertadoPor = onsOfertadoPor;
    }

    
    @Column(name="ONS_OFERTANTE_ID", nullable=false, precision=22, scale=0)
    public BigDecimal getOnsOfertanteId() {
        return this.onsOfertanteId;
    }
    
    public void setOnsOfertanteId(BigDecimal onsOfertanteId) {
        this.onsOfertanteId = onsOfertanteId;
    }

    
    @Column(name="OFE_ID_NSGA", nullable=false, precision=22, scale=0)
    public BigDecimal getOfeIdNsga() {
        return this.ofeIdNsga;
    }
    
    public void setOfeIdNsga(BigDecimal ofeIdNsga) {
        this.ofeIdNsga = ofeIdNsga;
    }

    
    @Column(name="OFD_ID_NSGA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getOfdIdNsga() {
        return this.ofdIdNsga;
    }
    
    public void setOfdIdNsga(BigDecimal ofdIdNsga) {
        this.ofdIdNsga = ofdIdNsga;
    }

    
    @Column(name="SE_ID_CE", precision=22, scale=0)
    public BigDecimal getSeIdCe() {
        return this.seIdCe;
    }
    
    public void setSeIdCe(BigDecimal seIdCe) {
        this.seIdCe = seIdCe;
    }

    
    @Column(name="MO_ID", precision=22, scale=0)
    public BigDecimal getMoId() {
        return this.moId;
    }
    
    public void setMoId(BigDecimal moId) {
        this.moId = moId;
    }

    
    @Column(name="GUID_OFD_ID_NSGA", length=500)
    public String getGuidOfdIdNsga() {
        return this.guidOfdIdNsga;
    }
    
    public void setGuidOfdIdNsga(String guidOfdIdNsga) {
        this.guidOfdIdNsga = guidOfdIdNsga;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiOfertaNsga")
    public Set<TdiOfertaDocentesNsga> getTdiOfertaDocentesNsgas() {
        return this.tdiOfertaDocentesNsgas;
    }
    
    public void setTdiOfertaDocentesNsgas(Set<TdiOfertaDocentesNsga> tdiOfertaDocentesNsgas) {
        this.tdiOfertaDocentesNsgas = tdiOfertaDocentesNsgas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiOfertaNsga")
    public Set<TheActividadesEvaAvance> getTheActividadesEvaAvances() {
        return this.theActividadesEvaAvances;
    }
    
    public void setTheActividadesEvaAvances(Set<TheActividadesEvaAvance> theActividadesEvaAvances) {
        this.theActividadesEvaAvances = theActividadesEvaAvances;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiOfertaNsga")
    public Set<TevaMicrovideos> getTevaMicrovideoses() {
        return this.tevaMicrovideoses;
    }
    
    public void setTevaMicrovideoses(Set<TevaMicrovideos> tevaMicrovideoses) {
        this.tevaMicrovideoses = tevaMicrovideoses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiOfertaNsga")
    public Set<TheActividadesDocEvaDet> getTheActividadesDocEvaDets() {
        return this.theActividadesDocEvaDets;
    }
    
    public void setTheActividadesDocEvaDets(Set<TheActividadesDocEvaDet> theActividadesDocEvaDets) {
        this.theActividadesDocEvaDets = theActividadesDocEvaDets;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tdiOfertaNsga")
    public Set<TheActividadesDocEvaCab> getTheActividadesDocEvaCabs() {
        return this.theActividadesDocEvaCabs;
    }
    
    public void setTheActividadesDocEvaCabs(Set<TheActividadesDocEvaCab> theActividadesDocEvaCabs) {
        this.theActividadesDocEvaCabs = theActividadesDocEvaCabs;
    }




}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientolib;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esperanza
 */
@Entity
@Table(name = "ORDEN_TRABAJO", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajo.findAll", query = "SELECT o FROM OrdenTrabajo o")
    , @NamedQuery(name = "OrdenTrabajo.findById", query = "SELECT o FROM OrdenTrabajo o WHERE o.id = :id")
    , @NamedQuery(name = "OrdenTrabajo.findByFechaEntrada", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaEntrada = :fechaEntrada")
    , @NamedQuery(name = "OrdenTrabajo.findByFechaSalida", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaSalida = :fechaSalida")})
public class OrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FECHA_ENTRADA")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @JoinColumn(name = "ID_DETALLE_PETICION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private DetallePeticion idDetallePeticion;
    @JoinColumn(name = "ID_ENCARGADO_MANTENIMIENTO", referencedColumnName = "DUI")
    @ManyToOne(optional = false)
    private PersonalMantenimiento idEncargadoMantenimiento;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumn(name = "ID_TIPO_MANTENIMIENTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoMantenimiento idTipoMantenimiento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordenTrabajo")
    private DiagnosticoHardware diagnosticoHardware;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordenTrabajo")
    private DiagnosticoSoftware diagnosticoSoftware;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(Integer id) {
        this.id = id;
    }

    public OrdenTrabajo(Integer id, Date fechaEntrada) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public DetallePeticion getIdDetallePeticion() {
        return idDetallePeticion;
    }

    public void setIdDetallePeticion(DetallePeticion idDetallePeticion) {
        this.idDetallePeticion = idDetallePeticion;
    }

    public PersonalMantenimiento getIdEncargadoMantenimiento() {
        return idEncargadoMantenimiento;
    }

    public void setIdEncargadoMantenimiento(PersonalMantenimiento idEncargadoMantenimiento) {
        this.idEncargadoMantenimiento = idEncargadoMantenimiento;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public TipoMantenimiento getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(TipoMantenimiento idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public DiagnosticoHardware getDiagnosticoHardware() {
        return diagnosticoHardware;
    }

    public void setDiagnosticoHardware(DiagnosticoHardware diagnosticoHardware) {
        this.diagnosticoHardware = diagnosticoHardware;
    }

    public DiagnosticoSoftware getDiagnosticoSoftware() {
        return diagnosticoSoftware;
    }

    public void setDiagnosticoSoftware(DiagnosticoSoftware diagnosticoSoftware) {
        this.diagnosticoSoftware = diagnosticoSoftware;
    }

  
    
}

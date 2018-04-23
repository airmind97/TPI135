/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.OrigenPeticion;

/**
 *
 * @author esperanza
 */
@Local
public interface OrigenPeticionFacadeLocal {

    void create(OrigenPeticion origenPeticion);

    void edit(OrigenPeticion origenPeticion);

    void remove(OrigenPeticion origenPeticion);

    OrigenPeticion find(Object id);

    List<OrigenPeticion> findAll();

    List<OrigenPeticion> findRange(int[] range);

    int count();
    
}

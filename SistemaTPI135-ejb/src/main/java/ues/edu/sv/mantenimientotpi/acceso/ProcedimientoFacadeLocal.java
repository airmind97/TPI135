/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientotpi.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientolib.Procedimiento;

/**
 *
 * @author esperanza
 */
@Local
public interface ProcedimientoFacadeLocal extends AbstractFacadeInterface<Procedimiento>{

   
    
    List<Procedimiento> findRange(int lower, int higher);
    
    List<Procedimiento> findByName(String nombre);
    
}

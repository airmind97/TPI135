
package ues.edu.sv.tpi135.servicioRest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.edu.sv.tpi135.entidades.ExcepcionCalendario;
import ues.edu.sv.tpi135.persistencia.ExcepcionCalendarioFacadeLocal;

/**
 *
 * @author mateo
 */

@Path("/excepcionCalendario")
public class ExcepcionCalendarioResource implements Serializable{
    @EJB
    private ExcepcionCalendarioFacadeLocal ejbExcepcionCalendario;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExcepcionCalendario> findAll(){
        List listaExcepcion = null;
        
        if (ejbExcepcionCalendario != null) {
            listaExcepcion =  ejbExcepcionCalendario.findAll();
        }
        
        return listaExcepcion;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbExcepcionCalendario != null) {
            count = ejbExcepcionCalendario.count();
        }
        return count;
    }
    
    @Path("/{fecha}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ExcepcionCalendario findById(@PathParam("fecha") Date fecha){
        if (ejbExcepcionCalendario != null) {
            return ejbExcepcionCalendario.find(fecha);
        }
        return new ExcepcionCalendario();
    }
    
    @Path("/remove/{fecha}")
    @DELETE
    public Response remove(@PathParam("fecha") Date fecha){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbExcepcionCalendario != null) {
            ExcepcionCalendario removeExcepcionCalendario = new ExcepcionCalendario(fecha);
            ejbExcepcionCalendario.remove(removeExcepcionCalendario);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{fecha}/{descripcion}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("fecha") Date fecha, @PathParam("descripcion") String descripcion){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbExcepcionCalendario != null){
            ExcepcionCalendario newExcepcionCalendario = new ExcepcionCalendario(fecha, descripcion);
            ejbExcepcionCalendario.create(newExcepcionCalendario);
            respuesta = Response.status(Response.Status.CREATED).entity(newExcepcionCalendario).build();
        }
        return respuesta;
    }
}

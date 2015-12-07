/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Model.VO.Curso;
import Repositorio.RepositorioCursos;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * REST Web Service
 *
 * @author fernando
 */
@Path("cursos")
public class CursosResource implements ContainerResponseFilter {

    @Context
    private UriInfo context;
    @EJB
    private RepositorioCursos repositorio; 

    /**
     * Creates a new instance of CursosResource
     */
    public CursosResource() {
    }

    /**
     * Retrieves representation of an instance of WS.CursosResource
     * @return an instance of Model.VO.Curso
     */
    @GET
    @Produces("application/json")
    public List<Curso> getCursos() {
        return repositorio.getCursos();
    }

    /**
     * PUT method for updating or creating an instance of CursosResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Produces("text/plain")
    @Consumes("application/json")
    public String addCurso(Curso curso) {
        //método de adicionar repositorio
        return "OK";
        
    }
    
    
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException{
        responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept");
    }
}

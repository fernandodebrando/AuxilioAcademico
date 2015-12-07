/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Model.VO.Curso_old;
import Repositorio.RepositorioCursos;
import Repositorio.RepositorioGradeCurricular;
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
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * REST Web Service
 *
 * @author fernando
 */
@Path("grade-curricular")
public class GradeCurricularResource implements ContainerResponseFilter {

    @Context
    private UriInfo context;
     @EJB
    private RepositorioGradeCurricular repositorio; 

    /**
     * Creates a new instance of GradeCurricularResource
     */
    public GradeCurricularResource() {
    }
    
    /**
     * Retrieves representation of an instance of WS.GradeCurricularResource
     * @return an instance of Model.VO.Curso_old
     */
    
    @GET    
    @Produces("application/json")
    public List<Curso_old> getGradeCurricular() {
        //TODO return proper representation object
        return repositorio.getGradeCurricular();
    }

    /**
     * PUT method for updating or creating an instance of GradeCurricularResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(Curso_old content) {
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException{
        responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept");
    }
}

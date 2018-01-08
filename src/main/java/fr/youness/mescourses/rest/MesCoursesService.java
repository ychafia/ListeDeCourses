package fr.youness.mescourses.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.youness.mescourses.bean.Element;
import fr.youness.mescourses.bean.Utilisateur;
import fr.youness.mescourses.dao.ElementImpl;
import fr.youness.mescourses.dao.UtilisateurImpl;



@Path("/json/mescourses")
public class MesCoursesService {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListe() {
		List liste_courses = new ArrayList<Element>();
		ElementImpl dao_courses = new ElementImpl();
		liste_courses = dao_courses.consulter();
		return Response.ok().entity(liste_courses)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").
	             header("Access-Control-Allow-Credentials", "true").
	             header("Access-Control-Max-Age", "3600").
	             header("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, X-Requested-With").build();    
	}
	
	@OPTIONS
    @Path("/get")
    public Response autoriserOptioGet() {
      	System.out.println("OPTIONS GET");
        return Response.ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").
             header("Access-Control-Allow-Credentials", "true").
             header("Access-Control-Max-Age", "3600").
             header("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, X-Requested-With").build();
    }
	
	@PUT
    @Path("/ajouter")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response ajouterElement(Element elt) throws Exception{
		System.out.println("Début du POST serveur ");
		Element elt_tmp = new Element();
		elt_tmp.setIdElement(elt.getIdElement());
	 	elt_tmp.setNomElement(elt.getNomElement());
	 	elt_tmp.setComplete(elt.getComplete());
	 	List liste_courses = new ArrayList<Element>();
	 	ElementImpl dao_courses = new ElementImpl();
	 	dao_courses.ajouterElement(elt_tmp);
	    liste_courses = dao_courses.consulter();
	    return Response.ok().entity(liste_courses)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").
	             header("Access-Control-Allow-Credentials", "true").
	             header("Access-Control-Max-Age", "3600").
	             header("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, X-Requested-With").build(); 
    }
	
	@OPTIONS
    @Path("/ajouter")
    public Response autoriserOptioAjouter() {
      	System.out.println("OPTIONS");
        return Response.ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").
             header("Access-Control-Allow-Credentials", "true").
             header("Access-Control-Max-Age", "3600").
             header("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, X-Requested-With").build();
    }
	
	@DELETE
	@Path("/supprimer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response supprimerElement(String idSupp) {
		System.out.println(idSupp);
		List liste_courses = new ArrayList<Element>();
		Element e = new Element();
		e.setIdElement(Integer.parseInt(idSupp));
		ElementImpl dao_courses = new ElementImpl();
		dao_courses.supprimer(Integer.parseInt(idSupp));
		liste_courses = dao_courses.consulter();
		return Response.ok().entity(liste_courses)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").
	             header("Access-Control-Allow-Credentials", "true").
	             header("Access-Control-Max-Age", "3600").
	             header("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, X-Requested-With").build();
	}
	
	@OPTIONS
    @Path("/supprimer")
    public Response autoriserOptioSupprimer() {
          System.out.println("OPTIONS");
        return Response.ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").
             header("Access-Control-Allow-Credentials", "true").
             header("Access-Control-Max-Age", "3600").
             header("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, X-Requested-With").build();
    }
	
	@POST
	@Path("/mettreAjour")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mettreAjour(int idSupp) {
		System.out.println(idSupp);
		List liste_courses = new ArrayList<Element>();
		ElementImpl dao_courses = new ElementImpl();
		dao_courses.mettreAjour(idSupp);
		liste_courses = dao_courses.consulter();
		return Response.ok().entity(liste_courses)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").
	             header("Access-Control-Allow-Credentials", "true").
	             header("Access-Control-Max-Age", "3600").
	             header("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, X-Requested-With").build();
	}
	
	@OPTIONS
    @Path("/mettreAjour")
    public Response autoriserOptioMAJ() {
          System.out.println("OPTIONS");
        return Response.ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").
             header("Access-Control-Allow-Credentials", "true").
             header("Access-Control-Max-Age", "3600").
             header("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, X-Requested-With").build();
    }
	
	@PUT
    @Path("/seConnecter")
    @Consumes({MediaType.APPLICATION_JSON})
	public Response seConnecter(Utilisateur u){
		System.out.println("PUT seConnecter");
		UtilisateurImpl dao_courses = new UtilisateurImpl();
		boolean autoriser = false;
		autoriser = dao_courses.seConnecter(u);
		return Response.ok().entity(autoriser)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").
	             header("Access-Control-Allow-Credentials", "true").
	             header("Access-Control-Max-Age", "3600").
	             header("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, X-Requested-With").build();
	}
	
	@OPTIONS
    @Path("/seConnecter")
    public Response autoriserOptioSeconnecter() {
      	System.out.println("OPTIONS seConnecter");
        return Response.ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").
             header("Access-Control-Allow-Credentials", "true").
             header("Access-Control-Max-Age", "3600").
             header("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, X-Requested-With").build();
    }
}

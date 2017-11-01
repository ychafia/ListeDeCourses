package fr.youness.mescourses.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.youness.mescourses.bean.Element;
import fr.youness.mescourses.dao.ElementImpl;



@Path("/json/mescourses")
public class MesCoursesService {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List getListe() {
		List liste_courses = new ArrayList<Element>();
		ElementImpl dao_courses = new ElementImpl();
		liste_courses = dao_courses.consulter();
		return liste_courses;
	}
	
	@POST
    @Path("/post")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response postPerson(Element elt) throws Exception{
		System.out.println("Début du POST serveur ");
		Element elt_tmp = new Element();
		elt_tmp.setIdElement(elt.getIdElement());
	 	elt_tmp.setNomElement(elt.getNomElement());
	 	elt_tmp.setComplete(elt.getComplete());
	 	List liste_courses = new ArrayList<Element>();
	 	ElementImpl dao_courses = new ElementImpl();
	 	dao_courses.ajouterElement(elt_tmp);
	    liste_courses = dao_courses.consulter();
	    return Response.status(200).entity(liste_courses).build();
    }
	
	@POST
	@Path("/supprimer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response supprimerElement(int idSupp) {
		System.out.println(idSupp);
		List liste_courses = new ArrayList<Element>();
		Element e = new Element();
		e.setIdElement(idSupp);
		ElementImpl dao_courses = new ElementImpl();
		dao_courses.supprimer(idSupp);
		liste_courses = dao_courses.consulter();
		return Response.status(200).entity(liste_courses).build();
	}
	
	@POST
	@Path("/maj")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mettreAjour(int idSupp) {
		System.out.println(idSupp);
		List liste_courses = new ArrayList<Element>();
		ElementImpl dao_courses = new ElementImpl();
		dao_courses.mettreAjour(idSupp);
		liste_courses = dao_courses.consulter();
		return Response.status(200).entity(liste_courses).build();
	}
}

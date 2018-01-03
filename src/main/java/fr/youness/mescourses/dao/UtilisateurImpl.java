package fr.youness.mescourses.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.youness.mescourses.bean.Utilisateur;
import fr.youness.mescourses.util.HibernateUtil;

public class UtilisateurImpl implements IUtilisateur {

	@Override
	public boolean seConnecter(Utilisateur u) {
		boolean autoriser = false;
		Session session = HibernateUtil.getSessionFactory().openSession();	
		session.beginTransaction();
        Utilisateur user;
        List users = session.createCriteria(Utilisateur.class).add(Restrictions.like("identifiant", u.getIdentifiant()))
        		.add(Restrictions.eq("motDePasse", u.getMotDePasse())).list();
        
        if(users.size() > 0){
        	user = (Utilisateur)users.get(0);
        	if(user.getMotDePasse().equals(u.getMotDePasse())){
        		autoriser = true;
        	}
        	else{
        		autoriser = false;
        	}
        }
        
        session.getTransaction().commit();
        session.clear();
        session.close();
		return autoriser;
	}

}

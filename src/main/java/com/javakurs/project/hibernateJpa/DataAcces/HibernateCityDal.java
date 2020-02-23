package com.javakurs.project.hibernateJpa.DataAcces;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javakurs.project.hibernateJpa.Entities.City;


//Repomuz budur dedik
@Repository
public class HibernateCityDal implements ICityDal{

	
//JPA - ORM gibi ama standart artık
	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	//AOP - Aspect Orriented Programming -açma kapama oto yapıyor
	@Override
	@Transactional
	public List<City> getAll() {
		Session session =entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
	
		Session session =entityManager.unwrap(Session.class);
		session.saveOrUpdate(city); //yoksa ekler varsa günceller
	}

	@Override
	public void update(City city) {
		Session session =entityManager.unwrap(Session.class);
		session.saveOrUpdate(city); //yoksa ekler varsa günceller		
	}

	@Override
	public void delete(City city) {
		Session session =entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class, city.getId());
		session.delete(cityToDelete);
	}

	@Override
	public City getById(int id) {
		Session session =entityManager.unwrap(Session.class);
		City city = session.get(City.class, id);
		return city;
		
	}
	
	

}

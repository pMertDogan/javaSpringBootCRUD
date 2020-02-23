package com.javakurs.project.hibernateJpa.DataAcces;

import java.util.List;
import com.javakurs.project.hibernateJpa.Entities.City;

public interface ICityDal {

	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete (City city);
	City getById(int id);
	
}

package com.javakurs.project.hibernateJpa.restAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakurs.project.hibernateJpa.Bussines.ICityService;
import com.javakurs.project.hibernateJpa.Entities.*;


// Controller -> Bussines /service  -> Manager -> DAL -> entity 

@RestController
@RequestMapping("/api")
public class CityController {

	private ICityService cityService;

	
	//Otomatik olarak IcityService nesnesini
	//al zaten bir adet var
	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities")
	public List<City> get(){
		return cityService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody City city) {
		cityService.add(city);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		cityService.update(city);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	
	@GetMapping("/cities/{id}")
	public City getByID(@PathVariable int id) {
		return cityService.getByID(id);
	}
	
}

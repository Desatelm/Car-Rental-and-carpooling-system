package edu.mum.cs.projects.carpooling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.projects.carpooling.domain.entity.Vehicle;
import edu.mum.cs.projects.carpooling.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	public void creatVehicle(Vehicle vehicle){
		vehicleRepository.save(vehicle);
	}
	
	public void removeVehicle(Vehicle vehicle){
		vehicleRepository.delete(vehicle.getId());
	}
	
	public Vehicle getVehicle(int id){
		return vehicleRepository.getOne(id);
	}
	
	

}

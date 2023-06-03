package com.example.demo.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.Exception;
import com.example.demo.module.Vehicle;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepo repo;
	@Override
	public Vehicle addVehicle(Vehicle v) {
		return repo.save(v);
	}
	@Override
	public String deleteVehicle(Integer vid) {
		repo.deleteById(vid);
		return "Deleted ID: "+vid;
	}
	@Override
	public List<Vehicle> getAllVehicles() {
		
		return repo.findAll();
	}
	@Override
	public Vehicle getVehicleById(Integer vid) {
		return repo.findById(vid).orElseThrow(()->new Exception("Vehicle", "ID", vid));
	}
	@Override
	public List<Vehicle> getVehicleByColor(String vcolor) {
		return repo.getVehicleByColor(vcolor);
	}
	
	@Override
	public List<Vehicle> getVehicleSortedByPrice() {
		return repo.getVehicleSortedByPrice();
	}
	@Override
	public Vehicle updateVehicle(Vehicle v1) {
		Vehicle v2=repo.findById(v1.getVid()).orElse(null);
		if(v2!=null) {
			v2.setVname(v1.getVname());
			v2.setVprice(v1.getVprice());
			v2.setVmodel(v1.getVmodel());
			v2.setVcolor(v1.getVcolor());
			return repo.save(v2);
		}
		else {
			throw new Exception("Vehicle", "Id", v1.getVid());
		}
	}
	@Override
	public List<Vehicle> getVehicleMoreThanPrice(int vprice) {
		return repo.getVehicleMoreThanPrice(vprice);
	}
	@Override
	public List<Vehicle> getVehicleSortedByPriceAndColor(double vprice) {
		return repo.getVehicleSortedByPriceAndColor(vprice);
	}

	
	

}

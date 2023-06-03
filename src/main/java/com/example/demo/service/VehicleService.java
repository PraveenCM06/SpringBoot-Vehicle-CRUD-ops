package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Vehicle;

public interface VehicleService {
	
	Vehicle addVehicle(Vehicle v);
	
	String deleteVehicle(Integer vid);
	
	List<Vehicle> getAllVehicles();
	
	Vehicle getVehicleById(Integer vid);
	
	List<Vehicle> getVehicleByColor(String vcolor);
	
	List<Vehicle> getVehicleSortedByPrice();
	
	Vehicle updateVehicle(Vehicle v1);
	
	List<Vehicle> getVehicleMoreThanPrice(int vprice);
	
	List<Vehicle> getVehicleSortedByPriceAndColor(double vprice);
}

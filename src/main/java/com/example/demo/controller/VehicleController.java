package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Vehicle;
import com.example.demo.service.VehicleService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class VehicleController {
	
	@Autowired
	VehicleService vh;

	@PostMapping("/addvehicle")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v){
		return new ResponseEntity<Vehicle>(vh.addVehicle(v),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletevehicle/{vid}")
	public String deleteVehicleById(@PathVariable Integer vid) {
		return vh.deleteVehicle(vid);
	}
	
	@GetMapping("/getallvehicles")
	List<Vehicle> getAllVehicles(){
		return vh.getAllVehicles();
	}
	
	@GetMapping("/getvehiclebyid")
	ResponseEntity<Vehicle> getVehicleById(@RequestHeader Integer vid){
		return new ResponseEntity<Vehicle>(vh.getVehicleById(vid), HttpStatus.FOUND);
	}
	
	@GetMapping("/getvehiclesbycolor")
	ResponseEntity <List<Vehicle>> getVehicleByColor(@RequestHeader String vcolor){
			return new ResponseEntity<List<Vehicle>>(vh.getVehicleByColor(vcolor), HttpStatus.FOUND);
	}
	
	@GetMapping("/getvehiclesortedbyprice")
	 List<Vehicle> getVehicleSortedByPrice() {
		 return vh.getVehicleSortedByPrice();
	 }
	
	@PutMapping("/updatevehicle")
	ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle v1){
		return new ResponseEntity<Vehicle>(vh.updateVehicle(v1),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getvehiclemorethanprice")
	ResponseEntity<List<Vehicle>> getVehicleMoreThanPrice(@RequestHeader int vprice){
		return new ResponseEntity<List<Vehicle>>(vh.getVehicleMoreThanPrice(vprice),HttpStatus.FOUND);
	}
	
	@GetMapping("/bypriceandcolor")
	ResponseEntity<List<Vehicle>> getVehicleSortedByPriceAndColor(@RequestHeader double vprice) {
		 return new ResponseEntity<List<Vehicle>>(vh.getVehicleSortedByPriceAndColor(vprice), HttpStatus.FOUND);
	 }
}

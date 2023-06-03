package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
	
	@Query(value="select * from vehicle where vcolor=?1", nativeQuery=true)
	List<Vehicle> getVehicleByColor(String vcolor);
	
	@Query(value="select * from vehicle order by vprice", nativeQuery=true)
	List<Vehicle> getVehicleSortedByPrice();
	
	@Query(value="select * from vehicle where vprice>?1", nativeQuery=true)
	List<Vehicle> getVehicleMoreThanPrice(int vprice);
	
	@Query(value="select * from vehicle where vprice=?1 order by vprice, vcolor asc", nativeQuery=true)
	List<Vehicle> getVehicleSortedByPriceAndColor(double vprice);
	
}
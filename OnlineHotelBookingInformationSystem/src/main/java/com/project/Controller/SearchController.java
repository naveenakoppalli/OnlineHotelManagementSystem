package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.OHISBusinessException;
import com.project.Model.City;
import com.project.Model.Hotel;
import com.project.Model.Room;
import com.project.Service.SearchService;



@RestController
@RequestMapping("/Search")
public class SearchController {
	
	@Autowired
	SearchService service;
    
	@RequestMapping(value="/addHotel",method=RequestMethod.POST)
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel h){
	    service.addHotel(h);
	
		return new ResponseEntity<Hotel>(h,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/addCity",method=RequestMethod.POST)
	public ResponseEntity<City> addCity(@RequestBody City h){
		service.addCity(h);
		return new ResponseEntity<City>(h,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addRoom",method=RequestMethod.POST)
	public ResponseEntity<Room> addRoom(@RequestBody Room r){
		service.addRoom(r);
		return new ResponseEntity<Room>(r,HttpStatus.OK);
	}
	
	@GetMapping("/FindByhotelId")
	public ResponseEntity<List<Hotel>> fetchById(@RequestParam int hotelId){
		String status=null;
		List<Hotel> obj=service.findByHotelId(hotelId);
		if(!obj.isEmpty()) {
			status="Retrived Successfully";
		}
		else {
			throw new OHISBusinessException("please give a valid Id");
		}
		return new ResponseEntity<List<Hotel>>(obj,HttpStatus.OK);
		
	}
	@GetMapping("/FindByhotelName")
	public ResponseEntity<List<Hotel>> fetchByNmae(@RequestParam String name){
		String status=null;
		List<Hotel> obj=service.findByHotelName(name);
		if(!obj.isEmpty()) {
			status="Retrived Successfully";
		}
		else {
			throw new OHISBusinessException("please give a valid Name");
		}
		return new ResponseEntity<List<Hotel>>(obj,HttpStatus.OK);
		
	}
	
	@GetMapping("/FindByTypeId")
	public ResponseEntity<List<Room>> fetchBytypeId(@RequestParam int type_id){
		String status=null;
		List<Room> obj=service.findByTypeId(type_id);
		if(!obj.isEmpty()) {
			status="Retrived Successfully";
		}
		else {
			throw new OHISBusinessException("please give a valid Id");
		}
		return new ResponseEntity<List<Room>>(obj,HttpStatus.OK);
		
	}
	
}

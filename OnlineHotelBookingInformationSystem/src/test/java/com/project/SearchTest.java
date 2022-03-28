package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.Model.Hotel;
import com.project.Model.Room;
import com.project.Repository.HotelRepository;
import com.project.Repository.RoomRepository;
import com.project.Service.SearchService;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchTest {

	@MockBean
	HotelRepository repo;
	
	@Autowired
	SearchService service;
	
	@MockBean
	RoomRepository repo1;
	 
    @Test	
	public void SaveHotelList() {
    	Hotel hotel=new Hotel(1011);
    	when(repo.save(hotel)).thenReturn(hotel);
    	assertEquals(hotel,service.addHotel(hotel));
    }
    
    @Test
    public void getByHotelId() {
    	int hotelId=1011;
    	when(repo.findByHotelId(hotelId)).thenReturn(
    			Stream.of(new Hotel(1011)).collect(Collectors.toList()));
    	assertEquals(1,service.findByHotelId(hotelId).size());
    }
    
    @Test
    public void getByTypeId() {
    	int type_id=386;
    	when(repo1.findByTypeId(type_id)).thenReturn(
    			Stream.of(new Room(1011)).collect(Collectors.toList()));
    	assertEquals(1,service.findByTypeId(type_id).size());
    }
}

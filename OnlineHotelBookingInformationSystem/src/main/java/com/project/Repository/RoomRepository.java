package com.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.project.Model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	@Query("select e from Room e where e.type_id=:type_id")
	List<Room> findByTypeId(@Param("type_id")int type_id);
}

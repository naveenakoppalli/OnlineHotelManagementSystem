package com.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROOM_TYPE")
public class Room {
	@Id
	@Column(name="ROOM_TYPE_ID")
	private int type_id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TARIFF_AMT")
	private int tariffAmt;

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTariffAmt() {
		return tariffAmt;
	}

	public void setTariffAmt(int tariffAmt) {
		this.tariffAmt = tariffAmt;
	}

	public Room(int type_id) {
		super();
		this.type_id = type_id;
	}
	

}

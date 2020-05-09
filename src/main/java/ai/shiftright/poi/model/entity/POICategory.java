package ai.shiftright.poi.model.entity;

import lombok.Getter;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
public enum POICategory {
	
	RESTAURANT("POIRestaurant"),
	CINEMA("POICinema"),
	SCHOOL("POISchool"),
	HOSPITAL("POIHospital");
	
	@Getter private String tableName;
	
	POICategory(String tableName) { this.tableName = tableName; }
}

package ai.shiftright.poi.services.model;


import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ai.shiftright.poi.endpoint.category.model.POICinemaLocationRequest;
import ai.shiftright.poi.endpoint.category.model.POIHospitalLocationRequest;
import ai.shiftright.poi.endpoint.category.model.POIRestaurantLocationRequest;
import ai.shiftright.poi.endpoint.category.model.POISchoolLocationRequest;
import ai.shiftright.poi.model.entity.POICategory;
import ai.shiftright.poi.model.entity.POIItem;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public abstract class POILocationRequest {

	protected ai.shiftright.poi.endpoint.model.POILocationRequest poiLocationRequest;

	protected String whereClauseKey = " where ";
	protected String whereClauseJoinKey = " and ";
	
	public abstract String getTableName();

	public abstract String getWhereClause();
	
	public abstract RowMapper<? extends POIItem> getPOIItemMapper();	
	
	public String getQuery(String tableName) {
		return "select * from " 
				+ tableName 
				+ (StringUtils.isEmpty(getWhereClause()) ? "" : getWhereClause()) 
				+ " order by ABS(latitude - :latitudeQ) + ABS(longitude - :longitudeQ) limit :limit offset 0";
	}
	
	public Map<String, String> getParameterMap() {
		Map<String, String> parameters = new HashMap<>();
		
		parameters.put("poiitem", POICategory.valueOf(poiLocationRequest.getCategory().toUpperCase()).getTableName());
		parameters.put("latitudeQ", new Double(poiLocationRequest.getLatitude()).toString());
		parameters.put("longitudeQ", new Double(poiLocationRequest.getLongitude()).toString());
		parameters.put("limit", new Integer(poiLocationRequest.getMaxNearest() * 2).toString());
		
		return parameters;
	}
}

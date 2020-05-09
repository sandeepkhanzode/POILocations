package ai.shiftright.poi.endpoint.model;


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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "category", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = POIRestaurantLocationRequest.class, name = "Restaurant"),
    @JsonSubTypes.Type(value = POISchoolLocationRequest.class, name = "School"),
    @JsonSubTypes.Type(value = POIHospitalLocationRequest.class, name = "Hospital"),
    @JsonSubTypes.Type(value = POICinemaLocationRequest.class, name = "Cinema")
})
public abstract class POILocationRequest {

	protected double latitude;
	protected double longitude;
	protected String category;
	protected int maxNearest;
}

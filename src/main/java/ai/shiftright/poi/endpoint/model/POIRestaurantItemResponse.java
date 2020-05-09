package ai.shiftright.poi.endpoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POIRestaurantItemResponse implements POIItemResponse {

	@JsonProperty("Restaurant Name")
	private String name;

	@JsonProperty("Restaurant Address")
	private String address;

	@JsonProperty("Haversine Distance")
	private double distance;

	@JsonProperty("Cuisine")
	private String cuisine;

	@JsonProperty("Delivery")
	private String delivery;
	
	@JsonProperty("Price Point")
	private String pricePoint;

	
	public POIRestaurantItemResponse(final String name, final String address, final double distance, 
			final String pricePoint, final String cuisine, final String delivery) {
		this.name = name;
		this.address = address;
		this.distance = distance;
		this.cuisine = cuisine;
		this.pricePoint = pricePoint;
		this.delivery = delivery;
	}
}

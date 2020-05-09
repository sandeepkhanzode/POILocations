package ai.shiftright.poi.model.entity;

import ai.shiftright.poi.endpoint.model.POIItemResponse;
import ai.shiftright.poi.endpoint.model.POIRestaurantItemResponse;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POIRestaurantItem extends POIItem {

	private String cuisine;
	private String delivery;
	private String pricePoint;

	public POIRestaurantItem(String name, String category, String address, double latitude, double longitude, 
			String pricePoint, String cuisine, String delivery) {
		super(name, category, address, latitude, longitude);
		this.cuisine = cuisine;
		this.delivery = delivery;
		this.pricePoint = pricePoint;
	}

	@Override
	public POIItemResponse createPOIItemResponse(double distance) {
		return new POIRestaurantItemResponse(this.getName(), this.getAddress(), distance, pricePoint, cuisine, delivery);
	}
}

package ai.shiftright.poi.endpoint.category.model;

import ai.shiftright.poi.endpoint.model.POILocationRequest;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POIRestaurantLocationRequest extends POILocationRequest {

	private String cuisine;
	private String delivery;
	private String pricePoint;
}

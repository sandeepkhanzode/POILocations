
package ai.shiftright.poi.model.entity;

import ai.shiftright.poi.endpoint.model.POIItemResponse;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POICinemaItem extends POIItem {

	public POICinemaItem(String name, String category, String address, double latitude, double longitude, String genre,
			double moveiRating) {
		super(name, category, address, latitude, longitude);
		this.genre = genre;
		this.moveiRating = moveiRating;
	}

	private String genre;
	private double moveiRating;

	@Override
	public POIItemResponse createPOIItemResponse(double distance) {
		/* Return new POICinemaItemResponse(); */
		return null;
	}
}

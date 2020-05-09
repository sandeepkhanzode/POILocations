
package ai.shiftright.poi.model.entity;

import ai.shiftright.poi.endpoint.model.POIItemResponse;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POISchoolItem extends POIItem {

	public POISchoolItem(String name, String category, String address, double latitude, double longitude, String curriculum) {
		super(name, category, address, latitude, longitude);
		this.curriculum = curriculum;
	}

	private String curriculum;


	@Override
	public POIItemResponse createPOIItemResponse(double distance) {
		/* Return new POISchoolItemResponse(); */
		return null;
	}
}

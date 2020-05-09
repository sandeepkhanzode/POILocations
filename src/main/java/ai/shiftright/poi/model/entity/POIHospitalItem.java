
package ai.shiftright.poi.model.entity;

import ai.shiftright.poi.endpoint.model.POIItemResponse;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POIHospitalItem extends POIItem {

	public POIHospitalItem(String name, String category, String address, double latitude, double longitude, String speciaility) {
		super(name, category, address, latitude, longitude);
		this.speciaility = speciaility;
	}

	private String speciaility;


	@Override
	public POIItemResponse createPOIItemResponse(double distance) {
		/* Return new POIHospitalItemResponse(); */
		return null;
	}
}

package ai.shiftright.poi.model.entity;

import ai.shiftright.poi.endpoint.model.POIItemResponse;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public abstract class POIItem {

	private Long id;
	private String category;
	private String name;
	private String address;
	private double latitude;
	private double longitude;
	
	protected POIItem() {}
	
	protected POIItem(String name, String category, String address, double latitude, double longitude) {
		this.category = category;
		this.name = name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public abstract POIItemResponse createPOIItemResponse(double distance);
}

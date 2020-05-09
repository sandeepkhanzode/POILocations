package ai.shiftright.poi.endpoint.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POILocationResponse {

	@JsonProperty("PointOfInterest")
	private List<POIItemResponse> poiItems;

	public POILocationResponse(final List<POIItemResponse> poiItems) {
		this.poiItems = poiItems;
	}
}

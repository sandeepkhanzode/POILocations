package ai.shiftright.poi.services.api;

import ai.shiftright.poi.endpoint.model.POILocationRequest;
import ai.shiftright.poi.endpoint.model.POILocationResponse;

/**
 * 
 * @author Sandeep Ramesh Khanzode
 *
 */
public interface POILocationService {

	public POILocationResponse getPOILocations(final POILocationRequest poiLocationRequest);
}

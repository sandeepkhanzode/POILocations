/**
 * 
 */
package ai.shiftright.poi.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ai.shiftright.poi.endpoint.model.POILocationRequest;
import ai.shiftright.poi.endpoint.model.POILocationResponse;
import ai.shiftright.poi.services.api.POILocationService;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@RestController
public class POILocationController {

	@Autowired(required = true)
	private POILocationService poiLocationService;


	@PostMapping(value = "/api/v1/poilocations/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<POILocationResponse> searchPOILocations(final @RequestBody POILocationRequest poiLocationRequest) {

		System.out.println("latitude: " + poiLocationRequest.getLatitude());
		System.out.println("longitude: " + poiLocationRequest.getLongitude());
		System.out.println("category: " + poiLocationRequest.getCategory());
		System.out.println("maxNearest: " + poiLocationRequest.getMaxNearest());
		
		if(poiLocationRequest.getMaxNearest() == 0)
			poiLocationRequest.setMaxNearest(5);
		
		return ResponseEntity.ok(poiLocationService.getPOILocations(poiLocationRequest));
	}
}

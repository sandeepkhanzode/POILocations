package ai.shiftright.poi.services.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ai.shiftright.poi.endpoint.model.POIItemResponse;
import ai.shiftright.poi.endpoint.model.POILocationRequest;
import ai.shiftright.poi.endpoint.model.POILocationResponse;
import ai.shiftright.poi.model.entity.POICategory;
import ai.shiftright.poi.model.entity.POIItem;
import ai.shiftright.poi.services.api.POILocationService;
import ai.shiftright.poi.services.dao.POIItemDAO;
import ai.shiftright.poi.services.model.POICinemaLocationRequest;
import ai.shiftright.poi.services.model.POIHospitalLocationRequest;
import ai.shiftright.poi.services.model.POIRestaurantLocationRequest;
import ai.shiftright.poi.services.model.POISchoolLocationRequest;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Component("POILocationService")
public class POILocationServiceImpl implements POILocationService {

	@Autowired
	POIItemDAO poiItemDAO;
	
	@Override
	public POILocationResponse getPOILocations(final POILocationRequest poiLocationRequest) {

		List<? extends POIItem> poiItems = poiItemDAO.getPOIItems(convert(poiLocationRequest));
		List<POIItemResponse> poiItemResponses = poiItems.stream()
													.map(poiItem -> mapToPOIItemResponse(poiItem, poiLocationRequest)).collect(Collectors.toList());

		Collections.sort(poiItemResponses, new POILocationComparator());
		return new POILocationResponse(poiItemResponses);
	}
	
	private ai.shiftright.poi.services.model.POILocationRequest convert(final POILocationRequest poiLocationRequest) {
		ai.shiftright.poi.services.model.POILocationRequest poiLocationServiceRequest;
		try {
			poiLocationServiceRequest = classMap.get(POICategory.valueOf(poiLocationRequest.getCategory().toUpperCase())).newInstance();
			
		} catch (InstantiationException | IllegalAccessException e) {
			throw new POIApplicationException();
		}
		
		poiLocationServiceRequest.setPoiLocationRequest(poiLocationRequest);
		return poiLocationServiceRequest;
	}

	private static Map<POICategory, Class<? extends ai.shiftright.poi.services.model.POILocationRequest>> classMap = new HashMap<>();

	static {
		classMap.put(POICategory.CINEMA, POICinemaLocationRequest.class);
		classMap.put(POICategory.HOSPITAL, POIHospitalLocationRequest.class);
		classMap.put(POICategory.RESTAURANT, POIRestaurantLocationRequest.class);
		classMap.put(POICategory.SCHOOL, POISchoolLocationRequest.class);
	}
	
	private POIItemResponse mapToPOIItemResponse(final POIItem poiItem, final POILocationRequest poiLocationRequest) {
		return poiItem.createPOIItemResponse(haversine(poiLocationRequest.getLatitude(), poiLocationRequest.getLongitude(), poiItem.getLatitude(), poiItem.getLongitude()));
	}

	/**
	 * https://en.wikipedia.org/wiki/Haversine_formula
	 * 
	 * 
	 * @param requestLatitude
	 * @param requestLongitude
	 * @param dbLatitude
	 * @param dbLongitude
	 * @return
	 */
	private double haversine(final double requestLatitude, final double requestLongitude, 
			final double dbLatitude, final double dbLongitude) {
        double deltaLat = Math.toRadians(dbLatitude - requestLatitude);
        double deltaLon = Math.toRadians(dbLongitude - requestLongitude);
 
        return 6372.8 * (2 * Math.asin(Math.sqrt(Math.pow(Math.sin(deltaLat/2), 2) + Math.pow(Math.sin(deltaLon/2), 2) * Math.cos(Math.toRadians(requestLatitude)) * Math.cos(Math.toRadians(dbLatitude)))));
    }
}


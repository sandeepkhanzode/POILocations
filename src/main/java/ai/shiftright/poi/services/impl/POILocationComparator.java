package ai.shiftright.poi.services.impl;

import java.util.Comparator;

import ai.shiftright.poi.endpoint.model.POIItemResponse;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
public class POILocationComparator implements Comparator<POIItemResponse> {
    
	@Override
    public int compare(final POIItemResponse poi1, final POIItemResponse poi2) {
        return poi1.getDistance() < poi2.getDistance() ? -1 : 1;
    }
}


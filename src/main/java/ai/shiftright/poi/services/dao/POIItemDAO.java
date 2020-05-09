package ai.shiftright.poi.services.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import ai.shiftright.poi.model.entity.POIItem;
import ai.shiftright.poi.services.model.POILocationRequest;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Component("POIItemDAO")
public class POIItemDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<? extends POIItem> getPOIItems(final POILocationRequest poiLocationRequest) {
		return namedParameterJdbcTemplate.query(poiLocationRequest.getQuery(poiLocationRequest.getTableName()), 
						poiLocationRequest.getParameterMap(), poiLocationRequest.getPOIItemMapper());
	}
}

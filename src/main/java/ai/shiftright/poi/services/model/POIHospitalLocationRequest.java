package ai.shiftright.poi.services.model;

import java.util.Map;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import ai.shiftright.poi.model.entity.POICategory;
import ai.shiftright.poi.model.entity.POIHospitalItem;
import ai.shiftright.poi.services.dao.POIHospitalItemMapper;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POIHospitalLocationRequest extends POILocationRequest {

	@Override
	public Map<String, String> getParameterMap() {
		Map<String, String> parameters = super.getParameterMap();
		
		ai.shiftright.poi.endpoint.category.model.POIHospitalLocationRequest endPointModel = (ai.shiftright.poi.endpoint.category.model.POIHospitalLocationRequest) this.poiLocationRequest; 
		String speciaility = endPointModel.getSpeciaility();

		if(!StringUtils.isEmpty(speciaility)) parameters.put("speciailityQ", speciaility);
		
		return parameters;
	}

	@Override
	public String getTableName() {
		return POICategory.HOSPITAL.getTableName();
	}

	@Override
	public RowMapper<POIHospitalItem> getPOIItemMapper() {
		return new POIHospitalItemMapper();
	}

	@Override
	public String getWhereClause() {
		/* Generate Where Clause as per the Category */
		return null;
	}
}

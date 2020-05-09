package ai.shiftright.poi.services.model;

import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import ai.shiftright.poi.model.entity.POICategory;
import ai.shiftright.poi.model.entity.POISchoolItem;
import ai.shiftright.poi.services.dao.POISchoolItemMapper;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POISchoolLocationRequest extends POILocationRequest {

	private String curriculum;

	@Override
	public Map<String, String> getParameterMap() {
		Map<String, String> parameters = super.getParameterMap();
		ai.shiftright.poi.endpoint.category.model.POISchoolLocationRequest endPointModel = (ai.shiftright.poi.endpoint.category.model.POISchoolLocationRequest) this.poiLocationRequest; 
		String curriculum = endPointModel.getCurriculum();

		if(!StringUtils.isEmpty(curriculum)) parameters.put("curriculumQ", curriculum);
		
		return parameters;
	}

	@Override
	public String getTableName() {
		return POICategory.SCHOOL.getTableName();
	}

	@Override
	public RowMapper<POISchoolItem> getPOIItemMapper() {
		return new POISchoolItemMapper();
	}

	@Override
	public String getWhereClause() {
		/* Generate Where Clause as per the Category */
		return null;
	}
}

package ai.shiftright.poi.services.model;

import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import ai.shiftright.poi.model.entity.POICategory;
import ai.shiftright.poi.model.entity.POICinemaItem;
import ai.shiftright.poi.services.dao.POICinemaItemMapper;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POICinemaLocationRequest extends POILocationRequest {

	private String genre;
	private double movieRating;

	@Override
	public Map<String, String> getParameterMap() {
		Map<String, String> parameters = super.getParameterMap();
		ai.shiftright.poi.endpoint.category.model.POICinemaLocationRequest endPointModel = (ai.shiftright.poi.endpoint.category.model.POICinemaLocationRequest) this.poiLocationRequest; 
		String genre = endPointModel.getGenre();
		double movieRating = endPointModel.getMovieRating();

		if(!StringUtils.isEmpty(genre)) parameters.put("genreQ", genre);
		if(movieRating > 0.0) parameters.put("movieRatingQ", new Double(movieRating).toString());
		
		return parameters;
	}

	@Override
	public String getTableName() {
		return POICategory.RESTAURANT.getTableName();
	}

	@Override
	public RowMapper<POICinemaItem> getPOIItemMapper() {
		return new POICinemaItemMapper();
	}

	@Override
	public String getWhereClause() {
		/* Generate Where Clause as per the Category */
		return null;
	}
}

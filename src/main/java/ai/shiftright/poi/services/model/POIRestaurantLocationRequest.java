package ai.shiftright.poi.services.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import ai.shiftright.poi.model.entity.POICategory;
import ai.shiftright.poi.model.entity.POIRestaurantItem;
import ai.shiftright.poi.services.dao.POIRestaurantItemMapper;
import lombok.Data;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@Data
public class POIRestaurantLocationRequest extends POILocationRequest {

	@Override
	public Map<String, String> getParameterMap() {
		Map<String, String> parameters = super.getParameterMap();

		ai.shiftright.poi.endpoint.category.model.POIRestaurantLocationRequest endPointModel = (ai.shiftright.poi.endpoint.category.model.POIRestaurantLocationRequest) this.poiLocationRequest; 
		String cuisine = endPointModel.getCuisine();
		String delivery = endPointModel.getDelivery();
		String pricePoint = endPointModel.getPricePoint();
		
		if(!StringUtils.isEmpty(cuisine)) parameters.put("cuisineQ", cuisine);
		if(!StringUtils.isEmpty(delivery)) parameters.put("deliveryQ", delivery);
		if(!StringUtils.isEmpty(pricePoint)) parameters.put("pricePointQ", pricePoint);
		
		return parameters;
	}

	@Override
	public String getTableName() {
		return POICategory.RESTAURANT.getTableName();
	}

	@Override
	public RowMapper<POIRestaurantItem> getPOIItemMapper() {
		return new POIRestaurantItemMapper();
	}

	@Override
	public String getWhereClause() {
		List<String> clauses = new ArrayList<>();

		ai.shiftright.poi.endpoint.category.model.POIRestaurantLocationRequest endPointModel = (ai.shiftright.poi.endpoint.category.model.POIRestaurantLocationRequest) this.poiLocationRequest; 
		String cuisine = endPointModel.getCuisine();
		String delivery = endPointModel.getDelivery();
		String pricePoint = endPointModel.getPricePoint();
		
		if(!StringUtils.isEmpty(cuisine)) clauses.add((" cuisine = '" + cuisine + "'"));
		if(!StringUtils.isEmpty(delivery)) clauses.add((" delivery = '" + delivery + "'"));
		if(!StringUtils.isEmpty(pricePoint)) clauses.add((" pricePoint = '" + pricePoint + "'"));
		
		String allClauses = String.join(this.whereClauseJoinKey, clauses);
		return clauses.size() > 0 ? this.whereClauseKey + allClauses : "";
	}
}

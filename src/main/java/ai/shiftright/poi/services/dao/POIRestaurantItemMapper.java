package ai.shiftright.poi.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ai.shiftright.poi.model.entity.POIRestaurantItem;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
public class POIRestaurantItemMapper implements RowMapper<POIRestaurantItem> {

	@Override
	public POIRestaurantItem mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new POIRestaurantItem(rs.getString("name"), rs.getString("category"), rs.getString("address"), 
				rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getString("pricePoint"), 
				rs.getString("cuisine"), rs.getString("delivery"));
	}
}

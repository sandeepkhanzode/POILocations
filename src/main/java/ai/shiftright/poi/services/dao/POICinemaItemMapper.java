package ai.shiftright.poi.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ai.shiftright.poi.model.entity.POICinemaItem;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
public class POICinemaItemMapper implements RowMapper<POICinemaItem> {

	@Override
	public POICinemaItem mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new POICinemaItem(rs.getString("name"), rs.getString("category"), rs.getString("address"), 
				rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getString("genre"), rs.getDouble("movieRating"));

	}

}

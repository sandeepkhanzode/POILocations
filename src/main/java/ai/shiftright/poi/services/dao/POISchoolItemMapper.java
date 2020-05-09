package ai.shiftright.poi.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ai.shiftright.poi.model.entity.POISchoolItem;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
public class POISchoolItemMapper implements RowMapper<POISchoolItem> {

	@Override
	public POISchoolItem mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new POISchoolItem(rs.getString("name"), rs.getString("category"), rs.getString("address"), 
				rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getString("curriculum"));

	}

}

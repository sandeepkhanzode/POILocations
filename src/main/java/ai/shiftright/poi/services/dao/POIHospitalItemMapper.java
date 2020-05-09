package ai.shiftright.poi.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ai.shiftright.poi.model.entity.POIHospitalItem;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
public class POIHospitalItemMapper implements RowMapper<POIHospitalItem> {

	@Override
	public POIHospitalItem mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new POIHospitalItem(rs.getString("name"), rs.getString("category"), rs.getString("address"), 
				rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getString("speciality"));

	}

}

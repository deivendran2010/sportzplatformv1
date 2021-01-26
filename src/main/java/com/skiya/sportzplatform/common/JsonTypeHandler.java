package com.skiya.sportzplatform.common;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@MappedTypes(Object.class)
public class JsonTypeHandler extends BaseTypeHandler<Object> {
	
	private final Logger log = LoggerFactory.getLogger(JsonTypeHandler.class);

	private static final PGobject jsonObject = new PGobject();

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		jsonObject.setType("json");
		try {
			jsonObject.setValue(new ObjectMapper().writeValueAsString(parameter)); // Converting java objects to json
			log.debug("Value..." + jsonObject.getValue());																	// strings
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		ps.setObject(i, jsonObject);
	}

	@Override
	public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return rs.getString(columnName); // Return to String
	}

	@Override
	public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getString(columnIndex);
	}

	@Override
	public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getString(columnIndex);
	}

}

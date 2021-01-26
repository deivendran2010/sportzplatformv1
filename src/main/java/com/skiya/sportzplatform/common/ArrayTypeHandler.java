package com.skiya.sportzplatform.common;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeException;

@MappedJdbcTypes({ JdbcType.ARRAY })
@MappedTypes(String[].class)
public class ArrayTypeHandler extends BaseTypeHandler<Object[]> {

	private static final String TYPE_NAME_VARCHAR = "varchar";
	private static final String TYPE_NAME_INTEGER = "integer";
	private static final String TYPE_NAME_BOOLEAN = "boolean";
	private static final String TYPE_NAME_NUMERIC = "numeric";

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object[] parameter, JdbcType jdbcType)
			throws SQLException {
		String typeName = null;
		if (parameter instanceof Integer[]) {
			typeName = TYPE_NAME_INTEGER;
		} else if (parameter instanceof String[]) {
			typeName = TYPE_NAME_VARCHAR;
		} else if (parameter instanceof Boolean[]) {
			typeName = TYPE_NAME_BOOLEAN;
		} else if (parameter instanceof Double[]) {
			typeName = TYPE_NAME_NUMERIC;
		}

		if (typeName == null) {
			throw new TypeException(
					"ArrayTypeHandler parameter typeName error, your type is " + parameter.getClass().getName());
		}
		Array array = ps.getConnection().createArrayOf(typeName, parameter);
		ps.setArray(i, array);
	}

	@Override
	public Object[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return extractArray(rs.getArray(columnName));
	}

	@Override
	public Object[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return extractArray(rs.getArray(columnIndex));
	}

	@Override
	public Object[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return extractArray(cs.getArray(columnIndex));
	}

	protected Object[] extractArray(Array array) throws SQLException {
		if (array == null) {
			return null;
		}
		try {
			return (Object[]) array.getArray();
		} catch (Exception e) {
		}
		return null;
	}
}

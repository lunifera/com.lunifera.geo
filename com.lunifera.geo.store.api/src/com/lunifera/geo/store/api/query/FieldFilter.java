package com.lunifera.geo.store.api.query;

import com.lunifera.geo.store.api.query.QueryBuilder.CompareType;

public class FieldFilter implements Filter {

	final String field;
	final CompareType type;
	final Object value;

	public FieldFilter(String field, CompareType type, Object value) {
		this.field = field;
		this.type = type;
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public CompareType getType() {
		return type;
	}

	public Object getValue() {
		return value;
	}

}

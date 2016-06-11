package com.lunifera.geo.store.api.query;

import static com.lunifera.geo.store.api.query.QueryBuilder.CompareType.EQUALS;
import static com.lunifera.geo.store.api.query.QueryBuilder.CompareType.GREATER;

import java.time.LocalDateTime;

public class TestClass {

	public void filter() {
		QueryBuilder b = null;
		
		Filter x = b.and(b.subjectId(EQUALS, "Flo00001"), b.timestamp(GREATER, LocalDateTime.now()));
		Filter result = b.or(x, b.subjectId(EQUALS, "Klemens"));
		
		Query query = b.build(result);
	}
}

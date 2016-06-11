package com.lunifera.geo.store.api.query;

import com.lunifera.geo.store.api.dto.LineGeometryDTO;

public class IntersectsFilter implements Filter {

	final LineGeometryDTO dto;

	public IntersectsFilter(LineGeometryDTO dto) {
		this.dto = dto;
	}

	public LineGeometryDTO getLineGeometryDTO() {
		return dto;
	}

}

package com.lunifera.geo.store.api.query;

import com.lunifera.geo.store.api.dto.AreaGeometryDTO;

public class WithinFilter implements Filter {

	final AreaGeometryDTO dto;

	public WithinFilter(AreaGeometryDTO dto) {
		this.dto = dto;
	}

	public AreaGeometryDTO getAreaGeometryDTO() {
		return dto;
	}

}

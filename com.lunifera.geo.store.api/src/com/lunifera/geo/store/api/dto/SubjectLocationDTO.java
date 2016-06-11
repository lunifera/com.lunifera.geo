package com.lunifera.geo.store.api.dto;

import java.time.LocalDateTime;

import org.osgi.dto.DTO;

import com.lunifera.geo.api.dto.PositionDTO;

public class SubjectLocationDTO extends DTO {

	/**
	 * The id of the subject that has been at this coordinates at the defined
	 * time.
	 */
	public String subjectId;

	/**
	 * The point based on latitude and longitude
	 */
	public PositionDTO point;

	/**
	 * The height in meters above the sea.
	 */
	public double height;

	/**
	 * The current speed at this point.
	 */
	public double speed;

	/**
	 * The direction of movement in degrees. Direction north means 0 degrees.
	 * East means 90 degrees,...
	 */
	public double direction;

	/**
	 * The timestamp
	 */
	public LocalDateTime timestamp;

}

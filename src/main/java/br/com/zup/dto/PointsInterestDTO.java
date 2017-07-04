package br.com.zup.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class PointsInterestDTO {

	private Long id;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	private int coordinatedX;
	@NotNull
	private int coordinatedY;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public int getCoordinatedX() {
		return coordinatedX;
	}

	public void setCoordinatedX(int coordenadaX) {
		this.coordinatedX = coordenadaX;
	}

	public int getCoordinatedY() {
		return coordinatedY;
	}

	public void setCoordinatedY(int coordenadaY) {
		this.coordinatedY = coordenadaY;
	}

}

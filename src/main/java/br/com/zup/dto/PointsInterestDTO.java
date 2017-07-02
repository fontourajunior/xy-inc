package br.com.zup.dto;

public class PointsInterestDTO {

	private Long id;
	private String name;
	private int coordinatedX;
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

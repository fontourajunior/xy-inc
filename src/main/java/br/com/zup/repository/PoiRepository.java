package br.com.zup.repository;

import java.util.List;

import br.com.zup.dto.PointsInterestDTO;

public interface PoiRepository {

	/**
	 * Pesquisa lista de produtos de um cliente
	 *
	 * @param filtro
	 * @return
	 */
	List<PointsInterestDTO> findAllPointsInterest();

	void savePointInterest(PointsInterestDTO poi);

	List<String> findPointsInterestFoProximity(Integer coordinateReferenceX, Integer coordinateReferenceY, Integer distance);

}

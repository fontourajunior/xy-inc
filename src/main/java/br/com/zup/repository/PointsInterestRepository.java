package br.com.zup.repository;

import java.util.List;

import br.com.zup.dto.PointsInterestDTO;

public interface PointsInterestRepository {

	/**
	 * Pesquisa lista de produtos de um cliente
	 *
	 * @param filtro
	 * @return
	 */
	List<PointsInterestDTO> findAllPointsInterest();

	/**
	 * salva um ponto de interesse
	 * @param poi
	 */
	void savePointInterest(PointsInterestDTO pointInterest);


	/**
	 * Bsuca pontos de interesse por proximidade
	 * @param coordinateReferenceX
	 * @param coordinateReferenceY
	 * @param distance
	 * @return
	 */
	List<String> findPointsInterestFoProximity(Integer coordinateReferenceX, Integer coordinateReferenceY, Integer distance);

}

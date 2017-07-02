package br.com.zup.services;

import java.util.List;

import br.com.zup.dto.PointsInterestDTO;

public interface PoiService {

	/**
	 * Busca todos os pontos de referência
	 * @return
	 */
	List<PointsInterestDTO> buscarTodosPontosDeRefrencia();

	/**
	 * Salva um ponto de interesse
	 * @param poi
	 */
	void salvarPontoInteresse(PointsInterestDTO poi);

	/**
	 * Pesquisa todos os pontos de interesse em uma distância
	 * @param coordinateReferenceX
	 * @param coordinateReferenceY
	 * @param distance
	 * @return
	 */
	List<String> findPointsInterestFoProximity(Integer coordinateReferenceX, Integer coordinateReferenceY, Integer distance);

}

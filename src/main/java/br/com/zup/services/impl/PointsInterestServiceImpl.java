package br.com.zup.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.dto.PointsInterestDTO;
import br.com.zup.exceptions.BusinessException;
import br.com.zup.repository.PointsInterestRepository;
import br.com.zup.services.PointsInterestService;

@Service
@Transactional
public class PointsInterestServiceImpl implements PointsInterestService {

	@Autowired
	private PointsInterestRepository poiRepository;

	/**
	 * Busca todos os pontos de interesse existentes
	 */
	@Override
	public List<PointsInterestDTO> findAll() {
		return poiRepository.findAllPointsInterest();
	}

	/**
	 * Salva um determinado ponto de interesse
	 * @throws Exception
	 * @throws BusinessException
	 */
	@Override
	public void saveInterestPoints(PointsInterestDTO pointInterest) throws BusinessException {

		if(pointInterest.getCoordinatedX() < 0 || pointInterest.getCoordinatedY() < 0) {
			throw new BusinessException("Não é possível salvar pontos de interesse com coordenadas negativas");
		}

		poiRepository.savePointInterest(pointInterest);
	}

	/**
	 * Buscar pontos de interresse por proximidade
	 */
	@Override
	public List<String> findPointsInterestFoProximity(Integer coordinateReferenceX,
			Integer coordinateReferenceY, Integer distance) {
		return poiRepository.findPointsInterestFoProximity(coordinateReferenceX, coordinateReferenceY, distance);
	}

}

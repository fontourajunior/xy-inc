package br.com.zup.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.dto.PointsInterestDTO;
import br.com.zup.repository.PoiRepository;
import br.com.zup.services.PoiService;

@Service
@Transactional
public class PoiServiceImpl implements PoiService {

	@Autowired
	private PoiRepository poiRepository;

	@Override
	public List<PointsInterestDTO> buscarTodosPontosDeRefrencia() {
		return poiRepository.findAllPointsInterest();
	}

	@Override
	public void salvarPontoInteresse(PointsInterestDTO poi) {
		poiRepository.savePointInterest(poi);
	}

	@Override
	public List<String> findPointsInterestFoProximity(Integer coordinateReferenceX,
			Integer coordinateReferenceY, Integer distance) {
		return poiRepository.findPointsInterestFoProximity(coordinateReferenceX, coordinateReferenceY, distance);
	}



}

package br.com.zup.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.dto.PointsInterestDTO;
import br.com.zup.services.PoiService;

@RestController
@RequestMapping(value = "/points-interest")
public class PoiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PoiController.class);

	@Autowired
	private PoiService poiService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<PointsInterestDTO> buscarCliente(){
		LOGGER.info("Pesquisando todos os pontos de interesse.");
		return poiService.buscarTodosPontosDeRefrencia();
	}

	//	@RequestMapping(value="/insert", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public void salvarPontosInteresse(@Valid @RequestBody PointsInterestDTO poi) {
		LOGGER.info("Salvando pontos de interesse na base de dados.");
		poiService.salvarPontoInteresse(poi);
	}

	//	@RequestMapping(value="/points-interest-proximity/coordinateReferenceX/{coordinateReferenceX}/coordinateReferenceY/{coordinateReferenceY}/distance{distance}",params=""  method = RequestMethod.GET)
	@RequestMapping(value="/points-interest-proximity" ,params={"coordinateReferenceX", "coordinateReferenceY", "distance"}, method = RequestMethod.GET)
	private List<String> findPointsInterestFoProximity(@Valid Integer coordinateReferenceX, Integer coordinateReferenceY, Integer distance) {
		LOGGER.info("Buscan pontos de interesse por proximidade.");
		return poiService.findPointsInterestFoProximity(coordinateReferenceX, coordinateReferenceY, distance);
	}

}

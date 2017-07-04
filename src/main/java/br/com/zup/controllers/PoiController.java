package br.com.zup.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.dto.PointsInterestDTO;
import br.com.zup.services.PointsInterestService;

@RestController
@RequestMapping(value = "/points-interest")
public class PoiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PoiController.class);

	@Autowired
	private PointsInterestService poiService;

	/**
	 * Método responsável por pesquisar todos os pontos de interesse, cadastrados na base de dados
	 * @return
	 */
	@GetMapping()
	@ResponseBody
	public List<PointsInterestDTO> findAll(){
		LOGGER.info("Pesquisando todos os pontos de interesse.");
		return poiService.findAll();
	}

	/**
	 * Método reponsável por efetuar o cadastro de um novo ponto de endereço
	 * @param poi
	 * @throws Exception
	 */
	@PostMapping()
	public void saveInterestPoints(@Valid @RequestBody PointsInterestDTO poi) throws Exception {
		LOGGER.info("Salvando pontos de interesse na base de dados.");
		poiService.saveInterestPoints(poi);
	}

	/**
	 * Método responsável por buscar todos os pontos de interesse que se encontram a uma distância x
	 * de uma coordenada.
	 * @param coordinateReferenceX
	 * @param coordinateReferenceY
	 * @param distance
	 * @return
	 */
	@GetMapping("/points-interest-proximity")
	private List<String> findPointsInterestFoProximity(@Valid @RequestParam("coordinateReferenceX") Integer coordinateReferenceX
			, @RequestParam("coordinateReferenceY") Integer coordinateReferenceY
			, @RequestParam("distance")Integer distance) {
		LOGGER.info("Buscando pontos de interesse por proximidade.");
		return poiService.findPointsInterestFoProximity(coordinateReferenceX, coordinateReferenceY, distance);
	}

}

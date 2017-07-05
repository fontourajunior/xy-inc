package br.com.zup.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.dto.PointsInterestDTO;
import br.com.zup.exceptions.BusinessException;
import br.com.zup.services.PointsInterestService;

@RestController
@RequestMapping(value = "/api/points-interest")
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
	 * @throws BusinessException
	 */
	@PostMapping()
	public ResponseEntity saveInterestPoints(@Valid @RequestBody PointsInterestDTO poi) throws Exception, BusinessException {
		LOGGER.info("Salvando pontos de interesse na base de dados.");
		poiService.saveInterestPoints(poi);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Método responsável por buscar todos os pontos de interesse que se encontram a uma distância x
	 * de uma coordenada.
	 * @param coordinateReferenceX
	 * @param coordinateReferenceY
	 * @param distance
	 * @return
	 */
	@GetMapping("/proximity")
	private List<String> findPointsInterestFoProximity(@Valid @RequestParam("coordinateReferenceX") Integer coordinateReferenceX
			, @RequestParam("coordinateReferenceY") Integer coordinateReferenceY
			, @RequestParam("distance")Integer distance) {
		LOGGER.info("Buscando pontos de interesse por proximidade.");
		return poiService.findPointsInterestFoProximity(coordinateReferenceX, coordinateReferenceY, distance);
	}

}

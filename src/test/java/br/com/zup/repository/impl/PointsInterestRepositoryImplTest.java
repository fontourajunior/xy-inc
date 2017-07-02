package br.com.zup.repository.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.AbstractTest;
import br.com.zup.dto.PointsInterestDTO;

@Transactional
public class PointsInterestRepositoryImplTest extends AbstractTest {

	private static final Logger LOGGER = Logger.getLogger(PointsInterestRepositoryImplTest.class);

	@Autowired
	private PointsInterestRepositoryImpl pointsInterestRepository;

	@Test
	public void testfindAllPointsInterest() {
		List<PointsInterestDTO> pointsInterest = pointsInterestRepository.findAllPointsInterest();
		LOGGER.info("Listar todos: ");
		pointsInterest.forEach(pi -> {
			LOGGER.info("Name: " + pi.getName());
			LOGGER.info("Coordenate X: " + pi.getCoordinatedX());
			LOGGER.info("Coordenate Y: " + pi.getCoordinatedY());
			LOGGER.info("-----------------");
		});

	}

	@Test
	public void savePointInterest() {
		PointsInterestDTO pointInterest = new PointsInterestDTO();
		pointInterest.setName("Google");
		pointInterest.setCoordinatedX(45);
		pointInterest.setCoordinatedY(22);
		pointsInterestRepository.savePointInterest(pointInterest);
		LOGGER.info("Save point interest");

	}

	@Test
	public void findPointsInterestFoProximity() {
		Integer coordenateX = 20;
		Integer coordenateY = 10;
		Integer distance = 10;
		LOGGER.info("Pesquisar por proximidade: ");
		pointsInterestRepository.findPointsInterestFoProximity(coordenateX, coordenateY, distance).forEach(pi -> {
			LOGGER.info("Nome: " + pi);
		});;
	}


}

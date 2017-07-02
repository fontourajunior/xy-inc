package br.com.zup.repository.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.dto.PointsInterestDTO;
import br.com.zup.repository.PointsInterestRepository;

@Service
@Transactional
public class PointsInterestRepositoryImpl implements PointsInterestRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	/**
	 * Busca todos os pontos de interesse cadastrados
	 */
	@Override
	public List<PointsInterestDTO> findAllPointsInterest() {

		String query = "SELECT ID, NAME, COORDINATED_X, COORDINATED_Y FROM TB_POINTS_INTEREST";
		HashMap<String, Object> parametros = new HashMap<String, Object>();

		List<PointsInterestDTO> pontosInteresse = namedJdbcTemplate.query(query, parametros, (rs, rowNum) -> {
			PointsInterestDTO atividade = new PointsInterestDTO();
			atividade.setId(rs.getLong("id"));
			atividade.setName(rs.getString("name"));
			atividade.setCoordinatedX(rs.getInt("coordinated_x"));
			atividade.setCoordinatedY(rs.getInt("coordinated_y"));
			return atividade;
		});
		return pontosInteresse;
	}

	/**
	 * Salva um ponto de interesse
	 * @param pointInterest
	 */
	@Override
	public void savePointInterest(PointsInterestDTO pointInterest) {
		String insertQuery = "INSERT INTO TB_POINTS_INTEREST (NAME, COORDINATED_X, COORDINATED_Y) values (:name, :coordinated_x, :coordinated_Y)";
		HashMap<String, Object> parametros = new HashMap<>();
		parametros.put("name", pointInterest.getName());
		parametros.put("coordinated_x", pointInterest.getCoordinatedX());
		parametros.put("coordinated_Y", pointInterest.getCoordinatedY());
		namedJdbcTemplate.update(insertQuery, parametros);
	}

	/**
	 * Busca pontos de interesse por proximidade
	 * @param coordinateReferenceX
	 * @param coordinateReferenceY
	 * @param distance
	 */
	@Override
	public List<String> findPointsInterestFoProximity(Integer coordinateReferenceX,
			Integer coordinateReferenceY, Integer distance) {

		String query = "SELECT * FROM TB_POINTS_INTEREST WHERE SQRT(POWER(COORDINATED_X - :coordinated_x, 2) + POWER(COORDINATED_Y  - :coordinated_y, 2)) < :distance";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("coordinated_x", coordinateReferenceX);
		parameters.put("coordinated_y", coordinateReferenceY);
		parameters.put("distance", distance);

		List<String> pointsInterest = namedJdbcTemplate.query(query, parameters, (rs, rowNum) -> {
			return rs.getString("name");
		});
		return pointsInterest;
	}

}

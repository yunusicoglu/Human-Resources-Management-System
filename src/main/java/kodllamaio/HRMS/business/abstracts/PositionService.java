package kodllamaio.HRMS.business.abstracts;

import java.util.List;

import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.entities.concretes.Position;

public interface PositionService {

	DataResult<List<Position>> getAll();
	Result add(Position position);
}

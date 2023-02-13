package kodllamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodllamaio.HRMS.business.abstracts.PositionService;
import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodllamaio.HRMS.core.utilities.results.SuccessResult;
import kodllamaio.HRMS.dataAccess.abstracts.PositionRepository;
import kodllamaio.HRMS.entities.concretes.Position;

@Service
public class PositionManager implements PositionService{

	private PositionRepository positionRepository;
	
	public PositionManager(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}
	
	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(positionRepository.findAll(), "Is pozisyonlari listelendi");
	}

	@Override
	public Result add(Position position) {
		
		positionRepository.save(position);
		return new SuccessResult("Is pozisyonu eklendi.");
		
	}

	
	
}

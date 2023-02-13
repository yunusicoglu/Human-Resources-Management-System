package kodllamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodllamaio.HRMS.business.abstracts.PositionService;
import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {
	
	PositionService positionService;

	public PositionsController(PositionService positionService) {
		this.positionService = positionService;
	}

	@GetMapping("/getall")
	public DataResult<List<Position>> getAll(){
		return positionService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Position position) {
		return positionService.add(position);
	}
	
}

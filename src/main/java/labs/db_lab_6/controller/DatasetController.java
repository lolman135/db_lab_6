package labs.db_lab_6.controller;

import labs.db_lab_6.dto.DatasetDto;
import labs.db_lab_6.entity.Dataset;
import labs.db_lab_6.service.dataset.DatasetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DatasetController {

    private final DatasetService datasetService;

    public DatasetController(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @GetMapping("/datasets")
    public ResponseEntity<List<Dataset>> findAll(){
        List<Dataset> datasets = datasetService.findAll();
        return ResponseEntity.ok(datasets);
    }

    @GetMapping("/datasets/{id}")
    public ResponseEntity<Dataset> findById(@PathVariable("id") Long id){
        Dataset dataset = datasetService.findById(id);
        return ResponseEntity.ok(dataset);
    }

    @PostMapping("/datasets")
    public ResponseEntity<Dataset> save(@RequestBody DatasetDto dto){
        Dataset dataset = datasetService.save(dto);
        return ResponseEntity.ok(dataset);
    }

    @PutMapping("/datasets/{id}")
    public ResponseEntity<Dataset> updateById(@PathVariable("id") Long id, @RequestBody DatasetDto dto){
        Dataset dataset = datasetService.updateById(dto, id);
        return ResponseEntity.ok(dataset);
    }

    @DeleteMapping("/datasets/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(datasetService.deleteById(id));
    }
}

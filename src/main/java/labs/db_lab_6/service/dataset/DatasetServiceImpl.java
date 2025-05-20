package labs.db_lab_6.service.dataset;

import labs.db_lab_6.dto.DatasetDto;
import labs.db_lab_6.dto.ResponseDto;
import labs.db_lab_6.entity.Dataset;
import labs.db_lab_6.entity.Response;
import labs.db_lab_6.exception.ResourceNotFoundException;
import labs.db_lab_6.mapper.DatasetMapper;
import labs.db_lab_6.mapper.ResponseMapper;
import labs.db_lab_6.repository.DatasetRepository;
import labs.db_lab_6.repository.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasetServiceImpl implements DatasetService {

    private final DatasetRepository datasetRepository;
    private final ResponseRepository responseRepository;

    public DatasetServiceImpl(DatasetRepository datasetRepository, ResponseRepository responseRepository) {
        this.datasetRepository = datasetRepository;
        this.responseRepository = responseRepository;
    }

    @Override
    public List<Dataset> findAll() {
        return datasetRepository.findAll();
    }

    @Override
    public Dataset findById(Long id) {
        if (id == null){
            throw new IllegalArgumentException("Wrong id provided");
        }
        return datasetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with id:" + id));
    }

    @Override
    public Dataset save(DatasetDto dto) {
        if (dto == null){
            throw new IllegalArgumentException("Wrong data provided");
        }
        Dataset dataset = DatasetMapper.toEntity(dto, responseRepository);
        return datasetRepository.save(dataset);
    }

    @Override
    public Dataset updateById(DatasetDto dto, Long id) {
        if (id == null || dto == null){
            throw new IllegalArgumentException("Wrong data provided");
        }

        if (datasetRepository.existsById(id)){
            Dataset dataset = DatasetMapper.toEntity(dto, responseRepository);
            dataset.setId(id);
            return datasetRepository.save(dataset);
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (datasetRepository.existsById (id)){
            datasetRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

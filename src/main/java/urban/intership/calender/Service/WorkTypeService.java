package urban.intership.calender.Service;

import org.springframework.stereotype.Service;
import urban.intership.calender.DTO.WorkTypeDTO;
import urban.intership.calender.Model.Worktype;
import urban.intership.calender.Request.CreateWorkTypeRequest;

import java.util.List;

@Service
public interface WorkTypeService {
    List<WorkTypeDTO> getAllWorkType();
    String createWorkType(CreateWorkTypeRequest request);
    void delete(Long id);
}
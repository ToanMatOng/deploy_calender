package urban.intership.calender.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urban.intership.calender.DTO.WorkTypeDTO;
import urban.intership.calender.Model.Worktype;
import urban.intership.calender.Repository.WorkTypeRepository;
import urban.intership.calender.Request.CreateWorkTypeRequest;
import urban.intership.calender.Service.WorkTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkTypeServiceImpl implements WorkTypeService {

    @Autowired
    private WorkTypeRepository workTypeRepository;

    private WorkTypeDTO toWokrTypeDTO(Worktype worktype){
        WorkTypeDTO dto= new WorkTypeDTO();
        dto.setId(worktype.getId()  );
        dto.setWorkMode(worktype.getWorkMode());
        dto.setDescription(worktype.getDescription());
        return dto;
    }
    private List<WorkTypeDTO> toWorkTypeDTOlst(List<Worktype> worktypes){
        return worktypes.stream()
                .map(this::toWokrTypeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkTypeDTO> getAllWorkType() {
        try{
            List<Worktype> worktypes= workTypeRepository.findAll();
            List<WorkTypeDTO> wokrTypeDTOS= toWorkTypeDTOlst(worktypes);
            return wokrTypeDTOS;
        }catch (Exception e){
            return List.of();
        }
    }

    @Override
    public String createWorkType(CreateWorkTypeRequest request) {
        Optional<Worktype> checkWorkType= workTypeRepository.findByWorkMode(request.workMode());
        if (checkWorkType.isPresent())return "Chế độ làm việc đã tồn tại!";
        try {
            Worktype newWokType= new Worktype();
            newWokType.setWorkMode(request.workMode());
            newWokType.setDescription(request.description());
            workTypeRepository.save(newWokType);
            return "Tạo mới thành công!";
        }catch (Exception e){
            return "Co loi roi: "+e.getMessage();
        }
    }

    @Override
    public void delete(Long id) {
        workTypeRepository.deleteById(id);
    }
}
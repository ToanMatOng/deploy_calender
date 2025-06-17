package urban.intership.calender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import urban.intership.calender.DTO.WorkTypeDTO;
import urban.intership.calender.Request.CreateWorkTypeRequest;
import urban.intership.calender.Service.WorkTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/workType")
public class WorkTypeController {
    @Autowired
    public WorkTypeService workTypeService;

    @GetMapping
    public List<WorkTypeDTO> getAllWorkTypeDTO(){
        return workTypeService.getAllWorkType();
    }

    @PostMapping("/create")
    public String createWorkType(@RequestBody CreateWorkTypeRequest request){
        return workTypeService.createWorkType(request);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        workTypeService.delete(id);
    }
}
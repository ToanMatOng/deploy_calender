package urban.intership.calender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import urban.intership.calender.Model.Headquarter;
import urban.intership.calender.Request.CreateHeadQuarterRequest;
import urban.intership.calender.Service.HeadQuarterService;

import java.util.List;

@RestController
@RequestMapping("/api/headquarter")
public class HeadQuarterController {
    @Autowired
    private HeadQuarterService headQuarterService;

    @GetMapping
    public List<Headquarter> getAllHeadQuarter(){
        return headQuarterService.getAllHeadQuarter();
    }

    @PostMapping("/create")
    public Headquarter createHeadQuarter(@RequestBody CreateHeadQuarterRequest request){
        return headQuarterService.createHeadQuarter(request);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        headQuarterService.delete(id);
    }
}
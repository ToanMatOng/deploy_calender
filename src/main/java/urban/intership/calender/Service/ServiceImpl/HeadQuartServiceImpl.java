package urban.intership.calender.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urban.intership.calender.Model.Event;
import urban.intership.calender.Model.Headquarter;
import urban.intership.calender.Repository.EventRepository;
import urban.intership.calender.Repository.HeadQuarterRepository;
import urban.intership.calender.Request.CreateHeadQuarterRequest;
import urban.intership.calender.Service.HeadQuarterService;

import java.util.List;


@Service
public class HeadQuartServiceImpl implements HeadQuarterService {
    @Autowired
    private HeadQuarterRepository headQuarterRepository;
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Headquarter> getAllHeadQuarter() {
        return headQuarterRepository.findAll();
    }

    @Override
    public Headquarter createHeadQuarter(CreateHeadQuarterRequest request) {
        Headquarter newHeadQuarter= new Headquarter();
        newHeadQuarter.setName(request.name());
        newHeadQuarter.setAddress(request.address());
        newHeadQuarter.setDescription(request.description());

        return headQuarterRepository.save(newHeadQuarter);
    }

    @Override
    public void delete(Long id) {
        headQuarterRepository.deleteById(id);
    }
}
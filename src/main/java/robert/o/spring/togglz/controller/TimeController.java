package robert.o.spring.togglz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import robert.o.spring.togglz.service.TimeService;

@RestController
@RequestMapping("time")
public class TimeController {

    private TimeService timeService;

    public TimeController(TimeService timeService) {

        this.timeService = timeService;
    }

    @GetMapping("now")
    public String now() {

        return timeService.now();
    }
}

package robert.o.spring.togglz.service.impl;

import org.springframework.stereotype.Service;
import robert.o.spring.togglz.service.DateService;

import static java.time.OffsetDateTime.now;

@Service
public class OffsetDateTimeService implements DateService {

    @Override
    public int getWeekDayAsInt() {

        return now().getDayOfWeek().getValue();
    }

    @Override
    public String getNowAsString() {

        return now().toString();
    }
}

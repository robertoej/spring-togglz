package robert.o.spring.togglz.configuration;

import org.springframework.stereotype.Component;
import org.togglz.core.activation.Parameter;
import org.togglz.core.activation.ParameterBuilder;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.spi.ActivationStrategy;
import org.togglz.core.user.FeatureUser;
import robert.o.spring.togglz.service.DateService;

import static java.lang.Integer.parseInt;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class WeekdayActivationStrategy implements ActivationStrategy {

    private DateService dateService;

    public WeekdayActivationStrategy(DateService dateService) {

        this.dateService = dateService;
    }

    @Override
    public String getId() {

        return "weekday";
    }

    @Override
    public String getName() {

        return "Weekday strategy";
    }

    @Override
    public boolean isActive(FeatureState featureState, FeatureUser featureUser) {

        String activeWeekday = featureState.getParameter("day");

        return !isEmpty(activeWeekday) && dateService.getWeekDayAsInt() == parseInt(activeWeekday);
    }

    @Override
    public Parameter[] getParameters() {

        return new Parameter[] {
                ParameterBuilder.create("day").label("Day of week")
        };
    }
}

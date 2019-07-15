package robert.o.spring.togglz.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.togglz.core.repository.FeatureState;
import robert.o.spring.togglz.service.DateService;

import java.util.Random;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeekdayActivationStrategyTest {

    private final String WEEKDAY_AS_STRING = valueOf(new Random().nextInt(7));

    private final String DAY_PARAM = "day";

    private final String SUNDAY_AS_STRING = "7";

    @InjectMocks
    private WeekdayActivationStrategy strategy;

    @Mock
    private DateService dateService;

    @Mock
    private FeatureState featureState;

    @Test
    public void isActiveOnSunday() {

        when(featureState.getParameter(DAY_PARAM)).thenReturn(SUNDAY_AS_STRING);
        when(dateService.getWeekDayAsInt()).thenReturn(parseInt(SUNDAY_AS_STRING));

        assertTrue(strategy.isActive(featureState, null));
    }

    @Test
    public void isActiveOnWeekdays() {

        when(featureState.getParameter(DAY_PARAM)).thenReturn(SUNDAY_AS_STRING);
        when(dateService.getWeekDayAsInt()).thenReturn(parseInt(WEEKDAY_AS_STRING));

        assertFalse(strategy.isActive(featureState, null));
    }
}
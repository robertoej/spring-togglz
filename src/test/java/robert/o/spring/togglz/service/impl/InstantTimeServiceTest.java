package robert.o.spring.togglz.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.togglz.core.manager.FeatureManager;
import robert.o.spring.togglz.service.DateService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static robert.o.spring.togglz.constants.MessageConstants.FEATURE_NOT_ENABLED_PATTERN;
import static robert.o.spring.togglz.feature.TogglzFeature.NOW_API;

@RunWith(MockitoJUnitRunner.class)
public class InstantTimeServiceTest {

    private final String TODAY_AS_STRING = "TODAY";

    @InjectMocks
    private InstantTimeService instantTimeService;

    @Mock
    private FeatureManager featureManager;

    @Mock
    private DateService dateService;

    @Test
    public void testEnabledNow() {

        when(featureManager.isActive(NOW_API)).thenReturn(true);
        when(dateService.getNowAsString()).thenReturn(TODAY_AS_STRING);

        final String response = instantTimeService.now();

        verify(dateService).getNowAsString();
        assertEquals(TODAY_AS_STRING, response);
    }

    @Test
    public void testDisabledNow() {

        when(featureManager.isActive(NOW_API)).thenReturn(false);

        final String response = instantTimeService.now();

        verify(dateService, never()).getNowAsString();

        assertEquals(String.format(FEATURE_NOT_ENABLED_PATTERN, NOW_API.name()), response);
    }
}
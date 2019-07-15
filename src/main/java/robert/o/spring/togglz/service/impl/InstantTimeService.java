package robert.o.spring.togglz.service.impl;

import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;
import robert.o.spring.togglz.service.DateService;
import robert.o.spring.togglz.service.TimeService;

import static java.lang.String.format;
import static robert.o.spring.togglz.constants.MessageConstants.FEATURE_NOT_ENABLED_PATTERN;
import static robert.o.spring.togglz.feature.TogglzFeature.NOW_API;

@Service
public class InstantTimeService implements TimeService {

    private FeatureManager featureManager;
    private DateService dateService;

    public InstantTimeService(FeatureManager featureManager,
                              DateService dateService) {

        this.featureManager = featureManager;
        this.dateService = dateService;
    }

    @Override
    public String now() {

        if (featureManager.isActive(NOW_API)) {

            return dateService.getNowAsString();
        } else {

            return format(FEATURE_NOT_ENABLED_PATTERN, NOW_API.name());
        }
    }
}

package robert.o.spring.togglz.feature;

import org.togglz.core.Feature;
import org.togglz.core.annotation.ActivationParameter;
import org.togglz.core.annotation.DefaultActivationStrategy;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;

public enum TogglzFeature implements Feature {

    @EnabledByDefault
    @DefaultActivationStrategy(id = "weekday", parameters = @ActivationParameter(name = "day", value = "7"))
    @Label("GET /api/now")
    NOW_API
}

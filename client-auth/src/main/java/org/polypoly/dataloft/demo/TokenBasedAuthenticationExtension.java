package org.polypoly.dataloft.demo;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.UUID;

import org.eclipse.dataspaceconnector.api.auth.AuthenticationService;
import org.eclipse.dataspaceconnector.spi.system.Provides;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtension;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtensionContext;
import org.polypoly.dataloft.demo.TokenBasedAuthenticationService.Entry;

/**
 * Extension that registers an AuthenticationService that uses API Keys
 */
@Provides(AuthenticationService.class)
public class TokenBasedAuthenticationExtension implements ServiceExtension {
    private static final String AUTH_SETTING_APIKEY = "edc.api.auth.key";

    @Override
    public void initialize(ServiceExtensionContext context) {
        var apiKey = context.getSetting(AUTH_SETTING_APIKEY, UUID.randomUUID().toString());

        context.getMonitor().info(format("API Authentication: using static API Key '%s'", apiKey));

        var apiKeys = new ArrayList<Entry>();
        apiKeys.add(new Entry("herbert", apiKey));
        apiKeys.add(new Entry("drjoe", "dr" + apiKey));
        var authService = new TokenBasedAuthenticationService(apiKeys);
        context.registerService(AuthenticationService.class, authService);
    }
}

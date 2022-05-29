package org.polypoly.dataloft.demo;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.dataspaceconnector.api.auth.AuthenticationService;
import org.eclipse.dataspaceconnector.api.exception.AuthenticationFailedException;

public class TokenBasedAuthenticationService implements AuthenticationService {

    private static final String API_KEY_HEADER_NAME = "x-api-key";
    private final List<Entry> userApiKeys;

    public TokenBasedAuthenticationService(List<Entry> userApiKeys) {
        this.userApiKeys = userApiKeys;
    }

    /**
     * Checks whether a particular request is authorized based on the "X-Api-Key" header.
     *
     * @param headers The headers, that have to contain the "X-Api-Key" header.
     * @throws IllegalArgumentException The map of headers did not contain the "X-Api-Key" header
     */
    @Override
    public boolean isAuthenticated(Map<String, List<String>> headers) {

        Objects.requireNonNull(headers, "headers");

        var apiKey = headers.keySet().stream()
                .filter(k -> k.equalsIgnoreCase(API_KEY_HEADER_NAME))
                .map(headers::get)
                .findFirst();

        return apiKey.map(this::checkApiKeyValid).orElseThrow(() -> new AuthenticationFailedException(API_KEY_HEADER_NAME + " not found"));
    }

    private boolean checkApiKeyValid(List<String> apiKeys) {
        return apiKeys.stream().anyMatch(eachApiKey -> userApiKeys.stream().anyMatch(entry -> entry.includesToken(eachApiKey)));
    }

    public static class Entry {

        protected String name;
        protected String token;

        public Entry(String name, String token) {
            Objects.requireNonNull(name, "name must be non null");
            Objects.requireNonNull(token, "token must be non null");

            this.name = name;
            this.token = token;
        }

        public boolean includesToken(String token) {
            Objects.requireNonNull(token, "token must be non null");
            return this.token.equals(token);
        }
    }
}

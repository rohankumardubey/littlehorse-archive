package io.littlehorse.server.auth;

import com.nimbusds.oauth2.sdk.GeneralException;
import com.nimbusds.oauth2.sdk.ParseException;
import com.nimbusds.oauth2.sdk.TokenIntrospectionRequest;
import com.nimbusds.oauth2.sdk.TokenIntrospectionResponse;
import com.nimbusds.oauth2.sdk.TokenIntrospectionSuccessResponse;
import com.nimbusds.oauth2.sdk.auth.ClientAuthentication;
import com.nimbusds.oauth2.sdk.auth.ClientSecretBasic;
import com.nimbusds.oauth2.sdk.auth.Secret;
import com.nimbusds.oauth2.sdk.id.ClientID;
import com.nimbusds.oauth2.sdk.id.Issuer;
import com.nimbusds.oauth2.sdk.token.BearerAccessToken;
import com.nimbusds.openid.connect.sdk.op.OIDCProviderMetadata;
import java.io.IOException;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;

// https://connect2id.com/products/nimbus-oauth-openid-connect-sdk/examples/oauth/token-introspection
// https://www.nimbusds.com/products/nimbus-oauth-openid-connect-sdk/guides/java-cookbook-for-openid-connect-public-clients
// https://www.oauth.com/oauth2-servers/token-introspection-endpoint/

@Slf4j
public class OAuthClient {

    private final OIDCProviderMetadata providerMetadata;
    private final OAuthConfig config;

    public OAuthClient(OAuthConfig config) {
        this.config = config;
        try {
            this.providerMetadata =
                OIDCProviderMetadata.resolve(
                    new Issuer(config.getAuthorizationServer())
                );
        } catch (GeneralException | IOException e) {
            log.error(e.getMessage(), e);
            throw new UnexpectedAuthorizationServerException(e);
        }
    }

    public TokenStatus introspect(String token) {
        try {
            TokenIntrospectionRequest request = new TokenIntrospectionRequest(
                providerMetadata.getIntrospectionEndpointURI(),
                getCredentials(),
                new BearerAccessToken(token)
            );

            TokenIntrospectionResponse response = TokenIntrospectionResponse.parse(
                request.toHTTPRequest().send()
            );

            if (!response.indicatesSuccess()) {
                throw new UnexpectedAuthorizationServerException(
                    "Error getting the token status: " +
                    response.toErrorResponse().getErrorObject()
                );
            }

            TokenIntrospectionSuccessResponse successResponse = response.toSuccessResponse();

            Instant expiration = successResponse.getExpirationTime() != null
                ? successResponse.getExpirationTime().toInstant()
                : Instant.MIN;

            return TokenStatus.builder().token(token).expiration(expiration).build();
        } catch (ParseException | IOException e) {
            log.error(e.getMessage(), e);
            throw new UnexpectedAuthorizationServerException(e);
        }
    }

    private ClientAuthentication getCredentials() {
        return new ClientSecretBasic(
            new ClientID(config.getClientId()),
            new Secret(config.getClientSecret())
        );
    }
}

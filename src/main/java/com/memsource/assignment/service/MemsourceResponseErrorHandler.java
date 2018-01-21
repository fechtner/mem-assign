package com.memsource.assignment.service;

import com.memsource.assignment.model.memsource.AuthenticationException;
import com.memsource.assignment.model.memsource.MemsourceApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * Custom error handler for REST client.
 * Producing {@link AuthenticationException} and {@link MemsourceApiException}.
 */
@Slf4j
public class MemsourceResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse clienthttpresponse) throws IOException {
        if (clienthttpresponse.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            throw new AuthenticationException();
        } else {
            throw new MemsourceApiException(clienthttpresponse.getStatusCode().getReasonPhrase());
        }
    }

    @Override
    public boolean hasError(ClientHttpResponse clienthttpresponse) throws IOException {

        if (clienthttpresponse.getStatusCode() != HttpStatus.OK) {
            log.debug("Status code: " + clienthttpresponse.getStatusCode());
            log.debug("Response" + clienthttpresponse.getStatusText());
            log.debug(String.valueOf(clienthttpresponse.getBody()));
            return true;
        } else {
            return false;
        }
    }
}

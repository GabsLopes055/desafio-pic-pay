package gabs.desafio_pic_pay.services;

import gabs.desafio_pic_pay.client.AuthorizationClient;
import gabs.desafio_pic_pay.exceptions.PicPayException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized() {

        var response = authorizationClient.isAuthorized();

        if(response.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return response.getBody().authorization();

    }


}

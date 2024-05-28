package gabs.desafio_pic_pay.client;

import gabs.desafio_pic_pay.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        url = "{$client.notification-service.url}"
)
public interface NotificationClient {

    @PostMapping
    ResponseEntity<Void> notificationClient(@RequestBody Transfer transfer);

}

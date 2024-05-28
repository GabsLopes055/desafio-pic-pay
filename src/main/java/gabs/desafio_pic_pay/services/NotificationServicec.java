package gabs.desafio_pic_pay.services;

import gabs.desafio_pic_pay.client.NotificationClient;
import gabs.desafio_pic_pay.entity.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationServicec {

    private final NotificationClient notificationClient;

    private static final Logger logger = LoggerFactory.getLogger(NotificationClient.class);

    public NotificationServicec(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void setNotificationClient(Transfer transfer) {
        try {

            logger.info("Enviando notificação");

            var response = notificationClient.notificationClient(transfer);

            if(response.getStatusCode().isError()) {
                logger.error("Erro ao enviar notificação.");
            }


        } catch (Exception e) {
            logger.error("Erro ao enviar notificação ao usuário", e.getMessage());
        }
    }
}

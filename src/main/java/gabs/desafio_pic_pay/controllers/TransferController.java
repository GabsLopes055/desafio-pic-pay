package gabs.desafio_pic_pay.controllers;

import gabs.desafio_pic_pay.DTOs.TransferRequest;
import gabs.desafio_pic_pay.entity.Transfer;
import gabs.desafio_pic_pay.services.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    public final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferRequest request) {
        return ResponseEntity.ok(service.transfer(request));
    }
}

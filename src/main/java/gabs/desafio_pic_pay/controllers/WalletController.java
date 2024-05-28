package gabs.desafio_pic_pay.controllers;

import gabs.desafio_pic_pay.DTOs.WalletRequest;
import gabs.desafio_pic_pay.entity.Wallet;
import gabs.desafio_pic_pay.services.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping(value = "wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid WalletRequest request) {
        return ResponseEntity.ok(service.createWallet(request));
    }

    @GetMapping
    public String load() {
        return "Cheguei aqui";
    }
}

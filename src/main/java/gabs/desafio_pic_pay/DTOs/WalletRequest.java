package gabs.desafio_pic_pay.DTOs;

import gabs.desafio_pic_pay.entity.Wallet;
import gabs.desafio_pic_pay.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WalletRequest(@NotBlank String fullname,
                            @NotBlank String cpfCnpj,
                            @NotBlank String email,
                            @NotBlank String password,
                            @NotNull WalletType.Enum walletType) {

    public Wallet ToWallet() {
        return new Wallet(
                fullname,
                cpfCnpj,
                email,
                password,
                walletType.get()
        );
    }
}

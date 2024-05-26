package gabs.desafio_pic_pay.DTOs;

import gabs.desafio_pic_pay.entity.Wallet;
import gabs.desafio_pic_pay.entity.WalletType;

public record WalletRequest(String fullname,
                            String cpfCnpj,
                            String email,
                            String password,
                            WalletType.Enum walletType) {

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

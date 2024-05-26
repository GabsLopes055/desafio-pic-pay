package gabs.desafio_pic_pay.repository;

import gabs.desafio_pic_pay.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findBycpfCnpjOrEmail(String cpfCnpj, String email);
}

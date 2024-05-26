package gabs.desafio_pic_pay.repository;

import gabs.desafio_pic_pay.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}

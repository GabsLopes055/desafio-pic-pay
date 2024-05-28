package gabs.desafio_pic_pay.repository;

import gabs.desafio_pic_pay.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TranfersRepository extends JpaRepository<Transfer, UUID> {
}

package gabs.desafio_pic_pay.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tbl_wallet-type")
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWalletType;

    private String description;

    public WalletType() {
    }

    public WalletType(Long idWalletType, String description) {
        this.idWalletType = idWalletType;
        this.description = description;
    }

    public Long getIdWalletType() {
        return idWalletType;
    }

    public void setIdWalletType(Long idWalletType) {
        this.idWalletType = idWalletType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Enum {

        USER(1L, "USER"),
        MERCHANT(2L, "MERCHANT");

        Enum(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        private Long id;
        private String description;

        public WalletType get(){
            return new WalletType(id, description);
        }

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        WalletType that = (WalletType) object;
        return Objects.equals(idWalletType, that.idWalletType) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWalletType, description);
    }
}

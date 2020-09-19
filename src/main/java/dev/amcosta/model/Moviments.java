package dev.amcosta.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "movimentações")
public class Moviments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private MovimentTypeEnum type;

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public MovimentTypeEnum getType() {
        return type;
    }

    public void setType(MovimentTypeEnum type) {
        this.type = type;
    }
}

package dev.amcosta.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movimentacoes")
public class Moviment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt = LocalDateTime.now();
    private BigDecimal value;
    @Enumerated(EnumType.STRING)
    private MovimentTypeEnum type;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private BankAccount conta;
    private String description;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Category> categories;

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

    public BankAccount getConta() {
        return conta;
    }

    public void setBankAccout(BankAccount conta) {
        this.conta = conta;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

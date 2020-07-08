package com.antra.training.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "balance")
    private BigDecimal balance;

//    @Column(name = "create_date")
//    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee emp;//

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        balance = balance;
    }

//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        createDate = createDate;
//    }

    public long getId() {
        return id;
    }


}

package com.neosoft.model;

import jakarta.persistence.*;


@Entity
@Table(name="payment_table")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer orderId;
    private double amount;
    private boolean successful;

    public Payment(int id, Integer orderId, double amount, boolean successful) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.successful = successful;
    }

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", amount=" + amount +
                ", successful=" + successful +
                '}';
    }
}

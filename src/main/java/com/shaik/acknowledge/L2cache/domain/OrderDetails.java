package com.shaik.acknowledge.L2cache.domain;

import com.shaik.acknowledge.L2cache.listeners.AuditLogListener;
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;

import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE;

@Entity
@Table(name = "order_details")
@Cache(usage = READ_WRITE, region = "orderDetailsCache")
@EntityListeners(AuditLogListener.class)
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "order_status")
    private Integer orderStatus;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}

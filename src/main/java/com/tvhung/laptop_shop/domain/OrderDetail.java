package com.tvhung.laptop_shop.domain;

import com.tvhung.laptop_shop.constants.DbConstants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = DbConstants.OrderDetail.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(columnNames = {
        DbConstants.OrderDetail.ORDER_ID,
        DbConstants.OrderDetail.PRODUCT_ID
})
})
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long quantity;

    private double price;

    @ManyToOne
    @JoinColumn(name = DbConstants.OrderDetail.ORDER_ID)
    @ToString.Exclude
    private Order order;

    @ManyToOne
    @JoinColumn(name = DbConstants.OrderDetail.PRODUCT_ID)
    @ToString.Exclude
    private Product product;
}

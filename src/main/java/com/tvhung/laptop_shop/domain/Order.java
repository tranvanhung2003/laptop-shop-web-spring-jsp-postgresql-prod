package com.tvhung.laptop_shop.domain;

import java.util.ArrayList;
import java.util.List;

import com.tvhung.laptop_shop.constants.DbConstants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = DbConstants.OrderTable.TABLE_NAME)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = DbConstants.OrderTable.USER_ID)
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = DbConstants.OrderTable.MAPPED_BY)
    @ToString.Exclude
    @Builder.Default
    private List<OrderDetail> orderDetails = new ArrayList<>();
}

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
@Table(name = DbConstants.User.TABLE_NAME)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String fullName;

    private String address;

    private String phoneNumber;

    private String avatar;

    @ManyToOne
    @JoinColumn(name = DbConstants.User.ROLE_ID)
    @ToString.Exclude
    private Role role;

    @OneToMany(mappedBy = DbConstants.User.MAPPED_BY)
    @ToString.Exclude
    @Builder.Default
    private List<Order> orders = new ArrayList<>();

    public void updateFrom(User user) {
        this.fullName = user.getFullName();
        this.address = user.getAddress();
        this.phoneNumber = user.getPhoneNumber();
    }
}

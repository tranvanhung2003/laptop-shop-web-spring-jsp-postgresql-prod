package com.tvhung.laptop_shop.domain;

import java.util.ArrayList;
import java.util.List;

import com.tvhung.laptop_shop.constants.DbConstants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = DbConstants.Role.TABLE_NAME)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = DbConstants.Role.MAPPED_BY)
    @ToString.Exclude
    @Builder.Default
    private List<User> users = new ArrayList<>();
}

package com.example.buildingbankapplication.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "CurrentSessionUser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrentSessionUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private Integer userId;

    private String uuid;

    private String phoneNo;

    private LocalDateTime localDateTime;

}

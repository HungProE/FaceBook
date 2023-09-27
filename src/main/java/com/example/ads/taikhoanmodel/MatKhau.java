package com.example.ads.taikhoanmodel;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "matkhau")
public class MatKhau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idmatkhau")
    private Long idmatkhau;

    @Column(name = "matkhau1")
    private String matKhau1;

    @Column(name = "matkhau2")
    private String matKhau2;

    @ManyToOne
    @JoinColumn(name = "Iduser")
    private User user;
}

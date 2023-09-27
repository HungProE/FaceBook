package com.example.ads.taikhoanmodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please input information!")
    @Column(name = "thongtin")
    private String thongTin;

    @NotBlank(message = "Please input full name!")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Please input business email address!")
    @Column(name = "adress")
    private String adress;

    @NotBlank(message = "Please input personal email address!")
    @Column(name = "adressname")
    private String adressname;

    @NotBlank(message = "Please input mobile phone number!")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Please input your facebook page name!")
    @Column(name = "facebookpage")
    private String facebookpage;
}

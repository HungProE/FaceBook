package com.example.ads.taikhoanmodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "code")
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcode")
    private Long idcode;

    @Column(name = "macode")
    private Long macode;

    @ManyToOne
    @JoinColumn(name = "idfile")
    private Files files;

}

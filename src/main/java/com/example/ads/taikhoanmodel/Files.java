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
@Table(name = "files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfile")
    private Long idfile;

    @Column(name = "file_content")
    private byte[] fileContent;

    @ManyToOne
    @JoinColumn(name = "idmatkhau")
    private MatKhau matkhau;

    // Getters và setters
}

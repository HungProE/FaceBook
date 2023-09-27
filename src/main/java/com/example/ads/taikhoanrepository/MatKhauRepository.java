package com.example.ads.taikhoanrepository;

import com.example.ads.taikhoanmodel.MatKhau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatKhauRepository extends JpaRepository<MatKhau ,Long> {

}

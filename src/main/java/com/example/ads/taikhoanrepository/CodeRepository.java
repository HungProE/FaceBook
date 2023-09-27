package com.example.ads.taikhoanrepository;

import com.example.ads.taikhoanmodel.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {
}

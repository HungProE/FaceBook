package com.example.ads.taikhoanrepository;

import com.example.ads.taikhoanmodel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<User, Long> {

}

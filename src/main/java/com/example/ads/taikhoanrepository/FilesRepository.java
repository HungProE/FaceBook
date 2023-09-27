package com.example.ads.taikhoanrepository;

import com.example.ads.taikhoanmodel.Files;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

@ReadingConverter
public interface FilesRepository extends JpaRepository<Files, Long> {
}

package com.codeup.springblogapp.repositories;

import com.codeup.springblogapp.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long>{
    Ad findByTitle(String ad_to_be_deleted);
}

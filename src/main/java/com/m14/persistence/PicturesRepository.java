package com.m14.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m14.domain.Picture;

@Repository
public interface PicturesRepository extends JpaRepository<Picture, Integer>{

}

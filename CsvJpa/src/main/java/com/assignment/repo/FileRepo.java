package com.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entity.FileEntity;
@Repository
public interface FileRepo extends JpaRepository<FileEntity, Integer>{
//FILEeNTITY IS THE ENTITY CLASS AND DATATYPE IS iNTEGER
}

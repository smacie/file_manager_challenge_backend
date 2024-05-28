package com.challenge.filemanager.repository;

import com.challenge.filemanager.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {

    @Query("SELECT f FROM FileEntity f ORDER BY f.id DESC LIMIT 1")
    FileEntity findLastUploadedFile();
}

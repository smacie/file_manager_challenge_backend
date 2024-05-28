package com.challenge.filemanager.service;

import com.challenge.filemanager.model.FileDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService {
    void uploadFile(FileDto fileDto);
    void uploadFile(MultipartFile multipartFile);
    String getFileRandomLineBackwards() throws IOException;
}

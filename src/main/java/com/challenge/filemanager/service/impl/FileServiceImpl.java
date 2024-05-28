package com.challenge.filemanager.service.impl;

import com.challenge.filemanager.entity.FileEntity;
import com.challenge.filemanager.mapper.FileMapper;
import com.challenge.filemanager.model.FileDto;
import com.challenge.filemanager.repository.FileRepository;
import com.challenge.filemanager.service.IFileService;
import com.challenge.filemanager.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

@Service
public class FileServiceImpl implements IFileService {

    private FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public void uploadFile(FileDto fileDto) {
        fileRepository.save(FileMapper.toEntity(fileDto));
    }

    public void uploadFile(MultipartFile multipartFile) {   fileRepository.save(FileMapper.toEntity(multipartFile)); }

    @Override
    public String getFileRandomLineBackwards() throws IOException {
        FileEntity lastUploadedFile = fileRepository.findLastUploadedFile();

        byte[] lastUploadedFileByteArray = lastUploadedFile.getByteArray();
        File tempFile = File.createTempFile("temp", "txt", null);
        FileOutputStream fos = new FileOutputStream(tempFile);
        fos.write(lastUploadedFileByteArray);

        final RandomAccessFile f = new RandomAccessFile(tempFile, "r");
        final long randomLocation = (long) (Math.random() * f.length());
        f.seek(randomLocation);
        f.readLine(); //will move file pointer to the next line
        String randomLine = f.readLine();
        f.close();

        return Convert.toReverse(randomLine);
    }
}

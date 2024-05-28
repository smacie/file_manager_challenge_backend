package com.challenge.filemanager.controller;

import com.challenge.filemanager.service.IFileService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload/v1")
public class FileController {

    private IFileService iFileService;
    private static final Gson gson = new Gson();

    @Autowired
    public FileController(IFileService iFileService) {
        this.iFileService = iFileService;
    }

    @PostMapping(value = "/upload-file", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile fileMultipart){
        iFileService.uploadFile(fileMultipart);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/get-file-random-line-backwards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFileRandomLineBackwards() throws IOException {
        String randomLineBackwards = iFileService.getFileRandomLineBackwards();
        return ResponseEntity.ok().body(gson.toJson(randomLineBackwards));
    }
}

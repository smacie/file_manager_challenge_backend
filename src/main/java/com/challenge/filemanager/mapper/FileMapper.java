package com.challenge.filemanager.mapper;

import com.challenge.filemanager.entity.FileEntity;
import com.challenge.filemanager.model.FileDto;
import com.challenge.filemanager.util.Convert;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class FileMapper {
    /**
     * @return mapped object to given class
     */
    /*public static <T> T toInfo(Object object, Class<T> tClass) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(object, tClass);
    }*/

    public static FileDto toDto(FileEntity fileEntity){
        if(Objects.isNull(fileEntity)) return null;

        return FileDto.builder()
                .id(fileEntity.getId())
                .byteArray(fileEntity.getByteArray())
                .build();
    }

    public static FileEntity toEntity(FileDto fileDto){
        if(Objects.isNull(fileDto)) return null;

        FileEntity fileEntity = new FileEntity();
        fileEntity.setId(Objects.isNull(fileDto.getId()) ? null : fileDto.getId());
        fileEntity.setByteArray(fileDto.getByteArray());

        return fileEntity;
    }

    public static FileEntity toEntity(MultipartFile multipartFile){
        if(Objects.isNull(multipartFile)) return null;

        FileEntity fileEntity = new FileEntity();
        fileEntity.setByteArray(Convert.toByteArray(multipartFile));

        return fileEntity;
    }
}

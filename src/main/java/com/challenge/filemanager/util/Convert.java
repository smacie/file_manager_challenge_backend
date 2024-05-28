package com.challenge.filemanager.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

public class Convert {

    public static String toBase64(MultipartFile fileMultipart) {
        return new String(toByteArray(fileMultipart));
    }

    public static byte[] toByteArray(MultipartFile fileMultipart) {
        if(Objects.isNull(fileMultipart)) return null;

        byte[] fileByteArray = null;
        try {
            fileByteArray = fileMultipart.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileByteArray;
    }

    public static String toReverse(String str)
    {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--)        {
            reversed += str.charAt(i);
        }
        return reversed;
    }

}

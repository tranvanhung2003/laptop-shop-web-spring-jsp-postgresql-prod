package com.tvhung.laptop_shop.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tvhung.laptop_shop.enums.FileType;

import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UploadService {
    private final ServletContext servletContext;

    public String saveUploadFile(MultipartFile file, FileType fileType) {
        try {
            if (file == null || file.isEmpty()) {
                return null;
            }

            byte[] bytes = file.getBytes();
            String rootPath = servletContext.getRealPath("/resources/images");
            String folderName = fileType.getFolderName();

            File dir = new File(rootPath + File.separator + folderName);
            if (!dir.exists()) {
                dir.mkdir();
            }

            String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);

            try (BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile))) {
                stream.write(bytes);
            }

            return fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

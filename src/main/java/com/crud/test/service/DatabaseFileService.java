package com.crud.test.service;

import com.crud.test.entity.ImageFile;
import com.crud.test.exception.FileNotFoundException;
import com.crud.test.exception.FileStorageException;
import com.crud.test.repository.DatabaseFileRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DatabaseFileService {

    @Autowired
    private DatabaseFileRepository dbFileRepository;

    public ImageFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // Check if the file's name contains invalid characters
        if(fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }

        ImageFile dbFile = new ImageFile(fileName, file.getContentType());

        return dbFileRepository.save(dbFile);
    }

    public ImageFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }
}

package com.crud.test.controller;

import com.crud.test.entity.ImageFile;
import com.crud.test.exception.FileStorageException;
import com.crud.test.payload.Response;
import com.crud.test.service.DatabaseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileUploadController {

    @Autowired
    private DatabaseFileService fileStorageService;

    @Value("${filepath}")
    private String bucketPath;
    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
//    	ImageFile fileName = fileStorageService.storeFile(file);
//        if (file.isEmpty()){
//            throw new FileStorageException("Please Insert Image!!");
//        }
//    	if (!(file.getOriginalFilename().endsWith(".png") || file.getOriginalFilename().endsWith(".jpeg") || file.getOriginalFilename().endsWith(".jpg")))
//            throw new FileStorageException("Only PNG, JPEG and JPG images are allowed");
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName.getFileName())
//                .toUriString();
//
//        return new Response(fileName.getId(), fileDownloadUri,
//                file.getContentType(), file.getSize());
        File files = new File(bucketPath+"\\image.png");

        try (OutputStream os = new FileOutputStream(files)) {
            os.write(file.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Response("sad","dasd","dsadass",1234);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }
}

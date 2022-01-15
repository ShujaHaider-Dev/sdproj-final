package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {
    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public List<File> getFileListByUserId(Integer userId) {
        return this.fileMapper.findAllByUserId(userId);
    }


    public File getFileByFileName(String fileName) {
        return this.fileMapper.findFileByFileName(fileName);
    }


    public void saveFileByUserId(MultipartFile file, Integer userId) throws IOException {
        byte[] fileData = file.getBytes();
        String contentType = file.getContentType();
        String fileSize = String.valueOf(file.getSize());
        String fileName = file.getOriginalFilename();

        this.fileMapper.save(new File(null, fileName, contentType, fileSize, userId, fileData));

    }

    public void deleteByFileIdAndUserId(Integer fileId, Integer userId) {
        this.fileMapper.delete(fileId, userId);
    }
}
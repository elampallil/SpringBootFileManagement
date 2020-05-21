package com.file.management.fileManagement.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class FileServiceImpl implements FileService {
    @Override
    public ModelAndView fileUpload(MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            return new ModelAndView("status", "message", "Please select a file and try again");
        }

        try {
            // read and write the file to the selected location-
            byte[] bytes = file.getBytes();
            Path path = Paths.get("/home/asus/Downloads/" + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("status", "message", "File Uploaded sucessfully");
    }

    @Override
    public ModelAndView showUpload() {
        return new ModelAndView("upload");
    }
}

package com.file.management.fileManagement.service;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
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

    @Override
    public void downloadFiles(HttpServletRequest request,
                              HttpServletResponse response, String fileName) throws IOException {

        File file = new File("/home/asus/Downloads/" + fileName);


        if (file.exists()) {

            //get the mimetype
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
           // response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");


            //Here we have mentioned it to show as attachment
            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");


            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());

        }


    }
}

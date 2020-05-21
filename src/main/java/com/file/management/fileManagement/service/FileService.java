package com.file.management.fileManagement.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FileService {
    ModelAndView fileUpload(MultipartFile file, RedirectAttributes redirectAttributes);

     ModelAndView showUpload();
     void downloadFiles(HttpServletRequest request, HttpServletResponse response,String fileName) throws IOException;

}

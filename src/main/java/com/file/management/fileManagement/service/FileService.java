package com.file.management.fileManagement.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface FileService {
    public ModelAndView fileUpload(MultipartFile file, RedirectAttributes redirectAttributes);

    public ModelAndView showUpload();
}

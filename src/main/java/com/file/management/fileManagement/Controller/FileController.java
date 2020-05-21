package com.file.management.fileManagement.Controller;

import com.file.management.fileManagement.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {
    @Autowired
    public FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView showUpload() {
        ModelAndView modelAndView = fileService.showUpload();
        return modelAndView;
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = fileService.fileUpload(file, redirectAttributes);
        return modelAndView;

    }
}

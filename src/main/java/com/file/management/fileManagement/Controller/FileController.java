package com.file.management.fileManagement.Controller;

import com.file.management.fileManagement.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class FileController {
    @Autowired
    public FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView showUpload() {
        return fileService.showUpload();
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        return fileService.fileUpload(file, redirectAttributes);

    }
    @RequestMapping("/file/{fileName:.+}")
    public  void downloadFiles(HttpServletRequest request , HttpServletResponse response,
                               @PathVariable("fileName")String fileName) {
        try {
            fileService.downloadFiles(request,response,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

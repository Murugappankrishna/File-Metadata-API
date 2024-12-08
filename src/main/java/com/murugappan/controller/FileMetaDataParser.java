package com.murugappan.controller;

import com.murugappan.DTO.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
@Controller
@RestController
@CrossOrigin(origins = "*")
public class FileMetaDataParser {
    @PostMapping("/api/fileanalyse")
    @ResponseBody
    public ResponseDTO handleFileUpload(@RequestParam("upfile") MultipartFile file) {
            ResponseDTO response = new ResponseDTO();
           response.setName(file.getOriginalFilename());
            response.setSize((int)file.getSize());
            response.setType(file.getContentType());
        return response;
    }
    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String home() {
        return "<p> Vanakam form home</p>";
    }
}

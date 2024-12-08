package com.murugappan.controller;

import com.murugappan.DTO.ResponseDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FileMetaDataParser {
    @PostMapping("/fileanalyse")
    public ResponseDTO handleFileUpload(@RequestParam("upfile") MultipartFile file) {
            ResponseDTO response = new ResponseDTO();
            response.setName(file.getOriginalFilename());
            response.setSize((int)file.getSize());
            response.setType(file.getContentType());
        return response;
    }
}

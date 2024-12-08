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
        return """
            <!DOCTYPE html>
            <html>
              <head>
                <title>File Metadata</title>
                <link
                  rel="shortcut icon"
                  href="https://cdn.freecodecamp.org/universal/favicons/favicon.ico"
                  type="image/x-icon"
                />
                <link
                  href="https://fonts.googleapis.com/css?family=Roboto"
                  rel="stylesheet"
                  type="text/css"
                />
                <link href="/public/style.css" rel="stylesheet" type="text/css" />
              </head>
              <body>
                <div class="container">
                  <h1>API Project: File Metadata Microservice</h1>
                  <h2>Usage:</h2>
                  <p>Please Upload a File ...</p>
                  <div class="view">
                    <h3 id="output"></h3>
                    <form
                      enctype="multipart/form-data"
                      method="POST"
                      action="/api/fileanalyse"
                    >
                      <input id="inputfield" type="file" name="upfile" />
                      <input id="button" type="submit" value="Upload" />
                    </form>
                  </div>
                </div>
                <div class="footer">
                  <p>
                    by
                    <a href="https://www.freecodecamp.org/">freeCodeCamp</a>
                  </p>
                </div>
              </body>
            </html>
            """;
    }
}

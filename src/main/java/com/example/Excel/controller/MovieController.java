package com.example.Excel.controller;

import com.example.Excel.Service.MovieService;
import com.example.Excel.helper.Helper;
import com.example.Excel.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/movie/upload")
    public String upload(@RequestPart("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            return  this.movieService.save(file);
        }
        return "Please upload excel file ";
    }
}

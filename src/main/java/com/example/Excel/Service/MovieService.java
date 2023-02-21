package com.example.Excel.Service;

import com.example.Excel.Repository.MovieRepository;
import com.example.Excel.helper.Helper;
import com.example.Excel.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String save(MultipartFile file) {

        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println(fileName);
        System.out.print((file.getContentType()));

        try {

            List<Movie> movies = Helper.convertExcelToListOfMovie(file.getInputStream());

            this.movieRepository.saveAll(movies);
            return "File added to db successfully";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Something went wrong ";
    }

    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }
}

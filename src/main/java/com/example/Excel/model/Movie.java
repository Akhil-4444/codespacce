package com.example.Excel.model;



import javax.persistence.*;

@Entity
@Table(name = "report")
public class Movie {

    @Id
    @GeneratedValue
    int id;
    @Column
    private String movie;
    @Column
    private String category;
    @Column
    private String director;
    @Column
    private Long rating;

    public Movie() {
        this.movie = movie;
        this.category = category;
        this.director = director;
        this.rating = rating;
    }



    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}

package project.awj.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Game name is required")
    private String name;

    @NotEmpty(message = "Company is required")
    private String company;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date; // Modificat din datetime în date

    private Double rating;

    private int personalRating;

    private String progress;

    public Game() {
    }

    public Game(Long id, String name, String company, LocalDate date, Double rating, int personalRating, String progress) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.date = date;
        this.rating = rating;
        this.personalRating = personalRating;
        this.progress = progress;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public int getPersonalRating() { return personalRating; }
    public void setPersonalRating(int personalRating) { this.personalRating = personalRating; }

    public String getProgress() { return progress; }
    public void setProgress(String progress) { this.progress = progress; }
}

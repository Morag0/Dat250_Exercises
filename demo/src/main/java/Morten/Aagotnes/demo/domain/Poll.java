package Morten.Aagotnes.demo.domain;

import java.time.Instant;
import java.util.*;

public class Poll {
    private String question;
    private Instant publishedAt;
    private Instant validUntil;

    private int id;


    public Poll() {}

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }
}
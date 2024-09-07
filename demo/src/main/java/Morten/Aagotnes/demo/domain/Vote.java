package Aagotnes.demo.domain;

import java.time.Instant;

public class Vote {
    private Instant publishedAt;

    private int id;


    public Vote() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}
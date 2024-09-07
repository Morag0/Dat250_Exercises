package Morten.Aagotnes.demo.controllers;

import Morten.Aagotnes.demo.domain.Vote;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final List<Vote> votes = new ArrayList<>();


    @PostMapping
    public Vote createVote(@RequestBody Vote vote) {
        votes.add(vote);
        return vote;
    }


    @GetMapping
    public List<Vote> listVotes() {
        return votes;
    }
}
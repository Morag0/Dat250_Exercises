package Morten.Aagotnes.demo.controllers;

import Morten.Aagotnes.demo.domain.VoteOption;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/voteOptions")
public class VoteOptionController {

    private final List<VoteOption> voteOptions = new ArrayList<>();
    private final AtomicInteger voteOptionIdCounter = new AtomicInteger();


    @PostMapping
    public VoteOption createVoteOption(@RequestBody VoteOption voteOption) {
        voteOption.setId(voteOptionIdCounter.incrementAndGet());
        voteOptions.add(voteOption);
        return voteOption;
    }


    @GetMapping
    public List<VoteOption> listVoteOptions() {
        return voteOptions;
    }

    @GetMapping("/{id}")
    public VoteOption getVoteOption(@PathVariable int id) {
        return voteOptions.stream().filter(voteOption -> voteOption.getId() == id).findFirst().orElse(null);
    }


}
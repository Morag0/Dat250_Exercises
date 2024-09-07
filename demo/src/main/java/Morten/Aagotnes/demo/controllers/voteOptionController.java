package Aagotnes.demo.controllers;

import Aagotnes.demo.domain.VoteOption;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/voteOptions")
public class VoteOptionController {

    private final List<VoteOption> voteOptions = new ArrayList<>();


    @PostMapping
    public VoteOption createVoteOption(@RequestBody VoteOption voteOption) {
        voteOptions.add(voteOption);
        return voteOption;
    }


    @GetMapping
    public List<VoteOption> listVoteOptions() {
        return voteOptions;
    }
}
package com.kushal.ipldashboard.Controller;

import com.kushal.ipldashboard.Repository.MatchRepository;
import com.kushal.ipldashboard.Repository.TeamRepository;
import com.kushal.ipldashboard.model.Team;
<<<<<<< HEAD
=======
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
>>>>>>> frontend
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {


    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team =  this.teamRepository.findByTeamName(teamName);
        team.setMatches(this.matchRepository.findLatestMatchesByTeam(teamName, 4));

        return team;
    }
}

package com.gentian.e.voting.user;

import com.gentian.e.voting.enums.Page;
import com.gentian.e.voting.helper.SessionTools;
import com.gentian.e.voting.services.CandidateService;
import com.gentian.e.voting.services.VoterService;
import java.io.Serializable;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Gentian
 */
@Named(value = "confirm")
@SessionScoped
public class ConfirmVote implements Serializable {
        
    private static final long serialVersionUID = 1L;
    private static final Logger _logger = Logger.getLogger("ConfirmVote");
    
    @Inject private SessionTools _sessionTools;
    @Inject private VoterService _voterService;
    @Inject private CandidateService _candidateService;
    @Inject private VoterController _voterController;
    
    public String confirm() {
        //_userController.getUser().setUserVoted(true);
        // _voterService.save(_voterController.getEVoter());
        // int[] votedCandidates = _sessionTools.getVotedCandidates().stream().mapToInt(i->i).toArray();
        // System.out.println(Arrays.toString(votedCandidates));
        int votedSubject = _sessionTools.getVotedSubject().getId();
        String votedCandidates = _sessionTools.getVotedCandidates()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        _candidateService.addVotes(votedSubject, votedCandidates);
        _voterController.setVoter(null);
        return _voterController.logout();
    }
    
    public String returnBack() {
        _sessionTools.clearVotedCandidates();
        return Page.VoteCandidate.getRedirectUrl();
    }
    
}

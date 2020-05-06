package com.gentian.e.voting.user;

import com.gentian.e.voting.helper.SessionTools;
import com.gentian.e.voting.services.CandidateService;
import com.gentian.e.voting.services.UserService;
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
    @Inject private UserService _userService;
    @Inject private CandidateService _candidateService;
    @Inject private UserController _userController;
    
    public String confirm() {
        // _userController.getUser().setUserVoted(true);
        _userService.save(_userController.getUser());
        // int[] votedCandidates = _sessionTools.getVotedCandidates().stream().mapToInt(i->i).toArray();
        // System.out.println(Arrays.toString(votedCandidates));
        String numberString = _sessionTools.getVotedCandidates()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        _candidateService.addVotes(numberString);
        _userController.setUser(null);
        
        return _userController.logout();
    }
    
}

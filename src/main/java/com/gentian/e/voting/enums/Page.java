package com.gentian.e.voting.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gentian
 */
public enum Page {
    
    UserTemplate("/user/userTemplate"),
    Login("/user/login"),
    LoginError("/user/loginError"),
    UserHasVoted("/user/userHasVoted"),
    VoteSubject("/user/voteSubject"),
    VoteCandidate("/user/voteCandidate"),
    ConfirmVote("/user/confirmVote"),
    VotingResults("/user/votingResults"),
    ThankYou("/user/thankYou");
    
    private final String _url;
    private static Map<String, String> _pages;
    
    private Page(String url) {
        _url = url;
    }
    
    public String getUrl() {
        return _url + ".xhtml";
    }
    
    public String getRedirectUrl() {
        return _url + ".xhtml?faces-redirect=true";
    }
        
    public static Map<String, String> getPages() {
        if (_pages == null) {
            _pages = new HashMap<>();
            for (Page page : Page.values()) {
                _pages.put(page.name(), page.getUrl());
            }
        }
        return _pages;
    }
    
}

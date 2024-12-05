package sg.edu.nus.iss.vttp5a_ssf_day18l.model;

import java.util.List;

public class HttpSessionList {
    
    private List<HttpSessionData> sessionList;

    public HttpSessionList() {
    }

    public HttpSessionList(List<HttpSessionData> sessionList) {
        this.sessionList = sessionList;
    }

    public List<HttpSessionData> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<HttpSessionData> sessionList) {
        this.sessionList = sessionList;
    }
}

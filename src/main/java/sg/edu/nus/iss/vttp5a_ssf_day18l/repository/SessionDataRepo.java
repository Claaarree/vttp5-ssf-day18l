package sg.edu.nus.iss.vttp5a_ssf_day18l.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day18l.model.HttpSessionData;
import sg.edu.nus.iss.vttp5a_ssf_day18l.model.HttpSessionList;

@Repository
public class SessionDataRepo {
    
    private HttpSessionList httpSessionList;

    public List<HttpSessionData> getAllSessionDatas() {
        return httpSessionList.getSessionList();
    }

    public void addSessionData(HttpSessionData httpSessionData) {
        httpSessionList.getSessionList().add(httpSessionData);
    }
}

package sg.edu.nus.iss.vttp5a_ssf_day18l.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day18l.model.HttpSessionData;

@Repository
public class SessionDataRepo {
    
    private List<HttpSessionData> sessionDatas = new ArrayList<>();

    public List<HttpSessionData> getAllSessionDatas() {
        return sessionDatas;
    }

    public void addSessionData(HttpSessionData httpSessionData) {
        sessionDatas.add(httpSessionData);
    }
}

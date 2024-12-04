package sg.edu.nus.iss.vttp5a_ssf_day18l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day18l.model.HttpSessionData;
import sg.edu.nus.iss.vttp5a_ssf_day18l.repository.SessionDataRepo;

@Service
public class SessionDataService {

    @Autowired
    SessionDataRepo sessionDataRepo;

    public List<HttpSessionData> getAllSessionDatas() {
       return sessionDataRepo.getAllSessionDatas();
    }

    public void addSessionData(HttpSessionData httpSessionData) {
        sessionDataRepo.addSessionData(httpSessionData);
    }
    
}

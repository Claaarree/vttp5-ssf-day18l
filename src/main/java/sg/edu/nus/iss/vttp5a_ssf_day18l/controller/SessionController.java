package sg.edu.nus.iss.vttp5a_ssf_day18l.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.vttp5a_ssf_day18l.model.HttpSessionData;
import sg.edu.nus.iss.vttp5a_ssf_day18l.service.SessionDataService;

@Controller
@RequestMapping
public class SessionController {
    
    @Autowired
    SessionDataService sessionDataService;

    @GetMapping("/home")
    public String homepage(HttpSession httpSession) {
        // Optional<List<HttpSessionData>> data = Optional.of((List<HttpSessionData>) httpSession.getAttribute("data"));
        // List<HttpSessionData> dataList = data.get();
        List<HttpSessionData> dataList = (List<HttpSessionData>)httpSession.getAttribute("dataList");
        if (dataList == null) {
            dataList = new ArrayList<>();
            httpSession.setAttribute("dataList", dataList);
        }
        return "homepage";
    }

    @GetMapping("/sessions")
    public String getSessionsDataList(Model model, HttpSession httpSession) {
        // Object temp = httpSession.getAttribute("data");
        // if(temp instanceof List<HttpSessionData>){
        //     List<HttpSessionData> dataList = (List<HttpSessionData>) temp;
        // }
        List<HttpSessionData> sessions = (List<HttpSessionData>)httpSession.getAttribute("dataList");
        model.addAttribute("sessions", sessions);
        return "sessionList";
    }

    @GetMapping("/sessions/delete") 
    public String deleteSession(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/home";
    }

    @GetMapping("/sessions/create")
    public String createNewSessionData(Model model, HttpSessionData data) {
        data = new HttpSessionData();
        model.addAttribute("data", data);
        return "sessionForm";
    }

    @PostMapping("/sessions/create")
    public String handleSessionForm(@ModelAttribute HttpSessionData data, HttpSession httpSession) {
        List<HttpSessionData> dataList = (List<HttpSessionData>)httpSession.getAttribute("dataList");
        dataList.add(data);
        httpSession.setAttribute("data", dataList);

        return "redirect:/home";
    }
}

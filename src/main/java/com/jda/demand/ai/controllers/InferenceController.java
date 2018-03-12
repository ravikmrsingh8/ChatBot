package com.jda.demand.ai.controllers;

import com.jda.demand.ai.model.BotResponse;
import com.jda.demand.ai.services.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/api/infer")
@CrossOrigin
public class InferenceController {
    Bot bot;

    @Autowired
    public InferenceController(Bot bot) {
        this.bot = bot;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BotResponse infer(@RequestBody Map<String, String> request, HttpSession session) {
        BotResponse response = bot.infer(request.get("text"), session);
        return response;
    }


}

package proj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GameController {
    static final Logger log = LoggerFactory.getLogger(GameController.class);

    @GetMapping("/gameIndex")
    public String gameIndex() {
        log.info("gameIndex()");

        return "gameIndex";
    }
}

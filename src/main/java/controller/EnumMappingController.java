package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enummapping")
public class EnumMappingController {

    public enum Level {
        LOW, MEDIUM, HIGH
    }

    @GetMapping("/get")
    public String getByLevel(@RequestParam(name = "level", required = false) Level level){
        return level.name();
    }

}
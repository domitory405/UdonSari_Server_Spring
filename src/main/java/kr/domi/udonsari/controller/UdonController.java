package kr.domi.udonsari.controller;

import kr.domi.udonsari.service.UdonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="udon")
public class UdonController {

    @Autowired
    UdonService udonService;

    @GetMapping(value="/")
    public void CheckRegion(@RequestBody final HashMap<String, String> map) {

        System.out.println("params : " + map);

        String regCode = udonService.getRegCode(map.get("gps"));
        System.out.println(regCode);
    }
}

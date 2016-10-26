package com.octanner.ca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by howard.fackrell on 10/25/16.
 */
@Controller
public class Gorgon {

    Random random = new Random();

    List<String> nouns =
            new ArrayList<String>(){{
        add("howard");
        add("cameron");
        add("karen");
        add("lana");
        add("adam");
        add("steve");
        add("cory");
    }};

    List<String> adjectives =
            new ArrayList<String>() {{
                add("shy");
                add("happy");
                add("angry");
                add("proud");
                add("elated");
            }};

//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @RequestMapping("/gorgon")
    @ResponseBody
    String gorgon() {
        return getCodename();
    }

    List<String> getNouns() {
        if (nouns == null) {
//            nouns = jdbcTemplate.queryForList("select name from nouns", String.class);
        }
        return nouns;
    }

    List<String> getAdjectives() {
        if (adjectives == null) {
//            adjectives = jdbcTemplate.queryForList("select name from adjectives", String.class);
        }
        return adjectives;
    }



    String getRandom(List<String> possibilities) {
        int selection = random.nextInt(possibilities.size());
        return possibilities.get(selection);
    }

    String getCodename() {
        String adj = getRandom(getAdjectives());
        String noun = getRandom(getNouns());
        int num = random.nextInt(9999);
        return adj + "-" + noun + "-" + num;
    }
}

package engine.utils;

import java.util.HashMap;
import java.util.Map;

public class SpellChecker {
    private final Map<String, String> corrections = new HashMap<>();

    public SpellChecker() {
        corrections.put("seach", "search");
        corrections.put("quik", "quick");
        corrections.put("teh", "the");
        corrections.put("recieve", "receive");
        corrections.put("definately", "definitely");
        corrections.put("adress", "address");
        corrections.put("becuase", "because");
        corrections.put("calender", "calendar");
        corrections.put("happend", "happened");
        corrections.put("occurence", "occurrence");
        corrections.put("untill", "until");
        corrections.put("seperate", "separate");
        corrections.put("manuever", "maneuver");
        corrections.put("embarass", "embarrass");
        corrections.put("accomodate", "accommodate");
        corrections.put("comming", "coming");
        corrections.put("wierd", "weird");
        corrections.put("thier", "their");
        corrections.put("arguement", "argument");
        corrections.put("realy", "really");
        corrections.put("finaly", "finally");
        corrections.put("concious", "conscious");
        corrections.put("definate", "definite");
        corrections.put("occuring", "occurring");
        corrections.put("commited", "committed");
        corrections.put("priviledge", "privilege");
        corrections.put("severly", "severely");
        corrections.put("supercede", "supersede");
        corrections.put("threshhold", "threshold");
        corrections.put("tommorrow", "tomorrow");
        corrections.put("truely", "truly");
        corrections.put("wierd", "weird");
        corrections.put("writting", "writing");
        corrections.put("pronounciation", "pronunciation");
        corrections.put("posession", "possession");
        corrections.put("strenght", "strength");
        corrections.put("occurred", "occurred");
        corrections.put("enviroment", "environment");
        corrections.put("gratefull", "grateful");
        corrections.put("independance", "independence");
        corrections.put("knowlege", "knowledge");
        corrections.put("maintainance", "maintenance");
        corrections.put("neccessary", "necessary");
        corrections.put("publically", "publicly");
        corrections.put("rediculous", "ridiculous");
        corrections.put("speach", "speech");
        corrections.put("succesful", "successful");
        corrections.put("treshold", "threshold");
        corrections.put("unforseen", "unforeseen");
        corrections.put("wich", "which");
}


    public String correct(String word) {
        return corrections.getOrDefault(word, word);
    }
}

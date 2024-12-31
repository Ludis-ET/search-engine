package engine.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynonymHandler {
    private final Map<String, List<String>> synonymsMap = new HashMap<>();

    public SynonymHandler() {
        synonymsMap.put("quick", List.of("fast", "speedy", "rapid"));
        synonymsMap.put("search", List.of("find", "lookup", "query"));
        synonymsMap.put("happy", List.of("joyful", "content", "pleased", "delighted"));
        synonymsMap.put("sad", List.of("unhappy", "sorrowful", "downcast", "dismal"));
        synonymsMap.put("large", List.of("big", "huge", "gigantic", "immense", "massive"));
        synonymsMap.put("small", List.of("tiny", "miniature", "petite", "slight"));
        synonymsMap.put("fast", List.of("quick", "rapid", "speedy"));
        synonymsMap.put("slow", List.of("unhurried", "leisurely", "delayed"));
        synonymsMap.put("strong", List.of("powerful", "robust", "sturdy", "tough"));
        synonymsMap.put("weak", List.of("fragile", "feeble", "delicate", "frail"));
        synonymsMap.put("intelligent", List.of("smart", "bright", "clever", "brilliant"));
        synonymsMap.put("stupid", List.of("dumb", "ignorant", "foolish", "unwise"));
        synonymsMap.put("beautiful", List.of("pretty", "lovely", "gorgeous", "attractive"));
        synonymsMap.put("ugly", List.of("unattractive", "plain", "unsightly", "repulsive"));
        synonymsMap.put("happy", List.of("joyful", "cheerful", "content", "elated"));
        synonymsMap.put("sad", List.of("unhappy", "sorrowful", "downhearted", "melancholy"));
        synonymsMap.put("hard", List.of("difficult", "challenging", "tough", "complex"));
        synonymsMap.put("easy", List.of("simple", "effortless", "straightforward", "manageable"));
        synonymsMap.put("interesting", List.of("engaging", "fascinating", "captivating", "intriguing"));
        synonymsMap.put("boring", List.of("dull", "uninteresting", "monotonous", "tedious"));
        synonymsMap.put("rich", List.of("wealthy", "affluent", "prosperous", "opulent"));
        synonymsMap.put("poor", List.of("impoverished", "needy", "destitute", "underprivileged"));
        synonymsMap.put("new", List.of("recent", "modern", "novel", "fresh"));
        synonymsMap.put("old", List.of("ancient", "aged", "vintage", "outdated"));
        synonymsMap.put("clean", List.of("tidy", "neat", "orderly", "spotless"));
        synonymsMap.put("dirty", List.of("filthy", "grimy", "unclean", "messy"));
        synonymsMap.put("strong", List.of("sturdy", "powerful", "robust", "muscular"));
        synonymsMap.put("weak", List.of("fragile", "frail", "delicate", "infirm"));
        synonymsMap.put("happy", List.of("joyful", "cheerful", "content", "delighted"));
        synonymsMap.put("sad", List.of("unhappy", "sorrowful", "gloomy", "dismal"));
        synonymsMap.put("good", List.of("excellent", "great", "positive", "favorable"));
        synonymsMap.put("bad", List.of("poor", "negative", "unfavorable", "substandard"));
        synonymsMap.put("love", List.of("affection", "fondness", "devotion", "adoration"));
        synonymsMap.put("hate", List.of("dislike", "detest", "loathe", "despise"));
        synonymsMap.put("success", List.of("achievement", "victory", "triumph", "accomplishment"));
        synonymsMap.put("failure", List.of("defeat", "setback", "loss", "collapse"));
        synonymsMap.put("truth", List.of("fact", "reality", "verity", "accuracy"));
        synonymsMap.put("lie", List.of("falsehood", "deception", "fabrication", "untruth"));
        synonymsMap.put("beautiful", List.of("gorgeous", "lovely", "attractive", "pretty"));
        synonymsMap.put("ugly", List.of("unattractive", "repulsive", "unsightly", "plain"));
        synonymsMap.put("quiet", List.of("silent", "calm", "peaceful", "tranquil"));
        synonymsMap.put("loud", List.of("noisy", "boisterous", "clamorous", "racket"));
        synonymsMap.put("brave", List.of("courageous", "fearless", "valiant", "daring"));
        synonymsMap.put("cowardly", List.of("timid", "fearful", "scared", "weak-kneed"));
        synonymsMap.put("fun", List.of("enjoyable", "entertaining", "amusing", "delightful"));
        synonymsMap.put("boring", List.of("dull", "monotonous", "tedious", "uninteresting"));
        synonymsMap.put("difficult", List.of("challenging", "hard", "complex", "tough"));
        synonymsMap.put("easy", List.of("simple", "effortless", "straightforward", "manageable"));
        synonymsMap.put("smart", List.of("intelligent", "bright", "clever", "sharp"));
        synonymsMap.put("dumb", List.of("stupid", "ignorant", "foolish", "unwise"));
        synonymsMap.put("fast", List.of("quick", "speedy", "swift", "rapid"));
        synonymsMap.put("slow", List.of("sluggish", "leisurely", "delayed", "gradual"));
        synonymsMap.put("big", List.of("large", "huge", "immense", "colossal"));
        synonymsMap.put("small", List.of("tiny", "minute", "petite", "miniature"));
        synonymsMap.put("tall", List.of("high", "elevated", "lofty", "towering"));
        synonymsMap.put("short", List.of("low", "petite", "compact", "stumpy"));
        synonymsMap.put("young", List.of("youthful", "immature", "inexperienced", "novice"));
        synonymsMap.put("old", List.of("aged", "elderly", "vintage", "mature"));
        synonymsMap.put("rich", List.of("wealthy", "affluent", "prosperous", "opulent"));
        synonymsMap.put("poor", List.of("impoverished", "destitute", "needy", "underprivileged"));
        synonymsMap.put("rich", List.of("wealthy", "affluent", "prosperous", "opulent"));
    }

    public List<String> getSynonyms(String word) {
        return synonymsMap.getOrDefault(word, new ArrayList<>());
    }
}

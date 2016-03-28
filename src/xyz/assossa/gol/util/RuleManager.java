package xyz.assossa.gol.util;

import xyz.assossa.gol.ruleset.ConwayLife;
import xyz.assossa.gol.ruleset.RuleSet;

import java.util.HashMap;
import java.util.Map;

public class RuleManager {

    private static Map<String, RuleSet> rules = new HashMap<>();

    public static void addDefaultRules() {
        RuleManager.addRule(new ConwayLife());
    }

    public static void addRule(RuleSet ruleSet) {
        rules.put(ruleSet.id, ruleSet);
    }

    public static RuleSet getRule(String id) {
        return rules.containsKey(id) ? rules.get(id) : null;
    }
}

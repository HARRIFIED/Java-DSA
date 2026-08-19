import java.util.*;
/*
    node = {
        "name": "Dana Whitfield",
        "team": [
            { 
                "name": "Priya Raman",
                "team": [
                    { "name": "Sam Okafor" },
                    { "name": "Lena Fischer" }
                ] 
            },
            { "name": "Marco Silva" }
        ]
    }
    Task: Write a recursive program that prints all the names of the people in this orgs (node)
    output: ["Dana Whitfield", "Priya Raman", "Sam Okafor", "Lena Fischer", "Marco Silva"]

    node = {Dana, team} => team: {Priya, team}
 */

public class AllPeople {
    public List<String> solution(Object node) {
        List<String> names = new ArrayList<>();

        if (node instanceof Map) {
            for (Map.Entry<String, Object> e: ((Map<String, Object>) node).entrySet()) {
                if (e.getKey().equals("name")) {
                    names.add((String) e.getValue());
                } else {
                    names.addAll(solution(e.getValue()));
                }
            }
        } else if (node instanceof List) {
            for (Object person: (List<Object>) node) {
                names.addAll(solution(person));
            }
        }

        return names;
    }
}

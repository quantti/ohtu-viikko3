package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "01234556";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/"+studentNr+"/submissions";

        String courseInfoUrl = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        
        String stats = "https://studies.cs.helsinki.fi/ohtustats/stats";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();

        String courseInfo = Request.Get(courseInfoUrl).execute().returnContent().asString();
        
        String statResponse = Request.Get(stats).execute().returnContent().asString();
        
        JsonParser parser = new JsonParser();
        JsonObject parsittuData = parser.parse(statResponse).getAsJsonObject();
        
        
        System.out.println("json-muotoinen data:");
        System.out.println( courseInfo );
        System.out.println( bodyText);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        CourseInfo ci = mapper.fromJson(courseInfo, CourseInfo.class);
        Stats ohtuStats = mapper.fromJson(parsittuData.get("1"), Stats.class);

        System.out.println("Kurssi: " + ci.getName() + ", " + ci.getTerm());
        System.out.println("");
        System.out.println("Opiskelijanumero: " + studentNr);
        
        int i = 0;
        int points = 0;
        int hours = 0;
        for (Submission submission : subs) {
            submission.setMaxPoints(ci.getExercises()[i]);
            System.out.println(submission);
            points += submission.getExercises().length;
            hours += submission.getHours();
            i++;
        }
        System.out.println("\nyhteensä: " + points + " tehtävää " + hours + " tuntia");
        System.out.println(parsittuData);
        System.out.println("\nKurssilla yhteensä " + ohtuStats.getStudents() + " palautusta, palautettuja tehtäviä yhteensä " + ohtuStats.getExercises() + " kpl");
        

    }
}

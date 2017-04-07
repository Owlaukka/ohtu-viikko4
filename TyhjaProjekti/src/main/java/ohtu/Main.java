package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";
        String courseUrl = "https://ohtustats2017.herokuapp.com/courses/1.json";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String courseBody = Request.Get(courseUrl).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course course = mapper.fromJson(courseBody, Course.class);
        
        System.out.println("Kurssi: " + course.getName() + ", " + course.getTerm() + "\n");
        System.out.println("opiskelijanumero: " + studentNr + "\n");
        
        int totalTasks = 0;
        int totalHours = 0;
        for (Submission submission : subs) {
            totalTasks += submission.completedTasks().size();
            totalHours += submission.getHours();
            System.out.println(submission);
        }
        System.out.println("\nyhteensä: " + totalTasks + " tehtävää " + totalHours + " tuntia.");
    }
}

/*
package com.lista;



import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonObject {
    public static void main(String[] args)  {
        System.out.println("Hello World!");
        String cStr = "{\"Title\":\"Batman\",\"Year\":1989,\"Rated\":\"PG-13\",\"Released\":\"23 Jun 1989\"" +
                ",\"Runtime\":\"126 min\",\"Genre\":\"Action, Adventure\",\"Director\":\"Tim Burton\"" +
                ",\"Writer\":\"Bob Kane (Batman characters), Sam Hamm (story), Sam Hamm (screenplay), Warren Skaaren (screenplay)\"" +
                ",\"Actors\":\"Michael Keaton, Jack Nicholson, Kim Basinger, Robert Wuhl\"" +
                ",\"Plot\":\"The Dark Knight of Gotham City begins his war on crime with his first major enemy being the clownishly homicidal Joker.\"" +
                ",\"Language\":\"English, French, Spanish\",\"Country\":\"USA, UK\"" +
                ",\"Awards\":\"Won 1 Oscar. Another 8 wins & 26 nominations.\"" +
                ",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTYwNjAyODIyMF5BMl5BanBnXkFtZTYwNDMwMDk2._V1_SX300.jpg\"" +
                ",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.5/10\"}" +
                ",{\"Source\":\"Rotten Tomatoes\",\"Value\":\"72%\"},{\"Source\":\"Metacritic\"" +
                ",\"Value\":\"69/100\"}],\"Metascore\":\"69\",\"imdbRating\":\"7.5\",\"imdbVotes\":\"322,524\"" +
                ",\"imdbID\":\"tt0096895\",\"Type\":\"movie\",\"DVD\":\"25 Mar 1997\",\"BoxOffice\":\"N/A\"" +
                ",\"Production\":\"Warner Bros. Pictures\",\"Website\":\"N/A\",\"Response\":\"True\"}";

        try { FileWriter writer =  new FileWriter("film.json", false);
            writer.write(cStr);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("film.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        JSONObject carMap = (JSONObject) obj;

        System.out.printf("Year %d\n",carMap.get("Year"));
        System.out.printf("Year %s\n",carMap.get("Year"));

        System.out.println("Title : " + carMap.get("Title"));
        System.out.println("title : " + carMap.get("title"));
        System.out.println("Year : " + carMap.get("Year"));
        System.out.println("Rated : " + carMap.get("Rated"));
        System.out.println("Released : " + carMap.get("Released"));
        System.out.println("Ratings : " + carMap.get("Ratings"));

    }
}
*/

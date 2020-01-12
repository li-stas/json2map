package com.lista;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 * https://stackoverflow.com/questions/443499/convert-json-to-map
 *
 * https://overcoder.net/q/8041/%D0%BA%D0%B0%D0%BA-%D1%8F-%D0%BC%D0%BE%D0%B3%D1%83-%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-json-%D0%B2-hashmap-%D1%81-%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E-gson
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        /**
         * Read JSON from a file into a Map
         */
        //(where JSON_SOURCE(cStr) is a File, input stream, reader, or json content String)
        //File cStr = new File("result.json");
        //String cStr = "{\"Title\":\"Batman\",\"Year\":\"1989\",\"Rated\":\"PG-13\",\"Released\":\"23 Jun 1989\"" +
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

        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> carMap = mapper.readValue(cStr, new TypeReference<Map<String, Object>>() {
            });

            System.out.printf("Year %d\n",carMap.get("Year"));
            System.out.printf("Year %s\n",carMap.get("Year"));

            System.out.println("Title : " + carMap.get("Title"));
            System.out.println("title : " + carMap.get("title"));
            System.out.println("Year : " + carMap.get("Year"));
            System.out.println("Rated : " + carMap.get("Rated"));
            System.out.println("Released : " + carMap.get("Released"));
            System.out.println("Ratings : " + carMap.get("Ratings"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


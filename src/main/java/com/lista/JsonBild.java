package com.lista;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class JsonBild {
    public static void main(String[] args) {

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

        String source = cStr;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Object.class, new NaturalDeserializer());
        Gson gson = gsonBuilder.create();


        Object natural = gson.fromJson(source, Object.class);
        System.out.println("Hello World!");

        Map<String, Object> carMap = (Map<String, Object>) natural;

        //int nNum = (int) carMap.get("Year");
        System.out.printf("Year %d",carMap.get("Year"));

        System.out.println("Title : " + carMap.get("Title"));
        System.out.println("title : " + carMap.get("title"));
        System.out.println("Year : " + carMap.get("Year"));
        System.out.println("Rated : " + carMap.get("Rated"));
        System.out.println("Released : " + carMap.get("Released"));
        System.out.println("Ratings : " + carMap.get("Ratings"));
    }
    private static class NaturalDeserializer implements JsonDeserializer<Object> {
        public Object deserialize(JsonElement json, Type typeOfT,
                                  JsonDeserializationContext context) {
            if(json.isJsonNull()) return null;
            else if(json.isJsonPrimitive()) return handlePrimitive(json.getAsJsonPrimitive());
            else if(json.isJsonArray()) return handleArray(json.getAsJsonArray(), context);
            else return handleObject(json.getAsJsonObject(), context);
        }
        private Object handlePrimitive(JsonPrimitive json) {
            if(json.isBoolean())
                return json.getAsBoolean();
            else if(json.isString())
                return json.getAsString();
            else {
                BigDecimal bigDec = json.getAsBigDecimal();
                // Find out if it is an int type
                try {
                    bigDec.toBigIntegerExact();
                    try { return bigDec.intValueExact(); }
                    catch(ArithmeticException e) {}
                    return bigDec.longValue();
                } catch(ArithmeticException e) {}
                // Just return it as a double
                return bigDec.doubleValue();
            }
        }
        private Object handleArray(JsonArray json, JsonDeserializationContext context) {
            Object[] array = new Object[json.size()];
            for(int i = 0; i < array.length; i++)
                array[i] = context.deserialize(json.get(i), Object.class);
            return array;
        }
        private Object handleObject(JsonObject json, JsonDeserializationContext context) {
            Map<String, Object> map = new HashMap<String, Object>();
            for(Map.Entry<String, JsonElement> entry : json.entrySet())
                map.put(entry.getKey(), context.deserialize(entry.getValue(), Object.class));
            return map;
        }
    }
}

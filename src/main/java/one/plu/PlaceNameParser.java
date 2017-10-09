package one.plu;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class PlaceNameParser {
    private static Map<String, String> placeNameCodeMap = new HashMap();
    private static Map<String, String> placeCodeNameMap = new HashMap();

    static {
        init(placeCodeNameMap, placeNameCodeMap);
    }

    private static void init(Map placeCodeNameMap, Map placeNameCodeMap) {
        InputStream inputStream = PlaceNameParser.class.getClassLoader().getResourceAsStream("area.json");
        log.info("inputStream:{}", inputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(bufferedReader, JsonObject.class);
        JsonObject provinces = jsonObject.getAsJsonObject("86");
        log.info("provinces:{}", provinces);
        Set<Map.Entry<String, JsonElement>> provinceEntries = provinces.entrySet();
        for (Map.Entry<String, JsonElement> provinceEntry : provinceEntries) {
            log.info("province:{}", provinceEntry);
            placeCodeNameMap.put(provinceEntry.getKey(), provinceEntry.getValue().getAsString());
            foo(placeNameCodeMap, provinceEntry);
            JsonObject cities = jsonObject.getAsJsonObject(provinceEntry.getKey());
            log.info("cities:{}", cities);
            if (cities != null) {
                Set<Map.Entry<String, JsonElement>> cityEntries = cities.entrySet();
                for (Map.Entry<String, JsonElement> cityEntry : cityEntries) {
                    log.info("city:{}", cityEntry);
                    placeCodeNameMap.put(cityEntry.getKey(), cityEntry.getValue().getAsString());
                    foo(placeNameCodeMap, cityEntry);
                    JsonObject districtOrCounties = jsonObject.getAsJsonObject(cityEntry.getKey());
                    log.info("districtOrCounties:{}", districtOrCounties);
                    if (districtOrCounties != null) {
                        Set<Map.Entry<String, JsonElement>> districtOrCountyEntries = districtOrCounties.entrySet();
                        for (Map.Entry<String, JsonElement> districtOrCountyEntry : districtOrCountyEntries) {
                            log.info("districtOrCountyEntry:{}", districtOrCountyEntry);
                            placeCodeNameMap.put(districtOrCountyEntry.getKey(), districtOrCountyEntry.getValue().getAsString());
                            foo(placeNameCodeMap, districtOrCountyEntry);
                        }
                    }
                }
            }
        }
        log.info("finished");
    }

    private static void foo(Map placeNameCodeMap, Map.Entry<String, JsonElement> entry) {
        if (placeNameCodeMap.containsKey(entry.getValue().getAsString())) {
            String newValue = placeNameCodeMap.get(entry.getValue().getAsString()) + "," + entry.getKey();
            placeNameCodeMap.replace(entry.getValue().getAsString(), newValue);
        } else {
            placeNameCodeMap.putIfAbsent(entry.getValue().getAsString(), entry.getKey());
        }
    }

    public static Set parse(String placeName) {
        String placeCodeString = placeNameCodeMap.get(placeName);
        String[] split = placeCodeString.split(",");

        return null;
    }
}

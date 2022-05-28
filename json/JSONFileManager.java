package eu.mixeration.json;

import eu.mixeration.helper.Helper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class JSONFileManager {

    static JSONParser parser = new JSONParser();

    public String readJSONString(String file, String string){
        try {
            Object obj = parser.parse(new FileReader(Helper.get().getDataFolder() + File.separator + file));
            JSONObject jsonObject = (JSONObject) obj;

            return (String) jsonObject.get(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer readJSONInteger(String file, String string){
        try {
            Object obj = parser.parse(new FileReader(Helper.get().getDataFolder() + File.separator + file));
            JSONObject jsonObject = (JSONObject) obj;

            return (Integer) jsonObject.get(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean readJSONBoolean(String file, String string){
        try {
            Object obj = parser.parse(new FileReader(Helper.get().getDataFolder() + File.separator + file));
            JSONObject jsonObject = (JSONObject) obj;

            return (Boolean) jsonObject.get(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Long readJSONLong(String file, String string){
        try {
            Object obj = parser.parse(new FileReader(Helper.get().getDataFolder() + File.separator + file));
            JSONObject jsonObject = (JSONObject) obj;

            return (Long) jsonObject.get(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readJSONList(String file, String string, int pos){
        try {
            Object obj = parser.parse(new FileReader(Helper.get().getDataFolder() + File.separator + file));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray msg = (JSONArray) jsonObject.get(string);
            return (String) msg.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void modifyJSONValue(String file, String key, Object value){
        JSONFile jsonFile = new JSONFile(file);
        jsonFile.getJSONObject().put(key, value);
        jsonFile.saveJSONFile();
    }
}

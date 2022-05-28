package eu.mixeration.json;

import eu.mixeration.helper.Helper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;

public class JSONFile {

    private FileWriter file;
    private JSONObject jsonObject = new JSONObject();
    private JSONArray jsonArray = new JSONArray();

    public JSONFile(String filename) {
        try {
            file = new FileWriter( Helper.get().getDataFolder() + File.separator + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJSONObject() {
        return jsonObject;
    }

    @Deprecated
    public JSONArray getJSONArray() {
        return jsonArray;
    }

    public JSONArray createJSONArray(String key, JSONArray list) {
        getJSONObject().put(key, list);
        return jsonArray;
    }

    public void saveJSONFile() {
        try {
            file.write(getJSONObject().toJSONString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

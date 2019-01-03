package Settings;

import org.json.JSONObject;
import java.lang.reflect.Field;

public class SettingsHolder {
    public String ctrieHostname;
    public long ctriePort;
    public String seedbagHostname;
    public long seedbagPort;

    public static SettingsHolder fromJson(String json) throws IllegalAccessException {
        JSONObject jObj = new JSONObject(json);
        SettingsHolder holder = new SettingsHolder();
        Field[] fields = holder.getClass().getFields();
        for(int i = 0; i < fields.length; i++) {
            if(fields[i].getType() == Long.TYPE) {
                long val = jObj.getLong(fields[i].getName());
                fields[i].setLong(holder, val);
            } else if(fields[i].getType() == String.class) {
                String val = jObj.getString(fields[i].getName());
                fields[i].set(holder, val);
            }
        }
        return holder;
    }
}

package Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MethodInfo {
    private final String name;
    private final ParamInfo[] params;
    private final PrimitiveType returnType;

    public String getName() {
        return name;
    }

    public ParamInfo[] getParams() {
        return params;
    }

    public PrimitiveType getReturnType() {
        return returnType;
    }

    public MethodInfo(String name, ParamInfo[] params, PrimitiveType returnType) {
        this.name = name;
        this.params = params;
        this.returnType = returnType;
    }

    public static MethodInfo fromJsonFile(String path) throws IOException {
        return fromJsonFile(path, StandardCharsets.UTF_8);
    }

    public static MethodInfo fromJsonFile(String path, Charset encoding) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(path)), encoding);
        JSONObject jObj = new JSONObject(jsonString);
        String methodName = jObj.getString("name");
        JSONArray params = jObj.getJSONArray("params");
        ParamInfo[] methodParams = new ParamInfo[params.length()];
        for (int i = 0; i < params.length(); i++) {
            JSONObject obj = params.getJSONObject(i);
            String name = obj.getString("name");
            PrimitiveType type = PrimitiveType.valueOf(obj.getString("type").toUpperCase());
            methodParams[i] = new ParamInfo(name, type);
        }
        PrimitiveType returnType = PrimitiveType.valueOf(jObj.getString("returnType").toUpperCase());
        return new MethodInfo(methodName, methodParams, returnType);
    }

    public static class ParamInfo {
        private final String name;
        private final PrimitiveType type;

        public ParamInfo(String name, PrimitiveType type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public PrimitiveType getType() {
            return type;
        }
    }


    public enum PrimitiveType {
        INT, DOUBLE, STRING, CHAR, FLOAT, LONG, BYTE, SHORT, BOOLEAN,
    }

}

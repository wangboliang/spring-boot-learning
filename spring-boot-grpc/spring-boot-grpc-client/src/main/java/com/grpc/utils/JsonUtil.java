package com.grpc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * Json序列化工具类
 */
public class JsonUtil {

    private static ObjectMapper JSON_MAPPER = new ObjectMapper();

    public static String objectToJson(Object data) {
        String json = null;
        if (data != null) {
            try {
                json = JSON_MAPPER.writeValueAsString(data);
            } catch (Exception e) {
                throw new RuntimeException("objectToJson method error: " + e);
            }
        }
        return json;
    }

    public static Object jsonToObject(String json, Class<?> cls) {
        Object object = null;
        if (!StringUtils.isEmpty(json) && cls != null) {
            try {
                if (json.startsWith("\"{")) {
                    json = json.replace("\"{", "{").replace("}\"", "}").replace("\\\"", "\"");
                }
                object = JSON_MAPPER.readValue(json, cls);
            } catch (Exception e) {
                throw new RuntimeException("jsonToObject method error: " + e);
            }
        }
        return object;
    }
}

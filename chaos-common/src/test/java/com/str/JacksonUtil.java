package com.str;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ouyangkongtong on 17/1/13.下午5:44
 */
public final class JacksonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtil.class);
    private static ObjectMapper mapper;

    public static synchronized ObjectMapper getMapperInstance(boolean createNew) {
        if (createNew) {
            return new ObjectMapper();
        } else if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        return mapper;
    }

    public static String toJson(Object param) {
        try {
            ObjectMapper objectMapper = JacksonUtil.getMapperInstance(false);
            String dataJson = objectMapper.writeValueAsString(param);
            return dataJson;
        } catch (Exception e) {
            LOGGER.error("toJson", e);
        }
        return null;
    }


    public static <T> T jsonToBean(String json, Class<T> cls) {
        try {
            ObjectMapper objectMapper = JacksonUtil.getMapperInstance(false);
            return objectMapper.readValue(json, cls);
        } catch (Exception e) {
            LOGGER.error("jsonToBean", e);
            return null;
        }
    }

}

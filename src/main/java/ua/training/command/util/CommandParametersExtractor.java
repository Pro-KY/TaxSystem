package ua.training.command.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.function.Function;

public class CommandParametersExtractor {
    private static CommandParametersExtractor instance;
    private static final Logger log = LogManager.getLogger(CommandParametersExtractor.class);
    private CommandParametersExtractor() { }

    public static CommandParametersExtractor getInstance() {
        if (instance == null) {
            instance = new CommandParametersExtractor();
        }
        return instance;
    }

    public <T> T extractToDto(HttpServletRequest request, Class<T> classOfT) {
        T dto;
        JsonObject requestJson = new JsonObject();

        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            requestJson.addProperty(entry.getKey(), entry.getValue()[0]);
        }

        try {
             dto = new Gson().fromJson(requestJson, classOfT);
        } catch (JsonSyntaxException e) {
            log.debug(e.getMessage(), e.getCause());
            dto = null;
        }
        return dto;
    }

    public <T> T extractToEntity(HttpServletRequest request, Function<HttpServletRequest, T> function) {
        return function.apply(request);
    }
}

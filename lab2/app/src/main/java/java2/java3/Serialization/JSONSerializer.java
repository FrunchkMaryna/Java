package java3.Serialization;


import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JSONSerializer<T> implements Serialization<T> {
    private final ObjectMapper objectMapper;

    public JSONSerializer() {
        this.objectMapper = new ObjectMapper();

        // Реєстрація JavaTimeModule для LocalDate
        this.objectMapper.registerModule(new JavaTimeModule());

        // Вимкнення формату timestamp для дат
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Форматування JSON з відступами
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Встановлюємо формат для LocalDate (якщо потрібно)
        this.objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
    }

    @Override
    public T toEntity(String object, Class<T> type) throws IOException {
        return objectMapper.readValue(object, type);
    }

    @Override
    public List<T> toEntityList(String objectCollection, Class<T> type) throws IOException {
        return objectMapper.readValue(objectCollection, objectMapper.getTypeFactory().constructCollectionType(List.class, type));
    }



    @Override
    public String fromEntity(T object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    @Override
    public String fromEntityList(List<T> objectCollection) throws IOException {
        return objectMapper.writeValueAsString(objectCollection);
    }


    @Override
    public T toEntityFromFile(File file, Class<T> type) throws IOException {
        return objectMapper.readValue(file, type);
    }

    @Override
    public List<T> toEntityListFromFile(File file, Class<T> type) throws IOException {
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, type));
    }

    @Override
    public void fromEntityToFile(T object, String fileName) throws IOException {
        objectMapper.writeValue(new File(fileName), object);
    }

    @Override
    public void fromEntityListToFile(List<T> objectCollection, String fileName) throws IOException {
        objectMapper.writeValue(new File(fileName), objectCollection);
    }
}

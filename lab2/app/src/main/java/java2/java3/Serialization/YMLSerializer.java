package java3.Serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


import java.io.*;
import java.util.List;

public class YMLSerializer<T> implements Serialization<T> {
    private final ObjectMapper objectMapper;

    public YMLSerializer() {
        // Використовуємо YAMLFactory для роботи з YAML
        this.objectMapper = new ObjectMapper(new YAMLFactory());
        this.objectMapper.registerModule(new JavaTimeModule()); // Реєстрація модуля для підтримки LocalDate
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
    public void fromEntityToFile(T object, String fileName) throws IOException {
        objectMapper.writeValue(new File(fileName), object);
    }

    @Override
    public String fromEntity(T object) throws IOException {
        return objectMapper.writeValueAsString(object); // Без конвертації в JSON, оскільки це YAML
    }

    @Override
    public String fromEntityList(List<T> objectCollection) throws IOException {
        return objectMapper.writeValueAsString(objectCollection); // Без конвертації в JSON
    }

    @Override
    public T toEntityFromFile(File file, Class<T> type) throws IOException {
        return objectMapper.readValue(file, type); // Використовуємо YAML десеріалізацію
    }

    @Override
    public List<T> toEntityListFromFile(File file, Class<T> type) throws IOException {
        // Оскільки обробка YAML вже налаштована через YAMLFactory, можна використовувати ObjectMapper
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, type));
    }

    @Override
    public void fromEntityListToFile(List<T> entityList, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(new File(filePath))) {
            String yamlContent = fromEntityList(entityList);
            writer.write(yamlContent);
            System.out.println("YAML дані записано у файл: " + filePath);
        }
    }
}

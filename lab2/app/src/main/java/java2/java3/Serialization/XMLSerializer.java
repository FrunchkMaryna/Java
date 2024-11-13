package java3.Serialization;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLSerializer<T> implements Serialization<T> {
    private final XmlMapper xmlMapper;

    public XMLSerializer() {
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.registerModule(new JavaTimeModule()); // Реєстрація JavaTimeModule для LocalDate
        this.xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); // Форматуємо XML з відступами
    }

    @Override
    public T toEntity(String object, Class<T> type) throws IOException {
        return xmlMapper.readValue(object, type);
    }

    @Override
    public List<T> toEntityList(String objectCollection, Class<T> type) throws IOException {
        return xmlMapper.readValue(objectCollection, xmlMapper.getTypeFactory().constructCollectionType(List.class, type));
    }

    @Override
    public T toEntityFromFile(File file, Class<T> type) throws IOException {
        return xmlMapper.readValue(file, type);
    }

    @Override
    public String fromEntity(T object) throws IOException {
        return xmlMapper.writeValueAsString(object);
    }

    @Override
    public String fromEntityList(List<T> objectCollection) throws IOException {
        return xmlMapper.writeValueAsString(objectCollection);
    }

    @Override
    public List<T> toEntityListFromFile(File file, Class<T> type) throws IOException {
        return xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, type));
    }

    @Override
    public void fromEntityToFile(T object, String fileName) throws IOException {
        xmlMapper.writeValue(new File(fileName), object);
    }

    @Override
    public void fromEntityListToFile(List<T> objectCollection, String fileName) throws IOException {
        xmlMapper.writeValue(new File(fileName), objectCollection);
    }
}

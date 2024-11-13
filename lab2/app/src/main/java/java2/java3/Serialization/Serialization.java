package java3.Serialization;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Serialization<T> {
    T toEntity(String object, Class<T> type) throws IOException; // Додано параметр Class<T> type
    List<T> toEntityList(String objectCollection, Class<T> type) throws IOException; // Додано параметр Class<T> type

    T toEntityFromFile(File file, Class<T> type) throws IOException;
    List<T> toEntityListFromFile(File file, Class<T> type) throws IOException;

    String fromEntity(T object) throws IOException;
    String fromEntityList(List<T> objectCollection) throws IOException;
    void fromEntityToFile(T object, String fileName) throws IOException;
    void fromEntityListToFile(List<T> objectCollection, String fileName) throws IOException;
}

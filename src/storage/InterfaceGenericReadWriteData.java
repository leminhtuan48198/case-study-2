package storage;

import java.util.List;

public interface InterfaceGenericReadWriteData<T> {
    List<T> readData();
    void writeData(List<T> tList);

}

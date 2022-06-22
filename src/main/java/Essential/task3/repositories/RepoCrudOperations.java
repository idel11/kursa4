package Essential.task3.repositories;

import java.util.List;

public interface RepoCrudOperations <T> {

    public T add(T t);

    public List<T> getAll();

    public T update(T t);

    public T remove(T t);
}

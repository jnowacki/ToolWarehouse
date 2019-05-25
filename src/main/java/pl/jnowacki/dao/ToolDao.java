package pl.jnowacki.dao;

import pl.jnowacki.model.Tool;

import java.util.List;

public interface ToolDao {
    List<Tool> getAllTools();
    void setAvailability(Long id, boolean availability, Long userId);
}

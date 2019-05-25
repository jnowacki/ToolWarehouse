package pl.jnowacki.dao;

import pl.jnowacki.model.Tool;
import pl.jnowacki.model.ToolType;
import pl.jnowacki.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToolDaoImpl implements ToolDao {

    public List<Tool> getAllTools() {

        List<Tool> tools = new ArrayList<>();

        String selectSQL = "SELECT * FROM tools";

        try (Connection dbConnection = DbConnection.getInstance().getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Long toolId = rs.getLong("id");
                String toolName = rs.getString("name");
                ToolType toolType = ToolType.valueOf(rs.getString("type"));
                boolean toolAvailability = rs.getBoolean("available");
                Long userId = rs.getLong("user_id");

                tools.add(new Tool(toolId, toolName, toolType, toolAvailability, userId));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tools;
    }

    public void setAvailability(Long id, boolean availability, Long userId) {

        String selectSQL = "UPDATE tools SET available = ?, user_id = ? WHERE id = ?";

        try (Connection dbConnection = DbConnection.getInstance().getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setBoolean(1, availability);
            preparedStatement.setObject(2, userId);
            preparedStatement.setLong(3, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

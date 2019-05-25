package pl.jnowacki.service;

import pl.jnowacki.dao.ToolDao;
import pl.jnowacki.dao.ToolDaoImpl;
import pl.jnowacki.model.Tool;
import pl.jnowacki.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ToolsService {

    private UserService userService = new UserService();
    private ToolDao toolDao = new ToolDaoImpl();

    public List<Tool> getTools(){
        return toolDao.getAllTools();
    }

    public Optional<Tool> getTool(Long id){
        return toolDao.getAllTools().stream().filter(tool -> tool.getId().equals(id)).findAny();
    }

    public List<Tool> takeTool(Long id, String username){

        Optional<User> user = userService.getUser(username);

        if (user.isPresent()) {
            return setAvailability(id, false, user.get().getId());
        }

        return Collections.emptyList();
    }

    public List<Tool> returnTool(Long id){
        return setAvailability(id, true, null);
    }

    private List<Tool> setAvailability(Long id, boolean isAvailable, Long userId){
        toolDao.setAvailability(id, isAvailable, userId);

        return getTools();
    }
}

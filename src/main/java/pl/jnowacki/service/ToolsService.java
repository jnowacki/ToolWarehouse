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

    public List<Tool> takeTool(Long id, User user){

        if (user != null) {
            return setAvailability(id, false, user.getId());
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

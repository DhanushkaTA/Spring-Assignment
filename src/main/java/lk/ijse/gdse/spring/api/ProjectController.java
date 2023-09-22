package lk.ijse.gdse.spring.api;

import lk.ijse.gdse.spring.dto.ProjectDTO;
import lk.ijse.gdse.spring.exception.InvalidException;
import lk.ijse.gdse.spring.service.ProjectService;
import lk.ijse.gdse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllProjects(){

        return new ResponseUtil(200, "Get", projectService.getAllProjects());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil saveProject(@RequestBody ProjectDTO projectDTO){

        if(projectDTO.getPName() == null || !projectDTO.getPName().matches("[A-Za-z-0-9]+")){
            throw new InvalidException("Invalid Project Name");
        } else if (projectDTO.getDate() == null) {
            throw new InvalidException("Invalid Date");
        } else if (projectDTO.getTechLead() == null) {
            throw new InvalidException("Invalid Tech Lead");
        }
        return new ResponseUtil(200, "save", projectService.saveProject(projectDTO));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updateProject(@RequestBody ProjectDTO projectDTO){

        if(projectDTO.getPId() == 0){
            throw new InvalidException("Invalid Project Id");
        } else if(projectDTO.getPName() == null || !projectDTO.getPName().matches("[A-Za-z-0-9]+")){
            throw new InvalidException("Invalid Project Name");
        } else if (projectDTO.getDate() == null) {
            throw new InvalidException("Invalid Date");
        } else if (projectDTO.getTechLead() == null) {
            throw new InvalidException("Invalid Tech Lead");
        }

        return new ResponseUtil(200, "update", projectService.updateProject(projectDTO));
    }

    @DeleteMapping(params = {"projectId"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deleteProject(@RequestParam int projectId){

        if(projectId == 0){
            throw new InvalidException("Invalid Project Id");
        }
        projectService.deleteProjectByPk(projectId);
        return new ResponseUtil(200, "delete", null);
    }

    @GetMapping(path = {"/{projectId}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchProjectByProjectId(@PathVariable int projectId){

        return new ResponseUtil(200, "search", projectService.searchProjectByPk(projectId));
    }
}

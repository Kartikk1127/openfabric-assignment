package ai.openfabric.api.controller;

import ai.openfabric.api.model.Worker;
import ai.openfabric.api.repository.WorkerRepository;
import ai.openfabric.api.service.DockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("${node.api.path}/worker")
public class WorkerController {

    @Autowired
    public WorkerRepository workerRepository;

    @Autowired
    public DockerService dockerService;


    @PostMapping(path = "/hello")
    public @ResponseBody String hello(@RequestBody String name) {
        return "Hello!" + name;
    }


    @GetMapping("/workers/{offset}/{pageSize}")
    public List<String> getWorkers(@PathVariable int offset, @PathVariable int pageSize) {
        List<String> workerList = new ArrayList<String>();
        workerRepository.findAll(PageRequest.of(offset, pageSize)).forEach(worker -> {
            workerList.add(worker.getName());
            });
        Collections.sort(workerList);
        return workerList;
        }

    @GetMapping("/{id}")
    public Worker getWorkerById(@PathVariable String id)
    {
        return workerRepository.findById(id).get();
    }

    @PostMapping("/containers/{imageName}")
    public ResponseEntity<Void> createDockerContainer(@PathVariable String imageName)
    {
        dockerService.createContainer(imageName);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/containers/{containerId}/start")
    public ResponseEntity<Void> startDockerContainer(@PathVariable String containerId)
    {
        dockerService.startContainer(containerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/containers/{containerId}/stop")
    public ResponseEntity<Void> stopDockerContainer(@PathVariable String containerId)
    {
        dockerService.stopContainer(containerId);
        return ResponseEntity.ok().build();
    }
    }




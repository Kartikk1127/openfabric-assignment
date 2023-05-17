package ai.openfabric.api.controller;

import ai.openfabric.api.model.Worker;
import ai.openfabric.api.model.WorkerStatistics;
import ai.openfabric.api.repository.WorkerStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${node.api.path}/workerstats")
public class WorkerStatisticsController {

    @Autowired
    public WorkerStatisticsRepository workerStatisticsRepository;

    @GetMapping("/{workerid}")
    public WorkerStatistics getWorkerStatistics(@PathVariable Worker workerid)
    {
        WorkerStatistics statistics = workerStatisticsRepository.findByWorkerId(workerid);

        return statistics;
    }

}

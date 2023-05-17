package ai.openfabric.api.repository;

import ai.openfabric.api.model.Worker;
import ai.openfabric.api.model.WorkerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerStatisticsRepository extends JpaRepository<WorkerStatistics, String> {
    WorkerStatistics findByWorkerId(Worker workerId);
}

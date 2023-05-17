package ai.openfabric.api.repository;

import ai.openfabric.api.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, String> {

    @Query(value = "SELECT * FROM worker LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Worker> findPaginatedWorkers(@Param("offset") int offset, @Param("limit") int limit);



    @Query(value = "SELECT COUNT(*) FROM worker", nativeQuery = true)
    int getTotalCount();
}

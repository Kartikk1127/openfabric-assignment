package ai.openfabric.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity()
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkerStatistics extends Datable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "of-uuid")
    @GenericGenerator(name = "of-uuid", strategy = "ai.openfabric.api.model.IDGenerator")
    public String id;

    @OneToOne
    @JoinColumn(name = "worker_id")
    @JsonIgnore
    public Worker workerId;
    public BigDecimal timestamp;
    public BigDecimal cpuUsage;
    public BigDecimal memoryUsage;

}

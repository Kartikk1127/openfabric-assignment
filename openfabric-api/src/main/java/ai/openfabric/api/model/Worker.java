package ai.openfabric.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity()
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Worker extends Datable implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "of-uuid")
    @GenericGenerator(name = "of-uuid", strategy = "ai.openfabric.api.model.IDGenerator")
    public String id;

    public String name;
    public int port;
    public String status;
    public String imageName;

    @OneToOne(mappedBy = "workerId")
    @JsonIgnore
    public WorkerStatistics workerStatistics;



}

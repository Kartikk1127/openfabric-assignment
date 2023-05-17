package ai.openfabric.api.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class DockerService {

    private final DockerClient dockerClient;

    public DockerService() {
        DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost("tcp://localhost:2375").build();
        dockerClient = DockerClientBuilder.getInstance(config).build();
    }

    public void createContainer(String imageName) {
        // Create a container
        dockerClient.createContainerCmd(imageName).exec();
        System.out.println("Container created");
    }

    public void startContainer(String imageId){
        CreateContainerResponse containerResponse = dockerClient.createContainerCmd(imageId).exec();
        try{
            dockerClient.startContainerCmd(containerResponse.getId());
        }
        catch (Exception e)
        {
            System.out.println("not able to run");
        }
//        System.out.println("container started running");
    }

    public void stopContainer(String containerId)
    {
        dockerClient.stopContainerCmd(containerId);
        System.out.println("container stopped running");
    }




}

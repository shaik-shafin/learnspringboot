package com.shaik.acknowledge.docker;

/**
 * DOCKER WORK FLOW:-
 *
 * 1. In order work with docker the first thing that you have to do, downloading the docker desk top this is where you can manage the docker images and container. Docker built on Linux os In order to work with windows you need docker desktop which allow to run the docker.
 *
 * 2. Later after the installation you have to pull an image from DOCKER HUB which like a GIT HUB where you can find the images and upload and pull it from.
 *
 * 3. To get an image from the DOCKER HUB -> docker pull <image_name>
 *
 * 4. if it finds in the local it will get or will this fetch from the DOCKER HUB.
 *
 * 5. To see how many images you have in the docker desktop -> docker images
 *
 * 6. Once we get the image from the DOCKER HUB, to create an container -> docker run <image_name>
 *
 * 7. basically we can run the docker container in INTERACTIVE MODE which allow us to access the container terminal which helps to see the input/output of the container and also allow us to run the addition commands init.
 *
 * 8. To run the INTERACTIVE MODE -> docker run -it <image_name>
 *
 * 9. so that we are in the container terminal which allow us to run various COMMANDS such as ->
 *    a. ls -> To see the list of files & folders in the container
 *    b. mkdir <dir_name> -> To create a new directory in the container
 *    c. env -> To print the different environment variables
 *    d. exit -> To exit from the container which does not stop the container
 *
 * 10. If you wish to see how many container are there -> docker ps -a
 *
 * 11. If you wish to see the running container -> docker ps
 *
 * 12. With the help of the (docker run <image_name>) we can create a new container and run it but if you want to restart the existing container.
 *     a. docker start <container_name> or <container_id> -> For restart existing container
 *     b. docker stop <container_name> or <container_id> -> For stop container
 *
 * 13. In order to remove/destroy the Image -> docker rmi <image_name> or <image_id>
 *
 * 14. In order to remove/destroy the container -> docker rm <container_name> or <container_id>
 *
 * 15. Note: if you want to remove the image first you have to remove the associated container with it.
 *
 * 16. In DOCKER the tags are nothing but the versions of the images lets say if you want to pull any image and if you do not mention the version will it pull the latest version of it as you can find the command for this at 3.
 *
 * 17. Perhaps if you want to pull specific version in that case -> docker pull <image_name>:<version> (ex: MySQL:8.0)
 *
 * 18. In case you want to run an container in the detach mode -> docker run -d <image_name>
 *
 * 19. Detach mode which is basically running on background, by default all the container runs on attached mode
 *
 * 20. In case if you do not wish to provide the container name docker will gives default of any name to it, if you wish to give name then
 *     a. docker run --name <container_name> -d <image_name>
 *
 * 21. for running the MySQL image you have to follow few things that already mentioned in the DOCKERHUB, which is mentioning the env variable which you can achieve by -> docker run -d -e MYSQL_ROOT_PASSWORD = <any_password> MySQL (ex: docker run -d -e MYSQL_ROOT_PASSWORD=password --name my-old-mysql mysql:8.0)
 *
 * 22. Port Binding:-
 *     a. Whenever we map the host port with container port we will call it as PORT BINDING.
 *     b. Whatever the port as container has they are different from the host port.
 *     c. If the request comes to host port then we can map it to container port
 *     d. So that the request will flow in that way.
 *     e. docker run -p<host_port>:<container_port> <image_name> (ex: docker run -d -e MYSQL_ROOT_PASSWORD=password --name my-old-mysql -p8080:3306 mysql:8.0)
 *
 * 23. If you are facing the issues and you want to checkout the logs of the container to identify the issues is you can use the following commands
 *     a. docker logs <container_id> -> For checking the logs
 *     b. docker exec -it <container_id> /bin/bash -> Allowing to run additional commands in already running container
 *     c. docker exec -it <container_id> /bin/sh -> Allowing to run additional commands in already running container
 *
 * 24. Docker Network: Which is something that will allow you to interact with isolated container with each other without further need of port or localhost
 *
 * 25. When we wanted to interact with one container to another container directly we go and create the Docker Network.
 *
 * 26. To see the docker network list -> docker network ls
 *
 * 27. If you want to create a new network -> docker network create <network_name>
 *
 * 28. If you want to delete/remove the docker network -> docker network rm <network_name>
 *
 * 29. Example for creating the containers in the docker network with mango db
 *     docker run -d \
 *     -p27017:27017 \
 *     --name mango \
 *     --network <docker_netowk_name> \
 *     -e MANGO_INITDB_ROOT_USERNAME=admin \
 *     -e MANGO_INITDB_ROOT_PASSWORD=password \
 *     <image_name>
 *
 * 30. Note:
 *     a. \ -> indicates that you can write readable way of the commands
 *     b. if you do not pull the image and directly run the container with the <image_name> then it will pull the image first then runs the container.
 *     c. If you want to run the other container you can follow the above syntax so that 2 containers will run in same docker network.
 *
 * 31. Docker Compose :
 *     It is a way that to improve the readability and to simplify and standardize all the commands that required to run the container.
 *
 * 32. In order to achieve that you have to create the .yaml(Yet Another Markup Language) file in your project directory.
 *
 * 33. Below is the sample exmaple by simplifying the 28th example
 *     mangodb.yaml
 *     version : "3.8" (Optional)
 *     services :
 *        mango : (container name)
 *           image : <image_name>
 *           ports : - 27017:27017
 *           environment :
 * 	     MANGO_INITDB_ROOT_USERNAME=admin
 * 	     MANGO_INITDB_ROOT_PASSWORD=password
 *       ..ect (you can write another container commands by following the above syntax)
 *
 * 34. Note: As you can see that we haven't mentioned any docker network here, the reason is we no need mention the docker network by default this .yaml file will create a default network and runs these container inside of it.
 *
 * 35. Once after creating this .yaml file, In order to run it you have to follow below commands which is using the docker compose commands
 *     a. For creating/running all containers in the detach mode -> docker compose -f mangodb.yaml up -d OR docker compose up --build
 *     b. For removing/deleting the all containers -> docker compoe -f mangodb.yaml down
 *
 * 36. Note:
 *     a. In order to run the above command you have to enter into the app directory where the .ymal file will be located.
 *     b. Once you run the down command all the containers got removed along with the newly created network also removed.
 *
 * 35. Docker File: Which is blue print for creating the Docker Image and which contains all the information about our project.
 *
 * 36. In order to Dockerize your own application you have to create a DockerFile with no extension in your project directory
 *
 * 37. Syntax for creating the Docker File (https://docs.docker.com/get-started/docker-concepts/building-images/writing-a-dockerfile/)
 *
 * 38. As most common commands that we use to create the docker file
 *     a. FROM -> which indicates the base image, let's say if you want to run the java application jdk is mandatory so that you have to give jdk image there.
 *     b. WORKDIR -> We have to create new directory where we can copy the project folder and keep it for the reference for image & container to run.
 *     c. COPY -> This is the command useful for copying the project and keeping in the new created directory.
 *     d. RUN -> After copying project folder if you want to run any commands (such as maven) you can declare here it can be one or many.
 *     e. CMD -> This is one command that will run your project (such as mvn jetty:run)
 *     f. EXPOSE -> Used for exposing the port of the running project
 *     g. EVN -> Used to define the environment variables for your project
 *
 * 39. After creating the Docker File you build the image run -> docker build -t <image_name>:<version> .
 *
 * 40. -t indicates that tag and you can give any name to your project image which applies to versions as well.
 *
 * 41. Docker Pushing: Which is like pushing you docker image in the docker hub.
 *
 * 42. If you want to push your docker image in the docker hub you need a account in the docker and you have to create a repository in the docker hub.
 *
 * 43. Once you created an repo in the docker hub you will be given a name for the repo, so that with the same name you have to create your project image name.
 *
 * 44. After that, the account you have created in the docker which you have to login in the terminal as well.
 *
 * 45. command for docker login in the terminal
 *     a. docker login
 *     b. docker logout
 *
 * 46. Once you entered this command you will get two ways of login
 *     a. By entering -> docker login -u <your_account_name> after then you have to enter the password.
 *     b. On Url will be provided to you, where you have already login to your docker account there you have mention this url and otp (which already in the   	terminal itself as the result you will be login successfully)
 *
 * 47. After successfully logged in you have to use -> docker push <image_name> (in you want you can also mention the tag or else it will take as latest)
 *
 * 48. Docker Volumes: Volumes are persistent data stored for containers.
 *
 * 49. Whenever we use the MySQL image the data is stored in the virtual file in the container when we stop/remove the container we will lost the data.
 *
 * 50. To over come this problem Volumes are introduced, We will externally create a volume file in the host machine most of the case docker will manage it.
 *
 * 51. The external volume will connected the docker virtual file so that whatever the data stores in the virtual file will be replicated to external volume.
 *
 * 52. Even if we stop/remove the container we will reclaim the memory by this external volume.
 *
 * 53. Command for attaching the external volume on running container -> docker run -it -v /users/shaik/desktop/data:/test/data <image_name>
 *
 * 54. Note: Even you can mentioned created volume or if it doesn't exit then docker create new volume in the specified path.
 *
 * 55. To create files in the running container follow this command -> touch index.html or touch index.js
 *
 * 56. In order to use the docker volumes with the docker compose follow the below syntax
 *     mangodb.yaml
 *     version : "3.8" (Optional)
 *     services :
 *        mango : (container name)
 *           image : <image_name>
 *           ports : - 27017:27017
 *           environment :
 * 	     MANGO_INITDB_ROOT_USERNAME=admin
 * 	     MANGO_INITDB_ROOT_PASSWORD=password
 *           volumes :
 *              - <host_directory_path>:<container_directory_path> (for predefined images you will find this on docker documentation)
 *
 * 57. For more actions on the volumes follow below commands
 *     a. For see all the volumes -> docker volume ls
 *     b. To create volume -> docker volume create <volume_name>
 *     c. To remove/delete volume -> docker volume rm <volume_name> OR docker compose down -v
 *
 * 58. When you create volume using the command docker will store those volumes for window -> C:\programData\docker\volumes
 *
 * 59. When we create a volume those are isolated which means they are not attached with any running container so that to attach it to running container
 *     follow these commands
 *     a. Named Volumes -> docker run -v <vol_name>:<container_dir> (mostly we use this approach)
 *     b. Anonymous Volumes -> docker run -v <mount_path>
 *     c. Bind Mount -> docker run -v <host_dir>:<container_dir>
 *
 * 60. The main difference between named volumes and bind mount, In case of named volumes docker will manage the volumes but in case bind mount host machine
 *     will manage it.
 *
 * 61. If you want to remove/delete the unused volume in the local -> docker volume prune
 *
 * 62. Docker Network Drivers: which is a way to provide how to interact with containers with each other.
 *     a. bridge -> this is the default driver for creating the interaction with two or more containers
 *     b. host -> it will use the same network as our host network use.
 *     c. null -> when you want to create isolated container which is completely isolated with other container and host machine
 *
 *
 * **/
# java jni test
- take advantage of c++ libraries, like ros, ceres, pcl, tbb, openmp.
- setup docker remote development tool chain.


### set development environment

set environment variable to use some libraries, both in CLion and Idea

```sh
LD_LIBRARY_PATH=/opt/ros/noetic/lib;ROS_HOME=/tmp
```


##### set CLion
- cmake tool chain use docker
- set docker remote development, container setting, Volume bindings, map Idea project directory.
- set cmake install path, so cmake can directly install library to idea project.
- Do not use CLion install command, this cause linking error in Idea;
- Best to use docker cmake and install command in docker.
- write CMakeLists.txt to install library

```cmake

set(INSTALL_PATH IdeaProjects/java_test/java_test/native_libs)

install(DIRECTORY ${CMAKE_BINARY_DIR}/lib/
        DESTINATION ${INSTALL_PATH}
        PATTERN "launch/data" EXCLUDE
        )
```


##### set Idea

- use space remote development
- set project structures, global libraries, add java, native library

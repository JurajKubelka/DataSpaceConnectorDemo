# DataSpaceConnectorDemo
Demo using DataSpaceConnector

## Compilation 

__Submodule.__ Initialize submodules using

```shell
git submodule update --init --recursive
```

To build this project, you need the compiled DataSpaceConnector libraries. As they didn't yet publish a version to maven central, deploy them to maven local before. To do so, run:

```shell
./DataSpaceConnector/gradlew -p ./DataSpaceConnector -Pskip.signing=true publishToMavenLocal
```

__Project.__ Compile the project itself executing: 

```shell 
./gradlew build
```

## Execution 

### Client
```shell
java -Dedc.fs.config=client/config.properties -jar client/build/libs/client.jar
```

You should observe an output similar to the following: 

```log
INFO 2022-05-26T19:00:14.725654 Initialized FS Configuration
INFO 2022-05-26T19:00:14.890802 Initialized Core Services
WARNING 2022-05-26T19:00:15.180022 Settings: No setting found for key 'edc.hostname'. Using default value 'localhost'
INFO 2022-05-26T19:00:15.182933 Initialized org.eclipse.dataspaceconnector.core.defaults.DefaultServicesExtension
INFO 2022-05-26T19:00:15.187661 Initialized org.eclipse.dataspaceconnector.contract.ContractNegotiationCommandExtension
INFO 2022-05-26T19:00:15.190529 Initialized org.eclipse.dataspaceconnector.transfer.core.TransferProcessCommandExtension
INFO 2022-05-26T19:00:15.196772 Initialized Core Contract Service
INFO 2022-05-26T19:00:15.203054 Initialized Core Transfer
...
INFO 2022-05-26T19:00:16.126602 Started IDS Core
INFO 2022-05-26T19:00:16.126664 Started IDS API Configuration
INFO 2022-05-26T19:00:16.126725 Started IDS Multipart API
INFO 2022-05-26T19:00:16.126783 Started IDS Multipart Dispatcher API
INFO 2022-05-26T19:00:16.126859 Started IDS Transform Extension
INFO 2022-05-26T19:00:16.128652 edc-78e52c8c-59f1-40bb-9f08-061fddc5cb6a ready
```

### Hospital

```shell
java -Dedc.fs.config=hospital/config.properties -jar hospital/build/libs/hospital.jar
```

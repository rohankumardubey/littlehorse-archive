# LH Local Development Tools

This tools are intended to be use for development purposes.

## Running LH

The LH Server depends on Kafka as a backend database. To start Kafka using docker compose, you can run:

```
./local-dev/setup.sh
```

Next, you can start the LH server itself. The server can be started in a single command:

```
./local-dev/do-server.sh
```

You can confirm that the Server is running via:

```
-> lhctl search wfSpec
{
  "code":  "OK",
  "objectIds":  []
}
```

## Setup and Cleanup Kafka

Run:

```
./local-dev/setup.sh
```

You can clean up (i.e. stop Kafka and delete the data from the state directory) as follows:

```
./local-dev/cleanup.sh
```

## Debug Cycle

To "reset" the LittleHorse cluster, you need to delete the data in Kafka and also delete the KafkaStreams RocksDB state. That can be done as follows:

1. Stop all LH Server processes.
2. Run `./local-dev/refresh.sh`.
3. Start the LH Servers again.

### Running Multiple LH Servers

LittleHorse is a distributed system in which the different LH Server Instances (Brokers) need to communicate with each other. For example (among many others), all GET requests on the API use Interactive Queries, which involves requests between the different Brokers. Therefore, you'll need to be able to test with multiple brokers running at once.

Running two brokers is slightly tricky as you must configure the ports, advertised hostnames, and Kafka group instance ID's correctly.

However, you can start two Brokers in your terminal as follows:

```
# The first server has an external API port of 2023
./local-dev/do-server.sh

# <In another terminal>
# The second server has an external API port of 2033
./local-dev/do-server.sh server-2
```

## Release a new version

Install semver command:

```
npm install
```

Upgrade to a new version:

```bash
./local-dev/bump.sh -i <major, minor, patch>
./local-dev/bump.sh -i prerelease --preid <alpha, beta, rc>
```

> More information at https://github.com/npm/node-semver

## Code analysis

Run sonar:

```
./local-dev/setup-code-analyzer.sh
./local-dev/code-analysis.sh
```

Stop and start:

```
docker stop sonarqube
docker start sonarqube
```

Clean sonar:

```
./local-dev/clean-code-analyzer.sh
```

Run dependency check (It could take several minutes):

```
./local-dev/dependencies-analysis.sh
```

## Publishing to Maven Local

The `sdk-java` in particular is a library that will be published to maven central for production use. For local development, you can publish it to your local maven repository as follows:

```
./local-dev/publish-locally.sh
```

This step is necessary before building other components.

## Building the Docker Image

You can build the `littlehorse` docker image by running:

```
./local-dev/build.sh
```

Run server with docker (default config `local-dev/server-1.config`):

```
./local-dev/do-docker-server.sh
```

Run server with docker and specific config:

```
./local-dev/do-docker-server.sh <config-name>

# Example
./local-dev/do-docker-server.sh server-2
```

## Compile Schemas

```
./local-dev/compile-proto.sh
```
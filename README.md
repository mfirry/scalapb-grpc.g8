Simple seed to get started with Scala and gRPC using:

- [ScalaPB](https://scalapb.github.io/)
- `helloworld.proto` from [grpc-java examples](https://github.com/grpc/grpc-java/tree/master/examples)
- `hello_streaming.proto` from [grpc-java examples](https://github.com/grpc/grpc-java/tree/master/examples)
- `route_guide.proto` from [grpc-java examples](https://github.com/grpc/grpc-java/tree/master/examples)

## Usage

(For more information on how to use [Giter8](http://www.foundweekends.org/giter8/) templates with sbt have a look at https://www.scala-sbt.org/1.0/docs/sbt-new-and-Templates.html)

In general one should use this template simply running: `sbt new mfirry/scalapb-grpc.g8`

This will create a working project structure with two packages: `client` and `server` showing how ScalaPB can be used with grpc in both cases.

ScalaPB specific settings will be found under `project/scalapb.sbt`

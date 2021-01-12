package scalapb.grpc.example
package client

import io.grpc.ManagedChannelBuilder
import io.grpc.examples.manualflowcontrol.hello_streaming.{HelloReply, StreamingGreeterGrpc}
import io.grpc.stub.StreamObserver

object StreamingGreeterClient {
  val host = "127.0.0.1"
  val port = 50051

  val channel =
    ManagedChannelBuilder.forAddress(host, port).usePlaintext().build

  val stub = StreamingGreeterGrpc.stub(channel)
  stub.sayHelloStreaming(new StreamObserver[HelloReply] {
    def onNext(value: HelloReply): Unit = {
      println(s"Got HelloReply: \$value")
    }

    def onError(t: Throwable): Unit = ???

    def onCompleted(): Unit = ???
  })

}

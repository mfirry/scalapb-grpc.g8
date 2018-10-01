package scalapb.grpc.example
package server

import io.grpc.examples.manualflowcontrol.hello_streaming.{HelloReply, HelloRequest, StreamingGreeterGrpc}
import io.grpc.stub.StreamObserver

private class StreamingGreeterImpl extends StreamingGreeterGrpc.StreamingGreeter {
  def sayHelloStreaming(responseObserver: StreamObserver[HelloReply]): StreamObserver[HelloRequest] = {
    new StreamObserver[HelloRequest] {
      def onNext(request: HelloRequest): Unit = responseObserver.onNext(HelloReply.defaultInstance)

      def onError(t: Throwable): Unit = ???

      def onCompleted(): Unit = ???
    }
  }
}

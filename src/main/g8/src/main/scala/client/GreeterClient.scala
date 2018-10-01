package scalapb.grpc.example
package client

import io.grpc.ManagedChannelBuilder
import io.grpc.examples.helloworld.helloworld._

object GreeterClient {
  val host = "127.0.0.1"
  val port = 50051

  val channel =
    ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build
  val request = HelloRequest(name = "Foo")

  val blockingStub = GreeterGrpc.blockingStub(channel)
  val reply: HelloReply = blockingStub.sayHello(request)

  println(reply)

  // Just for test. Remove following line
  Thread.sleep(10000)
}

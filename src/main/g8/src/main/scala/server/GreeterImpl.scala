package scalapb.grpc.example
package server

import scala.concurrent.Future

import io.grpc.examples.helloworld.helloworld._

private class GreeterImpl extends GreeterGrpc.Greeter {
  override def sayHello(req: HelloRequest) = {
    val reply = HelloReply(message = "Hello " + req.name)
    Future.successful(reply)
  }
}

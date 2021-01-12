package scalapb.grpc.example
package client

import io.grpc.ManagedChannelBuilder
import io.grpc.examples.routeguide.route_guide.{Feature, Point, RouteGuideGrpc}

object RouteGuideClient {
  val host = "127.0.0.1"
  val port = 50051

  val channel =
    ManagedChannelBuilder.forAddress(host, port).usePlaintext().build

  val point = Point(37, 15)

  val blockingStub = RouteGuideGrpc.blockingStub(channel)
  val feature: Feature = blockingStub.getFeature(point)

  println(feature)
  Thread.sleep(10000)
}
package scalapb.grpc.example
package server

import io.grpc.examples.routeguide.route_guide._
import io.grpc.stub.StreamObserver

import scala.concurrent.Future

private class RouteGuideImpl extends RouteGuideGrpc.RouteGuide {
  def getFeature(request: Point): Future[Feature] =
    Future.successful(Feature(name = "foo", location = Some(Point(request.latitude * 2, request.longitude * 2))))

  def listFeatures(request: Rectangle, responseObserver: StreamObserver[Feature]): Unit = {
    responseObserver.onNext(Feature.defaultInstance)
    responseObserver.onCompleted()
  }

  def recordRoute(responseObserver: StreamObserver[RouteSummary]): StreamObserver[Point] = {
    new StreamObserver[Point]() {
      def onNext(value: Point): Unit =
        responseObserver.onNext(RouteSummary(0, 0, 0, 1))

      def onError(t: Throwable): Unit = ???

      def onCompleted(): Unit = ???
    }

  }

  def routeChat(responseObserver: StreamObserver[RouteNote]): StreamObserver[RouteNote] = {
    new StreamObserver[RouteNote] {
      def onNext(value: RouteNote): Unit = RouteNote.defaultInstance

      def onError(t: Throwable): Unit = ???

      def onCompleted(): Unit = ???
    }
  }
}

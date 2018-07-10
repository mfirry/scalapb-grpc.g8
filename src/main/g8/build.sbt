lazy val scalaPBsettings = Seq(
  PB.targets in Compile := Seq(
    scalapb.gen() -> (sourceManaged in Compile).value
  ),
  libraryDependencies ++= Seq(
    "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",
    "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
    "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion
  )
)

lazy val commonSettings = Seq(
  scalaVersion := "2.11.1"
)

lazy val root = (project in file(".")).
  settings(
    commonSettings,
    scalaPBsettings,
    name := "scalaPB-grpc-example"
  )

lazy val root = project.in(file("."))
  .settings(
    name := "$name$",
    organization := "com.example",
    scalaVersion := "2.13.3",
    version      := "0.1.0-SNAPSHOT",
    addCompilerPlugin("io.tryp" % "splain" % "0.5.7" cross CrossVersion.patch),
    scalacOptions ++= Seq(
      "-P:splain:all",                             // Enable all splain compiler plugin options -- https://github.com/tek/splain
      "-P:splain:rewrite:^(([^\\\\.]+\\\\.)*)([^\\\\.]+)\\\\.Type\$/\$3", // Rewrite types in splain errors to remove `.Type` from the end (newtypes)
      "-P:splain:foundreq:false",                  // Disable splain hijacking type mismatch errors
    )
  )

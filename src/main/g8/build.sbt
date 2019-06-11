lazy val root = (project in file("."))
  .settings(
    name := "$name$",
    organization := "com.example",
    scalaVersion := "2.12.8",
    version      := "0.1.0-SNAPSHOT",
    addCompilerPlugin("io.tryp" % "splain" % "0.4.1" cross CrossVersion.patch),
    scalacOptions ++= Seq(
      "-deprecation",                              // Emit warning and location for usages of deprecated APIs.
      "-encoding", "UTF-8",                        // Specify character encoding used by source files.
      "-explaintypes",                             // Explain type errors in more detail.
      "-feature",                                  // Emit warning and location for usages of features that should be imported explicitly.
      "-language:higherKinds",                     // Allow higher-kinded types
      "-P:splain:all",                             // Enable all splain compiler plugin options -- https://github.com/tek/splain
      "-P:splain:rewrite:^(([^\\.]+\\.)*)([^\\.]+)\\.Type\$/\$3", // Rewrite types in splain errors to remove `.Type` from the end (newtypes)
      "-unchecked",                                // Enable additional warnings where generated code depends on assumptions.
      "-Xcheckinit",                               // Wrap field accessors to throw an exception on uninitialized access.
      "-Xfatal-warnings",                          // Fail the compilation if there are any warnings.
      "-Xfuture",                                  // Turn on future language features.
      "-Xlint:_",                                  // Enable all lint warnings
      // "-Xlog-implicits",                           // Show more detail on why some implicits are not applicable.
      "-Ybreak-cycles",                            // Attempt to break cycles encountered during typing.
      "-Yno-adapted-args",                         // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
      "-Ywarn-dead-code",                          // Warn when dead code is identified. N.B. doesn't work well with the ??? hole
      "-Ybackend-parallelism", procs,              // maximum worker threads for backend
      "-Ycache-macro-class-loader:last-modified",  // Policy for caching class loaders for macros that are dynamically loaded.
      "-Ycache-plugin-class-loader:last-modified", // Policy for caching class loaders for compiler plugins that are dynamically loaded.
      "-Ypartial-unification",                     // Enable partial unification in type constructor inference
      "-Ywarn-extra-implicit",                     // Warn when more than one implicit parameter section is defined.
      "-Ywarn-inaccessible",                       // Warn about inaccessible types in method signatures.
      "-Ywarn-infer-any",                          // Warn when a type argument is inferred to be `Any`.
      "-Ywarn-nullary-override",                   // Warn when non-nullary `def f()' overrides nullary `def f'.
      "-Ywarn-nullary-unit",                       // Warn when nullary methods return Unit.
      "-Ywarn-numeric-widen",                      // Warn when numerics are widened.
      "-Ywarn-self-implicit",                      // Warn when an implicit resolves to an enclosing self-definition.
      "-Ywarn-macros:after",                       // Check for unused after macro expansion.
      "-Ywarn-unused:implicits",                   // Warn if an implicit parameter is unused.
      "-Ywarn-unused:imports",                     // Warn if an import selector is not referenced.
      "-Ywarn-unused:locals",                      // Warn if a local definition is unused.
      "-Ywarn-unused:patvars",                     // Warn if a variable bound in a pattern is unused.
      "-Ywarn-unused:privates",                    // Warn if a private member is unused.
      "-Ywarn-value-discard"                       // Warn when non-Unit expression results are unused.
    ),
    scalacOptions in (Compile, console) := scalacOptions.value.filterNot(_.contains("-Ywarn-unused"))
  )

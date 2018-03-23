package edu.knoldus.user.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait UserService extends Service {

  def greetUser(name: String): ServiceCall[NotUsed, String]

  def getUserData(): ServiceCall[NotUsed, UserData]

  override final def descriptor: Descriptor = {
    import Service._
    // @formatter:off
    named("user-lagom")
        .withCalls(
          restCall(Method.GET, "/api/getUserData", getUserData _),
          restCall(Method.GET, "/api/greet/:name", greetUser _)
        )
        .withAutoAcl(true)

  }
}
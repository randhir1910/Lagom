package edu.knoldus.user.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait ExternalService extends Service {

  def getUserData(): ServiceCall[NotUsed, UserData]

  override final def descriptor: Descriptor = {
    import Service._
    // @formatter:off
    named("external-service")
        .withCalls(
          pathCall("/posts/1", getUserData _))
        .withAutoAcl(true)

  }

}

package edu.knoldus.user.impl

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.ServiceCall
import edu.knoldus.user.api.{ExternalService, UserData, UserService}

import scala.concurrent.{ExecutionContext, Future}

class UserServiceImpl(externalService: ExternalService)(implicit ec: ExecutionContext) extends UserService {



  override def greetUser(name: String): ServiceCall[NotUsed, String] = ServiceCall { _ =>
    Future.successful(s"hello  $name")

  }

  override def getUserData(): ServiceCall[NotUsed, UserData] = ServiceCall { _ =>

    val result = externalService.getUserData().invoke()

    result.map(response => response)
  }
}

package com.git.sparyFirst

import akka.actor.ActorSystem
import akka.actor.Props
import akka.util.Timeout
import akka.io.IO
import spray.can.Http
import scala.concurrent.duration._
import akka.pattern.ask

object Boot extends App{
  implicit val system = ActorSystem("on-spray-can")

  val service = system.actorOf(Props[MyServiceActor],"demo-service")

  implicit val timeout = Timeout(5)
  IO(Http)?Http.Bind(service,interface= "localhost",port = 8080)

}
package com.git.sparyFirst

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._


class MyServiceActor extends Actor with MyService {

  def actorRefFactory = context
  def receive = runRoute(myRoute)

}


trait MyService extends HttpService {

  val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to xiaopengpeng !</h1>
              </body>
            </html>
          }
        }
      }
    }
}
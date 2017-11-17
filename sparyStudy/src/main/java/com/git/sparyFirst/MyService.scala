package com.git.sparyFirst

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._


class MyServiceActor extends Actor with MyService {

  def actorRefFactory = context
  def receive = runRoute(myRoute~onather)

}


trait MyService extends HttpService {

  val myRoute =
    path("hello") {
      post {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to xiaopengpeng !</h1>
              </body>
            </html>
          }
        }
      }~
      get {
        respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
           val person =new Person("ming",2)
           person.toString
          }
        }
      }
    }
  val onather = 
    path("spark") {
      post {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to xiaopengpeng !</h1>
              </body>
            </html>
          }
        }
      }~
      get {
        respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
           val person =new Person("ming",2)
           person.toString
          }
        }
      }
    }
}

case class Person(name:String,age:Int)
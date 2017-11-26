package main.scala.scalaDocumentation


abstract class Notification

case class Email(sourceEmail: String, title: String, body: String) extends Notification

case class SMS(sourceNumber: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification


object CaseClasses extends App {
  
  val emailFromKedar = Email("kedar@mail.com", "Hello World", "Hello World Body");
  
  /**
   * With case classes, you cannot mutate their fields directly. 
   * Unless you insert var before a field, but doing so is generally discouraged
   */
  // emailFromKedar.title = "New Title"; -- Will not work
  /**
   * A copy of the object can be made with new definitions
   */
  val editedEmail = emailFromKedar.copy(title = "I am learning Scala", body = "It's so cool");
  println(emailFromKedar);
  println(editedEmail);
  
  val firstSms = SMS("12345", "Hello!")
  val secondSms = SMS("12345", "Hello!")
  // == method will ensure that there is structural equality to two objects in terms of their content
  if (firstSms == secondSms) {
    println("They are equal!")
  } else {
    println("Objects are not equal");
  }
  
  /**
   * Matching objects of case classes using super-type
   */
  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _) =>
        "You got an email from " + email + " with title: " + title
      case SMS(number, message) =>
        "You got an SMS from " + number + "! Message: " + message
      case VoiceRecording(name, link) =>
        "you received a Voice Recording from " + name + "! Click the link to hear it: " + link
    }
  }
  
  
  /**
   * 
   */
  def showNotificationSpecial(notification: Notification, specialEmail: String, specialNumber: String): String = {
    notification match {
      case Email(email, _, _) 
        if email == specialEmail =>
        "You got an email from special someone!"
      case SMS(number, _) 
        if number == specialNumber =>
          "You got an SMS from special someone!"
      case default =>
        showNotification(default) // nothing special, delegate to our original showNotification function   
    }
  }
  
  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
  println(showNotification(someSms))
  println(showNotification(someVoiceRecording))
  
  val SPECIAL_NUMBER = "55555"
  val SPECIAL_EMAIL = "jane@mail.com"
  val specialEmail = Email("jane@mail.com", "Drinks tonight?", "I'm free after 5!")
  val specialSms = SMS("55555", "I'm here! Where are you?")
  
  println(showNotificationSpecial(someSms, SPECIAL_EMAIL, SPECIAL_NUMBER))
  println(showNotificationSpecial(someVoiceRecording, SPECIAL_EMAIL, SPECIAL_NUMBER))
  println(showNotificationSpecial(specialEmail, SPECIAL_EMAIL, SPECIAL_NUMBER))
  println(showNotificationSpecial(specialSms, SPECIAL_EMAIL, SPECIAL_NUMBER))
  
}

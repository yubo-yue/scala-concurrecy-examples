package org.scala.designpattern

import scala.collection.mutable.HashMap

trait Product

case class ConcreteProduct(s: String) extends Product
case class AlternativeConcreteProduct(i: Int) extends Product

trait Factory {
  def create(a: Any): Product
}

object ProductFactory extends Factory {
  implicit def create(a: Any): Product = a match {
    case s: String => ConcreteProduct(s)
    case i: Int => AlternativeConcreteProduct(i)
  }
}

object FactoryDemo extends App {
  val a = ProductFactory.create("John")
  println(a)

  val b = ProductFactory.create(32)
  println(b)

  import ProductFactory._
  val c: Product = "Adam"
  val d: Product = 44
  println(c)
  println(d)
}
package document {

  trait DocumentViewer {
    var filename: String
  }
  trait Factory {
    def create(s: String): DocumentViewer
  }

  private case class WordViewer(var filename: String) extends DocumentViewer
  private object WordView {
    def create(s: String) = WordViewer(s)
  }

  private case class OpenOfficeViewer(var filename: String) extends DocumentViewer
  private object OpenOfficeViewer {
    def create(s: String) = OpenOfficeViewer(s)
  }

  private case class JPEGViewer(var filename: String) extends DocumentViewer
  private object JPEGViewer {
    def create(s: String) = JPEGViewer(s)
  }

  object DocumentViewerFactory extends Factory {
    private[document] val viewers = HashMap[String, String => DocumentViewer]()

    def create(s: String): DocumentViewer = {
      var pos = s.lastIndexOf(".")
      if (pos < 0) pos = 0
      val endsWith = s.substring(pos)
      val funcOption = viewers.get(endsWith)
      if (funcOption.nonEmpty) {
        val func = funcOption.get
        return func(s)
      } else {
        throw new Exception("Unknown document type")
      }
    }
  }

  object Main extends App {
    DocumentViewerFactory.viewers.put(".docx", WordView.create)
    DocumentViewerFactory.viewers.put(".odt", OpenOfficeViewer.create)
    DocumentViewerFactory.viewers.put(".jpg", JPEGViewer.create)

    val p1 = DocumentViewerFactory.create("Info.docx")
    println(p1)
  }
}

package abstractFactoryMethod {
  trait Factory

  trait Product

  trait Window extends Product {
    val title: String
    var x: Int
    var y: Int
  }

  trait Menu extends Product {
    val title: String
    val shortcut: String
  }

  trait UIFactory extends Factory {
    def window(title: String): Window
    def menu(title: String, shortcut: String): Menu
  }

  case class OSXFactory() extends UIFactory {
    class OSXMenu(val title: String, val shortcut: String) extends Menu {
      override def toString = s"OSXMenu: $title ( $shortcut ) "
    }

    class OSXWindow(val title: String, var x: Int = 0, var y: Int = 0) extends Window {
      override def toString = s"OSXWindow: $title ( $x, $y )"
    }

    def window(title: String) = new OSXWindow(title)
    def menu(title: String, shortcut: String): Menu = new OSXMenu(title, shortcut)
  }

  case class WinFactory() extends UIFactory {
    class WinMenu(val title: String, val shortcut: String) extends Menu {
      override def toString = s"WinMenu $title ( $shortcut )"
    }

    class WinWindow(val title: String, var x: Int = 0, var y: Int = 0) extends Window {
      override def toString = s"WinWindow: $title ($x, $y)"
    }

    def window(title: String) = new WinWindow(title)
    def menu(title: String, shortcut: String): Menu = new WinMenu(title, shortcut)
  }

  object FactoryProvider {
    private val default = OSXFactory()
    private val factories = HashMap[String, UIFactory]("WIN" -> WinFactory(), "OSX" -> default)
    def factory = factories.getOrElse(System.getProperty("factory"), default)
  }
}
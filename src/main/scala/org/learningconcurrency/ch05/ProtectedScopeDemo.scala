package org.learningconcurrency.ch05 {

class Animal {
  
  protected def breathe {}
}

class Jungle {
  val a = new Animal
}


class Foo {
  private[ch05] def doX{}
  private[learningconcurrency] def doY{}
  private[org] def doZ{}
  
}
}


package org.learningconcurrency {
  import org.learningconcurrency.ch05.Foo
  class Bar {
    val f = new Foo
//    f.doX
    f.doY
    f.doZ
  }
}
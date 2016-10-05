package chapter8;

public class Test {
  public static void main(String[] args) {
    m(new A());
    m(new B());
    m(new C());
    m(new Object());
  }

  public static void m(Object x) {
    System.out.println(x.toString());
  }
}

class A extends B {
}

class B extends C {
  public String toString() {
    return "B";
  }
}

class C extends Object {
  public String toString() {
    return "C";
  }
}
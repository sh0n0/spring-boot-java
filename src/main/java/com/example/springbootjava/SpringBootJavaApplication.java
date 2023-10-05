package com.example.springbootjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJavaApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootJavaApplication.class, args);

    // error-prone 動作確認用
    // String[] nameArray = new String[] {"a", "b"};
    // System.out.println(nameArray);
  }

  // NullAway 動作確認用
  //  static void log(Object x) {
  //    System.out.println(x.toString());
  //  }
  //
  //  static void foo() {
  //    log(bar());
  //  }
  //
  //  static String bar() {
  //    return null;
  //  }
}

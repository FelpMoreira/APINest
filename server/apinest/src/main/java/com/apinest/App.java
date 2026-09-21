package com.apinest;

import io.javalin.Javalin;

public class App {
  public static void main(String[] args) {
    var app = Javalin.create(config -> {
      config.routes.get("/", ctx -> ctx.result());
    }).start(7070);
  }
}

package com.example.springbootjava;

sealed interface Expression permits IntExpr, StringExpr {}

record IntExpr(int i) implements Expression {}

record StringExpr(String s) implements Expression {}

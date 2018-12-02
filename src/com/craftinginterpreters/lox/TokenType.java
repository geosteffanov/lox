package com.craftinginterpreters.lox;

public enum TokenType {

    // SINGLE CHAR TOKENS
    LEFT_PAREN, RIGHT_PAREN,
    LEFT_BRACE, RIGHT_BRACE,
    COMMA,
    DOT,
    MINUS,
    PLUS,
    SEMICOLON,
    SLASH,
    STAR,


    // ONE OR TWO CHARS
    BANG, BANG_EQUAL,
    EQUAL, EQUAL_EQUAL,
    GREATER, GREATER_EQUAL,
    LESS, LESS_EQUAL,


    // LITERALS
    IDENTIFIER, STRING, NUMBER,


    // KEYWORDS
    AND, CLASS, ELSE, FALSE,
    FUN, FOR, IF, NIL, OR,
    PRINT, RETURN, SUPER, THIS,
    TRUE, VAR, WHILE,


    // MISC
    EOF,
    UNKNOWN,

}

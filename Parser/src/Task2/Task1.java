package task2;


import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author sb671
 */


public class Task1 {
    
    
    public static Lexer create() {
        return new Lexer() {
            public List<Token> lex(String input) throws LexicalException, Task1Exception {
                MyLexer mylex = new MyLexer(new StringReader(input));
                boolean endOfFile = false;
                Token temp;
                List<Token> tokenList = new ArrayList();
                while (!endOfFile) {
                    temp = mylex.yylex();
                    if (temp instanceof T_EOF) {
                        endOfFile = true;
                    }
                    else {
                        tokenList.add(temp);
                    }
                }
                return tokenList;
            }
        };
    }
    
}

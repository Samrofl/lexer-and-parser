
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mss60
 */
public class Task1 {

    public static Lexer create () {
        return new Lexer(){
            public List<Token> lex ( String input ) throws LexicalException, Task1Exception {
                MyLexer reader = new MyLexer(new StringReader(input));
                List<Token> list = new ArrayList();
                Token ptr = null;
                    while(!reader.getEOF()){
                    try {
                        ptr = reader.yylex();
                    } catch (IOException ex) {
                        Logger.getLogger(Task1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      //  if (ptr!=null){
                            list.add(ptr); 
                       // }
                    }
                    
                return list;
                }
        };
    }
}    


/*    public static Lexer create () {
        return new Lexer(){
            public List<Token> lex ( String input ) throws LexicalException, Task1Exception {
                MyLexer reader = new MyLexer(new StringReader(input));
                List<Token> list = new ArrayList();
                Token ptr = null;
                try {
                    ptr = reader.yylex();
                } catch (IOException ex) {
                    Logger.getLogger(Task1.class.getName()).log(Level.SEVERE, null, ex);
                }
                while(ptr != null){
                    list.add(ptr);
                }
                return list;
            } 
        };
    }
} */


/*    public static Lexer create () {
        return new Lexer(){
            public List<Token> lex ( String input ) throws LexicalException, Task1Exception {
                MyLexer reader = new MyLexer(new StringReader(input));
                List<Token> list = new ArrayList();
                while(!reader.getEOF()){
                    try {
                        list.add(reader.yylex());
                    } catch (IOException ex) {
                        Logger.getLogger(Task1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return list;
            } 
        };
    }
} */
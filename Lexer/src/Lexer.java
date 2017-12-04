
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mss60
 */
interface Lexer {
    public List<Token> lex ( String input ) throws LexicalException, Task1Exception; 
}

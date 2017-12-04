package Task2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author sb671
 */
class LexicalException extends Exception {
    public String msg;
    public LexicalException ( String _msg ) { msg = _msg; }
} 
package task2;
import java.util.ArrayList;
import java.util.List;

class Task2 implements Token {
    public static void Main () throws SyntaxException {
            Task1 t = new Task1();
            Lexer lexer = Task1.create();
            List <Token> myTokens = lexer.lex("{ 1;3;{1}}");
            ParseTokens parse = new ParseTokens();
            parse.parse(myTokens);
    }
}
    
class ParseTokens implements Parser {

    Token t = null;
    
    @Override
    public Block parse(List<Token> input) throws SyntaxException, Task2Exception {
        parseBlock(input);
        return parseBlock(input);
    }
    
    public Block parseBlock(List<Token> input) throws SyntaxException, Task2Exception {
       if (input.isEmpty())
       {
           throw new SyntaxException("Syntax Error!");
       }
       else if (input.get(0) instanceof T_LeftCurlyBracket) {
           input.remove(0);
           parseEne(input);
           if (!(input.get(0) instanceof T_RightCurlyBracket)){
                throw new SyntaxException("Syntax Error!");
            }
       }
       else
       {
           throw new SyntaxException("Syntax Error!");
       }
       
       return new Block(parseEne(input));
    }
    
    public List<Exp> parseEne(List<Token> input) throws SyntaxException, Task2Exception{
        List<Exp> expList = new ArrayList();
        Exp output = parseExp(input);
        expList.add(output);
        //if semi-colon detected, run ene again
        if (input.get(0) instanceof T_Semicolon)
        {
            input.remove(0);
            parseEne(input);
        }
        return expList;
    }
    
    
        public Exp parseExp(List<Token>input) throws SyntaxException, Task2Exception{
        if (input.get(0) instanceof T_Integer){
            Token f = input.get(0);
            input.remove(0);
            return new IntLiteral(((T_Integer)f).n);
        }
        else if (input.get(0) instanceof T_Skip){
            input.remove(0);
            return new Skip();
        }
        else if (input.get(0) instanceof T_LeftCurlyBracket){
            return new BlockExp(parseBlock(input));
        }
        else {
            throw new SyntaxException("Syntax Error!");
        }
}

    
}
    
//    public List<Exp> parseEne(List<Token> input) throws SyntaxException, Task2Exception {
//        t = input.get(0);
//        if (t instanceof Exp)
//        {
//            if (input.get(1) instanceof T_Semicolon)
//            {
//                expList.add((Exp) t);
//                expList.add((Exp) input.get(1));
//                input.remove(0);
//                input.remove(1);
//                parseEne(input);
//            }
//            else {
//              parseExp(input);
//            }
//        }
//        
//        else {
//            throw new SyntaxException("Syntax Error!");
//        }
//        
//    }
//    
//    public Exp parseExp(List<Token> input) throws SyntaxException, Task2Exception {
//        if (t instanceof Block)
//        {
//            parseBlock(input);
//        }
//        else if (t instanceof IntLiteral)
//        {
//            parseInt(input);
//        }
//        
//        else if (t instanceof Skip)
//        {
//            parseSkip(input);
//        }
//        else {
//            throw new SyntaxException("Syntax Error!");
//        }
//        
//    }
//    
//    public void parseInt(List<Token> input) {
//        expList.add((Exp) t);
//        input.remove(0);
//    }
//    
//    public void parseSkip(List<Token> input) {
//        expList.add((Exp) t);
//        input.remove(0);
//    }
//    
//}
//

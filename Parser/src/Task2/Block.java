package task2;
import java.util.List;


class Block {
    public List <Exp> exps;
    public Block ( List <Exp> _exps ) {
	assert ( _exps.size () > 0 );
	exps = _exps; } }

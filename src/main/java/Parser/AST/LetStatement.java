package Parser.AST;
import Token.*;

public class LetStatement implements Statement {
    private final Token tok;
    private Identifier name;
    private Expression value;



    public LetStatement(Token pToken) {
        this.tok = pToken;
    }

    public void setName(Identifier pIdent) {
        this.name = pIdent;
    }

    public void setValue(Expression pValue) {
        this.value = pValue;
    }

    public Expression getValue() {
        return this.value;
    }

    public Identifier getName() { return this.name; }

    @Override
    public String tokenLiteral() {
        return this.tok.literal;
    }

    @Override
    public void statementNode() {
    }

    @Override
    public String toString() {
        return "LetStatement{" +
                "tok=" + tok.type +
                ", name=" + name +
                ", value=" + value +
                '}';
    }
}

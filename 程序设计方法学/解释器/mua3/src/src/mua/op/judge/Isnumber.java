package src.mua.op.judge;

import src.mua.Expression;
import src.mua.dataType.Object;
import src.mua.dataType.Word;
import src.mua.interpreter.NameSpace;
import src.mua.utils.ArgumentUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Method: calculate
 * getOpName
 * getArgNum
 **/

public class Isnumber extends Expression {
    public static final int firstArg = 0;
    public static final int secondArg = 1;
    public static final int thirdArg = 2;

    public static final int firstObj = 0;
    public static final int secondObj = 1;
    public static final int thirdObj = 2;

    final static private ArrayList<Class> argTypes = new ArrayList<Class>(Arrays.asList(Object.class));

    @Override
    public String getOpName() {
        return "isnumber";
    }

    @Override
    public Word calculate(NameSpace nameSpace) throws Exception {
        super.calculate(nameSpace);
        ArgumentUtil.argCheck(getOpName(), argTypes, argList);
        Object obj = (Object) argList.get(firstArg);
        if (ArgumentUtil.typeCast(Number.class, obj) == null) {
            return new Word(false);
        }
        else
            return new Word(true);
    }

    public int getArgNum() {
        return argTypes.size();
    }
}

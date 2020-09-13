package src.mua.op.value;

import src.mua.Expression;
import src.mua.dataType.Number;
import src.mua.dataType.Object;
import src.mua.dataType.Word;
import src.mua.interpreter.NameSpace;
import src.mua.utils.ArgumentUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Random extends Expression {
    public static final int firstArg = 0;
    public static final int secondArg = 1;
    public static final int thirdArg = 2;

    public static final int firstObj = 0;
    public static final int secondObj = 1;
    public static final int thirdObj = 2;

    @Override
    public String getOpName() {
        return "random";
    }

    @Override
    public Word calculate(NameSpace nameSpace) throws Exception {
        super.calculate(nameSpace);
        ArgumentUtil.argCheck(getOpName(), argTypes, argList);
        Object obj = (Object) argList.get(firstArg);
        int bound = (int) Math.floor(((Number)obj).getValue());
        java.util.Random r = new java.util.Random();
        return new Word(r.nextInt(bound));
    }


    final static private ArrayList<Class> argTypes = new ArrayList<Class>(Arrays.asList(
            Number.class
    ));

    public int getArgNum() {
        return argTypes.size();
    }
}

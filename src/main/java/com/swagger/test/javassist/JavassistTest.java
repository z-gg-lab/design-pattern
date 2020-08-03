package com.swagger.test.javassist;

import com.swagger.test.asm.Base;
import javassist.*;

import java.io.IOException;

public class JavassistTest {

    public static void main(String[] args) throws NotFoundException,
            CannotCompileException, IllegalAccessException, InstantiationException,
            IOException {


        Base base1 = new Base();
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("com.swagger.test.asm.Base");
        CtMethod m = ctClass.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = ctClass.toClass();
        ctClass.writeFile("C:\\projects\\design-pattern\\target\\classes\\com\\swagger\\test\\");
        Base base = (Base) c.newInstance();
        base.process();
    }
}

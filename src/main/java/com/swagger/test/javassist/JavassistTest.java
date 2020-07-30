package com.swagger.test.javassist;

import com.swagger.test.asm.Base;
import javassist.*;

import java.io.IOException;

public class JavassistTest {

    public static void main(String[] args) throws NotFoundException,
            CannotCompileException, IllegalAccessException, InstantiationException,
            IOException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.swagger.test.asm.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("C:\\projects\\design-pattern\\target\\classes\\com\\swagger\\test\\");
        Base h = (Base) c.newInstance();
        h.process();
    }
}

package com.swagger.test.asm1;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public class TimeClassAdapter extends ClassAdapter {

    public TimeClassAdapter(ClassVisitor cv) {
        super(cv);
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature,exceptions);

        MethodVisitor methodVisitor = mv;
        if (mv != null) {
            //只增强 "operation" 方法
            if (name.equals("operation")) {
                //使用自定义 MethodVisitor，实际改写方法内容
                methodVisitor = new TimeMethodAdapter(mv);
        }
        }
        return methodVisitor;

    }

}
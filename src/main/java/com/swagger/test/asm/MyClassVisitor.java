package com.swagger.test.asm;


import org.objectweb.asm.*;


public class MyClassVisitor extends ClassAdapter implements Opcodes {
    public MyClassVisitor(ClassVisitor cv) {
        super(cv);
    }

    @Override
    public void visit(int version, int access, String name, String
            signature,
                      String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName,
                interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String
            desc, String signature,
                                     String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature,
                exceptions);
        //Base 类中有两个方法：无参构造以及 process 方法，这里不增强构造方法
        if (!name.equals("<init>") && mv != null) {
            mv = new MyMethodVisitor(mv);
        }
        return mv;
    }

    class MyMethodVisitor extends MethodAdapter implements Opcodes {
        public MyMethodVisitor(MethodVisitor mv) {
            super(mv);
        }

        @Override
        public void visitCode() {
            super.visitCode();
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out",
                    "Ljava/io/PrintStream;");
            mv.visitLdcInsn("start");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream",
                    "println", "(Ljava/lang/String;)V");
        }

        @Override
        public void visitInsn(int opcode) {
            if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW) {
                // 方法在返回之前，打印 "end"
                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out",
                        "Ljava/io/PrintStream;");
                mv.visitLdcInsn("end");
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream",
                        "println", "(Ljava/lang/String;)V");
            }
            mv.visitInsn(opcode);
        }
    }
}
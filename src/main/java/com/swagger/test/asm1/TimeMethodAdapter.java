package com.swagger.test.asm1;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class TimeMethodAdapter extends MethodAdapter {

    public TimeMethodAdapter(MethodVisitor mv) {
        super(mv);
    }

    /**
     * 访问Code区时调用
     */
    @Override
    public void visitCode() {
        super.visitCode();
        visitMethodInsn(Opcodes.INVOKESTATIC, "com/swagger/test/asm1/TimesRecord",
                "before", "()V");
    }

    /**
     * 每当ASM访问到无参数指令时，都会调用MyMethodVisitor中的visitInsn方法
     *
     * @param opcode
     */
    @Override
    public void visitInsn(int opcode) {
        // 判断当前指令是否为无参数的“return”指令，如果是就在它的前面添加AOP的后置逻辑
        if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN)
                || opcode == Opcodes.ATHROW) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/swagger/test/asm1/TimesRecord", "after", "()V");
        }
        mv.visitInsn(opcode);
    }
}


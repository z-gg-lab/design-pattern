package com.swagger.test.asm1;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AddSecurityCheckMethodAdapter extends MethodAdapter {

    public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
        super(mv);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void visitCode() {
        super.visitCode();
        visitMethodInsn(Opcodes.INVOKESTATIC, "com/swagger/test/asm1/TimesRecord",
                "before", "()V");
    }

    @Override
    public void visitInsn(int opcode) {
        if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN)
                || opcode == Opcodes.ATHROW) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/swagger/test/asm1/TimesRecord", "after", "()V");
        }
        mv.visitInsn(opcode);
    }
}


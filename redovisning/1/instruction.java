
public class instruction {

    interface Instruction {
        void execute(Memory, ProgramCounter);
    }

    class Print implements Instruction {
        private Address address;

        public Print(Address address) {
            this.address = address;
        }

        public execute(Memory memory, ProgramCounter pc){
            System.out.println(address(memory).toString());
        }
    }

    class Mul implements Instruction {
        private Operand left;
        private Operand right;
        private Address dest;

        public Mul(Operand left, Operand right, Address dest) {
            this.left = left;
            this.right = right;
            this.dest = dest;
        }

        public void execute(Memory memory, ProgramCounter pc) {
            dest.getWord(memory) = left.getWord(memory).mul(right.getWord(memory));
        }
    }

    class Copy implements Instruction {
        private Operand source;
        private Address dest;

        public Copy(Operand source, Address dest) {
            this.source = source;
            this.dest = dest;
        }

        public void execute(Memory memory, ProgramCounter pc) {
            dest.getWord(memory) = source.getWord(memory);
        }
    }

    class Add implements Instruction {
        private Operand left;
        private Operand right;
        private Address dest;

        public Add(Operand left, Operande right, Address dest) {
            this.left = left;
            this.right = right;
            this.dest = dest;
        }

        public void execute(Memory memory, ProgramCounter pc) {
            dest.getWord(memory) = left.getWord(memory).add(right.getWord(memory));
        }
    }

    class JumpEq {
        int index;
        Operand condition;
        Address addr;

        public JumpEq(int index, Operand condition, Address addr) {
            this.index = index;
            this.condition = condition;
            this.addr = addr;
        }

        public void execute(Memory memory, ProgramCounter pc) {
            if (addr.getWord(memory).equals(condition.getWord(memory))) {
                pc.setCount(index);
            }
        }
    }

    class Jump {
        int index;

        public Jump(int index) {
            this.index = index;
        }

        public void execute(Memory memory, ProgramCounter pc) {
            pc.setCount(index);
        }
    }

    class Halt {

        public void execute(Memory memory, ProgramCounter pc) {
            pc.setCount(-1);
        }

    }

}

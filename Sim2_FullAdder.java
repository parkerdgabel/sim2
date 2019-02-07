public class Sim2_FullAdder {

    public void execute() {
        // First adder execute
        firstAdder.a.set(a.get());
        firstAdder.b.set(b.get());
        firstAdder.execute();
        // second adder execute
        secondAdder.a.set(carryIn.get());
        secondAdder.b.set(firstAdder.sum.get());
        secondAdder.execute();
        sum.set(secondAdder.sum.get());
        // Execute or for carryOut
        or.a.set(secondAdder.carry.get());
        or.b.set(firstAdder.carry.get());
        or.execute();
        carryOut.set(or.out.get());
    }

    // necessary ops
    private Sim2_HalfAdder firstAdder, secondAdder;
    private OR or;
    // inputs
    public RussWire a, b;
    // outputs
    public RussWire sum, carryIn, carryOut;

    public Sim2_FullAdder() {
        firstAdder = new Sim2_HalfAdder();
        secondAdder = new Sim2_HalfAdder();
        or = new OR();
        a = new RussWire();
        b = new RussWire();
        sum = new RussWire();
        carryIn = new RussWire();
        carryOut = new RussWire();
    }
}

public class Sim2_AdderX {

    public void execute() {
        for (int i = 0; i < a.length; i++) {
            ripple[i].a.set(a[i].get());
            ripple[i].b.set(b[i].get());
            ripple[i].carryIn.set(carryIn);
            ripple[i].execute();
            sum[i].set(ripple[i].sum.get());
            carryIn = ripple[i].carryOut.get();
        }
        carryOut.set(carryIn);
        xor.a.set(carryIn);
        xor.b.set(ripple[ripple.length - 2].carryOut.get());
        xor.execute();
        overflow.set(xor.out.get());
    }

    boolean carryIn;
    // necessary ops
    Sim2_FullAdder[] ripple;
    Sim2_XOR xor;
    // inputs
    public RussWire[] a, b;
    // outputs
    public RussWire[] sum;
    public RussWire carryOut, overflow;

    /**
     * Initializes all the neccesary components
     */
    public Sim2_AdderX(int X) {
        boolean carryIn = false;
        a = new RussWire[X];
        b = new RussWire[X];
        sum = new RussWire[X];
        carryOut = new RussWire();
        overflow = new RussWire();
        ripple = new Sim2_FullAdder[X];
        xor = new Sim2_XOR();
        for (int i = 0; i < X; i++) {
            a[i] = new RussWire();
            b[i] = new RussWire();
            sum[i] = new RussWire();
            ripple[i] = new Sim2_FullAdder();
        }
    }
}

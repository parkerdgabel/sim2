/**
 * @author Parker Gabel
 * Class: CS252
 * Assignment: Sim2
 * File: Sim2_HalfAdder.java
 * This class implements Half adder logic using Russwires
 */
public class Sim2_HalfAdder {

    /**
     * Half adder is
     * sum = a XOR b
     * carry = a and b
     */
    public void execute() {
        //set values
        xor.a.set(a.get());
        xor.b.set(b.get());
        and.a.set(a.get());
        and.b.set(b.get());
        // execute
        xor.execute();
        and.execute();
        sum.set(xor.out.get());
        carry.set(and.out.get());
    }

    // necessary ops
    private Sim2_XOR xor;
    private AND and;
    // inputs
    public RussWire a, b;
    // outputs
    public RussWire sum, carry;

    /**
     * Initializes all the neccesary components
     */
    public Sim2_HalfAdder() {
        xor = new Sim2_XOR();
        and = new AND();
        a = new RussWire();
        b = new RussWire();
        sum = new RussWire();
        carry = new RussWire();
    }
}

/**
 * @author Parker Gabel
 * Class: CS252
 * Assignment: Sim2
 * File: Sim2_XOR.java
 * This class implements XOR logic using Russwires
 */
public class Sim2_XOR {

    /**
     * XOR is equivalent to the boolean function
     * x XOR y = (x or y) and not (x and y)
     */
    public void execute() {
        // Set initial values.
        internalOr.a.set(a.get());
        internalOr.b.set(b.get());
        internalAnd.a.set(a.get());
        internalAnd.b.set(b.get());
        // To set not, execute internalAnd
        internalAnd.execute();
        not.in.set(internalAnd.out.get());
        // Execute internalOr and not
        internalOr.execute();
        not.execute();
        // Set main and execute
        mainAnd.a.set(internalOr.out.get());
        mainAnd.b.set(not.out.get());
        mainAnd.execute();
        out.set(mainAnd.out.get());
    }

    // needed operations
    public AND internalAnd, mainAnd;
    public OR internalOr;
    public NOT not;
    // inputs
    public RussWire a, b;
    // outputs
    public RussWire out;

    /**
     * Initializes all the neccesary components
     */
    public Sim2_XOR() {
        internalAnd = new AND();
        mainAnd = new AND();
        internalOr = new OR();
        not = new NOT();
        a = new RussWire();
        b = new RussWire();
        out = new RussWire();
    }
}

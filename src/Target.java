public class Target {
    private String gate;
    private int dv;

    public Target(String gate, int dv) {
        this.gate = gate;
        this.dv = dv;
    }

    public String getGate() {
        return gate;
    }

    public int getDv() {
        return dv;
    }

    @Override
    public String toString() {
        return gate + ":" + dv;
    }

}

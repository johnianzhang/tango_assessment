public class App {

    public static void main(String[] args) {
        Simulator sim = new Simulator();
        sim.simulate();
        sim.printResult();
        sim.writeFile();
    }
}

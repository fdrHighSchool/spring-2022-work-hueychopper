import Store.Store;

class Front {
    public static void main(String[] args) {
        int[] g1 = {90,80,95,90,100}, g2 = {95,100,100,90,90}, g3 = {85,85,95,100,90}, g4 = {90,100,75,85,90}, g5 = {80,80,65,55,90};
        Store p1 = new Store(1234567, "Jimmy Smith", g1, true);
        Store p2 = new Store(9876543, "Maria Hernandez", g2,false);
        Store p3 = new Store(1357911, "Jamal Jenkins", g3,false);
        Store p4 = new Store(2468101, "Ramiz Ahmad", g4,true);
        Store p5 = new Store(1928374, "Michael Green", g5,true);

        // System.out.println(p1.getAverage());
        Store p6 = new Store(89,"Bob",new int[] {99,99,99,99,99});
        System.out.println(p6.getAverage());
        System.out.println(p6.isFailing());
    }
}
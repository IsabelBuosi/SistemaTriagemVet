package projeto.a3;

public class SistemaTriageSingleton {
    private static SistemaTriage instance = new SistemaTriage();

    private SistemaTriageSingleton() {}

    public static SistemaTriage getInstance() {
        return instance;
    }
}

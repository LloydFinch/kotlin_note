/**
 * 等见kotlin object的单例
 */

public class FuckSingleInstanceJ {

    public static FuckSingleInstanceJ instance;

    static {
        instance = new FuckSingleInstanceJ();
    }

    private FuckSingleInstanceJ() {
    }
}

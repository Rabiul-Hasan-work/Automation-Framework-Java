package drivers.strategies;

public class DriverStrategyImplementer {

    public static DriverStrategy chooseStrategy(String strategy) {
        switch (strategy) {
            case "drivers.strategies.Chrome":
                return new Chrome();

            case "drivers.strategies.PhantomJs":
                return new PhantomJs();

            case "drivers.strategies.FireFox":
                return new FireFox();

            default:
                return null;
        }
    }
}

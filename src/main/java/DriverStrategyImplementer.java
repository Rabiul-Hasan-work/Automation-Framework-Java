public class DriverStrategyImplementer {

    public static DriverStrategy chooseStrategy(String strategy) {
        switch (strategy) {
            case "Chrome":
                return new Chrome();

            case "PhantomJs":
                return new PhantomJs();

            case "FireFox":
                return new FireFox();

            default:
                return null;
        }
    }
}

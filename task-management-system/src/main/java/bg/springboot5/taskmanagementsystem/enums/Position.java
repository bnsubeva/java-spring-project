package bg.springboot5.taskmanagementsystem.enums;

public  enum Position {

    PRODUCT_OWNER("PRODUCT_OWNER"),
    SOFTWARE_ARCHITECT("SOFTWARE_ARCHITECT"),
    FRONTEND_DEVELOPER("FRONTEND_DEVELOPER"),
    BACKEND_DEVELOPER("BACKEND_DEVELOPER"),
    QA("QA");

    private final String name;

    Position(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

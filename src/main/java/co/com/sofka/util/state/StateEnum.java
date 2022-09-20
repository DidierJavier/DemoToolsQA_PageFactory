package co.com.sofka.util.state;

public enum StateEnum {
    NCR("NCR"),
    UTTAR_PRADESH("Uttar Pradesh"),

    HARYANA("Haryana"),

    RAJASHTHAN("Rahasthan");

    private final String stateEnum;

    public String getStateEnum(){return stateEnum;}

    StateEnum(String stateEnum) {
        this.stateEnum = stateEnum;
    }
}

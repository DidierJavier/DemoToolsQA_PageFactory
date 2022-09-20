package co.com.sofka.util;

public enum Number {
    CERO(0),
    UNO(1),

    TRES(3),

    DOS(2),

    CINCO(5),
    DIEZ(10),
    ONCE(11),

    VEINTE(20),
    VEINTIOCHO(28),

    DOSCIENTOSCINCUENTA(250),
    MILNOVECIENTOSCUARENTA(1940),
    DOSMILVEINTIDOS(2022);

    private final int number;

    public int getNumber(){return number;}

    Number(int number) {
        this.number = number;
    }
}

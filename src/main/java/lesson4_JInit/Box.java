package lesson4_JInit;

public class Box {
    private Integer ballsCouter;

    public Box() {
        ballsCouter = 0;
    }

    public void addBall() {
        ballsCouter++;

    }

    public void removeBall() throws NullPointerException {
        if (ballsCouter == 0) {
            throw new NullPointerException("мячей уже ноль");
        }
        ballsCouter--;

    }

    //для перемешивания мечей:
    public void suffleBall() throws ZeroBallsCoutException {
        if (ballsCouter == 0) {
            throw new ZeroBallsCoutException();//(создали сообственное искл
        }
        System.out.println("мяч перемешаны");
    }

    //для того чтобы узнавать сколько в коробке мячей
    public Integer getBallsCouter() {
        return ballsCouter;
    }
}

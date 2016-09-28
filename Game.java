// Главный класс, запускающий игру
public class Game extends Thread {

    // Игровое поле
    private GameField field;

    // Создание игры
    public Game() {
        field = new GameField();
        field.fillRandom();
    }

    // запуск игры
    public void run() {
        try {
            while (true){
                field.redrawField();
                field.makeNextGeneration();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.start();
    }
}
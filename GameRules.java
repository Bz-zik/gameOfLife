// Класс, определяющий правила игры
public class GameRules {

    // минимальное и максимальное количество соседей, необходимых для выживания клетки
    private int minNeighborsToStayAlive;
    private int maxNeighborsToStayAlive;

    // минимальное и максимальное количество соседей, необходимых для перерождения клетки
    private int minNeighborsToReborn;
    private int maxNeighborsToReborn;

    // Конструктор по умолчанию, генерирующий стандартные правила
    public GameRules() {
        minNeighborsToStayAlive = 2;
        maxNeighborsToStayAlive = 3;

        minNeighborsToReborn = 3;
        maxNeighborsToReborn = 3;
    }

    // Определяет, выживает ли клетка
    public boolean isStayedAlive (int numberOfNeighbors) {
        return minNeighborsToStayAlive <= numberOfNeighbors && numberOfNeighbors <= maxNeighborsToStayAlive;
    }

    // Определяет, переродится ли клетка
    public boolean isReborn (int numberOfNeighbors) {
        return minNeighborsToReborn <= numberOfNeighbors && numberOfNeighbors <= maxNeighborsToReborn;
    }
}
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.HashSet;

// Определяет игровое поле с клетками
public class GameField {

    //границы отображаемого окна
    private static int minXtoDraw = -350;
    private static int maxXtoDraw = 350;

    private static int minYtoDraw = -350;
    private static int maxYtoDraw = 350;

    //Правила игры
    private GameRules rules;

    //Массив живых клеток
    private HashSet<PairIndex> liveCells;


    // Конструктор строит пустое игровое поле
    public GameField() {
        rules = new GameRules();
        liveCells = new HashSet<>();

        // Задаем размеры поля
        StdDraw.setCanvasSize(maxXtoDraw-minXtoDraw+1, maxYtoDraw-minYtoDraw+1);
        StdDraw.setXscale(minXtoDraw, maxXtoDraw);
        StdDraw.setYscale(minYtoDraw, maxYtoDraw);
    }

    //заполняем поле случайными клетками
    public void fillRandom() {
        liveCells.clear();
        for (int i = minXtoDraw; i < maxXtoDraw; i++) {
            for (int j = minYtoDraw; j < maxYtoDraw; j++) {
                int key = (int) (Math.random() * 2);
                if (key != 0) liveCells.add(new PairIndex(i, j));
            }
        }
    }

    public void readFromFile () {
        // TODO считывание с файла
    }

    //отрисовываем поле
    public void redrawField() {
        StdDraw.clear(Color.WHITE);
        StdDraw.setPenColor(new Color(0, 0, 0));

        for (PairIndex pair: liveCells)
        {
                StdDraw.point(pair.getX(), pair.getY());
        }
        StdDraw.show(0);
    }

    //получаем следующее поколение клеток
    public void makeNextGeneration(){
        HashSet<PairIndex> nextLiveCells = new HashSet<>();
        int cout; // счетчик живых соседей

        //TODO расширяющееся поле
        for (int i = minXtoDraw-1; i < maxXtoDraw+1; i++) {
            for (int j = minYtoDraw-1; j < maxYtoDraw+1; j++) {
                cout = 0;
                PairIndex cell = new PairIndex(i, j);
                PairIndex[] neighborsOfCell = cell.getNeighbors(); // массив соседей

                // Проверяем всех соседей и узнаем количество живых
                for (int k = 0; k < PairIndex.neighbors_number; k++) {
                    if (liveCells.contains(new PairIndex(neighborsOfCell[k].getX(), neighborsOfCell[k].getY()))){
                        cout++;
                    }
                }

                if (liveCells.contains(cell)) {
                    if (rules.isStayedAlive(cout))
                        nextLiveCells.add(cell);
                    //else nextLiveCells.remove(cell);
                }
                else if (rules.isReborn(cout))
                    nextLiveCells.add(cell);
            }
        }
        liveCells = nextLiveCells;
    }
}
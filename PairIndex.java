// Класс, хранящий координаты клетки
public class PairIndex {

    // Координата X
    private int x;
    // Координата Y
    private int y;
    // Количество соседей клетки
    public static int neighbors_number = 8;

    public PairIndex (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Получаем доступ к координатам
    public int getX() {return x;}
    public int getY() {return y;}

    // Получаем массив соседей
    public PairIndex[] getNeighbors(){
        PairIndex[] neighbor = new PairIndex[neighbors_number];
        neighbor[0] = new PairIndex(x-1, y-1);
        neighbor[1] = new PairIndex(x-1, y);
        neighbor[2] = new PairIndex(x-1, y+1);
        neighbor[3] = new PairIndex(x, y-1);
        neighbor[4] = new PairIndex(x, y+1);
        neighbor[5] = new PairIndex(x+1, y-1);
        neighbor[6] = new PairIndex(x+1, y);
        neighbor[7] = new PairIndex(x+1, y+1);
        return neighbor;
    }

    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PairIndex pairIndex = (PairIndex) o;

        if (x != pairIndex.x) return false;
        return y == pairIndex.y;
    }


    @Override
    public int hashCode() {
        int result = x;
        result = result*31 + y;
        return result;
    }
}
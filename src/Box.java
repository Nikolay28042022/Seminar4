import java.util.ArrayList;

class Box<T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<>();

    // Метод добавления фрукта в коробку
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    // Метод вычисления веса коробки
    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    // Метод сравнения коробок
    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    // Метод пересыпания фруктов в другую коробку
    public void transferFruits(Box<T> anotherBox) {
        if (this == anotherBox) {
            return; // Нельзя пересыпать в ту же самую коробку
        }

        if (!this.fruits.isEmpty() && !anotherBox.fruits.isEmpty()
                && this.fruits.get(0).getClass() != anotherBox.fruits.get(0).getClass()) {
            System.out.println("Нельзя пересыпать фрукты разных типов!");
            return;
        }

        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}


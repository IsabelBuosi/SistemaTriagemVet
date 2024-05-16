package projeto.a3;
public class Fila {
    private Animal[] animais;
    private int index = 0;

    public Fila(int capacity) {
        animais = new Animal[capacity];
    }

    public void adicionar(Animal animal) {
        if (index < animais.length) {
            animais[index++] = animal;
        }
    }

    public Animal remover() {
        if (index == 0) {
            return null;
        }
        return animais[--index];
    }

    public boolean estaVazia() {
        return index == 0;
    }
}

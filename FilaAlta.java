package projeto.a3;
public class FilaAlta extends Fila {
    private QueueList fila;
    private Animal[] animais;
    private int tamanho;
    private int capacidade;

    public FilaAlta(int capacidade) {
        super(capacidade);
        fila = new QueueList(capacidade);
        animais = new Animal[capacidade]; 
        tamanho = 0;
        this.capacidade = capacidade;
    }

    public void adicionar(Animal animal) {
        if (tamanho < capacidade) {
            fila.adicionar(animal);
            animais[tamanho] = animal;
            tamanho++;
        } else {
            System.out.println("A fila está cheia. Não é possível adicionar mais animais.");
        }
    }

    public Animal remover() {
        if (tamanho > 0) {
            Animal animalRemovido = fila.remover();
            for (int i = 0; i < tamanho - 1; i++) {
                animais[i] = animais[i + 1]; 
            }
            tamanho--;
            return animalRemovido;
        } else {
            System.out.println("A fila está vazia. Não é possível remover animais.");
            return null;
        }
    }

    public Animal[] getAnimais() {
        return animais;
    }
}


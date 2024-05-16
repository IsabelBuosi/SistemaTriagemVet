package projeto.a3;

class Animal {
    private int idade;
    private String sintomas;
    private String nome;
    private int gravidade;

    public Animal(int idade, String sintomas, String nome, int gravidade) {
        this.idade = idade;
        this.sintomas = sintomas;
        this.nome = nome;
        this.gravidade = gravidade;
        
    }

    public int getIdade() {
        return idade;
    }

    public String getSintomas() {
        return sintomas;
    }
    
    public String getNome() {
    	return nome;
    }

    public int getGravidade() {
        return gravidade;
    }
}

class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("Fila vazia!");
    }
}

class QueueList {
    private Animal[] elementos;
    private int head;
    private int tail;

    public QueueList(int capacidade) {
        elementos = new Animal[capacidade];
        head = tail = -1;
    }

    public void adicionar(Animal animal) {
        if (tail == elementos.length - 1) {
            System.err.println("Fila cheia!");
            return;
        }
        elementos[++tail] = animal;
    }

    public Animal remover() {
        if (head == tail + 1) {
            throw new RuntimeException("Fila vazia!");
        }
        return elementos[++head];
    }
}
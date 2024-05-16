package projeto.a3;
import java.util.Scanner;
import java.util.function.Consumer;

public class SistemaTriage {
    private FilaAlta filaAlta;
    private FilaMedia filaMedia;
    private FilaBaixa filaBaixa;

    public SistemaTriage() {
        filaAlta = new FilaAlta(10);
        filaMedia = new FilaMedia(10);
        filaBaixa = new FilaBaixa(30);
    }
    
    public FilaAlta getFilaAlta() {
        return filaAlta;
    }
    public FilaMedia getFilaMedia() {
        return filaMedia;
    }
    public FilaBaixa getFilaBaixa() {
        return filaBaixa;
    }

    public void triar(Animal animal) {
        int gravidade = animal.getGravidade();
        String sintomas = animal.getSintomas();

        if (gravidade >= 3 || sintomas.contains("grave")) {
            filaAlta.adicionar(animal);
        } else if (gravidade >= 2 || sintomas.contains("moderado")) {
            filaMedia.adicionar(animal);
        } else {
            filaBaixa.adicionar(animal);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira a idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Insira os sintomas: ");
        String sintomas = scanner.nextLine();
        
        System.out.print("Insira o nome do Animal: ");
        String nome = scanner.nextLine();

        System.out.print("Insira a gravidade: ");
        int gravidade = scanner.nextInt();
        scanner.nextLine(); 
        scanner.close();

        Animal animal = new Animal(idade, sintomas, nome, gravidade);
        SistemaTriage triagem = new SistemaTriage();
        triagem.triar(animal);
        triagem.atender(output -> System.out.println(output));
        
    }
    public void atender(Consumer<String> outputConsumer) {
        while (!filaAlta.estaVazia() || !filaMedia.estaVazia() || !filaBaixa.estaVazia()) {
            if (!filaAlta.estaVazia()) {
                Animal animal = filaAlta.remover();
                System.out.println("Atendendo animal de alta prioridade: " + animal.getNome());
            } else if (!filaMedia.estaVazia()) {
                Animal animal = filaMedia.remover();
                System.out.println("Atendendo animal de média prioridade: " + animal.getNome());
            } else {
                Animal animal = filaBaixa.remover();
                System.out.println("Atendendo animal de baixa prioridade: " + animal.getNome());
            }
        }
    }
}

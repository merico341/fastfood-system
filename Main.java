import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String nomeDoClinte;
        int escolha;
        int nota;
        ArrayList<String> pedidos = new ArrayList<String>();

        System.out.println("Qual o seu nome?");
        nomeDoClinte = sc.nextLine();

        do {
            System.out.println(nomeDoClinte + " escolha o seu pedido:");
            System.out.println("1. Hamburgue  2. Fritas  3. Refrigerante 4. Combo 5. Sair 6. Remover item do carrinho");
            
            try {
                escolha = sc.nextInt();
            } catch ( Exception e) {
                escolha = 100000;
            }

            switch (escolha) {
                case 1:
                    System.out.println();
                    pedidos.add("Hamburguer");
                    System.out.println("o seu pedido" + pedidos.get(pedidos.size() - 1) + " foi adicionado no carrinho");
                    break;
                case 2:
                    System.out.println();
                    pedidos.add("Fritas");
                    System.out.println("o seu pedido" + pedidos.get(pedidos.size() - 1) + " foi adicionado no carrinho");
                    break;
                case 3:
                    System.out.println();
                    pedidos.add("Refrigerante");
                    System.out.println("o seu pedido" + pedidos.get(pedidos.size() - 1) + " foi adicionado no carrinho");
                    break;
                case 4:
                    System.out.println();
                    pedidos.add("Combo");
                    System.out.println("o seu pedido" + pedidos.get(pedidos.size() - 1) + " foi adicionado no carrinho");
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Obrigado por comprar");
                    System.out.println(pedidos);
                    break;
                case 6:
                    System.out.println();
                    pedidos.remove(pedidos.size() -1 );
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println(i+1 + " " + pedidos.get(i));
                    }
                    break;
                case 0:
                    System.out.println();
                    for (int i = 0; i< pedidos.size(); i++) {
                        System.out.println(i+1 + " " + pedidos.get(i));
                    }
                    break;
                default:
                    System.out.println();
                    System.out.println("algo deu errado");
                    break;
            }
        } while (escolha != 6);
        
        System.out.println("qual nota vc dá ao atendimento de 1 a 5?");
        nota = sc.nextInt();

        System.out.println(nomeDoClinte + " obrigado por comprar, vc comprou " + pedidos);
        System.out.println("o usuario deu " + nota + " de nota do atendimento");
        sc.close();
    }
}
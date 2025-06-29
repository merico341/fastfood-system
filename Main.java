import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        client user = new client();
        lista carrinho = new lista();
        int nota;

        System.out.println("Qual o seu nome?");
        user.setName(sc.nextLine());

        do {
            System.out.println(user.getName() + " escolha o seu pedido:");
            System.out.println("1. Hamburgue  2. Fritas  3. Refrigerante 4. Combo 5. Sair 6. Remover item do carrinho");
            
            try {
                carrinho.setEscolha(sc.nextInt());
            } catch ( Exception e) {
                carrinho.setEscolha(10000);
            }

            switch (carrinho.getEscolha()) {
                case 1:
                    System.out.println();
                    carrinho.addItem("Hamburguer");
                    System.out.println("o seu pedido " + carrinho.getLastItem() + " foi adicionado no carrinho");
                    break;
                case 2:
                    System.out.println();
                    carrinho.addItem("Fritas");
                    System.out.println("o seu pedido " + carrinho.getLastItem() + " foi adicionado no carrinho");
                    break;
                case 3:
                    System.out.println();
                    carrinho.addItem("Refrigerante");
                    System.out.println("o seu pedido " + carrinho.getLastItem() + " foi adicionado no carrinho");
                    break;
                case 4:
                    System.out.println();
                    carrinho.addItem("combo");
                    System.out.println("o seu pedido " + carrinho.getLastItem() + " foi adicionado no carrinho");
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Obrigado por comprar");
                    System.out.println(carrinho.getList());
                    break;
                case 6:
                    System.out.println();
                    carrinho.removeLastItem();
                    for (int i = 0; i < carrinho.getListSize(); i++) {
                        System.out.println(i+1 + " " + carrinho.getListItem(i));
                    }
                    break;
                case 0:
                    System.out.println();
                    for (int i = 0; i < carrinho.getListSize(); i++) {
                        System.out.println(i+1 + " " + carrinho.getListItem(i));
                    }
                    break;
                default:
                    System.out.println();
                    System.out.println("algo deu errado");
                    break;
            }
        } while (carrinho.getEscolha() != 5);
        
        System.out.println("qual nota vc dá ao atendimento de 1 a 5?");
        nota = sc.nextInt();

        System.out.println(user.getName() + " obrigado por comprar, vc comprou " + carrinho.getList());
        System.out.println("o usuario deu " + nota + " de nota do atendimento");
        sc.close();
    }

    public static class client {
        private String name;
        private String cpf;

        public void setName(String name) {
            this.name = name;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getCpf() {
            return this.cpf;
        }
        public String getName() {
            return this.name;
        } 
    }

    public static class lista {
        private ArrayList<String> list = new ArrayList<String>();
        private String lastItemName;
        private int listSize;
        private int escolha;

        public void addItem(String item) {
            list.add(item);
        }

        public void removeLastItem() {
            list.remove(list.get(list.size() - 1));
        }

        public void setEscolha(int escolha) {
            this.escolha = escolha;
        }

        public int getEscolha() {
            return this.escolha;
        }

        public String getLastItem() {
            this.lastItemName = list.get(list.size() - 1);
            return this.lastItemName;
        }

        public String getListItem(int i) {
            this.lastItemName = list.get(i);
            return lastItemName;
        }

        public ArrayList<String> getList() {
            return this.list;
        }

        public int getListSize() {
            listSize = list.size();
            return this.listSize;
        }
        
    }
}
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        client user = new client();
        lista carrinho = new lista();

        System.out.println("Bem vindo a Hamburgueria do seu zé!");
        System.out.println("Qual o seu nome?");
        user.setName(sc.nextLine());

        try {
            System.out.println("Deseja por cpf?");
            if(sc.nextLine().equals("sim")) {
                System.out.println("Digite seu cpf:");
                user.setCpf(sc.nextLine());
            } else {
                System.err.println("Operação cancelada");
            }
        } catch (Exception e) {
            System.err.println("Erro, falha ao por cpf, por favor continue sem");
        }

        do {
            System.out.println("\n" + user.getName() + " adicione o seu pedido no carrinho");
            System.out.println("1. Hamburguer - 2. Batata-Frita - 3. Coca-cola - 4. Combo - 5. Remover item do carrinho - 6. ir para o check out - 0. ver itens no carrinho");
            
            try {
                carrinho.setEscolha(sc.nextInt());
            } catch ( Exception e) {
                carrinho.setEscolha(100);
            }

            switch (carrinho.getEscolha()) {
                case 1:
                    carrinho.addItem("Hamburguer");
                    System.out.println("\no seu pedido " + carrinho.getLastItem() + " foi adicionado no carrinho");
                    break;
                case 2:
                    carrinho.addItem("Fritas");
                    System.out.println("\no seu pedido " + carrinho.getLastItem() + " foi adicionado no carrinho");
                    break;
                case 3:
                    carrinho.addItem("Refrigerante");
                    System.out.println("\no seu pedido " + carrinho.getLastItem() + " foi adicionado no carrinho");
                    break;
                case 4:
                    carrinho.addItem("combo");
                    System.out.println("\no seu pedido " + carrinho.getLastItem() + " foi adicionado no carrinho");
                    break;
                case 5:
                    carrinho.removeLastItem();
                    for (int i = 0; i < carrinho.getListSize(); i++) {
                        System.out.println(i+1 + " " + carrinho.getListItem(i));
                    }
                    break;
                case 6:
                    System.out.println("\nObrigado por comprar " + carrinho.getList());
                    break;
                    
                case 0:
                    System.out.println();
                    for (int i = 0; i < carrinho.getListSize(); i++) {
                        System.out.println(i+1 + " " + carrinho.getListItem(i));
                    }
                    break;
                default:
                    System.out.println();
                    System.out.println("\nalgo deu errado");
                    break;
            }
        } while (carrinho.getEscolha() != 6);
        
        System.out.println("qual nota vc dá ao atendimento de 1 a 5?");
        user.setNota(sc.nextInt());;

        System.out.println(user.getName() + ", do cpf: " + user.getCpf() +", obrigado por comprar, vc comprou " + carrinho.getList());
        System.out.println("o usuario deu " + user.getNota() + " de nota do atendimento");
        sc.close();
    }

    public static class client {
        private String name;
        private String cpf;
        private int nota;

        public void setName(String name) {
            this.name = name;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf.replaceAll("[^0-9]", cpf);
        }

        public void setNota(int nota) {
            this.nota = nota;
        }

        public String getCpf() {
            if (this.cpf.equals("0")) {
                return "sem cpf";
            } else {
                return this.cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
            }
        }

        public String getName() {
            return this.name;
        } 

        public int getNota() {
            return this.nota;
        }
    }

    public static class lista {
        private ArrayList<String> list = new ArrayList<String>();
        private String lastItemName;
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
            return list.size();
        }
    }
}
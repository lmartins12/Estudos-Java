import java.io.*;
import java.util.ArrayList;

public class Banco {

    private ArrayList<Correntista> listaDeClientes;

    public Banco(){
        listaDeClientes = new ArrayList<Correntista>();
    }

    public ArrayList<Correntista> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(ArrayList<Correntista> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    public void salvaClientela() throws IOException {
        File file = new File("database.dat");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Correntista c : listaDeClientes){
            oos.writeObject(c);
        }

        oos.close();
    }

    public void leClientela() throws IOException, ClassNotFoundException {
        File file = new File("database.dat");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object obj = null;
        try{
            while ((obj = ois.readObject()) != null) {
                this.listaDeClientes.add((Correntista) obj);
            }
        } catch (EOFException e){

        }
        finally {
            ois.close();
        }
    }
    public static void main(String args[]) {

        Banco banco = new Banco();

        ContaFisica conta = new ContaFisica();
        conta.deposito(1000);

        CorrentistaFisico lucas = new CorrentistaFisico("Lucas", conta);
        CorrentistaFisico clara = new CorrentistaFisico("Clara", conta);

        CorrentistaFisico c1 = new CorrentistaFisico("Lucas", new ContaFisica());
        banco.getListaDeClientes().add(c1);
        CorrentistaFisico c2 = new CorrentistaFisico("Clara", new ContaFisica());
        banco.getListaDeClientes().add(c2);
        CorrentistaFisico c3 = new CorrentistaFisico("Diana", new ContaFisica());
        banco.getListaDeClientes().add(c3);
        CorrentistaJuridico cJ1 = new CorrentistaJuridico("CI&T", "Lucas", new ContaJuridica());

        try {
            banco.salvaClientela();
        } catch (IOException e){

        }

        c1.exibeIdentificacao();
        c2.exibeIdentificacao();
        c3.exibeIdentificacao();
        cJ1.exibeIdentificacao();

        try {
            double valorParcela = c1.getConta().simulaEmprestimo(1000.0, 12);
            System.out.println(valorParcela);
        } catch (IllegalArgumentException e) {
            System.out.println("Digite valores válidos");
        }
    }
}
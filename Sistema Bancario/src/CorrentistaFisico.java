
public class CorrentistaFisico extends Correntista {

    public CorrentistaFisico( String nome, ContaFisica conta ) {
        super(nome, conta);
    }

    public void exibeIdentificacao() {
        System.out.println("Eu sou um correntista físico: " + getCodigo() + " - " + getNome());
    }
}

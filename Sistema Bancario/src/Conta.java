import java.io.Serializable;

public interface Conta extends Serializable {

    public void extrato();

    public  void deposito(double valor);

    public void saque(double valor);

    public double simulaEmprestimo(double cf, int n);
}

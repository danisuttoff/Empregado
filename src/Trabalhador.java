import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;


public class Trabalhador {

    private String nome;
    private NivelDeCargo nivelCargo;
    private Double salarioBase;
    //associações
    private Departamento departamento;
    private List<ContratoPorHora> contratos = new ArrayList<>();

    public Trabalhador() {
    }

    public Trabalhador(String nome, NivelDeCargo nivelCargo, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivelCargo = nivelCargo;
        this.salarioBase = salarioBase;
        this.departamento = departamento;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }


    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public NivelDeCargo getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(NivelDeCargo nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoPorHora> getContratos() {
        return contratos;
    }
    public void setContratos(List<ContratoPorHora> contratos){
        this.contratos = contratos;
    }

    public void addContrato(ContratoPorHora contrato) {
        contratos.add(contrato);
    }

    public void removeContrato(ContratoPorHora contrato) {
        contratos.remove(contrato);
    }

    //Quanto um trabalhador ganhou em um determinado mês
    public double renda(int ano, int mes) {
        double soma = salarioBase;
        Calendar cal = Calendar.getInstance();
        for (ContratoPorHora c : contratos) {
            cal.setTime(c.getData());
            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = 1 + cal.get(Calendar.MONTH);

            if (ano == c_ano && mes == c_mes) {
                soma += c.valorTotal();
            }
        }
        return soma;
    }



}



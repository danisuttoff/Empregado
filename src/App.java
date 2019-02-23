import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Locale;
import java.util.Date;
public class App {

    public  static void main(String[]args) throws ParseException {


        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Informe o nome do departamento: ");
        String nomeDepartamento = in.nextLine();
        System.out.println("Informe os dados do trabalhador");
        System.out.println("Informe o nome");
        String nomeTrabalhador = in.nextLine();
        System.out.println("Informe o nível do cargo: ");
        String nivelCargo  = in.nextLine();
        System.out.println(" Informe o salário base");
        double salarioBase = in.nextDouble();
        Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelDeCargo.valueOf(nivelCargo), salarioBase, new Departamento(nomeDepartamento));

        System.out.println("Informe a quantidade de contratos que este trabalhador possuí");
        int quantContratos = in.nextInt();

        for(int i = 1; i<=quantContratos; i++){
            System.out.println("Iniciando contrato #"+i+ "data:");
            System.out.print("Informe a data do contrato no formato DD/MM/AA : ");
            Date dataContrato = sdf.parse(in.next());
            System.out.print("Informe o valor por hora: ");
            double valorHora = in.nextDouble();
            System.out.print("Duração (horas): ");
            int horas = in.nextInt();
            ContratoPorHora contrato = new ContratoPorHora(dataContrato, valorHora, horas);
            trabalhador.addContrato(contrato);
        }

        System.out.println();
        System.out.println("Entre com o mês e ano para calcular o salário mm/yyyy : ");
        String mesEano = in.nextLine();
        int mes = Integer.parseInt(mesEano.substring(0,2));
        int ano = Integer.parseInt(mesEano.substring(3));
        System.out.println("Nome: " + trabalhador.getName());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        System.out.println("Renda na data de  " + mesEano + ": " + String.format("%.2f", trabalhador.renda(mes,ano)));

      in.close();



    }


}

package DevSuperiorDesafioImposto;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Renda anual com salário: ");
		double rendaAnual = scanner.nextDouble();
		System.out.print("Renda anual prestação de serviço: ");
		double rendaServiços = scanner.nextDouble();
		System.out.print("Renda anual ganho de capital: ");
		double rendaCapital = scanner.nextDouble();
		System.out.print("Gastos médicos: ");
		double gastoMedico = scanner.nextDouble();
		System.out.print("Gastos educacionais: ");
		double gastoEducacional = scanner.nextDouble();
		
		double rendaMensal = rendaAnual/12;
		double impostoSobreSalario = 0;
		if (rendaMensal>5000) {
			impostoSobreSalario = rendaAnual-(rendaAnual*0.80);
		} else if (rendaMensal>3000) {
			impostoSobreSalario = rendaAnual-(rendaAnual*0.90);
		} else {
			impostoSobreSalario = 0;
		}
		
		double impostoServiços = rendaServiços-(rendaServiços*0.85);
		double impostoCapital = rendaCapital-(rendaCapital*0.80);
		double impostoBruto = impostoCapital+impostoServiços+impostoSobreSalario;
		double maximoDedutivel = impostoBruto-(impostoBruto*0.70);
		double gastosDedutiveis = gastoEducacional+gastoMedico;
		double abatimento = gastosDedutiveis>maximoDedutivel?0:gastosDedutiveis;
		
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA\n");
		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: %.2f\n", impostoSobreSalario);
		System.out.printf("Imposto sobre serviços: %.2f\n", impostoServiços);
		System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoCapital);
		
		System.out.println("\nDEDUÇOES:");
		System.out.printf("Maximo dedutível: %.2f\n", maximoDedutivel);
		System.out.printf("Gastos dedutíveis: %.2f\n", gastosDedutiveis);
		
		System.out.println("\nRESUMO:");
		System.out.printf("Imposto bruto total: %.2f\n", impostoBruto);
		System.out.printf("Abatimento: %.2f\n", abatimento);
		System.out.printf("Imposto devido: %.2f\n", impostoBruto-abatimento);
		
		scanner.close();
	}
}

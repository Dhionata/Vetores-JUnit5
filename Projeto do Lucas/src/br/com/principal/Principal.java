package br.com.principal;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Principal {
	static int cod;

	public static void main(String[] args) {
		try {
			executar();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Os resultados não batem com o esperado ;-;\nErro: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Todos os testes realizados com sucesso!");
		if ((JOptionPane.showConfirmDialog(null, "Deseja executar com um vetor qualquer?", "Escolha uma opção",
				JOptionPane.YES_NO_OPTION)) == 0) {
			int[] personalizado = new int[5];
			do {
				for (int i = 0; i < 5; i++) {
					// valores
					do {
						try {
							personalizado[i] = Integer.parseInt(
									JOptionPane.showInputDialog("Informe o " + (i + 1) + " elemento do vetor"));
							cod = 0;
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Isso é um número inteiro?\nTente novamente");
							cod = 1;
						}
					} while (cod == 1);
				}
				JOptionPane.showMessageDialog(null, somaMinMax(personalizado));
				cod = JOptionPane.showConfirmDialog(null, "Deseja executar outro vetor qualquer?", "Escolha uma opção",
						JOptionPane.YES_NO_OPTION);

			} while (cod == 0);
			JOptionPane.showMessageDialog(null, "Obrigado por testar ;D");
		}
	}

	private static String somaMinMax(int[] arr) {
		int soma = 0;
		int menor = 2147483647;
		int maior = 0;

		for (int i = 0; i < 5; i++) {
			// menor
			if (arr[i] < menor) {
				menor = arr[i];
				System.out.println("menor: " + menor);
			}
			// maior
			if (arr[i] > maior) {
				maior = arr[i];
				System.out.println("maior: " + maior);
			}
		}
		// soma
		for (int i : arr) {
			soma += i;
			System.out.println("soma total: " + soma);
		}
		// saída
		System.out.println((soma - maior) + "-" + (soma - menor));
		return (soma - maior) + "-" + (soma - menor);
	}

	@Test
	public static void executar() {
		String mensagem = "O resultado não bateu com o esperado!";

		Assert.assertEquals(mensagem, "10-14", br.com.principal.Principal.somaMinMax(new int[] { 1, 2, 3, 4, 5 }));
		Assert.assertEquals(mensagem, "299-9271",
				br.com.principal.Principal.somaMinMax(new int[] { 7, 69, 2, 221, 8974 }));
		Assert.assertEquals(mensagem, "526-1425",
				br.com.principal.Principal.somaMinMax(new int[] { 75, 100, 101, 250, 974 }));
		Assert.assertEquals(mensagem, "326-10325",
				br.com.principal.Principal.somaMinMax(new int[] { 1, 25, 75, 225, 10000 }));
		Assert.assertEquals(mensagem, "30398-30402",
				br.com.principal.Principal.somaMinMax(new int[] { 7598, 7599, 7600, 7601, 7602 }));

	}
}

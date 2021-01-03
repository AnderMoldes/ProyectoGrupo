package classes;

import javax.swing.JTable;

public class Order {
	public static void quicksort(int tableWorkers[], int izq, int der) {
		int i = izq;
		int j = der;
		int pivote = tableWorkers[(i+j)/2];
		do {
			while(tableWorkers[i]< pivote) {
				i++;
			}
			while (tableWorkers[j] > pivote) {
				j--;
			}
			if(i<=j) {
				int aux = tableWorkers[i];
				tableWorkers[i] = tableWorkers[j];
				tableWorkers[j] = aux;
				i++;
				j--;
			}
		} while(i<=j);
		if (izq <j) {
			quicksort(tableWorkers,izq,j);
		}
		if (i<der) {
			quicksort(tableWorkers,i,der);
		}
	}
	public static void burbuja(int tabla[]) {
		int cuentaintercambios = 0;
		for(boolean ordenado = false; !ordenado;) {
			for (int i = 0; i < tabla.length-1; i++) {
				if (tabla[i] > tabla[i+1]) {
					int variableauxiliar = tabla[i];
					tabla[i] = tabla[i+1];
					tabla[i+1] = variableauxiliar;
					cuentaintercambios++;
				}
			
			}
			if (cuentaintercambios == 0) {
				ordenado = true;
		}
	}
	}
	

}

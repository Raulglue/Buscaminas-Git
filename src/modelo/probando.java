package modelo;

public class probando {

public static void main(String[] args) {
	int matriz [][]= new int [5][5];
	int contador=0;
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz.length; j++) {
			matriz[i][j]=contador;
			contador++;
		}
	}
	int tamaño= matriz.length* matriz[0].length	;
	int []array= new int[tamaño];
	int j2=0;
	for (int i = 0; i < array.length; i++) {
		for (int j = 0; j < matriz.length; j++) {
			array[i]= matriz[j][j2];
		}
		j2++;
		
	}
	for (int i = 0; i < array.length; i++) {
		System.out.println(array[i]); //
	}
}
}

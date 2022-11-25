package lab7p1_andreaortez;

import java.util.Random;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Lab7P1_AndreaOrtez {

    static Random random = new Random();
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        int menu = Menu(opcion);

        while (menu != 4) {
            switch (menu) {
                case 1: {
                    System.out.print("\n-- PORTRAIT EN PROCESO --\nIngrese numero de filas: ");
                    int fila = leer.nextInt();

                    System.out.print("Ingrese numero de columnas: ");
                    int col = leer.nextInt();

                    while (fila == col) {
                        System.out.println("LA MATRIZ NO DEBE SER CUADRADA!!\n");
                        System.out.print("Ingrese numero de filas: ");
                        fila = leer.nextInt();
                        System.out.print("Ingrese numero de columnas: ");
                        col = leer.nextInt();
                    }

                    int[][] matriz = Lectura(fila, col);
                    JOptionPane.showMessageDialog(null, "Matriz Original:\n" + Imprimir(matriz) + "\nMatriz Final:\n" + Imprimir(Rotacion(matriz)));
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.print("\n-- NUMERO MAGICO EN PROCESO --\nIngrese numero de filas: ");
                    int fila = leer.nextInt();

                    System.out.print("Ingrese numero de columnas: ");
                    int col = leer.nextInt();

                    int[][] matriz = Lectura(fila, col);
                    Ej2(matriz);
                    System.out.println();
                    break;
                }
                case 3: {
                    String cad1 = "-", cad2 = "-";
                    System.out.print("\n-- SUBSECUENCIA EN PROCESO --\nIngrese primera cadena: ");
                    cad1 += leer.next().toUpperCase();

                    System.out.print("Ingrese segunda cadena: ");
                    cad2 += leer.next().toUpperCase();
                    
                    Subsecuencia(cad1, cad2);
                    System.out.println();
                    break;
                }
            }
            menu = Menu(opcion);
        }

    }

    public static int Menu(int opcion) {
        System.out.println("-- MENU --");
        System.out.println("1-> Portrait");
        System.out.println("2-> Número Mágico");
        System.out.println("3-> Subsecuencia");
        System.out.println("4-> Salir");
        System.out.print("Ingrese una opcion: ");
        opcion = leer.nextInt();

        return opcion;
    }

    public static int[][] Lectura(int fila, int col) {
        int temp[][] = new int[fila][col];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = 0 + random.nextInt(9);
            }
        }
        return temp;
    }//Fin lectura

    public static String Imprimir(int[][] num) {
        String cad = "";
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                cad += "[" + num[i][j] + "]";
            }
            cad += "\n";
        }
        return cad;
    }//Fin imprimir

    public static int[][] Rotacion(int[][] matriz) {
        int temp[][] = new int[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {//Filas
            for (int j = 0; j < matriz[i].length; j++) {//Columnas
                temp[j][matriz.length - i - 1] = matriz[i][j];

            }
        }
        return temp;
    }

    public static int Ej2(int[][] matriz) {
        int suma = 0, mult = 1, sumaf;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == 0 || i == matriz.length - 1 || j == 0 || j == matriz[i].length - 1) {
                    suma += matriz[i][j];
                } else {
                    mult *= matriz[i][j];
                }
            }
        }
        sumaf = suma + mult;
        JOptionPane.showMessageDialog(null, "Matriz:\n" + Imprimir(matriz) + "\nSuma: "
                + suma + "\nMultiplicacion: " + mult + "\nEl numero generado es: " + sumaf);
        return sumaf;
    }

    public static int Subsecuencia(String cad1, String cad2) {
        int[][] matriz = new int[cad2.length()][cad1.length()];
        int max;
        for (int i = 0; i < matriz.length; i++) {//Filas
            char a = cad2.charAt(i);//Cadena pequeña
            for (int j = 0; j < matriz[0].length; j++) {//Columnas
                char b = cad1.charAt(j);//Cadena grande

                if (i == 0 || j == 0) {
                    matriz[i][j] = 0;
                } else if (a == b) {
                    matriz[i][j] = (matriz[i - 1][j - 1] + 1);
                } else if (a != b) {
                    matriz[i][j] = Math.max(matriz[i - 1][j], matriz[i][j - 1]);
                }
            }
        }

        max = matriz[cad2.length() - 1][cad1.length() - 1];
        JOptionPane.showMessageDialog(null, "Cadena 1: " + cad1 + "\nCadena 2: " + cad2
                + "\n\nMatriz:\n" + Imprimir(matriz) + "\nEl size de la subsecuencia más grande es igual a: " + max);
        return max;
    }
}//Fin clase

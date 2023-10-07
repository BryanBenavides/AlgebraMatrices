package com.mycompany.operaciones_de_matrices;

import java.util.Scanner;

public class Operaciones_de_matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continuar = 'S';
        int intentos = 3;

        while (intentos > 0 && (continuar == 'S' || continuar == 's')) {
            System.out.println("Operaciones con matrices:");
            System.out.println("1. Verificar si 2 matrices son iguales o no");
            System.out.println("2. Sumar 2 matrices");
            System.out.println("3. Generar una matriz de ceros de n x m");
            System.out.println("4. Obtener el inverso aditivo de una matriz de n x m");
            System.out.println("5. Restar 2 matrices");
            System.out.println("6. Multiplicar un escalar por una matriz de n x m");
            System.out.println("7. Multiplicar 2 matrices compatibles");
            System.out.println("8. Obtener una matriz identidad de tamaño n");
            System.out.println("9. Obtener la inversa de una matriz de tamaño n");
            System.out.println("10. Obtener el determinante de una matriz de tamaño n");
            System.out.print("Ingrese el número de la operación que desea realizar: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos.");
                        continuar = 'N';
                        break;
                    }
                    if (sonMatricesIguales(leerMatriz(), leerMatriz())) {
                        System.out.println("Las matrices son iguales.");
                    } else {
                        System.out.println("Las matrices no son iguales.");
                    }
                    intentos--;
                    break;
                case 2:
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos.");
                        continuar = 'N';
                        break;
                    }
                    double[][] matriz1Suma = leerMatriz();
                    double[][] matriz2Suma = leerMatriz();
                    if (sonCompatiblesParaSuma(matriz1Suma, matriz2Suma)) {
                        double[][] sumaMatrices = sumarMatrices(matriz1Suma, matriz2Suma);
                        mostrarMatriz(sumaMatrices);
                    } else {
                        System.out.println("Las matrices no son compatibles para la suma.");
                    }
                    intentos--;
                    break;
                case 3:
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos.");
                        continuar = 'N';
                        break;
                    }
                    int filasCeros = scanner.nextInt();
                    int columnasCeros = scanner.nextInt();
                    double[][] matrizCeros = generarMatrizCeros(filasCeros, columnasCeros);
                    mostrarMatriz(matrizCeros);
                    intentos--;
                    break;
                case 4:
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos.");
                        continuar = 'N';
                        break;
                    }
                    double[][] matrizInversoAditivo = obtenerInversoAditivo(leerMatriz());
                    mostrarMatriz(matrizInversoAditivo);
                    intentos--;
                    break;
                case 5:
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos.");
                        continuar = 'N';
                        break;
                    }
                    double[][] matriz1Resta = leerMatriz();
                    double[][] matriz2Resta = leerMatriz();
                    if (sonCompatiblesParaResta(matriz1Resta, matriz2Resta)) {
                        double[][] restaMatrices = restarMatrices(matriz1Resta, matriz2Resta);
                        mostrarMatriz(restaMatrices);
                    } else {
                        System.out.println("Las matrices no son compatibles para la resta.");
                    }
                    intentos--;
                    break;
                case 6:
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos.");
                        continuar = 'N';
                        break;
                    }
                    double[][] matrizEscalar = leerMatriz();
                    double escalar = scanner.nextDouble();
                    double[][] productoEscalar = multiplicarPorEscalar(matrizEscalar, escalar);
                    mostrarMatriz(productoEscalar);
                    intentos--;
                    break;
                case 7:
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos.");
                        continuar = 'N';
                        break;
                    }
                    double[][] matriz1Multiplicacion = leerMatriz();
                    double[][] matriz2Multiplicacion = leerMatriz();
                    if (sonCompatiblesParaMultiplicacion(matriz1Multiplicacion, matriz2Multiplicacion)) {
                        double[][] productoMatrices = multiplicarMatrices(matriz1Multiplicacion, matriz2Multiplicacion);
                        mostrarMatriz(productoMatrices);
                    } else {
                        System.out.println("Las matrices no son compatibles para la multiplicación.");
                    }
                    intentos--;
                    break;
                case 8:
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos.");
                        continuar = 'N';
                        break;
                    }
                    int tamanoIdentidad = scanner.nextInt();
                    double[][] matrizIdentidad = obtenerMatrizIdentidad(tamanoIdentidad);
                    mostrarMatriz(matrizIdentidad);
                    intentos--;
                    break;
                case 9:
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos.");
                        continuar = 'N';
                        break;
                    }
                    double[][] matrizInversa = obtenerMatrizInversa(leerMatriz());
                    mostrarMatriz(matrizInversa);
                    intentos--;
                    break;
                case 10:
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos.");
                        continuar = 'N';
                        break;
                    }
                    double[][] matrizDeterminante = leerMatriz();
                    double determinante = obtenerDeterminante(matrizDeterminante);
                    System.out.println("El determinante de la matriz es: " + determinante);
                    intentos--;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

            if (intentos > 0) {
                System.out.print("¿Desea realizar otra operación? (S/N): ");
                continuar = scanner.next().charAt(0);
            }
        }

        System.out.println("¡Hasta luego!");
        scanner.close();
    }

    public static boolean sonMatricesIguales(double[][] matriz1, double[][] matriz2) {
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            return false;
        }

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                if (matriz1[i][j] != matriz2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean sonCompatiblesParaSuma(double[][] matriz1, double[][] matriz2) {
        return matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length;
    }

    public static double[][] sumarMatrices(double[][] matriz1, double[][] matriz2) {
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        double[][] sumaMatrices = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sumaMatrices[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return sumaMatrices;
    }

    public static double[][] generarMatrizCeros(int filas, int columnas) {
        double[][] matrizCeros = new double[filas][columnas];
        return matrizCeros;
    }

    public static double[][] obtenerInversoAditivo(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] inversoAditivo = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                inversoAditivo[i][j] = -matriz[i][j];
            }
        }

        return inversoAditivo;
    }

    public static boolean sonCompatiblesParaResta(double[][] matriz1, double[][] matriz2) {
        return matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length;
    }

    public static double[][] restarMatrices(double[][] matriz1, double[][] matriz2) {
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        double[][] restaMatrices = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                restaMatrices[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }

        return restaMatrices;
    }

    public static double[][] multiplicarPorEscalar(double[][] matriz, double escalar) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] productoEscalar = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                productoEscalar[i][j] = matriz[i][j] * escalar;
            }
        }

        return productoEscalar;
    }

    public static boolean sonCompatiblesParaMultiplicacion(double[][] matriz1, double[][] matriz2) {
        return matriz1[0].length == matriz2.length;
    }

    public static double[][] multiplicarMatrices(double[][] matriz1, double[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int columnas2 = matriz2[0].length;
        double[][] productoMatrices = new double[filas1][columnas2];

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                for (int k = 0; k < columnas1; k++) {
                    productoMatrices[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return productoMatrices;
    }

    public static double[][] obtenerMatrizIdentidad(int n) {
        double[][] matrizIdentidad = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizIdentidad[i][j] = (i == j) ? 1.0 : 0.0;
            }
        }

        return matrizIdentidad;
    }

    public static double[][] obtenerMatrizInversa(double[][] matriz) {
        // Implementa la lógica para obtener la matriz inversa (puede ser complejo)
        return null;
    }

    public static double obtenerDeterminante(double[][] matriz) {
        // Implementa la lógica para obtener el determinante (puede ser complejo)
        return 0.0;
    }

    public static void mostrarMatriz(double[][] matriz) {
        if (matriz != null) {
            int filas = matriz.length;
            int columnas = matriz[0].length;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("La matriz es nula.");
        }
    }

    public static double[][] leerMatriz() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de filas de la matriz: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz: ");
        int columnas = scanner.nextInt();

        double[][] matriz = new double[filas][columnas];

        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = scanner.nextDouble();
            }
        }

        return matriz;
    }
}

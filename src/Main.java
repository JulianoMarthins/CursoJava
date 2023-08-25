import entities.Curso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Programado por Juliano Martins");
        Thread.sleep(2500);


        try {

            while (true) {
                linhas();
                System.out.println("Menu:\n1 -> DevSuperior:\n2 -> Cod3r:\n3 -> Sair: ");
                int op = sc.nextInt();
                sc.nextLine();

                switch (op) {

                    case 1:
                        Curso devSuperior = new Curso("DevSuperior", "Nélio Alvez");
                        devSuperior.dadosCurso("d:\\workspace\\arquivo\\curso\\devsuperior.txt");

                        linhas();
                        System.out.print("Aperte enter para continuar: ");
                        String con = sc.nextLine();

                        devSuperior.cursoRestante();
                        break;

                    case 2:
                        Curso coder = new Curso("Cod3r", "Leonardo Leitão");
                        coder.dadosCurso("d:\\workspace\\arquivo\\curso\\cod3r.txt");

                        linhas();
                        System.out.println("Aperte enter para continuar: ");
                        con = sc.nextLine();

                        coder.cursoRestante();
                        break;

                    case 3:
                        linhas();
                        System.out.println("Fechando o programa");
                        Thread.sleep(1500);
                        System.out.println("Obrigado por usar");
                        break;

                }
                if(op == 3){
                    break;
                }


            }
        } catch (RuntimeException e) {
            System.out.println("ERROR! Valor digitado inválido");
        }


        sc.close();
    }

    public static void linhas() {
        System.out.println("\n-----------------------------------\n");
    }
}
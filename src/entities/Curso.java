package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {
    public static final Scanner sc = new Scanner(System.in);

    // Atributos de Classe

    private String nomeCurso;

    private String professor;
    private List<String> modulo = new ArrayList<>();
    private Integer totalAulas = 0;


    // Contrutores

    public Curso(String nomeCurso, String professor) {

        this.nomeCurso = nomeCurso;
        this.professor = professor;
    }


    // Metodos

    public void linhas() {
        System.out.println("\n\n-----------------------------------\n");
    }

    public void dadosCurso(String caminho) {
        try (BufferedReader ler = new BufferedReader(new FileReader(caminho))) {
            String linha = ler.readLine();

            System.out.println("Acessando o curso da " + getNomeCurso());
            System.out.print("\nPor favor, aguarde a conexão com banco de dados -> ");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(750);
                System.out.print(i + 1 + " ");
            }

            System.out.println("\n\nBanco de dados acessado com sucesso");
            System.out.print("\nDigite quantas aulas foram assistidas: ");
            int aulasAssistidas = sc.nextInt();

            System.out.println();

            while (linha != null) {
                String[] vetor = linha.split(",");

                String modulo = vetor[0];
                int aulas = Integer.parseInt(vetor[1]);

                System.out.println(modulo);
                totalAulas(aulas);

                if (getTotalAulas() > aulasAssistidas) {
                    addModulo(vetor[0]);
                }
                linha = ler.readLine();
            }

            System.out.println("\nTotal de aulas: " + getTotalAulas());
            System.out.println("Faltam " + (getTotalAulas() - aulasAssistidas) +
                    " aulas para a conclusão do curso");
            System.out.printf("Completo: %.2f", porcentagem(aulasAssistidas));
            System.out.print("%");


        } catch (IOException e) {
            System.out.println("ERROR! Acesso negado ao banco de dados");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void cursoRestante() {
        linhas();
        System.out.println("Os modulos restantes são: ");
        System.out.println();

        for (String lista : getModulo()) {
            System.out.println(lista);
        }
    }

    public void addModulo(String modulo) {
        this.modulo.add(modulo);
    }

    public void removeModulo(String modulo) {
        try {
            this.modulo.remove(modulo);
        } catch (Exception e) {
            System.out.println("ERROR! A lista encontra-se vazia.");
        }
    }

    public double porcentagem(double num) {
        return num * 100 / this.totalAulas;

    }

    public void totalAulas(int num) {
        this.totalAulas += num;
    }


    // Getters & Setters

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Integer getTotalAulas() {
        return totalAulas;
    }

    public void setTotalAulas(Integer totalAulas) {
        this.totalAulas = totalAulas;
    }

    public List<String> getModulo() {
        return modulo;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aguardando informações");
        return "" + sb;
    }
}

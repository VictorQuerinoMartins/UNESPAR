package Revisão.Classes.Atividades;

public class UseGPS {
        public static void main(String[] args) {
            // Criando uma instância de GPS usando o construtor padrão
            GPS gps1 = new GPS();
            
            System.out.println("Valores iniciais do GPS 1:");
            gps1.mostrar();
            System.out.println("");
            
            gps1.definirIdioma("Português");
            gps1.definirRota("Casa -> Trabalho");
            
            System.out.println("Valores atualizados do GPS 1:");
            gps1.mostrar();
            System.out.println();
            
            GPS gps2 = new GPS("Inglês", "Trabalho -> Curso");
            
            System.out.println("Valores do GPS 2:");
            gps2.mostrar();
        }
    }

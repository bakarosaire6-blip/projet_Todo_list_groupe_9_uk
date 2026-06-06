
import java.util.Scanner;

public class Projet {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        int choix = 0;
        do {
             System.out.println("== BIENVENUE SUR TO DO LIST ==");
            System.out.println("1. Afficher les tâches");
            System.out.println("2. Ajouter une tâche");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Supprimer une tâche");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");
            
            if (clavier.hasNextInt()) {
                choix = clavier.nextInt();
                clavier.nextLine(); 
            } else {
                System.out.println("Erreur : Veuillez entrer un nombre valide.");
                clavier.nextLine(); 
                //continue;
            }
            switch (choix) {
                case 1:
                    System.out.println("pas encore implémenté");
                    break;
                case 2:
                    System.out.println("pas encore implémenté");
                    break;
                case 3:
                    System.out.println("pas encore implémenté");
                    break;
                case 4:
                    System.out.println("pas encore implémenté");
                    break;
                case 5:
                    System.out.println("Merci d'avoir utilisé notre application. Au revoir!");
                    break;
                default:
                    System.out.println("Option inconnue. Veuillez choisir un chiffre entre 1 et 5.");
            }
        } while (choix != 5);
        clavier.close();
    }
}

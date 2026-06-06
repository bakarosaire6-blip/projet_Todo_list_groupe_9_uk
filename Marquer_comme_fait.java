import java.util.List;
import java.util.Scanner;

public class marquerCommeFait {
    public static void main(String[] args) {
        gestion_de_tache gestionnaire = new gestion_de_tache();
        Scanner clavier = new Scanner(System.in);
         System.out.print("Entrez l'ID de la tâche à terminer : ");
                    if (clavier.hasNextInt()) {
                        int idTerminer = clavier.nextInt();
                        boolean reussiTerminer = gestionnaire.marquerTerminer(idTerminer);
                        if (reussiTerminer) {
                            System.out.println("Succès : Tâche marquée comme terminée.");
                        } else {
                            System.out.println("Erreur : Tâche introuvable avec cet ID.");
                        }
                    }
    }
    class gestion_de_tache {

    private List<Tache> listeTaches;
    private int compteurId;
     public boolean marquerTerminer(int id) {
        for (Tache tache : listeTaches) {
            if (tache.getId() == id) {
                tache.setFait(true);
                return true;
            }
        }
        return false;
    }

}
}

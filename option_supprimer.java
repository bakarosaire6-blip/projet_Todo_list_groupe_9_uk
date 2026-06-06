import java.util.List;
import java.util.Scanner;

public class option_supprimer {
    public static void main(String[] args){
        
        Scanner clavier = new Scanner(System.in);
         System.out.print("Entrez l'ID de la tâche à supprimer : ");
                    if (clavier.hasNextInt()) {
                        int idSupprimer = clavier.nextInt();
                        boolean reussiSupprimer = gestionnaire.supprimerTache(idSupprimer);
                        if (reussiSupprimer) {
                            System.out.println("Succès : Tâche supprimée avec succès.");
                        } else {
                            System.out.println("Erreur : Tâche introuvable avec cet ID.");
                        }
                    }
    }
    class gestion_de_tache {
    private List<Tache> listeTaches;
    private int compteurId;
        public boolean supprimerTache(int id) {
        for (int i = 0; i < listeTaches.size(); i++) {
            if (listeTaches.get(i).getId() == id) {
                listeTaches.remove(i);
                return true;
            }
        }
        return false;
    }
}
}

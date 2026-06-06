import java.util.List;
import java.util.Scanner;

public class afficherList {
    public static void main(String[] args){
         gestion_de_tache gestionnaire = new gestion_de_tache();
        Scanner clavier = new Scanner(System.in);
         gestionnaire.listerTaches();

}
 class gestion_de_tache {

    private List<Tache> listeTaches;
    private int compteurId;

public void listerTaches() {
        if (listeTaches.isEmpty()) {
            System.out.println("aucune tache disponible.");
            return;
        }       
        System.out.println("--- LISTE DES TÂCHES ---");
        for (Tache tache : listeTaches) {
            String statut = tache.getFait() ? "[Tache terminée]" : "[Tache non terminée]";
            System.out.println(tache.getId() + ". " + statut + " " + tache.getTitre() + " : " + tache.getDescription());
        }
    }
}
}

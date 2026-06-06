import java.util.ArrayList;

public class ajouterTaches {
    public static void main(String[] args) {

        System.out.print("Entrez le titre de la tâche : ");
                    String titre = clavier.nextLine();
                    System.out.print("Entrez la description de la tâche : ");
                    String description = clavier.nextLine();
                    gestionnaire.ajouterTache(titre, description);

        
    }
      public gestion_de_tache() {
        this.listeTaches = new ArrayList<>();
        this.compteurId = 1;
    }

    public void ajouterTache(String titre, String description) {
        Tache nouvelleTache = new Tache(compteurId, titre, description, false);
        listeTaches.add(nouvelleTache);
        System.out.println("Tache " + compteurId +" ajouté avec succes");
        compteurId++;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu_Todo {
    public static void main(String[] args) {
        

        gestion_de_tache gestionnaire = new gestion_de_tache();
        Scanner clavier = new Scanner(System.in);
        int choix = 0;

        do {
            System.out.println("== BIENVENUE SUR TO DO LIST ==");
            System.out.println("1. Afficher les tâches");
            System.out.println("2. Ajouter une tâche");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Supprimer une tâche");
            System.out.println("5. Rechercher une Tache");
            System.out.println("6. Quitter");
            System.out.print("Choix : ");
            
            if (clavier.hasNextInt()) {
                choix = clavier.nextInt();
                clavier.nextLine(); 
            } else {
                System.out.println("Erreur : Veuillez entrer un nombre valide.");
                clavier.nextLine(); 
                continue;
            }

            switch (choix) {
                case 1:
                    gestionnaire.listerTaches();
                    break;

                case 2:
                    System.out.print("Entrez le titre de la tâche : ");
                    String titre = clavier.nextLine();
                    System.out.print("Entrez la description de la tâche : ");
                    String description = clavier.nextLine();
                    gestionnaire.ajouterTache(titre, description);
                    break;

                case 3:
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
                    break;

                case 4:
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
                    break;
                case 5:
                    System.out.println("veillez entrer l'id de la tache à rechercher: ");
                    if (clavier.hasNextInt()){
                          int idRecherche = clavier.nextInt();
                          boolean trouve = gestionnaire.rechercherTache(idRecherche);
                          if (trouve){
                            System.out.println("La tache avec l'ID " + idRecherche+" a ete trouvée");

                          }else{
                            System.out.println("La tache avec l'ID " + idRecherche+" n'a pas ete trouvée");
                          }
                          
                    }
                case 6:
                    System.out.println("Fin du programme. Au revoir !");
                    break;

                default:
                    System.out.println("Option inconnue. Veuillez choisir un chiffre entre 1 et 5.");
            }

        } while (choix != 5);

        clavier.close();
    }
}

class gestion_de_tache {

    private List<Tache> listeTaches;
    private int compteurId;

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

    public boolean supprimerTache(int id) {
        for (int i = 0; i < listeTaches.size(); i++) {
            if (listeTaches.get(i).getId() == id) {
                listeTaches.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean rechercherTache(int id){
        for (int i = 0; i < listeTaches.size(); i++){
            if (listeTaches.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean marquerTerminer(int id) {
        for (Tache tache : listeTaches) {
            if (tache.getId() == id) {
                tache.setFait(true);
                return true;
            }
        }
        return false;
    }

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


class Tache {
    private int id;
    private String titre;
    private String description;
    private boolean fait;

    public Tache(int id, String titre, String description, boolean fait) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.fait = fait;
    }

    public void setFait(boolean fait) {
        this.fait = fait;
    }

    public boolean getFait() {
        return this.fait;
    }

    public int getId() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getDescription() {
        return this.description;
    }
}

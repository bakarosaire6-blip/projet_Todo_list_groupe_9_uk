
import java.util.Scanner;
public class Recherche {
    public static void main(String[] args){
        Scanner clavier = new Scanner(System.in);
        gestion_de_tache gestionnaire = new gestion_de_tache();
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
 
        public boolean rechercherTache(int id){
        for (int i = 0; i < listeTaches.size(); i++){
            if (listeTaches.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }
}
}
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuerProgramme = true;

        while (continuerProgramme) {
            System.out.println("\n=== Menu de Gestion de Bibliothèque ===");
            System.out.println("1. Afficher les livres");
            System.out.println("2. Ajouter un livre");
            System.out.println("3. Rechercher un livre");
            System.out.println("4. Supprimer un livre");
            System.out.println("5. Modifier un livre");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    Book.afficherLivres();
                    break;
                case 2:
                    Book.ajouterLivre();
                    break;
                case 3:
                    Book.rechercherLivre();
                    break;
                case 4:
                    Book.supprimerLivre();
                    break;
                case 5:
                    Book.modifierLivre();
                    break;
                case 6:
                    continuerProgramme = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

    }
}
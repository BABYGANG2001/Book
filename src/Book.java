import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String titre;
    private String auteur;
    private String isbn;
    private boolean disponible;

    private static ArrayList<Book> listeLivres = new ArrayList<>();

    // Constructeur
    public Book(String titre, String auteur, String isbn, boolean disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.disponible = disponible;
    }

    // Getters et Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Méthodes de gestion des livres
    public static void afficherLivres() {
        if (listeLivres.isEmpty()) {
            System.out.println("Aucun livre n'est enregistré.");
        } else {
            System.out.println("Liste des livres :");
            for (Book livre : listeLivres) {
                livre.afficherDetails();
            }
        }
    }

    public static void ajouterLivre() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le titre du livre : ");
        String titre = scanner.nextLine();

        System.out.print("Entrez l'auteur du livre : ");
        String auteur = scanner.nextLine();

        System.out.print("Entrez l'ISBN du livre : ");
        String isbn = scanner.nextLine();

        System.out.print("Le livre est-il disponible ? (oui/non) : ");
        String disponibleInput = scanner.nextLine();
        boolean disponible = disponibleInput.equalsIgnoreCase("oui");

        Book livre = new Book(titre, auteur, isbn, disponible);
        listeLivres.add(livre);

        System.out.println("Le livre a été ajouté avec succès !");
    }
    public static void rechercherLivre() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un titre, un auteur ou un ISBN pour rechercher : ");
        String critere = scanner.nextLine();
        boolean trouve = false;

        for (Book livre : listeLivres) {
            if (livre.getTitre().equalsIgnoreCase(critere) ||
                    livre.getAuteur().equalsIgnoreCase(critere) ||
                    livre.getIsbn().equalsIgnoreCase(critere)) {
                livre.afficherDetails();
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.println("Aucun livre trouvé avec les critères donnés.");
        }
    }

    public static void supprimerLivre() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ISBN du livre à supprimer : ");
        String isbn = scanner.nextLine();
        boolean supprime = false;

        for (int i = 0; i < listeLivres.size(); i++) {
            if (listeLivres.get(i).getIsbn().equalsIgnoreCase(isbn)) {
                listeLivres.remove(i);
                supprime = true;
                System.out.println("Le livre a été supprimé avec succès.");
                break;
            }
        }

        if (!supprime) {
            System.out.println("Aucun livre trouvé avec l'ISBN donné.");
        }
    }

    public static void modifierLivre() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ISBN du livre à modifier : ");
        String isbn = scanner.nextLine();
        boolean trouve = false;

        for (Book livre : listeLivres) {
            if (livre.getIsbn().equalsIgnoreCase(isbn)) {
                System.out.print("Nouveau titre (laissez vide pour conserver) : ");
                String nouveauTitre = scanner.nextLine();
                if (!nouveauTitre.isEmpty()) {
                    livre.setTitre(nouveauTitre);
                }

                System.out.print("Nouvel auteur (laissez vide pour conserver) : ");
                String nouvelAuteur = scanner.nextLine();
                if (!nouvelAuteur.isEmpty()) {
                    livre.setAuteur(nouvelAuteur);
                }

                System.out.print("Le livre est-il disponible ? (oui/non, laissez vide pour conserver) : ");
                String nouvelleDisponibilite = scanner.nextLine();
                if (!nouvelleDisponibilite.isEmpty()) {
                    livre.setDisponible(nouvelleDisponibilite.equalsIgnoreCase("oui"));
                }

                System.out.println("Le livre a été modifié avec succès.");
                trouve = true;
                break;
            }
        }

        if (!trouve) {
            System.out.println("Aucun livre trouvé avec l'ISBN donné.");
        }
    }




    // Méthode pour afficher les détails d'un livre
    public void afficherDetails() {
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("ISBN : " + isbn);
        System.out.println("Disponibilité : " + (disponible ? "Disponible" : "Non disponible"));
        System.out.println("---------------------------");
    }
}


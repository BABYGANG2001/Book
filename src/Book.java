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

    // Méthode pour afficher les détails d'un livre
    public void afficherDetails() {
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("ISBN : " + isbn);
        System.out.println("Disponibilité : " + (disponible ? "Disponible" : "Non disponible"));
        System.out.println("---------------------------");
    }
}


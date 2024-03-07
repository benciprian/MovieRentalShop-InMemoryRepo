package UI;

import Domain.Client;
import Domain.Movie;
import Service.MovieService;
import Service.ClientService;

import java.util.Scanner;
import java.util.Set;

public class Console {
    private MovieService movieService;
    private ClientService clientService;
    private Scanner scanner;

    public Console(MovieService movieService, ClientService clientService) {
        this.movieService = movieService;
        this.clientService = clientService;

        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Movie rent CRUD");
        System.out.println("2. Client CRUD");
        System.out.println("0. Exit");
    }

    public void run() {
        while (true) {
            showMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runMovieCrud();
                    break;
                case "2":
                    runClientCrud();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runMovieCrud() {
        while (true) {
            System.out.println("1. Add movie rental");
            System.out.println("2. View all movies rental");
            System.out.println("3. Update movie rental");
            System.out.println("4. Remove movies rental");
            System.out.println("9. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    addMovieRental();
                    break;
                case "2":
                    printMovies();
                    break;
                case "3":
                    updateMovieRental();
                    break;
                case "4":
                    deleteMovieRental();
                    break;
                case "9":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runClientCrud() {
        while (true) {
            System.out.println("1. Add a client");
            System.out.println("2. List all clients");
            System.out.println("3. Delete a client");
            System.out.println("9. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    addClient();
                    break;
                case "2":
                    listClients();
                    break;
                case "3":
                    handleRemoveClient();
                    break;
                case "9":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void printMovies() {
        System.out.println("All movies: \n");
        Set<Movie> movies = movieService.getAllMovies();
        movies.forEach(System.out::println);
    }

    private void addMovieRental() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("id = ");
        Long id = scanner.nextLong();

        System.out.println("title = ");
        String title = scanner.next();

        System.out.println("year = ");
        int year = scanner.nextInt();

        System.out.println("genre = ");
        String genre = scanner.next();

        System.out.println("rentalPrice = ");
        double rentalPrice = scanner.nextInt();

        Movie movie = new Movie(id,title, year, genre, rentalPrice);
        movieService.addMovieRental(movie);
    }
    private void deleteMovieRental() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID of the movie you want to remove: ");
        Long id = scanner.nextLong();
        Movie removedMovie = movieService.removeMovie(id);

        if (removedMovie != null) {
            System.out.println("Movie removed: " + removedMovie.getTitle());
        } else {
            System.out.println("Movie with ID " + id + " not found.");
        }
    }
    private void updateMovieRental() {
        System.out.println("Enter the ID of the movie to update: ");
        Long id = scanner.nextLong();

        Movie existingMovie = movieService.getMovieById(id);

        if (existingMovie != null) {
            System.out.println("Enter new title: ");
            String newTitle = scanner.next();
            System.out.println("Enter new year: ");
            int newYear = scanner.nextInt();
            System.out.println("Enter new genre: ");
            String newGenre = scanner.next();
            System.out.println("Enter new rental price: ");
            double newRentalPrice = scanner.nextDouble();

            // Create a new Movie object with the updated information.
            Movie updatedMovie = new Movie(id, newTitle, newYear, newGenre, newRentalPrice);

            // Update the movie in the repository.
            Movie updatedEntity = movieService.updateMovie(updatedMovie);

            if (updatedEntity != null) {
                System.out.println("Movie updated: " + updatedEntity);
            } else {
                System.out.println("Failed to update the movie.");
            }
        } else {
            System.out.println("No movie found with the given ID.");
        }
    }

    private void addClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("id = ");
        Long id = scanner.nextLong();

        System.out.println("Last Name = ");
        String lastName = scanner.next();

        System.out.println("First Name = ");
        String firstName = scanner.next();

        System.out.println("E-mail = ");
        String email = scanner.next();

        System.out.println("PhoneNumber = ");
        String phoneNumer = scanner.next();

        System.out.println("City = ");
        String city = scanner.next();

        Client client = new Client(id, firstName, lastName, email, phoneNumer, city);
        clientService.addClient(client);
    }

    private void listClients() {
        System.out.println("All clients: \n");
        Set<Client> clients = clientService.getAllClients();
        clients.forEach(System.out::println);
    }

    private void handleRemoveClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID of the client you want to remove: ");
        Long id = scanner.nextLong();
        Client removedClient = clientService.removeClient(id);

        if (removedClient != null) {
            System.out.println("Client removed: " + removedClient.getLastName() + " " + removedClient.getFirstName());
        } else {
            System.out.println("Client with ID " + id + " not found.");
        }
    }

}


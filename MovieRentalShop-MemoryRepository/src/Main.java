import Domain.Client;
import Domain.Movie;
import Repository.ClientRepository;
import Repository.ClientRepositoryImpl;
import Repository.MovieRepository;
import Repository.MovieRepositoryImpl;
import Service.ClientService;
import Service.MovieService;
import UI.Console;

public class Main {
    public static void main(String[] args) {

        MovieRepository movieRepository=new MovieRepositoryImpl();
        ClientRepository clientRepository =  new ClientRepositoryImpl();
        MovieService movieService=new MovieService(movieRepository);
        ClientService clientService = new ClientService(clientRepository);

        clientRepository.save(new Client(1L, "Adi","Chiorean","adi@gmail.com","074444444","Alba Iulia"));
        clientRepository.save(new Client(2L, "Ciprian","Negru","ciprian@gmail.com","0733333333","Cluj"));
        movieRepository.save(new Movie(1l,"Hotel_Transilvania",2001,"Action",23));
        movieRepository.save(new Movie(2l,"Laguna_Albastra",2012,"Adventure",32));
        Console console=new Console(movieService, clientService);

        console.run();

        System.out.println("bye");
    }
}
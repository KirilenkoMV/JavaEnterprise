package by.academy;


import by.academy.dao.Impl.ClientDAOImpl;
import by.academy.dao.interfaces.GenericDAO;
import by.academy.entity.Client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Client client = new Client();
    	client.setName("Михаил");
    	client.setSurname("Кириленко");
    	client.setPassword("qwerty");
    	client.setAge(30);
    	client.setPhone(1234567);
    	GenericDAO<Client> dao = ClientDAOImpl.getInstance();
    	dao.insert(client);
    }
}

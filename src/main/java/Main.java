import Dao.TicketDao;
import Model.TicketModel;
import Service.TicketService;

import java.util.List;

public class Main {
    public static void  main(String[] args){
        TicketDao ticketDao = new TicketDao();
        List<TicketModel> ticketModels = ticketDao.getTickets();
        TicketService ticketService = new TicketService();
        ticketService.MinFlightTimes(ticketModels);
        ticketService.PriceMedDiff(ticketModels);
    }
}

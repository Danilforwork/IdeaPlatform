package Dao;

import Model.TicketModel;
import Model.TicketModelList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TicketDao {
    private static final String FILE_PATH ="src/main/resources/tickets.json";
    public List<TicketModel> getTickets(){
        ObjectMapper mapper = new ObjectMapper();
        TicketModelList ticketModelList;
        try {
            ticketModelList = mapper.readValue(new File(FILE_PATH),TicketModelList.class);
            return Arrays.asList(ticketModelList.getTickets());
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }
}

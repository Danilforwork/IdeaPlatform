package Service;

import Model.TicketModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketService {
    public void MinFlightTimes(List<TicketModel> ticketModels){
        Map<String,Integer> minFlightTimes = new HashMap<>();
        for (TicketModel ticketModel:ticketModels){
            if (ticketModel.getOrigin().equals("VVO") && ticketModel.getDestination().equals("TLV")){
                String carrier = ticketModel.getCarrier();
                int duration = Duration(ticketModel.getDeparture_time(),ticketModel.getArrival_time());
                if (!minFlightTimes.containsKey(carrier)){
                    minFlightTimes.put(carrier,duration);
                }else {
                    int minDuration = minFlightTimes.get(carrier);
                    if (duration < minDuration) {
                        minFlightTimes.put(carrier, duration);
                    }
                }
            }
        }
        for (Map.Entry<String,Integer> entry:minFlightTimes.entrySet()){
            System.out.println("Минимальное время полета " + entry.getKey() + ": " + entry.getValue() + " минут");
        }
    }
    public void PriceMedDiff(List<TicketModel> ticketModels){
        List<Integer> prices = new ArrayList<>();
        for (TicketModel ticketModel : ticketModels){
            if (ticketModel.getOrigin().equals("VVO") && ticketModel.getDestination().equals("TLV")){
                prices.add(ticketModel.getPrice());
            }
        }
        prices.sort(null);
        double med;
        if (prices.size() % 2 ==0){
            med = (prices.get(prices.size() /2 -1) + prices.get(prices.size()/2)) /2.0;
        }else {
            med = prices.get(prices.size()/2);
        }
        double sum =0;
        for (int price : prices){
            sum+=price;
        }
        double avgprice = sum/prices.size();
        double diff = avgprice - med;
        System.out.println("Разница между средней ценой и медианой: "+ diff);
    }
    private int Duration(String departureTime, String arrivalTime) {
        String[] departureParts = departureTime.split(":");
        String[] arrivalParts = arrivalTime.split(":");
        int departureHour = Integer.parseInt(departureParts[0]);
        int departureMinute = Integer.parseInt(departureParts[1]);
        int arrivalHour = Integer.parseInt(arrivalParts[0]);
        int arrivalMinute = Integer.parseInt(arrivalParts[1]);
        int durationHour = arrivalHour - departureHour;
        int durationMinute = arrivalMinute - departureMinute;
        return durationHour * 60 + durationMinute;
    }
}

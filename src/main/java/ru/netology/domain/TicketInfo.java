package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TicketInfo implements Comparable<TicketInfo> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int time;

    @Override
    public int compareTo(TicketInfo o) {
        return price - o.price;
    }

    public boolean matches(String from, String to) {
        return airportFrom.equalsIgnoreCase(from) && airportTo.equalsIgnoreCase(to);
    }
}

package ru.netology.manager;
import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager() {
    }

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(TicketInfo ticketOffer) {
        repository.save(ticketOffer);
    }

    public TicketInfo[] findAll(String from, String to) {
        TicketInfo[] result = new TicketInfo[0];
        for (TicketInfo ticketInfo : repository.findAll()) {
            if (ticketInfo.matches(from, to)) {
                TicketInfo[] tmp = new TicketInfo[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticketInfo;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}

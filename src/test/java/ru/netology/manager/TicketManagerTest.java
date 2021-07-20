package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private TicketInfo first = new TicketInfo(1, 3000, "LED", "VNU", 50);
    private TicketInfo second = new TicketInfo(2, 5000, "BCN", "LED", 250);
    private TicketInfo third = new TicketInfo(3, 7000, "LED", "DME", 40);
    private TicketInfo fourth = new TicketInfo(4, 2500, "VNU", "LED", 45);
    private TicketInfo fifth = new TicketInfo(5, 8000, "SVO", "LED", 60);
    private TicketInfo sixth = new TicketInfo(6, 3500, "LED", "BCN", 270);
    private TicketInfo seventh = new TicketInfo(7, 6000, "VKO", "LED", 45);
    private TicketInfo eighth = new TicketInfo(8, 4500, "LED", "DME", 40);
    private TicketInfo ninth = new TicketInfo(9, 5500, "DME", "VKO", 15);
    private TicketInfo tenth = new TicketInfo(10, 7500, "LED", "DME", 40);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    @Test
    public void shouldPriceSort() {
        TicketInfo[] expected = new TicketInfo[]{fourth, first, sixth, eighth, second, ninth, seventh, third, tenth, fifth};
        TicketInfo[] actual = repository.findAll();
        Arrays.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindFromTo() {
        TicketInfo[] actual = manager.findAll("LED", "dmE");
        TicketInfo[] expected = new TicketInfo[]{eighth, third, tenth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindNoOne() {
        TicketInfo[] actual = manager.findAll("BCN", "DME");
        TicketInfo[] expected = new TicketInfo[]{};
        assertArrayEquals(actual, expected);
    }

}
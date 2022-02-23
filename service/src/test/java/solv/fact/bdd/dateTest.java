package solv.fact.bdd;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class dateTest {

    @Test
    void compareTest() {
        LocalDateTime now = LocalDateTime.now();
        Comparator<LocalDateTime> nowBetween = (o1, o2) -> o1.isAfter(now) ? -1 : o2.isBefore(now) ? 1 : 0;
        assertEquals(0, nowBetween.compare(now.minusDays(1), now.plusDays(1)));
        assertEquals(-1, nowBetween.compare(now.plusDays(1), now.plusDays(2)));
        assertEquals(1, nowBetween.compare(now.minusDays(2), now.minusDays(1)));
    }

}

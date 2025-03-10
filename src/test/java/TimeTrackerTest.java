import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class TimeTrackerTest {

    private List<TimeTracker> timeTrackers;

    @BeforeEach
    void setUp() {
        timeTrackers = new ArrayList<>();
    }

    @Test
    void testLogActivity() {
        TimeTracker activity = new TimeTracker("Swimming", 60, "2025-03-05");
        timeTrackers.add(activity);
        assertEquals(1, timeTrackers.size());
        assertEquals("Swimming", timeTrackers.get(0).getSportName());
        assertEquals(60, timeTrackers.get(0).getTimeSpent());
        assertEquals("2025-03-05", timeTrackers.get(0).getDate());
    }

    @Test
    void testCalculateTotalTime() {
        timeTrackers.add(new TimeTracker("Basketball", 90, "2025-03-09"));
        timeTrackers.add(new TimeTracker("Football", 20, "2025-03-08"));
        timeTrackers.add(new TimeTracker("Swimming", 70, "2025-03-06"));

        int totalMinutes = timeTrackers.stream().mapToInt(TimeTracker::getTimeSpent).sum();
        assertEquals(180, totalMinutes);
    }

    @Test
    void testEmptyActivityList() {
        assertTrue(timeTrackers.isEmpty(), "List should be empty at the start");
    }

    @Test
    void testViewActivities() {
        timeTrackers.add(new TimeTracker("Tennis", 90, "2025-03-07"));
        assertFalse(timeTrackers.isEmpty(), "List should not be empty after adding an activity");
        assertEquals(1, timeTrackers.size());
        assertEquals("Tennis", timeTrackers.get(0).getSportName());
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main = new Main();

    @Test
    public void SetupTest() {
        main.checkbook = "Some value";
        main.currentBalance = 5;

        assertEquals(main.checkbook, "Some value"); // Test checkbook
        assertEquals(main.currentBalance, 5); // Test currentBalance

        main.Setup("1233.00\n125 Boat;! 24.80?\n123 Flowers 93.50;\n127 Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n", 9000); // Call method

        assertNotEquals(main.checkbook, "125 Market 125.45\n126 Hardware 34.95\n127 Video 7.45\n128 Book 14.32\n129 Gasoline 16.10"); // Test checkbook
        assertNotEquals(main.currentBalance, 1000); // Test current balance
    }
}
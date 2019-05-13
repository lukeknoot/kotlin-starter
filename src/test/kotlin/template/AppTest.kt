package template

import mu.KLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppTest {
    @Test
    fun `test runs`() {
        logger.info("Running test")
        assertEquals(1, 1)
    }
    companion object: KLogging()
}

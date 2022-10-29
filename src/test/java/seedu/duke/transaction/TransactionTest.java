package seedu.duke.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// @@author bdthanh
class TransactionTest {
    Transaction transaction;

    @BeforeEach
    void initializeTest() {
        transaction = new Transaction("pen", "28sd37h2", "bui", 5,
                LocalDate.parse("2022-10-03"), 3.2);
    }

    @Test
    void getReturnDate_fiveDaysDuration_expectReturnDate5DaysFromCreatedDate() {
        assertEquals(LocalDate.parse("2022-10-08"), transaction.getReturnDate());
    }

    @Test
    void isFinished_finishedTx_expectTrue() {
        assertTrue(transaction.isFinished());
    }

    @Test
    void isFinished_notFinishedTx_expectFalse() {
        transaction = new Transaction("pen", "28sd37h2", "bui", 300,
                LocalDate.parse("2022-10-03"), 192);
        assertFalse(transaction.isFinished());
    }

    @Test
    void getItemIdTest() {
        assertEquals("28sd37h2", transaction.getItemId());
    }

    @Test
    void getBorrowerTest() {
        assertEquals("bui", transaction.getBorrower());
    }

    @Test
    void getDurationTest() {
        assertEquals(5, transaction.getDuration());
    }

    @Test
    void convertTransactionToFileFormatTest() {
        String transactionId = transaction.getTxId();
        assertEquals(transactionId + " | pen | 28sd37h2 | bui | 5 | 2022-10-03 | 3.2",
                transaction.convertTransactionToFileFormat());
    }

        //    @Test
        //    void updateDurationTest() {
        //        Transaction newTransaction = new Transaction(transaction.getTxId(), "pen", "28sd37h2", "bui", 300,
        //                LocalDate.parse("2022-10-03"), 192);
        //        assertEquals(newTransaction.toString(),
        //                transaction.update(300, 192));
    //      }
}
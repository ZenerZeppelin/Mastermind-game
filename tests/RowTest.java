import mastermind.Row;
import mastermind.Symbol;
import org.junit.Assert;
import org.junit.Test;

public class RowTest {
    @Test
    public void testRow(){
        Row row = new Row();
        row.addSymbol(Symbol.HEART);
        Assert.assertEquals(1, row.size());
    }
}

import mastermind.Row;
import mastermind.RowException;
import mastermind.Table;
import org.junit.Test;

public class TableTest {

    @Test
    public void testIsMatch(){
        Table table = new Table();
        try {
            System.out.println(table.isMatch(new Row(new String[]{"HEART", "HEART", "STAR", "STAR"})));
        } catch (RowException e) {
            e.printStackTrace();
        }
    }
}

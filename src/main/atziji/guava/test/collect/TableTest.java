package main.atziji.guava.test.collect;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * guava的Table，包含行、列、值的集合测试
 *
 * @author ZhuQiuPing
 *         on 2018/1/9
 */
public class TableTest {

    @Test
    public void TableTest(){
        Table<String, Integer, String> aTable = HashBasedTable.create();

        for (char a = 'A'; a <= 'C'; ++a) {
            for (Integer b = 1; b <= 3; ++b) {
                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
            }
        }

        System.out.println(aTable.column(2));
        System.out.println(aTable.row("B"));
        System.out.println(aTable.get("B", 2));

        System.out.println(aTable.contains("D", 1));
        System.out.println(aTable.containsColumn(3));
        System.out.println(aTable.containsRow("C"));
        System.out.println(aTable.columnMap());
        System.out.println(aTable.rowMap());

        System.out.println(aTable.remove("B", 3));
    }

    @Test
    public void test1() {
        List<Integer> xxx = Lists.newArrayList();
        xxx.add(123);
        xxx.add(124);
        xxx.add(125);
        xxx.add(126);
        xxx.add(127);
        xxx.add(128);
        xxx.add(129);
        xxx.add(130);

        Collections.sort(xxx, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        xxx.forEach(System.out::println);
    }

    @Test
    public void testBigDecimal() {
        double d = 4.45166917826E10;
        String ds = d + "";
        System.out.println(d);
        //BigDecimal bigDecimal = new BigDecimal(ds);
        //d = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //System.out.println(bigDecimal);

        //String str=new DecimalFormat("0.00").format(d);
        String str = new DecimalFormat("#############0.00 ").format(d);
        System.out.println(new Double(str));

        //NumberFormat numberFormat = NumberFormat.getInstance();
        //
        //numberFormat.setGroupingUsed(false);
        //System.out.println(numberFormat.format(d) instanceof String);
        //try {
        //Double ss = null;
        BigDecimal decimal = new BigDecimal(str);
        //System.out.println(decimal);
        //DecimalFormat decimalFormat = DecimalFormat.getInstance();
        //    System.out.println(numberFormat.parse(str, parsePosition));
        //} catch (ParseException e) {
        //    e.printStackTrace();
        //}
        //StringToNumber
        //numberFormat.parse()
    }
}

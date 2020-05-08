import java.io.*;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2020/5/8
 */
public class SqlTableShowUtil {

    public static void main (String [] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("SqlTableShowUtil.txt"));
        String line = null;
        String beforeTableName = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] columnArray = line.split("--g--");
//            System.out.println(line);
            //新的表
            if (!columnArray[0].equals(beforeTableName)) {
                System.out.println("\n\n\n表名\t表描述");
                System.out.printf("%s\t%s\n",columnArray[0].trim(),columnArray[1].trim());
                beforeTableName = columnArray[0];
                System.out.println("字段\t字段类型\t字段描述");
            }
            System.out.printf("%s\t%s\t%s\n",columnArray[2].trim(),columnArray[3].trim(),columnArray[4].trim());
        }
        bufferedReader.close();
    }

//  1.通过这个sql 撸出所有表和表字段
//SELECT
//concat(
//        ifnull( t1.table_name, 'NULL' ),
//		'--g--',
//    ifnull( t1.table_comment, 'NULL' ),
//		'--g--',
//    ifnull( t2.column_name, 'NULL' ),
//		'--g--',
//    ifnull( t2.column_type, 'NULL' ),
//		'--g--',
//    ifnull( t2.COLUMN_COMMENT, 'NULL' ),
//		'--g--',
//    ifnull( t2.COLUMN_DEFAULT, 'NULL' ),
//		'--gn--'
//                )
//    FROM
//    INFORMATION_SCHEMA.TABLES t1
//    LEFT JOIN information_schema.COLUMNS t2 ON t2.table_name = t1.table_name
//            WHERE
//    t1.table_schema = 'xfsgxgg'
//    AND t1.table_type = 'base table'
//    ORDER BY
//    t1.table_name;

//    2.通过上面那到数据 然后进行数据修正
//    修正换行
//    \n 替换成 空格
//    --gn-- 再替换成\n






}

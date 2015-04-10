import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import javax.sql.StatementEventListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by ds on 3/12/15.
 */
public class Selenium {



    public String[][] a2d() throws IOException {


        System.out.println("Number of lines = ");

        String csvFile = "./src/main/resources/Title_Validation.csv";
        BufferedReader br = null;
        String line = null;
        String[] column = null;
        int lines = 0;
        int columns = 0;
        String SplitBy = ",";
        String test_case_id = null;
        String url = null;
        String title_expected = null;

        //Print count results for checking

        System.out.println("Number of lones = " + lines);
        System.out.println("Number of lones = " + columns);



        //Counting lines and columns

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null){
            lines++;
            column = line.split(SplitBy);
            columns = column.length;
        }
        br.close();

        //Print count results for checking

        System.out.println("Number of lines = " + lines);
        System.out.println("Number of lines = " + columns);


        String s2d[][] = new String [lines][columns];
        br = new BufferedReader(new FileReader(csvFile));

        WebDriver driver = new FirefoxDriver();
        int i = 0;
        while ((line = br.readLine()) != null){
            String[] csv = line.split(SplitBy);

            test_case_id = csv[0];
            url = csv[1];
            title_expected = csv[2];

            driver.get(url);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            String title_actual = driver.getTitle();

            s2d[i][0] = test_case_id;
            s2d[i][1] = title_expected;
            s2d[i][2] = title_actual;

            i++;
        }

        driver.quit();
        br.close();
        return s2d;

    }

    public static void main(String[] args) throws IOException {
        Selenium selenium = new Selenium();
        selenium.a2d();
    }
}

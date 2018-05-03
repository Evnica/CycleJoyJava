/**
 * Class: CycleJoyIOServletTest
 * Version: 0.1
 * Created on 27.04.2018 with the help of IntelliJ IDEA (thanks!)
 * Author: Evnica
 * Description:
 */
public class CycleJoyIOServletTest
{
    @org.junit.Before
    public void setUp() throws Exception
    {

    }

    @org.junit.After
    public void tearDown() throws Exception
    {

    }

    @org.junit.Test
    public void readFile() throws Exception
    {
        System.out.println( CycleJoyIOServlet.readFile( "./data/night.json" ));
    }

}
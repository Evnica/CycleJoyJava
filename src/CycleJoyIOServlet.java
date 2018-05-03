import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Class: CycleJoyIOServlet
 * Version: 0.2
 * Created on 27.04.2018 with the help of IntelliJ IDEA (thanks!)
 * Author: Evnica
 * Description:
 */
@WebServlet("/CycleJoyIO")
public class CycleJoyIOServlet extends HttpServlet
{
    private static final long serialVersionUID = 1827645647L;
    private static final String[] paths = {"../webapps/CycleJoy/WEB-INF/data/night.json",
                                           "../webapps/CycleJoy/WEB-INF/data/kids.json",
                                           "../webapps/CycleJoy/WEB-INF/data/historical.json"};

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
    {
        String tripType = req.getParameter( "tripType" );
        String pois = "[]";
        switch (tripType){
            case "night":
                pois = readFile( paths[0] );
                break;
            case "kids":
                pois = readFile( paths[1] );
                break;
            case "historical":
                pois = readFile( paths[2] );
                break;
        }
        resp.setContentType( "application/json" );
        resp.setCharacterEncoding( "UTF-8" );
        resp.getWriter().write( pois );

    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
    {
        doGet( req, resp );
    }

    @Override
    protected void doPut( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
    {
        super.doPut( req, resp );
    }

    static String readFile( String path){
        String fileContent;
       Path pathToFile = Paths.get(path);

        try
        {
            fileContent = Files.lines(pathToFile).collect( Collectors.joining());
        } catch ( IOException e )
        {
            fileContent = pathToFile.toString() + Arrays.toString( e.getStackTrace() );
        }
        return fileContent;
    }
}

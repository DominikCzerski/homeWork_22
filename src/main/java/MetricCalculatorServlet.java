import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculatorMetric", urlPatterns = "/calculatorMetric")
public class MetricCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String meters = request.getParameter("meters");
        String centimeters = request.getParameter("centimeters");
        String milimeters = request.getParameter("milimeters");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if (!meters.isEmpty() && !centimeters.isEmpty() || !centimeters.isEmpty() && !milimeters.isEmpty() || !milimeters.isEmpty() && !meters.isEmpty()) {
            writer.println("<h1> Wypełnij tylko 1 pole</h1>" +
                    "<button onclick=\"location.href='/form.html'\">Go back</button>");
        } else if (!meters.isEmpty()) {
            writer.println("<h1> Podana wartość w przeliczeniu na:</h1> " +
                    "<h2>metry: " + MetricCalculator.meterConverter(Double.parseDouble(meters), "meters") + "</h2>"
                    +
                    "<h2>centymetry: " + MetricCalculator.meterConverter(Double.parseDouble(meters), "centimeters") + "</h2>"
                    +
                    "<h2>milimetry: " + MetricCalculator.meterConverter(Double.parseDouble(meters), "milimeters") + "</h2>" +
                    "<button onclick=\"location.href='/form.html'\">Go back</button>"
            );
        } else if (!centimeters.isEmpty()) {
            writer.println("<h1> Podana wartość w przeliczeniu na:</h1> " +
                    "<h2>metry: " + MetricCalculator.centimeterConverter(Double.parseDouble(centimeters), "meters") + "</h2>"
                    +
                    "<h2>centymetry: " + MetricCalculator.centimeterConverter(Double.parseDouble(centimeters), "centimeters") + "</h2>"
                    +
                    "<h2>milimetry: " + MetricCalculator.centimeterConverter(Double.parseDouble(centimeters), "milimeters") + "</h2>" +
                    "<button onclick=\"location.href='/form.html'\">Go back</button>"
            );
        } else if (!milimeters.isEmpty()) {
            writer.println("<h1> Podana wartość w przeliczeniu na:</h1> " +
                    "<h2>metry: " + MetricCalculator.milimeterConverter(Double.parseDouble(milimeters), "meters") + "</h2>"
                    +
                    "<h2>centymetry: " + MetricCalculator.milimeterConverter(Double.parseDouble(milimeters), "centimeters") + "</h2>"
                    +
                    "<h2>milimetry: " + MetricCalculator.milimeterConverter(Double.parseDouble(milimeters), "milimeters") + "</h2>" +
                    "<button onclick=\"location.href='/form.html'\">GoToCalculator</button>"
            );
        }
    }
}

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculatorWeight", urlPatterns = "/calculatorWeight")
public class WeightCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kilograms = request.getParameter("kilograms");
        String grams = request.getParameter("grams");
        String miligrams = request.getParameter("miligrams");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if (!kilograms.isEmpty() && !grams.isEmpty() || !grams.isEmpty() && !miligrams.isEmpty() || !miligrams.isEmpty() && !kilograms.isEmpty()) {
            writer.println("<h1> Wypełnij tylko 1 pole</h1>" +
                    "<button onclick=\"location.href='/form.html'\">Go back</button>");
        } else if (!kilograms.isEmpty()) {
            writer.println("<h1> Podana wartość w przeliczeniu na:</h1> " +
                    "<h2>kilogramy: " + WeightCalculator.kilogramsConverter(Double.parseDouble(kilograms), "kilograms") + "</h2>"
                    +
                    "<h2>gramy: " + WeightCalculator.kilogramsConverter(Double.parseDouble(kilograms), "grams") + "</h2>"
                    +
                    "<h2>miligramy: " + WeightCalculator.kilogramsConverter(Double.parseDouble(kilograms), "miligrams") + "</h2>" +
                    "<button onclick=\"location.href='/form.html'\">Go back</button>"
            );
        } else if (!grams.isEmpty()) {
            writer.println("<h1> Podana wartość w przeliczeniu na:</h1> " +
                    "<h2>kilogramy: " + WeightCalculator.gramsConverter(Double.parseDouble(grams), "kilograms") + "</h2>"
                    +
                    "<h2>gramy: " + WeightCalculator.gramsConverter(Double.parseDouble(grams), "grams") + "</h2>"
                    +
                    "<h2>miligramy: " + WeightCalculator.gramsConverter(Double.parseDouble(grams), "miligrams") + "</h2>" +
                    "<button onclick=\"location.href='/form.html'\">Go back</button>"
            );
        } else if (!miligrams.isEmpty()) {
            writer.println("<h1> Podana wartość w przeliczeniu na:</h1> " +
                    "<h2>kilogramy: " + WeightCalculator.miligramsConverter(Double.parseDouble(miligrams), "kilograms") + "</h2>"
                    +
                    "<h2>gramy: " + WeightCalculator.miligramsConverter(Double.parseDouble(miligrams), "grams") + "</h2>"
                    +
                    "<h2>miligramy: " + WeightCalculator.miligramsConverter(Double.parseDouble(miligrams), "miligrams") + "</h2>" +
                    "<button onclick=\"location.href='/form.html'\">GoToCalculator</button>"
            );
        }
    }
}

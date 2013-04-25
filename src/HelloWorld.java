

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        super();
    }

	//compteur généré par la servlet
    protected int compteur = 0;
    protected PrintWriter out;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	out = response.getWriter();
    	try {
    		// on ecrit ligne par ligne le code HTML a afficher chez le client
    		out.println("<html>");
    		out.println("<head>");
    		out.println("<title>Servlet HelloWorld</title>");
    		out.println("</head>");
    		out.println("<body>");
    		out.println("<h1>Servlet HelloWorld</h1>");
    		// on inserer ici la valeur du compteur en l'incrémentant au passage
    		out.println("<p>Nombre d'appels : "+(++compteur)+"</p>");
    		out.println("</body>");
    		out.println("</html>");
    	}
    	finally{
    		out.close();
    	}
    }

}

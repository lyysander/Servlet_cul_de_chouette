

import game.gui.Interaction.Type;
import game.gui.PlayerModel;
import game.network.GameService;
import game.network.IGameClient;
import game.network.IGameService;
import game.network.messages.GameStatus;
import game.network.messages.NetPlayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


@WebServlet("/ServletV1")
public class ServletV1 extends HttpServlet implements IGameClient{
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public ServletV1() {
        super();
        
        service = new GameService();
        service.refreshGameList();
    }

	//compteur généré par la servlet
    protected int compteur = 0;
    
    protected PrintWriter out;
    
    protected Session session;
    
    protected IGameService service;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	session = (new Configuration().configure().buildSessionFactory()).openSession();
    	
    	
    	
    	
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
    		// on insere ici la valeur du compteur en l'incrémentant au passage
    		out.println("<p>Nombre d'appels : "+(++compteur)+"</p>");
    		
    		//on affiche les infos des joueurs
    		getPlayersInfo(queryPlayers());
    		
    		
    		out.println("</body>");
    		out.println("</html>");
    	}
    	finally{
    		out.close();
    	}
    }
    
    
    public List<PlayerModel> queryPlayers() {
    	
		session.beginTransaction();
		
	    Query query = session.createQuery("from PlayerModel");                 
	    List <PlayerModel>list = query.list();
//	    java.util.Iterator<PlayerModel> iter = list.iterator();
//	    while (iter.hasNext()) {
//	
//	        PlayerModel player = iter.next();
//	        System.out.println("Player: " + player.getPlayerLogin() +", " + player.getPlayerPassword()+", " + player.getPlayerAge()+", " + player.getPlayerSex()+", " + player.getPlayerCity());
//	
//	    }
	
	    session.getTransaction().commit();
	    
	    return query.list();
	
	}
    
    public void getPlayersInfo(List <PlayerModel>list){
    	
	    java.util.Iterator<PlayerModel> iter = list.iterator();
	    while (iter.hasNext()) {
	
	        PlayerModel player = iter.next();
	        System.out.println("Player: " + player.getPlayerLogin() +
	        		", " + player.getPlayerPassword()+
	        		", " + player.getPlayerAge()+
	        		", " + player.getPlayerSex()+
	        		", " + player.getPlayerCity());
	        
	        out.println("<p>Login joueur : "+(player.getPlayerLogin())+"</p>");
	        out.println("<p>Age joueur : "+(player.getPlayerAge())+"</p>");
	        out.println("<p>Sexe joueur : "+(player.getPlayerSex())+"</p>");
	        out.println("<p>Ville joueur : "+(player.getPlayerCity())+"</p>");
	
	    }
    }


	@Override
	public void handleInvit(NetPlayer creator, NetPlayer guest) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleJoinAnswer(NetPlayer creator, NetPlayer guest) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleStatus(GameStatus status) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleStart(GameStatus status) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleRefresh() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleWaitingNotification(NetPlayer player) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleInteraction(NetPlayer creator, NetPlayer player, Type type) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleKick(NetPlayer c, NetPlayer p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleCancelGame(NetPlayer c) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleLeaveGame(NetPlayer c, NetPlayer p) {
		// TODO Auto-generated method stub
		
	}

}

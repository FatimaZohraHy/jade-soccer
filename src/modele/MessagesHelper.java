package modele;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import java.util.stream.Stream;

public class MessagesHelper {
	   public static ACLMessage createBallonQuery(AID receiverId){
	        ACLMessage demandeBallon = new ACLMessage(ACLMessage.QUERY_IF);
	        demandeBallon.setOntology(MessagesConstantes.ONTOLOGY_BALLON);
	        demandeBallon.addReceiver(receiverId);
	        demandeBallon.setContent(MessagesConstantes.QUERY_BALLON);
	        return demandeBallon;
	   }
	  
	        public static ACLMessage createDebutDuMatchRequest(Stream<AID> joueursIds){
	            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
	            msg.setOntology(MessagesConstantes.ONTOLOGY_TEMPS);
	            joueursIds.forEach(msg::addReceiver);
	            msg.setContent(MessagesConstantes.REQUEST_DEBUT_MATCH);
	            return msg;
	        }
	        
	        

	        public static ACLMessage createFinDuMatchRequest(Stream<AID> joueursIds){
	            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
	            msg.setOntology(MessagesConstantes.ONTOLOGY_TEMPS);
	            joueursIds.forEach(msg::addReceiver);
	            msg.setContent(MessagesConstantes.REQUEST_FIN_MATCH);
	            return msg;
	        }
	        
	        


}

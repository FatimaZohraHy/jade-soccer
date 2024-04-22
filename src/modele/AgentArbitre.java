package modele;


import controller.AgentHandler;
import controller.GameObject;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

import java.awt.*;

public class AgentArbitre extends GameObject {
    private int scoreEquipe1 = 0;
    private int scoreEquipe2 = 0;
    private int tempsDeJeu = 0;
    private Position pos;
    private AgentHandler handler;
    private boolean coupDEnvoiDonne;

    public void sifflerCoupDEnvoi() {
        send(MessagesHelper.createDebutDuMatchRequest(handler.getJoueursIds()));
        coupDEnvoiDonne = true;
    }

    protected void setup() {
        Object[] args = getArguments();
        tempsDeJeu = (int) args[0];
        handler = (AgentHandler) args[1];
        handler.getObjects().add(this);
        handler.setArbitreId(this.getAID());

        addBehaviour(new TickerBehaviour(this, 1000) {
            protected void onTick() {
                // perform operation Y
                System.out.println(tempsDeJeu + " minutes jouées");
                if (tempsDeJeu >= 90 * 60) {
                    sifflerFinDuMatch();
                    myAgent.doDelete();
                } else if (coupDEnvoiDonne)
                    tempsDeJeu++;
            }
        });
    }

    public void sifflerFinDuMatch() {
        send(MessagesHelper.createFinDuMatchRequest(handler.getJoueursIds()));
    }

    protected void takeDown() {
        System.out.println("Agent " + getLocalName() + ": terminating");
    }

    @Override
    public void render(Graphics g) {
        int minutes = tempsDeJeu / 60;
        int secondes = tempsDeJeu % 60;
        StringBuilder sb = new StringBuilder();
        sb.append("[Equipe1] ")
                .append(scoreEquipe1)
                .append("-")
                .append(scoreEquipe2)
                .append(" [Equipe2] | [");
        if (minutes < 10)
            sb.append("0");
        sb.append(minutes);
        sb.append(":");
        if (secondes < 10)
            sb.append("0");
        sb.append(secondes);
        sb.append("]");
        g.setColor(Color.BLACK);
        g.drawString(sb.toString(), 20, 20);
    }

    public void inscrireBut(int numeroEquipe) {
        if(numeroEquipe == 1)
            scoreEquipe1++;
        else
            scoreEquipe2++;
    }
}
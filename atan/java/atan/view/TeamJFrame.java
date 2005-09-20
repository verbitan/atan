package atan.view;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

import atan.model.Team;

public class TeamJFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    TeamJPanel teamPanel = new TeamJPanel();
    Border border1;

    public TeamJFrame() {
        try {
            setSize(600, 500);
            setLocation(50, 50);
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TeamJFrame(Team t) {
        this();
        try {
            TeamModel m = new TeamModel();
            m.setModel(t);
            this.setModel(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        border1 = BorderFactory.createEmptyBorder(4, 4, 4, 4);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                this_windowClosing(e);
            }
        });
        teamPanel.setBorder(border1);
        this.getContentPane().add(teamPanel, BorderLayout.CENTER);
    }

    public void setModel(TeamModel t) {
        teamPanel.setModel(t);
        setTitle("Atan " + t.getModel().getTeamName());
    }

    void this_windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
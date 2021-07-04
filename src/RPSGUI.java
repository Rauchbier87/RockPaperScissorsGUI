import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Random;

public class RPSGUI extends JFrame {
    JTextArea area;
    //int scoreY = 0; make score keeper section
    //int scoreC = 0;
    private static final String[] rps = {"Rock", "Paper", "Scissors"};

    public RPSGUI(){
      init();
    }

    public final void init(){ //fix alignment below
        JPanel p = new JPanel();
        setLayout(new FlowLayout());
        p.setEnabled(true);
        setEnabled(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Rock Paper Scissors");
        setLocationRelativeTo(null);
        setSize(500,200);
        setVisible(true);
        add(p);

        p.add(Box.createRigidArea(new Dimension(0, 50)));
        area = new JTextArea();
        area.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        area.setText("Ready to play?");
        area.setBackground(Color.LIGHT_GRAY);
        area.setVisible(true);
        area.setSize(20,10);
        area.setAlignmentX(0.5f);
        p.add(area);

        p.add(Box.createRigidArea(new Dimension(0, 10)));
        JButton b1 = new JButton("Rock");
        b1.setAlignmentX(0.5f);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  shoot("rock");
            }
        });
        p.add(b1);

        p.add(Box.createRigidArea(new Dimension(0, 10)));
        JButton b2 = new JButton("Paper");
        b2.setAlignmentX(0.5f);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shoot("paper");
            }
        });
        p.add(b2);

        p.add(Box.createRigidArea(new Dimension(0, 10)));
        JButton b3 = new JButton("Scissors");
        b3.setAlignmentX(0.5f);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shoot("scissors");
            }
        });
        p.add(b3);
        revalidate();
    }

    public void shoot(String s){
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(20));
        }catch (Exception a){System.out.println("failed to sleep");}
        int x = random.nextInt(3);
        String comp = rps[x];
        area.setText("You: " + s + "\nCOMP: " + comp);
        if (s.equals("rock") && comp.equals("Paper")){
            area.append("\nNo Dice!!!");
        }else if (s.equals("rock") && comp.equals("Scissors")){
            area.append("\nLucky shot.");
        }else  if (s.equals("paper") && comp.equals("Rock")){
            area.append("\nLucky shot.");
        }else  if (s.equals("paper") && comp.equals("Scissors")){
            area.append("\nNo Dice!!!");
        }else  if (s.equals("scissors") && comp.equals("Rock")){
            area.append("\nNo Dice!!!");
        }else  if (s.equals("scissors") && comp.equals("Paper")){
            area.append("\nLucky shot.");
        }else  if (s.equals(comp.toLowerCase(Locale.ROOT))){
            area.append("\nTie, try again.");
        }
    }

    public static void main(String[] args){
       new RPSGUI();
    }
}

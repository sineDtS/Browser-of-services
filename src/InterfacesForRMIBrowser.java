import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class InterfacesForRMIBrowser {
    public  interface ServiceServer extends Remote {
        Object[] getServiceList() throws RemoteException;
        Service getService(Object serviceKey) throws RemoteException;
    }

    public interface Service extends Serializable {
        public JPanel getGuiPanel();
    }

    public static class DiceService implements Service {
        JPanel panel;
        int numOfDiceToRoll;
        ArrayList<Integer> numOfDigit = new ArrayList<>();
        JLabel label;
        JComboBox numOfDice;
        DrowPa drow;

        @Override
        public JPanel getGuiPanel() {
            panel = new JPanel();
            panel.setLayout(new BorderLayout());
            JPanel panelForTools = new JPanel();
            drow = new DrowPa();
            drow.setPreferredSize(new Dimension(400,400));
            JButton button = new JButton("Roll `em!");
            String[] choices = {"1", "2", "3", "4"};
            numOfDice = new JComboBox(choices);
            label = new JLabel("Dice values here:");
            panelForTools.add(numOfDice);
            panelForTools.add(button);
            panelForTools.add(label);
            button.addActionListener(new RollEmListener());
            panel.add(BorderLayout.NORTH, panelForTools);
            panel.add(BorderLayout.CENTER, drow);
            return panel;
        }

        class DrowPa extends JPanel {

            public void template(Graphics g, int ww, int hh, int w, int h) {
                g.fillOval((getWidth() / 2) + ww, (getHeight() / 2) + hh, w, h);
            }

            public void paintNumOfSquareOne(Graphics g , ArrayList<Integer> arr) {
                int w = 20;
                int h = 20;
                g.setColor(Color.black);
                if (arr.get(0) == 1) {
                    template(g, -10, -50, w,h);
                }
                if (arr.get(0) == 2) {
                    template(g, -35, -50, w,h);
                    template(g, 15, -50, w,h);
                }
                if (arr.get(0) == 3) {
                    template(g, -35, -25, w,h);
                    template(g, -10, -50, w,h);
                    template(g, 15, -75, w,h);
                }
                if (arr.get(0) == 4) {
                    template(g, -35, -25, w,h);
                    template(g, 15, -25, w,h);
                    template(g, -35, -75, w,h);
                    template(g, 15, -75, w,h);
                }
                if (arr.get(0) == 5) {
                    template(g, -35, -25, w,h);
                    template(g, 15, -25, w,h);
                    template(g, -35, -75, w,h);
                    template(g, 15, -75, w,h);
                    template(g, -10, -50, w,h);
                }
                if (arr.get(0) == 6) {
                    template(g, -35, -25, w,h);
                    template(g, 15, -25, w,h);
                    template(g, -35, -75, w,h);
                    template(g, 15, -75, w,h);
                    template(g, -10, -25, w,h);
                    template(g, -10, -75, w,h);
                }
            }

            public void paintNumOfSquareDown(Graphics g , ArrayList<Integer> arr) {
                int w = 20;
                int h = 20;
                g.setColor(Color.black);
                if (arr.get(1) == 1) {
                    template(g, -10, 50, w,h);
                }
                if (arr.get(1) == 2) {
                    template(g, -35, 50, w,h);
                    template(g, 15, 50, w,h);
                }
                if (arr.get(1) == 3) {
                    template(g, -35, 75, w,h);
                    template(g, -10, 50, w,h);
                    template(g, 15, 25, w,h);
                }
                if (arr.get(1) == 4) {
                    template(g, -35, 75, w,h);
                    template(g, 15, 75, w,h);
                    template(g, -35, 25, w,h);
                    template(g, 15, 25, w,h);
                }
                if (arr.get(1) == 5) {
                    template(g, -35, 75, w,h);
                    template(g, 15, 75, w,h);
                    template(g, -35, 25, w,h);
                    template(g, 15, 25, w,h);
                    template(g, -10, 50, w,h);
                }
                if (arr.get(1) == 6) {
                    template(g, -35, 75, w,h);
                    template(g, 15, 75, w,h);
                    template(g, -35, 25, w,h);
                    template(g, 15, 25, w,h);
                    template(g, -10, 75, w,h);
                    template(g, -10, 25, w,h);
                }
            }

            public void paintNumOfSquareLeft(Graphics g , ArrayList<Integer> arr) {
                int w = 20;
                int h = 20;
                g.setColor(Color.black);
                if (arr.get(2) == 1) {
                    template(g, -110, -50, w,h);
                }
                if (arr.get(2) == 2) {
                    template(g, -135, -50, w,h);
                    template(g, -85, -50, w,h);
                }
                if (arr.get(2) == 3) {
                    template(g, -135, -25, w,h);
                    template(g, -110, -50, w,h);
                    template(g, -85, -75, w,h);
                }
                if (arr.get(2) == 4) {
                    template(g, -135, -25, w,h);
                    template(g, -85, -25, w,h);
                    template(g, -135, -75, w,h);
                    template(g, -85, -75, w,h);
                }
                if (arr.get(2) == 5) {
                    template(g, -135, -25, w,h);
                    template(g, -85, -25, w,h);
                    template(g, -135, -75, w,h);
                    template(g, -85, -75, w,h);
                    template(g, -110, -50, w,h);
                }
                if (arr.get(2) == 6) {
                    template(g, -135, -25, w,h);
                    template(g, -85, -25, w,h);
                    template(g, -135, -75, w,h);
                    template(g, -85, -75, w,h);
                    template(g, -110, -25, w,h);
                    template(g, -110, -75, w,h);
                }
            }

            public void paintNumOfSquareRight(Graphics g , ArrayList<Integer> arr) {
                int w = 20;
                int h = 20;
                g.setColor(Color.black);
                if (arr.get(3) == 1) {
                    template(g, 90, -50, w,h);
                }
                if (arr.get(3) == 2) {
                    template(g, 65, -50, w,h);
                    template(g, 115, -50, w,h);
                }
                if (arr.get(3) == 3) {
                    template(g, 65, -25, w,h);
                    template(g, 90, -50, w,h);
                    template(g, 115, -75, w,h);
                }
                if (arr.get(3) == 4) {
                    template(g, 65, -25, w,h);
                    template(g, 115, -25, w,h);
                    template(g, 65, -75, w,h);
                    template(g, 115, -75, w,h);
                }
                if (arr.get(3) == 5) {
                    template(g, 65, -25, w,h);
                    template(g, 115, -25, w,h);
                    template(g, 65, -75, w,h);
                    template(g, 115, -75, w,h);
                    template(g, 90, -50, w,h);
                }
                if (arr.get(3) == 6) {
                    template(g, 65, -25, w,h);
                    template(g, 115, -25, w,h);
                    template(g, 65, -75, w,h);
                    template(g, 115, -75, w,h);
                    template(g, 90, -25, w,h);
                    template(g, 90, -75, w,h);
                }
            }

            public void paintDownSquare(Graphics g) {
                g.setColor(Color.red);
                g.fillRect((getWidth() / 2) - 40, (getHeight() / 2) + 20, 80,80);
            }

            public void paintRightSquare(Graphics g) {
                g.setColor(Color.red);
                g.fillRect((getWidth() / 2) + 60, (getHeight() / 2) - 80, 80,80 );
            }

            public void paintLeftSquare(Graphics g) {
                g.setColor(Color.red);
                g.fillRect((getWidth() / 2) - 140, (getHeight() / 2) - 80, 80,80);
            }

            public void paintOneSquare(Graphics g) {
                g.setColor(Color.red);
                g.fillRect((getWidth() / 2) - 40, (getHeight() / 2) - 80, 80,80);
            }

            public void paintComponent(Graphics g) {
                switch (numOfDiceToRoll) {
                    case 1 : paintOneSquare(g);
                             paintNumOfSquareOne(g, numOfDigit);  break;

                    case 2 : paintOneSquare(g);
                             paintNumOfSquareOne(g, numOfDigit);

                             paintDownSquare(g);
                             paintNumOfSquareDown(g, numOfDigit); break;

                    case 3 : paintOneSquare(g);
                             paintNumOfSquareOne(g, numOfDigit);

                             paintLeftSquare(g);
                             paintNumOfSquareLeft(g,numOfDigit);

                             paintRightSquare(g);
                             paintNumOfSquareRight(g,numOfDigit); break;

                    case 4 : paintOneSquare(g);
                             paintNumOfSquareOne(g, numOfDigit);

                             paintDownSquare(g);
                             paintNumOfSquareDown(g, numOfDigit);

                             paintLeftSquare(g);
                             paintNumOfSquareLeft(g,numOfDigit);

                             paintRightSquare(g);
                             paintNumOfSquareRight(g,numOfDigit); break;
                }
            }
        }

        class RollEmListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = (String) numOfDice.getSelectedItem();
                numOfDiceToRoll = Integer.parseInt(Objects.requireNonNull(selection));
                for (int i = 0; i < numOfDiceToRoll; i++) {
                    int r = (int) ((Math.random() * 6) + 1);
                    numOfDigit.add(i, r);
                }
                ServiceBrowser.mainPanel.repaint();
                drow.repaint();
            }
        }
    }

    public static class MiniMusicService implements Service {

        MyDrowPanel myPanel;

        public JPanel getGuiPanel() {
            JPanel mainPanel = new JPanel();
            myPanel = new MyDrowPanel();
            JButton playItButton = new JButton("Play it");
            playItButton.addActionListener(new PlayItListener());
            mainPanel.add(myPanel);
            mainPanel.add(playItButton);
            return mainPanel;
        }

        public class PlayItListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Sequencer sequencer = MidiSystem.getSequencer();
                    sequencer.open();

                    sequencer.addControllerEventListener(myPanel, new int[] {127});
                    Sequence seq = new Sequence(Sequence.PPQ, 4);
                    Track track = seq.createTrack();

                    for (int i = 0; i < 100; i+= 4) {

                        int rNum = (int) ((Math.random() + 50) + 1);
                        track.add(makeEvent(144,1,rNum,100,i));
                        track.add(makeEvent(176,1,127,0,i));
                        track.add(makeEvent(128,1,rNum,100,i + 2));
                    }

                    sequencer.setSequence(seq);
                    sequencer.start();
                    sequencer.setTempoInBPM(220);
                } catch (Exception ex) {ex.printStackTrace();}
            }
        }

        public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
            MidiEvent event = null;
            try {
                ShortMessage a = new ShortMessage();
                a.setMessage(comd,chan,one,two);
                event = new MidiEvent(a, tick);
            } catch (Exception e) {}
            return event;
        }

        class MyDrowPanel extends JPanel implements ControllerEventListener {
            boolean msg = false;

            public void controlChange(ShortMessage event) {
                msg = true;
                repaint();
            }

            public Dimension getPreferredSize() {
                return new Dimension(300,300);
            }

            public void paintComponent(Graphics g) {
                if (msg) {
                    Graphics2D g2 = (Graphics2D) g;

                    int r = (int) (Math.random() * 250);
                    int gr = (int) (Math.random() * 250);
                    int b = (int) (Math.random() * 250);

                    g.setColor(new Color(r,gr,b));

                    int ht = (int) ((Math.random() * 120) +10);
                    int width = (int) ((Math.random() * 120) + 10);

                    int x = (int) ((Math.random() * 40) + 10);
                    int y = (int) ((Math.random() * 40) + 10);

                    g.fillRect(x,y,ht,width);
                    msg = false;
                }
            }
        }
    }

    public static class DayOfTheWeekService implements Service {
        JLabel outputLabel;
        JComboBox month;
        JTextField day;
        JTextField year;


        @Override
        public JPanel getGuiPanel() {
            JPanel panel = new JPanel();
            JButton button = new JButton("Do it!");
            button.addActionListener(new DoItListener());
            outputLabel = new JLabel("date appears here");
            DateFormatSymbols dateStuff = new DateFormatSymbols();
            month = new JComboBox(dateStuff.getMonths());
            day = new JTextField(8);
            year = new JTextField(8);
            JPanel inputPanel = new JPanel(new GridLayout(3,2));
            inputPanel.add(new JLabel("Month"));
            inputPanel.add(month);
            inputPanel.add(new JLabel("Day"));
            inputPanel.add(day);
            inputPanel.add(new JLabel("Year"));
            inputPanel.add(year);
            panel.add(inputPanel);
            panel.add(button);
            panel.add(outputLabel);
            return panel;
        }

        public class DoItListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                int monthNum = month.getSelectedIndex();
                int dayNum = Integer.parseInt(day.getText());
                int yearNum = Integer.parseInt(year.getText());
                Calendar c = Calendar.getInstance();
                c.set(Calendar.MONTH, monthNum);
                c.set(Calendar.DAY_OF_MONTH, dayNum);
                c.set(Calendar.YEAR, yearNum);
                Date date = c.getTime();
                String dayOfWeek = (new SimpleDateFormat("EEEE")).format(date);
                outputLabel.setText(dayOfWeek);
            }
        }
    }

}

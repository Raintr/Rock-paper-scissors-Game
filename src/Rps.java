import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

class Computer {
    public Computer() {
        this.ComputerHand();
    }

    public int ComputerHand() {
        Random random = new Random();
        int rnd = random.nextInt(3) + 1;
        return (rnd);
    }
}

public class Rps extends Frame {
    private Label lb;
    private Button bt1;
    private Button bt2;
    private Button bt3;

    public static void main(String[] args) {
        new Rps();
    }

    public Rps() {
        super("じゃんけんゲーム");
        setLayout(null);

        lb = new Label("じゃんけん");
        lb.setBounds(110, 55, 600, 250);
        add(lb);
        lb.setFont(new Font("selif", Font.BOLD, 90));

        bt1 = new Button("グー");
        bt1.setBounds(50, 350, 200, 80);
        add(bt1);
        bt1.addActionListener(new Report5ActionListener());
        bt1.setFont(new Font("selif", Font.PLAIN, 30));

        bt2 = new Button("チョキ");
        bt2.setBounds(250, 350, 200, 80);
        add(bt2);
        bt2.addActionListener(new Report5ActionListener());
        bt2.setFont(new Font("selif", Font.PLAIN, 30));

        bt3 = new Button("パー");
        bt3.setBounds(450, 350, 200, 80);
        add(bt3);
        bt3.addActionListener(new Report5ActionListener());
        bt3.setFont(new Font("selif", Font.PLAIN, 30));

        addWindowListener(new Report5WindowListener());

        setSize(700, 500);
        setVisible(true);

        new Computer();

    }

    class Report5WindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    class Report5ActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Computer cp = new Computer();
            String hand = "じゃんけん";

            if (cp.ComputerHand() == 1) {
                hand = "グー";
                lb.setText(hand);
                lb.setBounds(230, 55, 400, 250);

            } else if (cp.ComputerHand() == 2) {
                hand = "チョキ";
                lb.setText(hand);
                lb.setBounds(200, 55, 400, 250);
            } else if (cp.ComputerHand() == 3) {
                hand = "パー";
                lb.setText(hand);
                lb.setBounds(230, 55, 400, 250);
            }

        }
    }

}

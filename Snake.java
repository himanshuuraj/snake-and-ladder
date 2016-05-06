/*
 * Decompiled with CFR 0_114.
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.PrintStream;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Snake
extends JFrame
implements MouseMotionListener,
ActionListener {
    int in1 = 1;
    int in2 = 1;
    int initial = 0;
    int x;
    int y;
    int i = 0;
    int j = 0;
    JLabel status = new JLabel();
    JLabel jn;
    JLabel label1;
    JLabel label2;
    JLabel instruct;
    JButton newgame;
    JButton exitgame;
    JTextField show_point;
    Font f;
    Integer p1_counter = 0;
    Integer points1 = 0;
    Integer p2_counter = 0;
    Integer points2 = 0;

    public Snake() {
        this.setTitle("Background Color for JFrame");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.jn = new JLabel(new ImageIcon("C:\\workspace\\Snake\\src\\a.jpg"));
        this.add(this.jn);
        this.jn.setLayout(null);
        this.label1 = new JLabel(new ImageIcon("C:\\workspace\\Snake\\src\\ab.jpg"));
        this.label2 = new JLabel(new ImageIcon("C:\\workspace\\Snake\\src\\dice.jpg"));
        this.jn.add(this.label1);
        this.jn.add(this.label2);
        this.newgame = new JButton("New Game");
        this.newgame.addActionListener(this);
        this.exitgame = new JButton("Exit Game");
        this.exitgame.addActionListener(this);
        this.instruct = new JLabel();
        this.show_point = new JTextField();
        this.show_point.setEditable(false);
        this.show_point.addActionListener(this);
        this.jn.add(this.newgame);
        this.jn.add(this.exitgame);
        this.jn.add(this.instruct);
        this.jn.add(this.show_point);
        this.initialise();
        JButton jb = new JButton("P1");
        this.jn.add(jb);
        jb.addActionListener(this);
        jb.setBounds(598, 382, 62, 42);
        JButton jb1 = new JButton("P2");
        this.jn.add(jb1);
        jb1.addActionListener(this);
        jb1.setBounds(598, 444, 62, 42);
        this.setSize(750, 700);
        this.setResizable(false);
        this.initialise();
    }

    public static void main(String[] args) {
        new Snake();
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        int x = arg0.getX();
        int y = arg0.getY();
        System.out.println(x);
        System.out.println(y);
    }

    void start() {
        if (this.initial % 2 == 0) {
            this.instruct.setText("P2's turn");
            this.show_point.setText(this.p1_counter.toString());
            this.show_point.setFont(this.f);
            this.points1 = this.points1 + this.p1_counter;
            if (this.points1 > 100) {
                this.points1 = this.points1 - this.p1_counter;
            }
            this.win(this.points1);
            this.points1 = this.ladder(this.points1);
            this.points1 = this.snake(this.points1);
            System.out.println(this.points1);
            this.setij(this.points1);
            this.label1.setBounds(2 + this.i * 53, 25 + this.j * 53, 95, 145);
            ++this.initial;
        } else {
            this.instruct.setText("P1's turn");
            this.show_point.setText(this.p2_counter.toString());
            this.show_point.setFont(this.f);
            this.points2 = this.points2 + this.p2_counter;
            if (this.points2 > 100) {
                this.points2 = this.points2 - this.p2_counter;
            }
            this.win(this.points2);
            this.points2 = this.ladder(this.points2);
            this.points2 = this.snake(this.points2);
            System.out.println(this.points2);
            this.setij(this.points2);
            this.label2.setBounds(2 + this.i * 53, 25 + this.j * 53, 95, 145);
            ++this.initial;
        }
    }

    public void initialise() {
        this.i = 0;
        this.j = 9;
        this.label1.setBounds(2 + this.i * 53, 25 + this.j * 53, 95, 145);
        this.label2.setBounds(2 + this.i * 53, 25 + this.j * 53, 95, 145);
        this.newgame.setBounds(600, 540, 110, 40);
        this.exitgame.setBounds(600, 580, 110, 40);
        this.instruct.setBounds(580, 71, 110, 40);
        this.instruct.setText("P1's turn");
        this.show_point.setBounds(582, 210, 112, 112);
        this.show_point.setText("0");
        this.f = new Font("Times New Roman", 1, 72);
        this.show_point.setFont(this.f);
    }

    public void win(int d) {
        if (d == 100) {
            int a = 1;
            a = JOptionPane.showConfirmDialog(null, "you won");
            if (a == 0) {
                this.dispose();
            }
        }
    }

    public int ladder(int d) {
        if (d == 17) {
            return 37;
        }
        if (d == 10) {
            return 28;
        }
        if (d == 31) {
            return 70;
        }
        if (d == 45) {
            return 84;
        }
        if (d == 78) {
            return 97;
        }
        return d;
    }

    public int snake(int d) {
        if (d == 95) {
            return 73;
        }
        if (d == 79) {
            return 59;
        }
        if (d == 68) {
            return 48;
        }
        if (d == 44) {
            return 21;
        }
        if (d == 34) {
            return 16;
        }
        return d;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int d;
        Random r = new Random();
        if (ae.getActionCommand().equals("P1")) {
            if (this.initial % 2 != 0) {
                return;
            }
            d = r.nextInt(6);
            this.p1_counter = ++d;
            this.start();
        }
        if (ae.getActionCommand().equals("P2")) {
            if (this.initial % 2 == 0) {
                return;
            }
            System.out.println(this.initial);
            d = r.nextInt(6);
            this.p2_counter = ++d;
            this.start();
        }
        if (ae.getActionCommand().equals("New Game")) {
            this.initialise();
        }
        if (ae.getActionCommand().equals("Exit Game")) {
            System.exit(0);
        }
    }

    public void setij(int d) {
        int c = d % 10;
        if (d < 10 && d > 0) {
            this.i = c - 1;
            this.j = 9;
        }
        if (d < 20 && d > 10) {
            this.i = 10 - c;
            this.j = 8;
        }
        if (d < 30 && d > 20) {
            this.i = c - 1;
            this.j = 7;
        }
        if (d < 40 && d > 30) {
            this.i = 10 - c;
            this.j = 6;
        }
        if (d < 50 && d > 40) {
            this.i = c - 1;
            this.j = 5;
        }
        if (d < 60 && d > 50) {
            this.i = 10 - c;
            this.j = 4;
        }
        if (d < 70 && d > 60) {
            this.i = c - 1;
            this.j = 3;
        }
        if (d < 80 && d > 70) {
            this.i = 10 - c;
            this.j = 2;
        }
        if (d < 90 && d > 80) {
            this.i = c - 1;
            this.j = 1;
        }
        if (d < 100 && d > 90) {
            this.i = 10 - c;
            this.j = 0;
        }
        if (d == 10) {
            this.i = 9;
            this.j = 0;
        }
        if (d == 30) {
            this.i = 9;
            this.j = 3;
        }
        if (d == 50) {
            this.i = 9;
            this.j = 5;
        }
        if (d == 70) {
            this.i = 9;
            this.j = 6;
        }
        if (d == 90) {
            this.i = 9;
            this.j = 8;
        }
        if (d == 0) {
            this.i = 0;
            this.j = 9;
        }
        if (d == 20) {
            this.i = 0;
            this.j = 8;
        }
        if (d == 40) {
            this.i = 0;
            this.j = 6;
        }
        if (d == 60) {
            this.i = 0;
            this.j = 4;
        }
        if (d == 80) {
            this.i = 0;
            this.j = 2;
        }
        if (d != 100) {
            return;
        }
        this.i = 0;
        this.j = 0;
    }
}


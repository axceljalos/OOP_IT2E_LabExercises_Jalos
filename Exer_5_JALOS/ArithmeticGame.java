package OOP_IT2E_LabExercises_Jalos.Exer_5_JALOS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ArithmeticGame extends JFrame {

    private JLabel numLabelA, opLabel, numLabelB, eqLabel;
    private JTextField ansField;
    private JButton startBtn;
    private JButton submitBtn;
    private JButton quitBtn;
    private JLabel correctLbl, wrongLbl;
    private JLabel answerMessageLbl;

    private JRadioButton addRadio, subRadio, mulRadio, divRadio, modRadio;
    private JRadioButton easyLvl, medLvl, hardLvl;
    private ButtonGroup opSelect, lvlSelect;

    private int resultValue;
    private int scoreCorrect = 0, scoreWrong = 0;

    Random generator = new Random();
    private String playerName;
    private int originalWidth = 520;
    private int originalHeight = 380;

    private Timer timer;
    private int timeRemaining = 60;
    private boolean timerStarted = false;
    private JLabel timerLbl;

    private Font originalNumFont = new Font("Arial", Font.BOLD, 24);
    private Font originalOpFont = new Font("Arial", Font.BOLD, 24);
    private Font originalAnsFont = new Font("Arial", Font.BOLD, 24);
    private Font originalBtnFont = new Font("Arial", Font.BOLD, 10);
    private Font originalMsgFont = new Font("Arial", Font.BOLD, 18);
    private Font originalScoreFont = new Font("Arial", Font.BOLD, 12);

    private static class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.LIGHT_GRAY);
            g.setColor(Color.GRAY);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            Random rand = new Random();
            for (int i = 0; i < 100; i++) {
                int x = rand.nextInt(getWidth());
                int y = rand.nextInt(getHeight());
                String symbol = "" + rand.nextInt(10);
                if (rand.nextBoolean()) {
                    String[] ops = {"+", "-", "×", "÷", "%"};
                    symbol = ops[rand.nextInt(ops.length)];
                }
                g.drawString(symbol, x, y);
            }
        }
    }

    public ArithmeticGame() {

        // --- USERNAME INPUT ---
        while (true) {
            playerName = JOptionPane.showInputDialog(null, "Enter Username:", "Player Login", JOptionPane.PLAIN_MESSAGE);
            if (playerName == null) {
                System.exit(0);
            }
            if (!playerName.trim().isEmpty()) break;
        }

        setTitle("Arithmetic Game - Player: " + playerName);
        setSize(520, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BackgroundPanel bg = new BackgroundPanel();
        setContentPane(bg);
        bg.setLayout(null);
        setLocationRelativeTo(null);

        // --- NUMBER LABELS ---
        numLabelA = new JLabel("0", SwingConstants.CENTER);
        numLabelA.setBounds(50, 50, 80, 60);
        numLabelA.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        numLabelA.setFont(new Font("Arial", Font.BOLD, 24));
        bg.add(numLabelA);

        opLabel = new JLabel("+", SwingConstants.CENTER);
        opLabel.setBounds(150, 60, 40, 40);
        opLabel.setFont(new Font("Arial", Font.BOLD, 2));
        bg.add(opLabel);

        numLabelB = new JLabel("0", SwingConstants.CENTER);
        numLabelB.setBounds(210, 50, 80, 60);
        numLabelB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        numLabelB.setFont(new Font("Arial", Font.BOLD, 24));
        bg.add(numLabelB);

        eqLabel = new JLabel("=", SwingConstants.CENTER);
        eqLabel.setFont(new Font("Arial", Font.BOLD, 24));
        eqLabel.setBounds(305, 50, 40, 40);
        bg.add(eqLabel);

        ansField = new JTextField();
        ansField.setBounds(350, 50, 100, 60);
        ansField.setFont(new Font("Arial", Font.BOLD, 24));
        ansField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        bg.add(ansField);

        startBtn = new JButton("Start");
        startBtn.setBounds(430, 320, 70, 25);
        startBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        bg.add(startBtn);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(430, 350, 70, 25);
        submitBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        bg.add(submitBtn);

        quitBtn = new JButton("Quit");
        quitBtn.setBounds(430, 380, 70, 25);
        quitBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        bg.add(quitBtn);

        timerLbl = new JLabel("Time: 1:00", SwingConstants.CENTER);
        timerLbl.setBounds(50, 170, 100, 30);
        timerLbl.setFont(new Font("Arial", Font.BOLD, 18));
        bg.add(timerLbl);

        answerMessageLbl = new JLabel("", SwingConstants.CENTER);
        answerMessageLbl.setBounds(50, 140, 350, 30);
        answerMessageLbl.setFont(new Font("Arial", Font.BOLD, 18));
        bg.add(answerMessageLbl);

        // --- OPERATION SELECTION ---
        addRadio = new JRadioButton("Addition", true);
        subRadio = new JRadioButton("Subtraction");
        mulRadio = new JRadioButton("Multiplication");
        divRadio = new JRadioButton("Division");
        modRadio = new JRadioButton("Modulo");

        opSelect = new ButtonGroup();
        opSelect.add(addRadio);
        opSelect.add(subRadio);
        opSelect.add(mulRadio);
        opSelect.add(divRadio);
        opSelect.add(modRadio);

        JPanel opBox = new JPanel(new GridLayout(5, 1));
        opBox.setBounds(50, 200, 130, 120);
        opBox.setBorder(BorderFactory.createTitledBorder("Operations"));
        opBox.add(addRadio);
        opBox.add(subRadio);
        opBox.add(mulRadio);
        opBox.add(divRadio);
        opBox.add(modRadio);
        bg.add(opBox);

        // --- LEVEL SELECTION ---
        easyLvl = new JRadioButton("Level 1 (1-10)", true);
        medLvl = new JRadioButton("Level 2 (11-50)");
        hardLvl = new JRadioButton("Level 3 (51-100)");

        lvlSelect = new ButtonGroup();
        lvlSelect.add(easyLvl);
        lvlSelect.add(medLvl);
        lvlSelect.add(hardLvl);

        JPanel lvlBox = new JPanel(new GridLayout(3, 1));
        lvlBox.setBounds(200, 200, 140, 120);
        lvlBox.setBorder(BorderFactory.createTitledBorder("Level"));
        lvlBox.add(easyLvl);
        lvlBox.add(medLvl);
        lvlBox.add(hardLvl);
        bg.add(lvlBox);

        // --- SCORE LABELS ---
        correctLbl = new JLabel("Correct: 0");
        correctLbl.setBounds(360, 220, 150, 30);
        bg.add(correctLbl);

        wrongLbl = new JLabel("Incorrect: 0");
        wrongLbl.setBounds(360, 250, 150, 30);
        bg.add(wrongLbl);

        // --- EVENT HANDLERS ---
        startBtn.addActionListener(e -> {
            if (!timerStarted) {
                startTimer();
                timerStarted = true;
                disableRadios();
                makeQuestion();
            }
        });
        submitBtn.addActionListener(e -> {
            if (!timerStarted) {
                JOptionPane.showMessageDialog(this, "Please press start before answer!");
                return;
            }
            verifyInput();
        });
        quitBtn.addActionListener(e -> {
            if (timer != null) {
                timer.stop();
            }
            timeRemaining = 60;
            timerLbl.setText("Time: 1:00");
            timerStarted = false;
            enableRadios();
            makeQuestion();
            scoreCorrect = 0;
            scoreWrong = 0;
            correctLbl.setText("Correct: 0");
            wrongLbl.setText("Incorrect: 0");
        });
        addRadio.addActionListener(e -> {
            if (!timerStarted) makeQuestion();
        });
        subRadio.addActionListener(e -> {
            if (!timerStarted) makeQuestion();
        });
        mulRadio.addActionListener(e -> {
            if (!timerStarted) makeQuestion();
        });
        divRadio.addActionListener(e -> {
            if (!timerStarted) makeQuestion();
        });
        modRadio.addActionListener(e -> {
            if (!timerStarted) makeQuestion();
        });
        easyLvl.addActionListener(e -> {
            if (!timerStarted) makeQuestion();
        });
        medLvl.addActionListener(e -> {
            if (!timerStarted) makeQuestion();
        });
        hardLvl.addActionListener(e -> {
            if (!timerStarted) makeQuestion();
        });

        makeQuestion();
        setVisible(true);

        // Add ComponentListener for resizing
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int currentWidth = getWidth();
                int currentHeight = getHeight();
                boolean isMaximized = (getExtendedState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH;

                if (isMaximized) {
                    double scaleX = (double) currentWidth / originalWidth;
                    double scaleY = (double) currentHeight / originalHeight;
                    double scaleFont = Math.min(scaleX, scaleY);

                    // Scale components
                    numLabelA.setBounds((int) (50 * scaleX), (int) (50 * scaleY), (int) (80 * scaleX), (int) (60 * scaleY));
                    numLabelA.setFont(originalNumFont.deriveFont((float) (24 * scaleFont)));
                    opLabel.setBounds((int) (150 * scaleX), (int) (60 * scaleY), (int) (40 * scaleX), (int) (40 * scaleY));
                    opLabel.setFont(originalOpFont.deriveFont((float) (24 * scaleFont)));
                    numLabelB.setBounds((int) (210 * scaleX), (int) (50 * scaleY), (int) (80 * scaleX), (int) (60 * scaleY));
                    numLabelB.setFont(originalNumFont.deriveFont((float) (24 * scaleFont)));
                    eqLabel.setBounds((int) (305 * scaleX), (int) (58 * scaleY), (int) (40 * scaleX), (int) (40 * scaleY));
                    eqLabel.setFont(originalOpFont.deriveFont((float) (24 * scaleFont)));
                    ansField.setBounds((int) (350 * scaleX), (int) (50 * scaleY), (int) (100 * scaleX), (int) (60 * scaleY));
                    ansField.setFont(originalAnsFont.deriveFont((float) (24 * scaleFont)));
                    startBtn.setBounds((int) (430 * scaleX), (int) (120 * scaleY), (int) (70 * scaleX), (int) (25 * scaleY));
                    startBtn.setFont(originalBtnFont.deriveFont((float) (10 * scaleFont)));
                    submitBtn.setBounds((int) (430 * scaleX), (int) (150 * scaleY), (int) (70 * scaleX), (int) (25 * scaleY));
                    submitBtn.setFont(originalBtnFont.deriveFont((float) (10 * scaleFont)));
                    quitBtn.setBounds((int) (430 * scaleX), (int) (180 * scaleY), (int) (70 * scaleX), (int) (25 * scaleY));
                    quitBtn.setFont(originalBtnFont.deriveFont((float) (10 * scaleFont)));
                    timerLbl.setBounds((int) (50 * scaleX), (int) (170 * scaleY), (int) (100 * scaleX), (int) (30 * scaleY));
                    timerLbl.setFont(originalMsgFont.deriveFont((float) (18 * scaleFont)));
                    answerMessageLbl.setBounds((int) (50 * scaleX), (int) (140 * scaleY), (int) (350 * scaleX), (int) (30 * scaleY));
                    answerMessageLbl.setFont(originalMsgFont.deriveFont((float) (18 * scaleFont)));
                    opBox.setBounds((int) (50 * scaleX), (int) (200 * scaleY), (int) (130 * scaleX), (int) (120 * scaleY));
                    lvlBox.setBounds((int) (200 * scaleX), (int) (200 * scaleY), (int) (140 * scaleX), (int) (120 * scaleY));
                    correctLbl.setBounds((int) (360 * scaleX), (int) (220 * scaleY), (int) (150 * scaleX), (int) (30 * scaleY));
                    correctLbl.setFont(originalScoreFont.deriveFont((float) (12 * scaleFont)));
                    wrongLbl.setBounds((int) (360 * scaleX), (int) (250 * scaleY), (int) (150 * scaleX), (int) (30 * scaleY));
                    wrongLbl.setFont(originalScoreFont.deriveFont((float) (12 * scaleFont)));
                } else {
                    // Reset to original positions and fonts
                    numLabelA.setBounds(50, 50, 80, 60);
                    numLabelA.setFont(originalNumFont);
                    opLabel.setBounds(150, 60, 40, 40);
                    opLabel.setFont(originalOpFont);
                    numLabelB.setBounds(210, 50, 80, 60);
                    numLabelB.setFont(originalNumFont);
                    eqLabel.setBounds(305, 58, 40, 40);
                    eqLabel.setFont(originalOpFont);
                    ansField.setBounds(350, 50, 100, 60);
                    ansField.setFont(originalAnsFont);
                    startBtn.setBounds(400, 115, 70, 25);
                    startBtn.setFont(originalBtnFont);
                    submitBtn.setBounds(400, 140, 70, 25);
                    submitBtn.setFont(originalBtnFont);
                    quitBtn.setBounds(400, 165, 70, 25);
                    quitBtn.setFont(originalBtnFont);
                    timerLbl.setBounds(50, 170, 100, 30);
                    timerLbl.setFont(originalMsgFont);
                    answerMessageLbl.setBounds(50, 140, 350, 30);
                    answerMessageLbl.setFont(originalMsgFont);
                    opBox.setBounds(50, 200, 130, 120);
                    lvlBox.setBounds(200, 200, 140, 120);
                    correctLbl.setBounds(360, 220, 150, 30);
                    correctLbl.setFont(originalScoreFont);
                    wrongLbl.setBounds(360, 250, 150, 30);
                    wrongLbl.setFont(originalScoreFont);
                }
                repaint();
            }
        });
    }

    private void makeQuestion() {
        int low = 1, high = 10;

        if (medLvl.isSelected()) { low = 11; high = 50; }
        else if (hardLvl.isSelected()) { low = 51; high = 100; }

        int x = generator.nextInt(high - low + 1) + low;
        int y = generator.nextInt(high - low + 1) + low;

        numLabelA.setText(String.valueOf(x));
        numLabelB.setText(String.valueOf(y));
        answerMessageLbl.setText("");

        if (addRadio.isSelected()) { opLabel.setText("+"); resultValue = x + y; }
        else if (subRadio.isSelected()) { opLabel.setText("-"); resultValue = x - y; }
        else if (mulRadio.isSelected()) { opLabel.setText("×"); resultValue = x * y; }
        else if (divRadio.isSelected()) {
            opLabel.setText("÷");
            if (y == 0) y = 1;
            numLabelB.setText(String.valueOf(y));
            resultValue = x / y;
        }
        else if (modRadio.isSelected()) { opLabel.setText("%"); resultValue = x % y; }

        ansField.setText("");
    }

    private void verifyInput() {
        try {
            int userAns = Integer.parseInt(ansField.getText());

            if (userAns == resultValue) {
                scoreCorrect++;
                correctLbl.setText("Correct: " + scoreCorrect);
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
                JOptionPane.showMessageDialog(this, "Correct Answer!", "Result", JOptionPane.INFORMATION_MESSAGE);
                if (timer != null && timerStarted) {
                    timer.start();
                }
            } else {
                scoreWrong++;
                wrongLbl.setText("Incorrect: " + scoreWrong);
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
                JOptionPane.showMessageDialog(this, "Wrong Answer! Correct: " + resultValue, "Result", JOptionPane.ERROR_MESSAGE);
                if (timer != null && timerStarted) {
                    timer.start();
                }
            }

            makeQuestion();

        } catch (NumberFormatException ex) {
            if (timer != null && timer.isRunning()) {
                timer.stop();
            }
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
            if (timer != null && timerStarted) {
                timer.start();
            }
        }
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                int minutes = timeRemaining / 60;
                int seconds = timeRemaining % 60;
                timerLbl.setText("Time: " + minutes + ":" + String.format("%02d", seconds));
                if (timeRemaining <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(ArithmeticGame.this, "Time's up! Game over.", "Timer", JOptionPane.WARNING_MESSAGE);
                    timeRemaining = 60;
                    timerLbl.setText("Time: 1:00");
                    timerStarted = false;
                    enableRadios();
                }
            }
        });
        timer.start();
    }

    private void disableRadios() {
        addRadio.setEnabled(false);
        subRadio.setEnabled(false);
        mulRadio.setEnabled(false);
        divRadio.setEnabled(false);
        modRadio.setEnabled(false);
        easyLvl.setEnabled(false);
        medLvl.setEnabled(false);
        hardLvl.setEnabled(false);
    }

    private void enableRadios() {
        addRadio.setEnabled(true);
        subRadio.setEnabled(true);
        mulRadio.setEnabled(true);
        divRadio.setEnabled(true);
        modRadio.setEnabled(true);
        easyLvl.setEnabled(true);
        medLvl.setEnabled(true);
        hardLvl.setEnabled(true);
    }

    public static void main(String[] args) {
        new ArithmeticGame();
    }
}
package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener {

    String[] questions = {
            "Which company created Java?",
            "Which year was Java created?",
            "What was Java originally called?",
            "Who is credited with creating Java?"
    };

    String[][] options = {
            {"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"},
            {"1989", "1996", "1972", "1492"},
            {"Apple", "Latte", "Oak", "KOffing"},
            {"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zuckerberg"}
    };

    char[] answers = {
            'A',
            'B',
            'C',
            'C'
    };

    char guess;
    char answer;
    int index;
    int correctNumberOfGuesses = 0;
    int totalQuestions = questions.length;
    int result;
    int seconds = 10;

    JFrame frame;
    JTextField textField;
    JTextArea textArea;
    JButton buttonA;
    JButton buttonB;
    JButton buttonC;
    JButton buttonD;
    JLabel answerLabelA;
    JLabel answerLabelB;
    JLabel answerLabelC;
    JLabel answerLabelD;
    JLabel timeLabel;
    JLabel secondsLeft;
    JTextField numberRight;
    JTextField percentage;
    Timer timer;

    public Quiz() {
        frame = new JFrame();
        textField = new JTextField();
        textArea = new JTextArea();
        buttonA = new JButton();
        buttonB = new JButton();
        buttonC = new JButton();
        buttonD = new JButton();
        answerLabelA = new JLabel();
        answerLabelB = new JLabel();
        answerLabelC = new JLabel();
        answerLabelD = new JLabel();
        timeLabel = new JLabel();
        secondsLeft = new JLabel();
        numberRight = new JTextField();
        percentage = new JTextField();

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds--;
                secondsLeft.setText(String.valueOf(seconds));
                if (seconds <= 0) {
                    displayAnswer();
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(55, 200, 50));
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText("testing text");

        textArea.setBounds(0, 50, 650, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(55, 200, 50));
        textArea.setFont(new Font("MV Boli", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answerLabelA.setBounds(125, 100, 500, 100);
        answerLabelA.setBackground(new Color(50, 50, 50));
        answerLabelA.setForeground(new Color(55, 200, 50));
        answerLabelA.setFont(new Font("MV Boli", Font.PLAIN, 35));

        answerLabelB.setBounds(125, 200, 500, 100);
        answerLabelB.setBackground(new Color(50, 50, 50));
        answerLabelB.setForeground(new Color(55, 200, 50));
        answerLabelB.setFont(new Font("MV Boli", Font.PLAIN, 35));

        answerLabelC.setBounds(125, 300, 500, 100);
        answerLabelC.setBackground(new Color(50, 50, 50));
        answerLabelC.setForeground(new Color(55, 200, 50));
        answerLabelC.setFont(new Font("MV Boli", Font.PLAIN, 35));

        answerLabelD.setBounds(125, 400, 500, 100);
        answerLabelD.setBackground(new Color(50, 50, 50));
        answerLabelD.setForeground(new Color(55, 200, 50));
        answerLabelD.setFont(new Font("MV Boli", Font.PLAIN, 35));

        secondsLeft.setBounds(535, 510, 100, 100);
        secondsLeft.setBackground(new Color(25, 25, 25));
        secondsLeft.setForeground(new Color(255, 0, 0));
        secondsLeft.setFont(new Font("Ink Free", Font.BOLD, 60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        timeLabel.setBounds(535, 485, 100, 25);
        timeLabel.setBackground(new Color(50, 50, 50));
        timeLabel.setForeground(new Color(255, 0, 0));
        timeLabel.setFont(new Font("MV Boli", Font.PLAIN, 16));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("timer");

        numberRight.setBounds(225, 225, 200, 100);
        numberRight.setBackground(new Color(25, 25, 25));
        numberRight.setForeground(new Color(55, 200, 50));
        numberRight.setFont(new Font("Ink Free", Font.BOLD, 50));
        numberRight.setBorder(BorderFactory.createBevelBorder(1));
        numberRight.setHorizontalAlignment(JTextField.CENTER);
        numberRight.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(55, 200, 50));
        percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(textField);
        frame.add(textArea);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(secondsLeft);
        frame.add(timeLabel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion() {
        if (index >= totalQuestions) {
            results();
        } else {
            textField.setText("Question " + (index + 1));
            textArea.setText(questions[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);
            timer.start();
        }
    }

    public void displayAnswer() {
        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A') {
            answerLabelA.setForeground(new Color(255, 0, 0));
        }

        if (answers[index] != 'B') {
            answerLabelB.setForeground(new Color(255, 0, 0));
        }

        if (answers[index] != 'C') {
            answerLabelC.setForeground(new Color(255, 0, 0));
        }

        if (answers[index] != 'D') {
            answerLabelD.setForeground(new Color(255, 0, 0));
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerLabelA.setForeground(new Color(55, 200, 50));
                answerLabelB.setForeground(new Color(55, 200, 50));
                answerLabelC.setForeground(new Color(55, 200, 50));
                answerLabelD.setForeground(new Color(55, 200, 50));

                answer = ' ';
                seconds = 10;
                secondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;

                nextQuestion();
            }
        });

        pause.setRepeats(false);
        pause.start();
    }

    public void results() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int) ((correctNumberOfGuesses / (double) totalQuestions) * 100);

        textField.setText("RESULTS!");
        textArea.setText("");
        answerLabelA.setText("");
        answerLabelB.setText("");
        answerLabelC.setText("");
        answerLabelD.setText("");

        numberRight.setText("(" + correctNumberOfGuesses + "/" + totalQuestions + ")");
        percentage.setText(result + "%");

        frame.add(percentage);
        frame.add(numberRight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = 'A';
            if (answer == answers[index]) {
                correctNumberOfGuesses++;
            }
        }


        if (e.getSource() == buttonB) {
            answer = 'B';
            if (answer == answers[index]) {
                correctNumberOfGuesses++;
            }
        }


        if (e.getSource() == buttonC) {
            answer = 'C';
            if (answer == answers[index]) {
                correctNumberOfGuesses++;
            }
        }


        if (e.getSource() == buttonD) {
            answer = 'D';
            if (answer == answers[index]) {
                correctNumberOfGuesses++;
            }
        }

        displayAnswer();
    }
}

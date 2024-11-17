package Sprint4.Additionals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 'Dead' chat client only showcasing what a chat box can look like in swing
public class BasicSwingChatbox {
    public static void main(String[] args) {
        // Create JFrame`
        JFrame frame = new JFrame("Chat Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Create JTextArea for chat display
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false); // Make non-editable
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create JPanel for input area
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        // JTextField for typing messages
        JTextField messageField = new JTextField();
        inputPanel.add(messageField, BorderLayout.CENTER);

        // JButton for sending messages
        JButton sendButton = new JButton("Send");
        inputPanel.add(sendButton, BorderLayout.EAST);

        // The entire inputPanel is added as south in the JFrame
        frame.add(inputPanel, BorderLayout.SOUTH);

        // ActionListener for sending messages
        ActionListener sendAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText().trim();
                if (!message.isEmpty()) {
                    chatArea.append("You: " + message + "\n");
                    messageField.setText(""); // Clear input field
                }
            }
        };

        // Add ActionListener to JButton and JTextField (Enter key)
        sendButton.addActionListener(sendAction);
        messageField.addActionListener(sendAction);

        // Make the frame visible
        frame.setVisible(true);
    }
}
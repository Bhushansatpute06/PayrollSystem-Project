import java.awt.*;
import java.awt.event.*;

public class PayrollSystem extends Frame implements ActionListener {

    // Declare UI components
    Label nameLabel, idLabel, hoursLabel, rateLabel, payLabel;
    TextField nameField, idField, hoursField, rateField;
    Button calculateButton;
    TextArea resultArea;

    public PayrollSystem() {
        // Create fonts
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font inputFont = new Font("Arial", Font.PLAIN, 12);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        // Create components with smaller text fields
        nameLabel = new Label("Employee Name:");
        nameField = new TextField(8);  // Smaller text field
        idLabel = new Label("Employee ID:");
        idField = new TextField(8);  // Smaller text field
        hoursLabel = new Label("Hours Worked:");
        hoursField = new TextField(8);  // Smaller text field
        rateLabel = new Label("Hourly Rate (INR):");
        rateField = new TextField(8);  // Smaller text field
        calculateButton = new Button("Calculate Pay");
        payLabel = new Label("Pay Details:");
        resultArea = new TextArea(5, 30);

        // Set fonts
        nameLabel.setFont(labelFont);
        idLabel.setFont(labelFont);
        hoursLabel.setFont(labelFont);
        rateLabel.setFont(labelFont);
        payLabel.setFont(labelFont);

        nameField.setFont(inputFont);
        idField.setFont(inputFont);
        hoursField.setFont(inputFont);
        rateField.setFont(inputFont);

        calculateButton.setFont(buttonFont);
        resultArea.setFont(inputFont);

        // Set colors
        nameLabel.setForeground(Color.BLACK);
        idLabel.setForeground(Color.BLACK);
        hoursLabel.setForeground(Color.BLACK);
        rateLabel.setForeground(Color.BLACK);
        payLabel.setForeground(Color.BLUE);

        resultArea.setBackground(Color.LIGHT_GRAY);
        resultArea.setForeground(Color.DARK_GRAY);
        calculateButton.setBackground(new Color(0, 102, 204));  // Custom blue color
        calculateButton.setForeground(Color.WHITE);

        // Set layout
        setLayout(new GridLayout(6, 2, 10, 10));  // 6 rows, 2 columns, 10px gaps

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(idLabel);
        add(idField);
        add(hoursLabel);
        add(hoursField);
        add(rateLabel);
        add(rateField);
        add(calculateButton);
        add(payLabel);
        add(resultArea);

        // Add event listener to the button
        calculateButton.addActionListener(this);

        // Set frame properties
        setTitle("Payroll System");
        setSize(250, 200);  // Adjusted size to fit the smaller fields
        setVisible(true);

        // Add window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Event handling
    public void actionPerformed(ActionEvent e) {
        try {
            String name = nameField.getText();
            String id = idField.getText();
            double hours = Double.parseDouble(hoursField.getText());
            double rate = Double.parseDouble(rateField.getText());

            // Calculate gross pay in INR
            double grossPayINR = hours * rate;

            // Calculate monthly salary assuming full-time (e.g., 160 hours per month)
            double monthlySalaryINR = rate * 160;

            resultArea.setText("Employee: " + name + "\nID: " + id +
                    "\nGross Pay: ₹" + grossPayINR + " (INR)" +
                    "\nMonthly Salary: ₹" + monthlySalaryINR + " (INR)");
        } catch (NumberFormatException nfe) {
            resultArea.setText("Invalid input. Please enter numerical values for hours and rate.");
        }
    }

    public static void main(String[] args) {
        new PayrollSystem();
    }
}

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ApplicationDate extends JFrame implements ActionListener {
    private JTextField startDateField;
    private JTextField endDateField;
    private JButton submitButton;
    private JLabel resultLabel;
    private boolean isPopupOpen = false;

    // GUI implementation
    public ApplicationDate() {
        setTitle("Weekdays Calci (CSE-071)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));
        setContentPane(contentPane);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        JPanel startDatePanel = new JPanel();
        JLabel startDateLabel = new JLabel("Start Date:");
        startDateField = new JTextField("dd-mm-yyyy", 10);
        startDatePanel.add(startDateLabel);
        startDatePanel.add(startDateField);

        JPanel endDatePanel = new JPanel();
        JLabel endDateLabel = new JLabel("Finish Date:");
        endDateField = new JTextField("dd-mm-yyyy", 10);
        endDatePanel.add(endDateLabel);
        endDatePanel.add(endDateField);

        inputPanel.add(startDatePanel);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(endDatePanel);

        submitButton = new JButton("Let's Go!");
        submitButton.addActionListener(this);
        submitButton.setEnabled(true);

        resultLabel = new JLabel();

        contentPane.add(inputPanel);
        contentPane.add(Box.createVerticalStrut(10));
        contentPane.add(submitButton);
        contentPane.add(Box.createVerticalStrut(15));
        contentPane.add(resultLabel);

        pack();
        setResizable(false);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ApplicationDate::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton && !isPopupOpen) {
            String startDateString = startDateField.getText();
            String endDateString = endDateField.getText();

            // this will be handling start and end dates validity.
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate startDate = LocalDate.parse(startDateString, formatter);
                LocalDate endDate = LocalDate.parse(endDateString, formatter);

                if (endDate.isBefore(startDate)) {
                    throw new IllegalArgumentException("FinishDate must be later than StartDate!");
                }

                int totalWeekdayCount = countWeekdays(startDate, endDate);

                WeekdayCountWindow countWindow = new WeekdayCountWindow(
                        getSundayCount(startDate, endDate),
                        getMondayCount(startDate, endDate),
                        getTuesdayCount(startDate, endDate),
                        getWednesdayCount(startDate, endDate),
                        getThursdayCount(startDate, endDate),
                        getFridayCount(startDate, endDate),
                        getSaturdayCount(startDate, endDate),
                        totalWeekdayCount
                );
                countWindow.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        isPopupOpen = false;
                        submitButton.setEnabled(true);
                    }
                });
                countWindow.setVisible(true);
                isPopupOpen = true;
                submitButton.setEnabled(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error PopUp", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static int countWeekdays(LocalDate startDate, LocalDate endDate) {
        int weekdayCount = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                weekdayCount++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return weekdayCount;
    }

    private static int getSundayCount(LocalDate startDate, LocalDate endDate) {
        int sundayCount = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SUNDAY) {
                sundayCount++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return sundayCount;
    }

    private static int getMondayCount(LocalDate startDate, LocalDate endDate) {
        int mondayCount = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.MONDAY) {
                mondayCount++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return mondayCount;
    }

    private static int getTuesdayCount(LocalDate startDate, LocalDate endDate) {
        int tuesdayCount = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.TUESDAY) {
                tuesdayCount++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return tuesdayCount;
    }

    private static int getWednesdayCount(LocalDate startDate, LocalDate endDate) {
        int wednesdayCount = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.WEDNESDAY) {
                wednesdayCount++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return wednesdayCount;
    }

    private static int getThursdayCount(LocalDate startDate, LocalDate endDate) {
        int thursdayCount = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.THURSDAY) {
                thursdayCount++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return thursdayCount;
    }

    private static int getFridayCount(LocalDate startDate, LocalDate endDate) {
        int fridayCount = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                fridayCount++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return fridayCount;
    }

    private static int getSaturdayCount(LocalDate startDate, LocalDate endDate) {
        int saturdayCount = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY) {
                saturdayCount++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return saturdayCount;
    }
}
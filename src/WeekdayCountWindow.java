// 
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class WeekdayCountWindow extends JFrame {
    private JLabel sundayLabel;
    private JLabel mondayLabel;
    private JLabel tuesdayLabel;
    private JLabel wednesdayLabel;
    private JLabel thursdayLabel;
    private JLabel fridayLabel;
    private JLabel saturdayLabel;
    private JLabel weekdayLabel;

    public WeekdayCountWindow(int sundayCount, int mondayCount, 
    						  int tuesdayCount, int wednesdayCount,
                              int thursdayCount, int fridayCount, 
                              int saturdayCount, int weekdayCount) {
        setTitle("Weekdays Result Panel");
        setSize(600, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);

        sundayLabel = createLabel("Sundays : " + sundayCount);
        mondayLabel = createLabel("Mondays : " + mondayCount);
        tuesdayLabel = createLabel("Tuesdays : " + tuesdayCount);
        wednesdayLabel = createLabel("Wednesdays : " + wednesdayCount);
        thursdayLabel = createLabel("Thursdays : " + thursdayCount);
        fridayLabel = createLabel("Fridays : " + fridayCount);
        saturdayLabel = createLabel("Saturdays : " + saturdayCount);
        weekdayLabel = createLabel("Weekdays (Monday to Friday) : " + weekdayCount);
        weekdayLabel.setBackground(Color.yellow);
        weekdayLabel.setForeground(Color.red);
        weekdayLabel.setOpaque(true);

        contentPane.add(sundayLabel);
        contentPane.add(mondayLabel);
        contentPane.add(tuesdayLabel);
        contentPane.add(wednesdayLabel);
        contentPane.add(thursdayLabel);
        contentPane.add(fridayLabel);
        contentPane.add(saturdayLabel);
        contentPane.add(weekdayLabel);
    }
    
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Verdana", Font.PLAIN, 20));
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        return label;
    }
}

//01-01-2023
//31-12-2023
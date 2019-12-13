import adapter.MyTableModel;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.table.JBTable;
import interfaces.Call;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AttrListDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOk;
    private JPanel tablePanel;
    private Call call;
    private MyTableModel myTableModel;



    public AttrListDialog(Call call) {
        this.call = call;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOk);
        myTableModel = new MyTableModel();
        JBTable table = new JBTable(myTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(800, 300));
        table.setFillsViewportHeight(true);
        // 声明一个JBScrollPane，把JBTable放进去
        JBScrollPane scrollPane = new JBScrollPane(table);
        tablePanel.setLayout(new GridLayout(1, 0));
         // 在tablePane中加入scrollPane
        tablePanel.add(scrollPane);

        buttonOk.addActionListener(e1 -> onOK());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e13 -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    //点击按钮的回调
    private void onOK() {
        if(call != null){
            call.back(myTableModel.getList());
        }
        dispose();
    }

    private void onCancel() {
        dispose();
    }
}

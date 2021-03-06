package main;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import main.entities.AttrItems;
import main.utils.Notifications;
import main.utils.Outputs;
import org.apache.http.util.TextUtils;

public class FormAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);

        //获取选中的文本内容
        final Editor mEditor = e.getData(PlatformDataKeys.EDITOR);
        if (null == mEditor) {
            return;
        }
        //文档操作
        Document document = mEditor.getDocument();
        //获取光标位置
        CaretModel caretModel = mEditor.getCaretModel();
        int offset = caretModel.getOffset();

//        获取选中字段
//        SelectionModel selectionModel = mEditor.getSelectionModel();
//        //获取选中内容
//        final String selectedText = selectionModel.getSelectedText();

//        //获取最终位置
//        int endOffset = selectionModel.getSelectionEnd();
//        if (TextUtils.isEmpty(selectedText)) {
//            return;
//        }
        AttrListDialog attrListDialog = new AttrListDialog(obj -> {
            String input = Outputs.getOutPutString((AttrItems[]) obj);
            Runnable runnable = () -> document.insertString(offset, input);
            WriteCommandAction.runWriteCommandAction(project, runnable);
            if (!TextUtils.isEmpty(input)) {
                Notifications.showNotification(e, "uix_xml_helper", "提示", "属性添加成功！");
            }
        });
        attrListDialog.pack();
        attrListDialog.setVisible(true);
    }
}

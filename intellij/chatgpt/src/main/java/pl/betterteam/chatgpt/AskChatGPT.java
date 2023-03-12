package pl.betterteam.chatgpt;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import pl.betterteam.chatgpt.api.ApiBuilder;
import pl.betterteam.chatgpt.exception.ApiException;
import pl.betterteam.chatgpt.model.Message;
import pl.betterteam.chatgpt.model.RequestObject;
import pl.betterteam.chatgpt.model.ResponseObject;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class AskChatGPT extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();
        try {
            Response<ResponseObject> response = ApiBuilder.build().askChatGPT(
                    new RequestObject(
                            "gpt-3.5-turbo",
                            List.of(new Message("user", selectedText))
                    )
            ).execute();
            if (!response.isSuccessful() || response.body() == null) {
                throw new ApiException(response.message());
            }
            Messages.showMessageDialog(response.body().getChoices().get(0).getMessage().getContent(),
                    "AskChatGPT",
                    Messages.getInformationIcon());
        } catch (IOException ex) {
            Messages.showMessageDialog("Something went wrong!",
                    "AskChatGPT",
                    Messages.getErrorIcon());
        }
    }
}

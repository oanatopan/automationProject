package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class AlertModel {

    private String promptText;
    private boolean chooseAccept;

    public AlertModel(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            AlertModel data = objectMapper.readValue(new File(filePath), AlertModel.class);
            this.promptText = data.promptText;
            this.chooseAccept = data.chooseAccept;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read alert data from JSON file.", e);
        }
    }

    public AlertModel() {
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    public boolean isChooseAccept() {
        return chooseAccept;
    }

    public void setChooseAccept(boolean chooseAccept) {
        this.chooseAccept = chooseAccept;
    }
}
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Location;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.Venue;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        long chatid = update.getMessage().getChatId();
        new KeyboardButton("location").setRequestLocation(true);
        Location location = new Location();
        float longitude = location.getLongitude();
        float latitude = location.getLatitude();

    }

 //private void Keyboard(String text, long chatid /*String... buttonsName*/) {
   /*  ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
     List<KeyboardRow> keyboard = new ArrayList<>();
     KeyboardRow firstRow = new KeyboardRow();
     firstRow.add(new KeyboardButton("location").setRequestLocation(true));
     keyboard.add(firstRow);
     markup.setKeyboard(keyboard);
     SendMessage request =  new SendMessage();
     request.setText(text);
     request.setChatId(chatid);
     request.setReplyMarkup(markup);

     try {
         execute(request);
     } catch (TelegramApiException e) {
         e.printStackTrace();
     }
    }*/

    private void sendText(String text, long chatid) {
        SendMessage request = new SendMessage();
        request.setText(text);
        request.setChatId(chatid);
        try {
            execute(request);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Sob_Guide_Bot";
    }

    @Override
    public String getBotToken() {
        return "531567310:AAFfe1scrnEhtkOOjo0DA17qtO1e7BeJZKc";
    }
}

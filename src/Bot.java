import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Location;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.Venue;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    static Inf inf = new Inf();
    static Cafes cafes = new Cafes();
    @Override
    public void onUpdateReceived(Update update) {
        locationButtons();
        String text = update.getMessage().getText();
        long chatid = update.getMessage().getChatId();
        Location location = update.getMessage().getLocation();
        float longitude = location.getLongitude();
        float latitude = location.getLatitude();
        //latitude = new BigDecimal(latitude).setScale(3, RoundingMode.UP).doubleValue();
        //longitude = new BigDecimal(longitude).setScale(3, RoundingMode.UP).doubleValue();
        if (update.getMessage().hasLocation()) {
            cafes(text, chatid, longitude, latitude);
            /*
            if (text.equals("location")) {
                location(text, chatid, longitude, latitude);
            } else if (text.equals("Кафе и рестораны")) {
                cafes(text, chatid, longitude, latitude);
            }*/
        }
    }
    public void location(String text, long chatid, float longitude, float latitude) {
        if (latitude == 60.018 && longitude == 30.368) {
            inf.house(text, chatid);
        }
        sendText("широта: " + latitude + "\nдолгота: " + longitude, chatid);
    }
    public void cafes(String text, long chatid, float longitude, float latitude) {
        if (latitude >= 60.014 && latitude <= 60.024 && longitude >= 30.35 && longitude <= 30.38) {
            cafes.cafesLocation(text, longitude, latitude, chatid);
        }
    }
    public void locationButtons() {
        new KeyboardButton("location").setRequestLocation(true);
        new KeyboardButton("Что интересного поблизости?").setRequestLocation(true);
        new KeyboardButton("Кафе и рестораны").setRequestLocation(true);
    }
    public void sendText(String text, long chatid) {
        SendMessage request = new SendMessage();
        request.setText(text);
        request.setChatId(chatid);
        try {
            execute(request);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void sendLocation(float longitude, float latitude, long chatid) {
        SendLocation request = new SendLocation();
        request.setLatitude(latitude);
        request.setLongitude(longitude);
        request.setChatId(chatid);
        try {
            execute(request);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void sendPhoto(String photo, long chatid) {
        SendPhoto request = new SendPhoto();
        request.setPhoto(photo);
        request.setChatId(chatid);
        try {
            sendPhoto(request);
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

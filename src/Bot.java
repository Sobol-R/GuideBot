import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Location;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    static Main main = new Main();
    static Inf inf = new Inf();
    static Cafes cafes = new Cafes();
    @Override
    public void onUpdateReceived(Update update) {
        locationButtons();
        String text = update.getMessage().getText();
        long chatid = update.getMessage().getChatId();
        Location location = update.getMessage().getLocation();
        Float longitude = location.getLongitude();
        Float latitude = location.getLatitude();
        if (update.getMessage().hasLocation()) {
            setLocation(text, chatid, longitude, latitude);
        }
    }
    public void setLocation(String text, long chatid, Float latitude, Float longitude) {
     // System.out.println("широта: " + latitude + "\nдолгота: " + longitude);
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

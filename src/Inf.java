public class Inf {
    static Bot bot = new Bot();
    public void house(String text, long chatid) {
        bot.sendText("Вы находитесь рядом с домом моего разработчика", chatid);
    }
}

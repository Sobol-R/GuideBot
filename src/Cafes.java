public class Cafes {
    static Bot bot = new Bot();
    public void cafesLocation(String text, float longitude, float latitude, long chatid) {
        bot.sendText("Вы находитесь недалеко от кафе 'Сад Бенуа', \nесли хотите проложить маршрут - поставьте метку на карте: ", chatid);
        bot.sendLocation(30.37033939f, 60.01919798f, chatid);
        bot.sendPhoto("https://lh5.googleusercontent.com/proxy/mTV2WV9pY16-fTbiphLIh54zWiQsG3iSReGnUX_RluA_o6gwN9EKh6aE65MBNKd43MPwA_HVvDuVJ6hrfiDA7y8JbbvNCLGcHfu6PtICe3GOmz15ubZfFOH2ET7xmCZvTvnPlmvdkiSVmjR8I13xL8YzyGfaPVs=w408-h271-k-no", chatid);
        bot.sendPhoto("https://st0.restorating.ru/upload/images/2017/01/10/07e09654ec.jpg", chatid);
        bot.sendPhoto("https://st0.restorating.ru/upload/images/2017/01/10/682ab8b54a.jpg", chatid);
    }
}

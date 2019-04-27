package algorithm;

import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        //System.out.println(aplusb(1, 2));
        //System.out.println(find(105));
        long a = 3883008;
        System.out.println(a >> 20);

        String url = "/share/game?game_type=1232312";
        String game_type = "";
        if (url != null) {
            try {
                String[] params = url.split("=");
                game_type = params[1];
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("game_type = " + game_type);
        }


        String json = "{\n" +
                "\"type\":\"game_jumps\",\n" +
                "\"help\":\"/gamehelp?id=game_jumps\",\n" +
                "\"game_bg\":\"https://game-cdn.xiaobanhui.com/games/jumps/icons/bg.png\",\n" +
                "\"name\":\"跳一跳\",\n" +
                "\"icon\":\"https://game-cdn.xiaobanhui.com/games/jumps/icons/icon.png\"\n" +
                "}";

        //parse();
    }


    static int aplusb(int a, int b) {
        // write your code here
        if (b == 0) {
            return a;
        }
        int result = a ^ b;
        int shift = (a & b) << 1;
        return aplusb(result, shift);
    }


    static long find(long n) {
        long count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    static List<Lyric> lyricList = new ArrayList<>();

    static long currentTime = 0;

    static void parse() {
        String lyric = "[00:00.16]袁娅维 - 说散就散(《前任3：再见前任》电影主题曲)\r\n[00:05.37]作词：张楚翘\r\n[00:06.59]作曲：伍乐城\r\n[00:18.44]抱一抱\r\n[00:19.55]就当作从没有在一起\r\n[00:25.17]好不好\r\n[00:26.37]要解释都已经来不及\r\n[00:32.03]算了吧\r\n[00:33.28]我付出过什么没关系\r\n[00:37.50]我忽略自己\r\n[00:40.06]就因为遇见你\r\n[00:44.54]没办法\r\n[00:46.31]好可怕\r\n[00:47.96]那个我\r\n[00:49.73]不像话\r\n[00:50.98]一直奋不顾身\r\n[00:54.83]是我太傻\r\n[00:57.26]说不上爱别说谎\r\n[01:00.60]就一点喜欢\r\n[01:03.99]说不上恨别纠缠\r\n[01:07.44]别装作感叹\r\n[01:10.95]就当作我太麻烦\r\n[01:13.06]不停让自己受伤\r\n[01:14.87]我告诉我自己\r\n[01:17.58]感情就是这样\r\n[01:21.09]怎么一不小心太疯狂\r\n[01:34.01]抱一抱\r\n[01:34.94]再好好觉悟不能长久\r\n[01:40.61]好不好\r\n[01:41.80]有亏欠我们都别追究\r\n[01:47.46]算了吧\r\n[01:48.69]我付出再多都不足够\r\n[01:52.95]我终于得救\r\n[01:55.52]我不想再献丑\r\n[02:00.09]没办法 不好吗\r\n[02:03.45]大家都 不留下\r\n[02:06.37]一直勉强相处\r\n[02:10.27]总会累垮\r\n[02:12.60]说不上爱别说谎\r\n[02:16.08]就一点喜欢\r\n[02:19.37]说不上恨别纠缠\r\n[02:22.86]别装作感叹\r\n[02:26.32]就当作我太麻烦\r\n[02:28.49]不停让自己受伤\r\n[02:30.24]我告诉我自己\r\n[02:33.00]感情就是这样\r\n[02:36.44]怎么一不小心太疯狂\r\n[02:42.45]别后悔\r\n[02:43.47]就算错过\r\n[02:45.78]在以后\r\n[02:46.89]你少不免想起我\r\n[02:51.37]还算不错\r\n[02:55.51]当我不在你会不会难过\r\n[02:58.98]你够不够我这样洒脱\r\n[03:03.93]说不上爱别说谎\r\n[03:07.51]就一点喜欢\r\n[03:10.95]说不上恨别纠缠\r\n[03:14.36]别装作感叹\r\n[03:16.48]将一切都体谅\r\n[03:18.20]将一切都原谅\r\n[03:19.91]我尝试找答案\r\n[03:21.57]而答案很简单\r\n[03:23.33]简单得很遗憾\r\n[03:27.50]因为成长\r\n[03:29.53]我们逼不得已要习惯\r\n[03:34.28]因为成长\r\n[03:36.50]我们忽尔间说散就散\r\n";
        String[] lyrics = lyric.split("\r\n");
        for (String l : lyrics) {
            //System.out.println(l);
            String[] sentences = l.split("]");
            String time = sentences[0].replace("[", "");
            String[] split = time.split(":");
            long minute = Long.parseLong(split[0]) * 60 * 1000;
            String[] last = split[1].split("\\.");
            long seconds = Long.parseLong(last[0]) * 1000;
            long mSeconds = Long.parseLong(last[1]) * 10;

            lyricList.add(new Lyric(time, minute + seconds + mSeconds, sentences[1]));
        }

        Thread thread = new Thread(() -> {
            for (Lyric l : lyricList) {
                try {
                    Thread.sleep(l.starTime - currentTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(l.time + " " + l.sentence);
                currentTime = l.starTime;
            }
        });
        thread.start();

    }

    static class Lyric {
        String time;
        long starTime;
        String sentence;

        public Lyric(String time, long starTime, String sentence) {
            this.time = time;
            this.starTime = starTime;
            this.sentence = sentence;
        }

        @Override
        public String toString() {
            return "Lyric{" +
                    "starTime=" + starTime +
                    ", sentence='" + sentence + '\'' +
                    '}';
        }
    }

}

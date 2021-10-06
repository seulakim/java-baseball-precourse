package baseball;

public class Application {

    static final String PLAY_GAME = "1";
    static String QUIT_GAME = "2";

    public static void main(String[] args) {

        String isPlay = "1";

        // TODO 숫자 야구 게임 구현
        do {
            // 랜덤 숫자 생성
            RandomNumber randomNum = new RandomNumber(3);

            // 게임 진행
            PlayGame game = new PlayGame();
            isPlay = game.isPlay;

        } while (isPlay.equals(PLAY_GAME));
    }
}

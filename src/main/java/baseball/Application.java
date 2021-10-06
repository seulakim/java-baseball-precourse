package baseball;

public class Application {

    public static void main(String[] args) {

        String isPlay = "1";

        // TODO 숫자 야구 게임 구현
        // 랜덤 숫자 생성
        RandomNumber randomNum = new RandomNumber(3);

        // 게임 진행
        PlayGame game = new PlayGame();
    }
}

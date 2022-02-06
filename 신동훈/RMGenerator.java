package 단계별로_풀어보기.bfs와dfs;

import gitrepourlparser.AnAGitRepositoryUrlParser;
import readmegenerator.BOJReadmeGenerator;

public class RMGenerator {
    public static void main(String[] args) {
        //== ANA 하루하나 알고리즘 리드미 만드는 코드 ==//
        AnAGitRepositoryUrlParser anaParser = new AnAGitRepositoryUrlParser();

        anaParser.setUsername("신동훈");//자기이름 입력

        BOJReadmeGenerator rg = new BOJReadmeGenerator(anaParser);

        rg.setTitle("동훈이의 하루하나 알고리즘");//안해줄 경우 기본값인 "백준" 사용

        rg.generate();
    }
}

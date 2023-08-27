package model;

public class Config {

    private String fileName;
    private String lotteryResult;


    public Config() {
        fileName = "toy_list.dat";
        lotteryResult = "lottery_result.txt";
    }

    public String getFileName() {
        return fileName;
    }

    public String getLotteryResult() {
        return lotteryResult;
    }

}

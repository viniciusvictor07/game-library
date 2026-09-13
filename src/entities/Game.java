package entities;

public class Game {
    private String name;
    private String franchise;
    private String ranking;
    private String pendingStatus;

    public Game(String name, String franchise, String ranking, String pendingStatus) {
        this.name = name;
        this.franchise = franchise;
        this.ranking = ranking;
        this.pendingStatus = pendingStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getPendingStatus() {
        return pendingStatus;
    }

    public void setPendingStatus(String pendingStatus) {
        this.pendingStatus = pendingStatus;
    }
}

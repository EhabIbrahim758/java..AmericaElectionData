public class ElectionData {

    String state;
    String country;
    String candidate;
    String party;
    Double total_vote;
    String won;

    public ElectionData(String state, String country, String candidate, String party, Double total_vote, String won) {
        this.state = state;
        this.country = country;
        this.candidate = candidate;
        this.party = party;
        this.total_vote = total_vote;
        this.won = won;
    }
}

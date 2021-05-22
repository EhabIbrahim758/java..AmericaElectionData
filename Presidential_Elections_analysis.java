import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Presidential_Elections_analysis {

    public List<ElectionData> read_Data(String filename){
        List<ElectionData> president_country_candidate
                = new ArrayList<>();

        try( BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line = br.readLine();
            if (line != null){
                line = br.readLine();
            }
            while(line != null){
                String[] Attributes = line.split(",");
                ElectionData data = CreateData(Attributes);
                president_country_candidate
                        .add(data);
                line = br.readLine();

            }

        }catch(IOException e){
            System.out.println(e);
        }


        return president_country_candidate;
    }
public ElectionData CreateData(String[] attributes ){

        String state = attributes[0];
        String country = attributes[1];
        String candidate = attributes[2];
        String party = attributes[3];
        Double total_vote = 0.0;
        if(attributes[4]!=null && attributes[4].length() !=0){
            total_vote = Double.parseDouble(attributes[4]);
        }
        String won = attributes[5];

        return new ElectionData(state, country, candidate, party, total_vote, won);
}

    public Map<String, Integer> trump_perc(List<ElectionData> Data){
        Map<String, Integer> trump_Percentage = new HashMap<>();
        Set<String> states = new HashSet<>();
        List<String> states_list = new ArrayList<>();

        for(ElectionData e : Data){
            states.add(e.state);
        }
        states_list.addAll(states);
        int[] total_votes = new int[states.size()];
        int[] sum_votes = new int[states.size()];


        for(ElectionData e : Data){
            int idx = (states_list.indexOf(e.state));
            total_votes[idx] += e.total_vote ;
            if (e.candidate.contains("Donald Trump")){
                sum_votes[idx] += e.total_vote;
            }
        }

        for (int i =0; i<states.size(); i++){
            int percentage = (sum_votes[i]  *100) / total_votes[i] ;
            trump_Percentage.put(states_list.get(i), percentage);

        }
    return trump_Percentage;
    }


    public Map<String, Integer> Biden_perc(List<ElectionData> Data){
        Map<String, Integer> Biden_Percentage = new HashMap<>();
        Set<String> states = new HashSet<>();
        List<String> states_list = new ArrayList<>();

        for(ElectionData e : Data){
            states.add(e.state);
        }
        states_list.addAll(states);
        int[] total_votes = new int[states.size()];
        int[] sum_votes = new int[states.size()];


        for(ElectionData e : Data){
            int idx = (states_list.indexOf(e.state));
            total_votes[idx] += e.total_vote ;
            if (e.candidate.contains("Joe Biden")){
                sum_votes[idx] += e.total_vote;
            }
        }

        for (int i =0; i<states.size(); i++){
            int percentage = (sum_votes[i]  *100) / total_votes[i] ;
            Biden_Percentage.put(states_list.get(i), percentage);

        }
        return Biden_Percentage;
    }
        public String result(List<ElectionData> Data){
            int Trump_votes = 0;
            int Biden_votes = 0;
            for (ElectionData e : Data){
                if (e.candidate.contains("Donald Trump")){
                    Trump_votes += e.total_vote;
                }else if(e.candidate.contains("Joe Biden")){
                    Biden_votes += e.total_vote;
                }

            }
            String result;
            if (Trump_votes > Biden_votes){
                result = "The Winner Is Donald Trump With Total Votes = " + String.valueOf(Trump_votes);
            }else{
                result = "The Winner Is Joe Biden With Total Votes = " + String.valueOf(Biden_votes);
            }
        return result;
    }

}

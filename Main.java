import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Presidential_Elections_analysis p = new Presidential_Elections_analysis();
        List<ElectionData> data = p.read_Data("D:\\ITI-- -AI-PRO\\JAVA & UML PROGRAMMING\\Day 4\\president_county_candidate.csv - president_county_candidate.csv.csv");

        System.out.println(p.trump_perc(data));
        System.out.println(p.Biden_perc(data));
        System.out.println(p.result(data));


    }}

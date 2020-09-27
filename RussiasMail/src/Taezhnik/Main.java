package Taezhnik;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> geozones_id = new ArrayList<>();
        ArrayList<String> services_id = new ArrayList<>();
        ArrayList<String> supplementary_conditions_id = new ArrayList<>();

        HashMap<String, ArrayList<Contractors>> geoServSuppl_toContractors = new HashMap<>();


        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("data.json"));
        AllData allData = gson.fromJson(reader, AllData.class);
        //System.out.println(allData.data.contractors[0].toString());

        Geozones[] geozones = allData.data.geozones;
        for(int i=0; i<geozones.length; i++){
            geozones_id.add(geozones[i].id);
        }

        Services[] services = allData.data.services;
        for(int i=0; i<services.length; i++){
            services_id.add(services[i].id);
        }

        Supplementary_conditions[] supplementary_conditions = allData.data.supplementary_conditions;
        for(int i=0; i<supplementary_conditions.length; i++){
            supplementary_conditions_id.add(supplementary_conditions[i].id);
        }

        Contractors [] contractors = allData.data.contractors;
        //System.out.println(contractors[0].);










        //ArrayList<ArrayList<String>> all_permutations =  Combinations.createAllPermutations(services_id, supplementary_conditions_id);
        //System.out.println(all_permutations.get(0).size());
        //System.out.println(all_permutations.get(1).size());
        //ArrayList<String> all_hashes = Hasher.createAllHashs(geozones_id, all_permutations.get(0), all_permutations.get(1));
        //System.out.println(all_hashes.size());



        //System.out.println(Hasher.getHash(geozones[0].id));
        //System.out.println(Hasher.getHash(text));

        /*String str = "A,B,C,D";
        String str1 = "1,2,3";
        String str2 = "0";
        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(str.split(",")));
        ArrayList<String> myList1 = new ArrayList<String>(Arrays.asList(str1.split(",")));
        ArrayList<String> myList2 = new ArrayList<String>(Arrays.asList(str2.split(",")));
        ArrayList<ArrayList<String>> all_permutations = Combinations.createAllPermutations(myList2,myList,myList1);
        ArrayList<String> all_hashes = Hasher.createAllHashs(all_permutations.get(0), all_permutations.get(1), all_permutations.get(2));
        for(String elem: all_hashes){
            System.out.println(elem);
        }*/



        /*for(int i = 0; i<all_permutations.size(); i++) {
            System.out.println(all_permutations.get(i).size());
        }*/

        /*for(int i=0; i<count_hash_data_elements-1; i++){

        }*/


        /*ArrayList<int[]> arrayList = combinations.getComb(5, 5);
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(Arrays.toString(arrayList.get(i)));
        }*/


    }
}

/*right
prise
sr_time
ot time
do time
weight
weight
statistics %%%

* */
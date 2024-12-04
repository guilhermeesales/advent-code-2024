package challenges;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class day1 {

    public Integer solutionPart1(){
        Integer result = 0;
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        try {
            List<String[]> list = readInputChallenge();

            for (String[] pair : list) {
                if(pair.length == 2) {
                    leftList.add(Integer.parseInt(pair[0].trim()));
                    rightList.add(Integer.parseInt(pair[1].trim()));
                }
            }

        } catch(IOException a) {
            System.out.println("Erro ao fazer a leitura do arquivo.");
        }


        // 1. Compare the smallest number in the left list with the smallest number in the right list        Collections.sort(leftList);
        Collections.sort(rightList);


        // 2. Within each pair, find out how far apart the two numbers are; you will need to add up all these distances.
        // 3. Add up all these distances

        return IntStream.range(0, Math.min(leftList.size(), rightList.size()))
                .map(i -> Math.abs(leftList.get(i) - Math.abs(rightList.get(i))))
                .sum();
    }


    public void solutionPart2() throws IOException {
        Integer similarityPunctuation = 0;
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        try {
            List<String[]> list = readInputChallenge();

            for (String[] pair : list) {
                if(pair.length == 2) {
                    leftList.add(Integer.parseInt(pair[0].trim()));
                    rightList.add(Integer.parseInt(pair[1].trim()));
                }
            }

        } catch(IOException a) {
            System.out.println("Erro ao fazer a leitura do arquivo.");
        }


        Map<Integer, Integer> countRight = rightList.stream()
                .collect(Collectors.groupingBy(i -> i,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));



        similarityPunctuation = leftList.stream().map(num ->
                num * countRight.getOrDefault(num, 0)
        ).reduce(0, Integer::sum);


        System.out.println(similarityPunctuation);



    }

    public List<String[]> readInputChallenge() throws IOException {
        return readFiles("src/resources/input.txt");
    }


    public List<String[]> readFiles(String arq) throws IOException {
        List<String[]> list = new ArrayList<>();
        FileReader fr = new FileReader(arq);
        BufferedReader br = new BufferedReader(fr);

        String linha = br.readLine();

        while(linha != null) {
            list.add(linha.split(" {3}"));
            linha = br.readLine();

        }

        br.close();
        fr.close();

        return list;


    }
}

